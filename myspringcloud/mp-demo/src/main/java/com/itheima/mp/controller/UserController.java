package com.itheima.mp.controller;

import cn.hutool.core.bean.BeanUtil;
import com.itheima.mp.domain.dto.PageDTO;
import com.itheima.mp.domain.dto.UserFormDTO;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.UserQuery;
import com.itheima.mp.domain.vo.UserVO;
import com.itheima.mp.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/12/28 9:51
 */

@RestController
@RequestMapping("/users")
@Api(tags = "用户管理接口")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping
    @ApiOperation("新增用户接口")
    public void saveUser(@RequestBody UserFormDTO userFormDTO) {
        User user = BeanUtil.copyProperties(userFormDTO, User.class);
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除用户接口")
    public void deleteById(@ApiParam("用户id") @PathVariable("id") Long id) {
        userService.removeById(id);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询用户接口")
    public UserVO getById(@ApiParam("用户id") @PathVariable("id") Long id) {
        return userService.getUserAndAddressesById(id);
    }

    @GetMapping
    @ApiOperation("根据id批量查询用户接口")
    public List<UserVO> getByIds(@ApiParam("用户id集合") @RequestParam("ids") List<Long> ids) {
        return userService.getUserAndAddressesByIds(ids);
    }

    @PutMapping("/{id}/deduction/{money}")
    @ApiOperation("根据id扣减余额接口")
    public void deductionBalance(
            @ApiParam("用户id") @PathVariable("id") Long id,
            @ApiParam("扣减的余额") @PathVariable("money") Integer money
    ) {
        userService.deductionBalance(id, money);
    }

    @GetMapping("/list")
    @ApiOperation("根据复杂条件查询用户接口")
    public List<User> getUsers(UserQuery userQuery) {
        return userService.getUsers(userQuery);
    }

    @GetMapping("/page")
    @ApiOperation("根据分页查询用户接口")
    public PageDTO<UserVO> pageQuery(@ApiParam("用户分页数据") UserQuery userQuery) {
        return userService.pageQuery(userQuery);
    }

}
