package com.mou.dao;

import com.mou.domain.Student;
import com.mou.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    /*
    * 一个简单类型参数
    * 简单类型：mybatis把Java中的基本数据类型和String都叫做简单类型
    * 在mapper文件中获取简单类型的一个参数的值使用 #{任意字符}
    * */

    public Student selectStudentById(Integer id);

    /*
    * 多个参数：命名参数，在形参定义的前面加入 @param("自定义的名称")
    * */

    public List<Student> selectStudentMuliParam(@Param("myname")String name,@Param("myage")Integer age);


    /*
    * 多个参数，使用java对象作为接口中的方法的参数
    * */

    public List<Student> selectMuliObject(QueryParam param);


    public List<Student> selectMuliStudent(Student student);


    /*
    * 多个参数，使用map存放多个值
    * */
    public List<Student> selectByMap(Map<String,Object> map);
}
