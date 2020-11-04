package com.cp;

import com.cp.entity.Student;
import com.cp.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenping
 * @Date: 2019/6/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringmvcCpApplication.class)
public class TestMybatisXml {

    @Autowired
    StudentMapper studentMapper;


    @Test
    public void inSelect() {
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        student.setName("小王");
        Student student1 = new Student();
        student1.setName("老王");
        list.add(student);
        list.add(student1);
        List<Student> resultList = studentMapper.selectListWithList(list);
        System.out.println(JSONObject.toJSONString(resultList));
    }

    @Test
    public void likeSelect() {
        Student student = new Student();
        student.setName("王");
        List<Student> resultList = studentMapper.selectListWithLike(student);
        System.out.println(JSONObject.toJSONString(resultList));
    }

    @Test
    public void selectWithTime() {
        Student student = new Student();
        student.setStartTime("2020-09-29 11:10:51");
        student.setEndTime("2020-11-02 11:06:41");
        List<Student> resultList = studentMapper.selectListWithTime(student);
        System.out.println(JSONObject.toJSONString(resultList));
    }

    @Test
    public void batchInsert() {
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        student.setName("小刘");
        student.setCity("广东");
        student.setAge(24);
        Student student1 = new Student();
        student1.setName("老刘");
        student1.setCity("重庆");
        student1.setAge(45);
        list.add(student);
        list.add(student1);
        studentMapper.xmlBatchInsert(list);
    }

}
