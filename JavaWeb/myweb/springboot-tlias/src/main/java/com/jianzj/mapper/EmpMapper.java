package com.jianzj.mapper;

import com.jianzj.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    /**
     * 查询总记录数
     * @return
     */
//    @Select("select count(*) from emp")
//    public Long count();

    /**
     * 分页查询, 获取列表数据
     * @param start
     * @param pageSize
     * @return
     */
//    @Select("select * from emp limit #{start}, #{pageSize}")
//    public List<Emp> page(Integer start, Integer pageSize);

    /**
     * 员工信息查询
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除员工
     * @param ids
     */
    void deleteByIds(Integer[] ids);

    /**
     * 添加员工
     * @param emp
     */
    @Insert("insert emp(username, name, gender, image, dept_id, entrydate, job, create_time, update_time)" +
            "values (#{username}, #{name}, #{gender}, #{image}, #{deptId}, #{entrydate}, #{job}, #{createTime}, #{updateTime})")
    void add(Emp emp);

    /**
     * 根据ID查询员工信息
     * @param id
     * @return
     */
    @Select("select * from emp where id = #{id}")
    Emp get(Integer id);

    /**
     * 修改员工信息
     * @param emp
     */
    void update(Emp emp);
}