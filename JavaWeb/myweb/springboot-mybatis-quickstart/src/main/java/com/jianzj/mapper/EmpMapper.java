package com.jianzj.mapper;

import com.jianzj.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Delete("delete from emp where id = #{id}")
    public void delete(Integer id);

    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);

    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, " +
            "job = #{job}, entrydate = #{entrydate}, dept_id = #{deptId}, update_time = #{updateTime} " +
            "where id = #{id}")
    public void update(Emp emp);

    @Select("select * from emp where id = #{id}")
    public Emp select(Integer id);

    // 方案一: 起别名, 让别名与实体类属性一致
//    @Select("select id, username, password, name, gender, image, job, entrydate, " +
//            "dept_id deptId, create_time createTime, update_time updateTime from emp where id = #{id}")
//    public Emp select(Integer id);


    // 方案二: 通过@Result注解手动映射封装
//    @Results({
//            @Result(column = "dept_id", property = "deptId"),
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })
//    @Select("select * from emp where id = #{id}")
//    public Emp select(Integer id);

    public List<Emp> selectBySubmit(String name, Short gender, LocalDate begin, LocalDate end);

    public void deleteByIds(List<Integer> ids);

}
