package com.cp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cp.entity.User;
import com.cp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: chenping
 * @Date: 2019/12/5
 */
@RestController
@RequestMapping("/entity")
public class EntityMybatisPlusUserController {

    @Autowired
    UserMapper userMapper;

    /** 
     * @Description:  通过QueryWrapper查询
     * @param:  
     * @return: java.util.List<com.cp.entity.User> 
     * @Author: chenping
     * @Date: 2019/12/5
     **/
    @RequestMapping("/getUsers")
    public List<User> getAll() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("manager_id",102);
        return userMapper.selectList(queryWrapper);
//        return userMapper.selectList(null);
    }

    /** 
     * @Description:  通过id查询
     * @param:  
     * @return: com.cp.entity.User 
     * @Author: chenping
     * @Date: 2019/12/5
     **/
    @RequestMapping("/selectById")
    public User selectById() {
        return userMapper.selectById(101);
    }

    /** 
     * @Description:  通过实体插入
     * @param:  
     * @return: int 
     * @Author: chenping
     * @Date: 2019/12/5
     **/
    @RequestMapping("/insertUsers")
    public int insert() {
        User user = new User();
        user.setId(204);
        user.setAge(66);
        user.setName("cart");
        user.setManagerId(102);
        return userMapper.insert(user);

    }

    /** 
     * @Description:  根据实体带id更新
     * @param:  
     * @return: int 
     * @Author: chenping
     * @Date: 2019/12/5
     **/
    @RequestMapping("/updateUser")
    public int updateUser() {
        User user = new User();
        user.setId(204);
        user.setAge(55);
        return userMapper.updateById(user);//不传的字段值不更新


    }

    /** 
     * @Description:  通过map参数查询
     * @param:  
     * @return: java.util.List<com.cp.entity.User> 
     * @Author: chenping
     * @Date: 2019/12/5
     **/
    @RequestMapping("/getByColumn")
    public List<User> getByColumn() {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("id", 204);//写表中的列名
        columnMap.put("age", 55);
        return userMapper.selectByMap(columnMap);
    }

    /** 
     * @Description:  根据多个id批量查询
     * @param:  
     * @return: java.util.List<com.cp.entity.User> 
     * @Author: chenping
     * @Date: 2019/12/5
     **/
    @RequestMapping("/batchSelect")
    public List<User> batchSelect() {
        List<Integer> listIds = new ArrayList<>();
        listIds.add(101);
        listIds.add(102);
        return userMapper.selectBatchIds(listIds);
    }
}
