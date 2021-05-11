package com.cp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cp.controller.dto.SysRoleDTO;
import com.cp.entity.MybatisPlusTest;
import com.cp.entity.Student;
import com.cp.entity.SysRole;
import com.cp.entity.User;
import com.cp.mapper.MybatisPlusTestMapper;
import com.cp.mapper.StudentMapper;
import com.cp.mapper.SysRoleMapper;
import com.cp.mapper.UserMapper;
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

    @Autowired
    UserMapper userMapper;

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Autowired
    MybatisPlusTestMapper testMapper;


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
    /** 
     * @Description:  mybatis-plus LambdaQueryWrapper 使用方式示例
     * @param:  
     * @return: void 
     * @Author: chenping
     * @Date: 2020/12/25 16:11
     */
    @Test
    public void mybatisPlusLambdaQueryWrapper() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getManagerId,10);
        List<User> resultList = userMapper.selectList(lambdaQueryWrapper);
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
    public void selectWithEndTime() {
        Student student = new Student();
        student.setEndTime("2020-11-02 11:06:41");
        List<Student> resultList = studentMapper.selectWithEndTime(student);
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

    @Test
    public void MybatisPlusTest() {

        MybatisPlusTest test = new MybatisPlusTest();
       test.setAge(22);
       test.setName("test01");
        testMapper.insert(test);
        System.out.println(test);
    }

    /**
     * @Description:  查询条件有list数据
     * @param:
     * @return: void
     * @Author: chenping
     * @Date: 2021/5/11 14:45
     */
    @Test
    public void testMybatisWithListParam() {

        SysRoleDTO dto = new SysRoleDTO();
        List<String> status = new ArrayList<>();
        status.add("1");
        status.add("2");
        status.add("3");
        dto.setStatus(status);
        dto.setRoleName("b");
        List<SysRole> list = sysRoleMapper.testMybatisWithListParam(dto);
        System.out.println(list);
    }

}
