package com.mcbbs.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mcbbs.annotation.AutoFill;
import com.mcbbs.constant.MessageConstant;
import com.mcbbs.context.BaseContext;
import com.mcbbs.dto.UserLoginDTO;
import com.mcbbs.dto.UserPageQueryDTO;
import com.mcbbs.entity.*;
import com.mcbbs.enumeration.OperationType;
import com.mcbbs.exception.UserBusinessException;
import com.mcbbs.mapper.*;
import com.mcbbs.result.PageResult;
import com.mcbbs.service.UserService;
import com.mcbbs.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @Author JianZJ
 * @Date 2024/11/13 21:09
 */

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RemarkMapper remarkMapper;
    @Autowired
    private LogMapper logMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private PlateMapper plateMapper;
    @Autowired
    private AliOssUtil aliOssUtil;

    @Override
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public User login(UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();
        // 根据用户名查询用户
        User user = userMapper.selectOne(
                new LambdaQueryWrapper<User>()
                        .eq(User::getUsername, username)
        );
        // 账号不存在
        if (user == null) {
            throw new UserBusinessException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        // 密码比对
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        // 密码错误
        if (!password.equals(user.getPassword())) {
            throw new UserBusinessException(MessageConstant.PASSWORD_ERROR);
        }
        return user;
    }

    @AutoFill(OperationType.REGISTER)
    @Override
    public void register(User user) {
        // 根据用户名查询用户
        User tmp = userMapper.selectOne(
                new LambdaQueryWrapper<User>()
                        .eq(User::getUsername, user.getUsername())
        );
        // 该用户名已存在
        if (tmp != null) {
            throw new UserBusinessException(MessageConstant.ACCOUNT_HAS_EXIST);
        }
        // 加密密码
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        // 判断是否有权限修改
        if (!Objects.equals(user.getId(), BaseContext.getCurrentId())) {
            throw new UserBusinessException(MessageConstant.NO_PERMISSION);
        }
        String username = user.getUsername();
        String password = user.getPassword();
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new UserBusinessException(MessageConstant.USERNAME_OR_PASSWORD_NULL);
        }
        // 判断修改后的用户名是否存在
        User tmp = userMapper.selectOne(
                new LambdaQueryWrapper<User>()
                        .eq(User::getUsername, user.getUsername())
        );
        System.out.println(tmp);
        if (tmp != null) {
            throw new UserBusinessException(MessageConstant.ACCOUNT_HAS_EXIST);
        }
        // 加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userMapper.updateById(user);
    }

    @Override
    public User load() {
        Long id = BaseContext.getCurrentId();
        return userMapper.selectById(id);
    }

    public LambdaQueryWrapper<User> getWrapper(UserPageQueryDTO userPageQueryDTO) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        String keyWord = userPageQueryDTO.getKeyWord();
        if (keyWord != null && !keyWord.isEmpty()) {
            wrapper.like(User::getUsername, keyWord);
        }
        wrapper.orderByDesc(User::getRegisterTime);
        return wrapper;
    }

    @Override
    public PageResult page(UserPageQueryDTO userPageQueryDTO) {
        // 处理默认值
        if (userPageQueryDTO.getPage() == null) {
            userPageQueryDTO.setPage(0);
        }
        if (userPageQueryDTO.getPageSize() == null) {
            userPageQueryDTO.setPageSize(10);
        }
        Page<User> page = userMapper.selectPage(
                new Page<>(userPageQueryDTO.getPage(), userPageQueryDTO.getPageSize()),
                getWrapper(userPageQueryDTO)
        );
        return new PageResult(page.getTotal(), page.getPages(), page.getRecords());
    }

    @Override
    public void updatePassword(User user) {
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new UserBusinessException(MessageConstant.PASSWORD_NULL);
        }
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userMapper.updateById(user);
    }

    @Override
    public void switchRole(Long id) {
        User user = userMapper.selectById(id);
        // 身份取反
        user.setIsAdmin(!user.getIsAdmin());
        userMapper.updateById(user);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        for (Long id : ids) {
            // 获取wrapper
            LambdaQueryWrapper<Plate> plateLambdaQueryWrapper = new LambdaQueryWrapper<Plate>().eq(Plate::getUserId, id);
            // 删除用户关联的版块
            List<Plate> list = plateMapper.selectList(plateLambdaQueryWrapper);
            plateMapper.delete(plateLambdaQueryWrapper);
            for (Plate plate : list) {
                LambdaQueryWrapper<Message> messageLambdaQueryWrapper = new LambdaQueryWrapper<Message>().eq(Message::getPlateId, plate.getId());
                // 删除版块下的所有帖子
                List<Message> messages = messageMapper.selectList(messageLambdaQueryWrapper);
                messageMapper.delete(messageLambdaQueryWrapper);
                for (Message message : messages) {
                    // 删除帖子下的所有评论
                    remarkMapper.delete(
                            new LambdaQueryWrapper<Remark>()
                                    .eq(Remark::getMessageId, message.getId())
                    );
                }
            }
            // 删除用户关联的帖子
            LambdaQueryWrapper<Message> messageLambdaQueryWrapper = new LambdaQueryWrapper<Message>().eq(Message::getUserId, id);
            List<Message> messages = messageMapper.selectList(messageLambdaQueryWrapper);
            messageMapper.delete(messageLambdaQueryWrapper);
            for (Message message : messages) {
                // 删除帖子下的所有评论
                remarkMapper.delete(
                        new LambdaQueryWrapper<Remark>()
                                .eq(Remark::getMessageId, message.getId())
                );
            }
            // 删除用户关联的评论
            remarkMapper.delete(
                    new LambdaQueryWrapper<Remark>()
                            .eq(Remark::getUserId, id)
            );
            // 删除用户
            userMapper.deleteById(id);
        }
    }

    @Override
    public User test(Long userId) {
        return userMapper.selectById(userId);
    }
}