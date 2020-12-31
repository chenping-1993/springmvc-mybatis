package com.cp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cp.entity.MybatisPlusTest;
import com.cp.mapper.MybatisPlusTestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @Author: chenping
 * @Date: 2019/6/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringmvcCpApplication.class)
public class TestMybatisPlus {

    @Autowired
    MybatisPlusTestMapper testMapper;


    /** 
     * @Description:  MybatisPlusTestInsert 插入自动生成id
     * @param:  
     * @return: void 
     * @Author: chenping
     * @Date: 2020/12/25 17:06
     */
    @Test
    public void MybatisPlusTestInsert() {

        MybatisPlusTest test = new MybatisPlusTest();
       test.setAge(22);
       test.setName("test01");
        testMapper.insert(test);
        System.out.println(test);
    }

    /** 
     * @Description:  MybatisPlusTestSelect 根据条件查询
     * @param:  
     * @return: void 
     * @Author: chenping
     * @Date: 2020/12/25 17:18
     */
    @Test
    public void MybatisPlusTestSelect() {

        LambdaQueryWrapper<MybatisPlusTest> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(MybatisPlusTest::getAge,22);
        lambdaQueryWrapper.like(MybatisPlusTest::getName,"test");
        List<MybatisPlusTest> mybatisPlusTests = testMapper.selectList(lambdaQueryWrapper);
        System.out.println(mybatisPlusTests);
    }

    /** 
     * @Description:  根据id更新，没有set的值不更新
     * @param:  
     * @return: void 
     * @Author: chenping
     * @Date: 2020/12/25 17:19
     */
    @Test
    public void MybatisPlusTestUpdateById() {

        MybatisPlusTest test = new MybatisPlusTest();
        test.setName("test001");
        test.setId(1342387505013063681L);
        testMapper.updateById(test);
        System.out.println(test);
    }

    /**
     * @Description:  更具条件更新值，为null不更新
     *  UPDATE mybatis_plus_test SET name=? WHERE age = ?
     * @param:
     * @return: void
     * @Author: chenping
     * @Date: 2020/12/25 17:21
     */
    @Test
    public void MybatisPlusTestUpdate() {

        LambdaQueryWrapper<MybatisPlusTest> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(MybatisPlusTest::getAge,22);
        MybatisPlusTest test = new MybatisPlusTest();
        test.setName("test006");
        testMapper.update(test,lambdaQueryWrapper);
        System.out.println(test);
    }

    /** 
     * @Description:  distinct limit 查询方式示例
     * @param:  
     * @return: void 
     * @Author: chenping
     * @Date: 2020/12/31 10:32
     */
    @Test
    public void MybatisPlusTestDistinctLimitSelect() {

        QueryWrapper<MybatisPlusTest> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("distinct name");
        queryWrapper.last("limit 3");
        List<MybatisPlusTest> distinctLimitSelect = testMapper.selectList(queryWrapper);
        System.out.println(distinctLimitSelect);
    }

}
