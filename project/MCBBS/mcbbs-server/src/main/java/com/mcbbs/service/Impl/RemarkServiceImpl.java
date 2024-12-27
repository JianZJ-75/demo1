package com.mcbbs.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mcbbs.annotation.AutoFill;
import com.mcbbs.constant.MessageConstant;
import com.mcbbs.context.BaseContext;
import com.mcbbs.dto.RemarkPageQueryDTO;
import com.mcbbs.dto.UserPageQueryDTO;
import com.mcbbs.entity.Remark;
import com.mcbbs.entity.User;
import com.mcbbs.enumeration.OperationType;
import com.mcbbs.exception.RemarkBusinessException;
import com.mcbbs.mapper.RemarkMapper;
import com.mcbbs.result.PageResult;
import com.mcbbs.service.RemarkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @Author JianZJ
 * @Date 2024/11/13 21:09
 */

@Service
@Slf4j
@Transactional
public class RemarkServiceImpl implements RemarkService {

    @Autowired
    private RemarkMapper remarkMapper;

    @AutoFill(OperationType.CREATE)
    @Override
    public void save(Remark remark) {
        remarkMapper.insert(remark);
    }

    @Override
    public void update(Remark remark) {
        Remark tmp = remarkMapper.selectById(remark.getId());
        // 判断是否有权限
        if (!Objects.equals(BaseContext.getCurrentId(), tmp.getUserId())) {
            throw new RemarkBusinessException(MessageConstant.NO_PERMISSION);
        }
        remarkMapper.updateById(remark);
    }

    @Override
    public void deleteById(Long id) {
        // 判断是否有权限
        Remark remark = remarkMapper.selectById(id);
        if (!Objects.equals(BaseContext.getCurrentId(), remark.getUserId())) {
            throw new RemarkBusinessException(MessageConstant.NO_PERMISSION);
        }
        remarkMapper.deleteById(id);
    }

    public LambdaQueryWrapper<Remark> getWrapper(RemarkPageQueryDTO remarkPageQueryDTO) {
        LambdaQueryWrapper<Remark> wrapper = new LambdaQueryWrapper<>();
        String keyWord = remarkPageQueryDTO.getKeyWord();
        if (keyWord != null && !keyWord.isEmpty()) {
            wrapper.like(Remark::getContent, keyWord);
        }
        wrapper.orderByDesc(Remark::getCreateTime);
        return wrapper;
    }

    @Override
    public PageResult page(RemarkPageQueryDTO remarkPageQueryDTO) {
        // 处理默认值
        if (remarkPageQueryDTO.getPage() == null) {
            remarkPageQueryDTO.setPage(0);
        }
        if (remarkPageQueryDTO.getPageSize() == null) {
            remarkPageQueryDTO.setPageSize(10);
        }
        Page<Remark> page = remarkMapper.selectPage(
                new Page<>(remarkPageQueryDTO.getPage(), remarkPageQueryDTO.getPageSize()),
                getWrapper(remarkPageQueryDTO)
        );
        return new PageResult(page.getTotal(), page.getPages(), page.getRecords());
    }

    @Override
    public Remark getRemarkById(Long id) {
        return remarkMapper.selectById(id);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        remarkMapper.deleteBatchIds(ids);
    }

    @Override
    public List<Remark> getRemarkByUserId(Long id) {
        List<Remark> remarks = remarkMapper.selectList(
                new LambdaQueryWrapper<Remark>()
                        .eq(Remark::getUserId, id)
        );
        return remarks;
    }
}