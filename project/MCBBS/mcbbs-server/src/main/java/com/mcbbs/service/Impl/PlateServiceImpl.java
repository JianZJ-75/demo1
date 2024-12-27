package com.mcbbs.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mcbbs.annotation.AutoFill;
import com.mcbbs.constant.MessageConstant;
import com.mcbbs.dto.PlatePageQueryDTO;
import com.mcbbs.entity.Message;
import com.mcbbs.entity.Plate;
import com.mcbbs.entity.Remark;
import com.mcbbs.enumeration.OperationType;
import com.mcbbs.exception.MessageBusinessException;
import com.mcbbs.mapper.MessageMapper;
import com.mcbbs.mapper.PlateMapper;
import com.mcbbs.mapper.RemarkMapper;
import com.mcbbs.mapper.UserMapper;
import com.mcbbs.result.PageResult;
import com.mcbbs.service.PlateService;
import com.mcbbs.vo.UserPlateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/11/13 21:09
 */

@Service
@Slf4j
@Transactional
public class PlateServiceImpl implements PlateService {

    @Autowired
    private PlateMapper plateMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private RemarkMapper remarkMapper;

    @Override
    public List<UserPlateVO> getPlateWithNewMessageAndUser() {
        // 查询所有版块
        List<Plate> plates = plateMapper.selectList(
                new LambdaQueryWrapper<Plate>()
                        .orderByDesc(Plate::getCreateTime)
        );
        // 处理数据
        List<UserPlateVO> userPlateVOS = new ArrayList<>();
        for (Plate plate : plates) {
            UserPlateVO userPlateVO = new UserPlateVO();
            BeanUtils.copyProperties(plate, userPlateVO);
            // 处理user
            userPlateVO.setUser(userMapper.selectById(userPlateVO.getUserId()));
            // 查询全部帖子并将最新帖子处理
            List<Message> messages = messageMapper.selectList(
                    new LambdaQueryWrapper<Message>()
                            .eq(Message::getPlateId, plate.getId())
                            .orderByDesc(Message::getCreateTime)
            );
            // 处理帖子数量和查看次数
            Long totalViewTimes = 0L;
            // 如果存在帖子, 将最新帖子存入VO
            if (messages != null && messages.size() > 0) {
                totalViewTimes = messages.stream().mapToLong(Message::getViewTimes).sum();
                userPlateVO.setTotal((long) messages.size());
                userPlateVO.setMessageId(messages.get(0).getId());
                userPlateVO.setMessage(messages.get(0));
            } else {
                userPlateVO.setTotal(0L);
            }
            userPlateVO.setTotalViewTimes(totalViewTimes);
            userPlateVOS.add(userPlateVO);
        }
        return userPlateVOS;
    }

    @Override
    public UserPlateVO getUserPlateById(Long id) {
        Plate plate = plateMapper.selectById(id);
        UserPlateVO userPlateVO = new UserPlateVO();
        BeanUtils.copyProperties(plate, userPlateVO);
        userPlateVO.setUser(userMapper.selectById(userPlateVO.getUserId()));
        return userPlateVO;
    }

    public LambdaQueryWrapper<Plate> getWrapper(PlatePageQueryDTO platePageQueryDTO) {
        LambdaQueryWrapper<Plate> wrapper = new LambdaQueryWrapper<>();
        String keyWord = platePageQueryDTO.getKeyWord();
        if (keyWord != null && !keyWord.isEmpty()) {
            wrapper.like(Plate::getName, keyWord);
        }
        wrapper.orderByDesc(Plate::getCreateTime);
        return wrapper;
    }

    @Override
    public PageResult page(PlatePageQueryDTO platePageQueryDTO) {
        // 处理默认值
        if (platePageQueryDTO.getPage() == null) {
            platePageQueryDTO.setPage(0);
        }
        if (platePageQueryDTO.getPageSize() == null) {
            platePageQueryDTO.setPageSize(10);
        }
        Page<Plate> page = plateMapper.selectPage(
                new Page<>(platePageQueryDTO.getPage(), platePageQueryDTO.getPageSize()),
                getWrapper(platePageQueryDTO)
        );
        System.out.println(page.getTotal() + " " + page.getPages());
        return new PageResult(page.getTotal(), page.getPages(), page.getRecords());
    }

    @Override
    public Plate getPlateById(Long id) {
        return plateMapper.selectById(id);
    }

    @AutoFill(OperationType.CREATE)
    @Override
    public void save(Plate plate) {
        // 判断是否存在同名
        Plate tmp = plateMapper.selectOne(
                new LambdaQueryWrapper<Plate>()
                        .eq(Plate::getName, plate.getName())
        );
        if (tmp != null) {
            throw new MessageBusinessException(MessageConstant.PLATE_HAS_EXIST);
        }
        plateMapper.insert(plate);
    }

    @Override
    public void update(Plate plate) {
        // 判断修改后是否存在同名
        Plate tmp = plateMapper.selectOne(
                new LambdaQueryWrapper<Plate>()
                        .eq(Plate::getName, plate.getName())
        );
        if (tmp != null) {
            throw new MessageBusinessException(MessageConstant.PLATE_HAS_EXIST);
        }
        plateMapper.updateById(plate);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        for (Long id : ids) {
            // 删除版块下的所有帖子
            LambdaQueryWrapper<Message> messageLambdaQueryWrapper = new LambdaQueryWrapper<Message>().eq(Message::getPlateId, id);
            List<Message> messages = messageMapper.selectList(messageLambdaQueryWrapper);
            messageMapper.delete(messageLambdaQueryWrapper);
            for (Message message : messages) {
                // 删除帖子写的所有评论
                remarkMapper.delete(
                        new LambdaQueryWrapper<Remark>()
                                .eq(Remark::getMessageId, message.getId())
                );
            }
            // 删除版块
            plateMapper.deleteById(id);
        }
    }
}