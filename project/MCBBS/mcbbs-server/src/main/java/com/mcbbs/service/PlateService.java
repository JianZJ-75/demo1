package com.mcbbs.service;

import com.mcbbs.dto.PlatePageQueryDTO;
import com.mcbbs.entity.Plate;
import com.mcbbs.result.PageResult;
import com.mcbbs.vo.UserPlateVO;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/11/13 21:08
 */

public interface PlateService {

    /**
     * 获取所有版块以及每个对应的最新帖子与用户信息
     * @return
     */
    List<UserPlateVO> getPlateWithNewMessageAndUser();

    /**
     * 根据id查询版块
     * @param id
     * @return
     */
    UserPlateVO getUserPlateById(Long id);

    /**
     * 分页查询
     * @param platePageQueryDTO
     * @return
     */
    PageResult page(PlatePageQueryDTO platePageQueryDTO);

    /**
     * 根据id查询单个版块
     * @param id
     * @return
     */
    Plate getPlateById(Long id);

    /**
     * 添加单个版块
     * @param plate
     */
    void save(Plate plate);

    /**
     * 修改版块
     * @param plate
     */
    void update(Plate plate);

    /**
     * 根据id批量删除版块
     * @param ids
     */
    void deleteByIds(List<Long> ids);
}
