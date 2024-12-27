package com.mcbbs.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.IPage;
import com.github.pagehelper.PageHelper;
import com.mcbbs.annotation.AutoFill;
import com.mcbbs.constant.MessageConstant;
import com.mcbbs.context.BaseContext;
import com.mcbbs.dto.MessagePageQueryDTO;
import com.mcbbs.entity.Message;
import com.mcbbs.entity.Remark;
import com.mcbbs.enumeration.OperationType;
import com.mcbbs.exception.MessageBusinessException;
import com.mcbbs.exception.UserBusinessException;
import com.mcbbs.mapper.*;
import com.mcbbs.result.PageResult;
import com.mcbbs.service.MessageService;
import com.mcbbs.vo.MessageAndPlateVO;
import com.mcbbs.vo.MessageAndRemarkVO;
import com.mcbbs.vo.RemarkVO;
import com.mcbbs.vo.UserMessageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author JianZJ
 * @Date 2024/11/13 21:08
 */

@Service
@Slf4j
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RemarkMapper remarkMapper;
    @Autowired
    private PlateMapper plateMapper;

    /**
     * 创建wrapper
     * @param messagePageQueryDTO
     * @return
     */
    public LambdaQueryWrapper<Message> getWrapper(MessagePageQueryDTO messagePageQueryDTO) {
        LambdaQueryWrapper<Message> wrapper = new LambdaQueryWrapper<>();
        if (messagePageQueryDTO.getOperation() == null) {
            messagePageQueryDTO.setOperation(0);
        }
        if (messagePageQueryDTO.getOperation() != 10) {
            wrapper.eq(Message::getPlateId, messagePageQueryDTO.getPlateId());
        } else {
            messagePageQueryDTO.setOperation(0);
        }
        Integer op = messagePageQueryDTO.getOperation();
        String keyWord = messagePageQueryDTO.getKeyWord();
        if (keyWord != null && !keyWord.isEmpty()) {
            wrapper.and(i -> i
                    .like(Message::getTitle, keyWord)
                    .or()
                    .like(Message::getContent, keyWord)
            );
        }
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime from = null;
        if (op == 1) {
            wrapper.orderByDesc(Message::getViewTimes);
            return wrapper;
        }
        if (op == 2) {
            from = now.minusDays(7);
        } else if (op == 3) {
            from = now.minusMonths(1);
        } else if (op == 4) {
            from = now.minusYears(1);
        }
        if (from != null) {
            wrapper.ge(Message::getCreateTime, from);
        }
        wrapper.orderByDesc(Message::getCreateTime);
        return wrapper;
    }

    @Override
    public PageResult page(MessagePageQueryDTO messagePageQueryDTO) {
        // 处理默认值
        if (messagePageQueryDTO.getPage() == null) {
            messagePageQueryDTO.setPage(0);
        }
        if (messagePageQueryDTO.getPageSize() == null) {
            messagePageQueryDTO.setPageSize(10);
        }
        Page<Message> page = messageMapper.selectPage(
                new Page<>(messagePageQueryDTO.getPage(), messagePageQueryDTO.getPageSize()),
                getWrapper(messagePageQueryDTO)
        );
        List<UserMessageVO> messages = new ArrayList<>();
        for (Message record : page.getRecords()) {
            UserMessageVO userMessageVO = new UserMessageVO();
            BeanUtils.copyProperties(record, userMessageVO);
            userMessageVO.setUser(userMapper.selectById(userMessageVO.getUserId()));
            messages.add(userMessageVO);
        }
        System.out.println(1);
        return new PageResult(page.getTotal(), page.getPages(), messages);
    }

    @AutoFill(OperationType.CREATE)
    @Override
    public void save(Message message) {
        message.setViewTimes(0L);
        messageMapper.insert(message);
    }

    @Override
    public MessageAndRemarkVO getMessageAndRemarkById(Long id) {
        // 查询帖子
        Message message = messageMapper.selectById(id);
        // 查看次数 + 1
        message.setViewTimes(message.getViewTimes() + 1);
        messageMapper.updateById(message);
        // 封装VO
        MessageAndRemarkVO messageAndRemarkVO = new MessageAndRemarkVO();
        BeanUtils.copyProperties(message, messageAndRemarkVO);
        // 查询帖子下的评论
        List<Remark> remarks = remarkMapper.selectList(
                new LambdaQueryWrapper<Remark>()
                        .eq(Remark::getMessageId, messageAndRemarkVO.getId())
                        .orderByDesc(Remark::getCreateTime)
        );
        List<RemarkVO> remarkVOS = new ArrayList<>();
        // 查询评论的用户信息
        for (Remark remark : remarks) {
            RemarkVO remarkVO = new RemarkVO();
            BeanUtils.copyProperties(remark, remarkVO);
            remarkVO.setUser(
                    userMapper.selectById(remark.getUserId())
            );
            remarkVOS.add(remarkVO);
        }
        messageAndRemarkVO.setRemarkList(remarkVOS);
        return messageAndRemarkVO;
    }

    @Override
    public void update(Message message) {
        Message tmp = messageMapper.selectById(message.getId());
        // 判断是否有权限
        if (!Objects.equals(BaseContext.getCurrentId(), tmp.getUserId())) {
            throw new MessageBusinessException(MessageConstant.NO_PERMISSION);
        }
        String title = message.getTitle();
        String content = message.getContent();
        if (title == null || title.isEmpty() || content == null || content.isEmpty()) {
            throw new MessageBusinessException(MessageConstant.TITLE_OR_CONTENT_NULL);
        }
        messageMapper.updateById(message);
    }

    @Override
    public void deleteById(Long id) {
        // 判断是否有权限
        Message message = messageMapper.selectById(id);
        if (!Objects.equals(BaseContext.getCurrentId(), message.getUserId())) {
            throw new MessageBusinessException(MessageConstant.NO_PERMISSION);
        }
        // 先删除该帖子的所有评论
        remarkMapper.delete(
                new LambdaQueryWrapper<Remark>()
                        .eq(Remark::getMessageId, id)
        );
        // 在删除该帖子
        messageMapper.deleteById(id);
    }

    @Override
    public Message getMessageById(Long id) {
        return messageMapper.selectById(id);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        for (Long id : ids) {
            // 删除该帖子的所有评论
            remarkMapper.delete(
                    new LambdaQueryWrapper<Remark>()
                            .eq(Remark::getMessageId, id)
            );
            // 删除帖子
            messageMapper.deleteById(id);
        }
    }

    @Override
    public List<MessageAndPlateVO> getMessagesByUserId(Long id) {
        List<MessageAndPlateVO> messageAndPlateVOS = new ArrayList<>();
        // 获取帖子
        List<Message> messages = messageMapper.selectList(
                new LambdaQueryWrapper<Message>()
                        .eq(Message::getUserId, id)
        );
        // 获取帖子对应版块并封装
        for (Message message : messages) {
            MessageAndPlateVO messageAndPlateVO = new MessageAndPlateVO();
            BeanUtils.copyProperties(message, messageAndPlateVO);
            messageAndPlateVO.setPlate(
                    plateMapper.selectById(message.getPlateId())
            );
            messageAndPlateVOS.add(messageAndPlateVO);
        }
        return messageAndPlateVOS;
    }
}