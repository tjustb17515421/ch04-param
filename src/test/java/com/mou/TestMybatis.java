package com.mou;

import com.mou.dao.StudentDao;
import com.mou.domain.Student;
import com.mou.utils.MyBatisUtils;
import com.mou.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {


    @Test
    public void test() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudentById(1001);
        System.out.println("学生="+student);

    }

    //多个参数,直接传参
    @Test
    public void test1(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectStudentMuliParam("刘备",20);
        for (Student stu:students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();

    }

    //使用对象作为参数传值
    @Test
    public void test2(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        QueryParam param=new QueryParam();
        param.setParamName("张三");
        param.setParamAge(21);
        List<Student> students = dao.selectMuliObject(param);
        for (Student stu:students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();

    }

    //使用Student作为对象传入演示
    @Test
    public void test3(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
        student.setName("王五");
        student.setAge(24);
        List<Student> students = dao.selectMuliStudent(student);
        for (Student stu:students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();

    }

    //使用map集合作为对象传入演示
    @Test
    public void test4(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<String,Object> map =new HashMap<>();
        map.put("myname","张飞");
        map.put("myage",24);
        List<Student> students = dao.selectByMap(map);
        for (Student stu:students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();

    }
}

