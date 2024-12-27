package com.mcbbs.controller.user;

import com.mcbbs.entity.Remark;
import com.mcbbs.result.Result;
import com.mcbbs.service.RemarkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/11/13 20:25
 */

@RestController("userRemarkController")
@Slf4j
@RequestMapping("/user/remark")
public class RemarkController {

    @Autowired
    private RemarkService remarkService;

    /**
     * 根据用户id获取评论
     * @param id
     * @return
     */
    @GetMapping({"/byUser/{id}"})
    public Result<List<Remark>> getRemarkByUserId(@PathVariable Long id) {
        log.info("根据用户id获取评论 {} ...", id);
        List<Remark> remarks = remarkService.getRemarkByUserId(id);
        return Result.success(remarks);
    }

    /**
     * 发表评论
     * @param remark
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Remark remark) {
        log.info("发表评论 {} ...", remark);
        remarkService.save(remark);
        return Result.success();
    }

    /**
     * 修改评论
     * @param remark
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody Remark remark) {
        log.info("修改评论 {} ...", remark);
        remarkService.update(remark);
        return Result.success();
    }

    /**
     * 根据评论id删除评论
     * @param id
     * @return
     */
    @DeleteMapping
    public Result deleteById(Long id) {
        log.info("根据id {} 删除评论...", id);
        remarkService.deleteById(id);
        return Result.success();
    }

}