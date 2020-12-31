package com.cp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Transient;

/**
 * @Author: chenping
 * @Date: 2019/6/12
 */
@Data
@TableName(value = "user")//指定表名
public class User {
    private Integer id;

    private String name;

    private Integer age;

//    @TableField(value = "manager_id")//默认的是下划线驼峰，不用指定数据库字段名
    private Integer managerId;

    /**
     * 数据库中不存在的字段
     */
    @Transient
    @TableField(exist = false)
    private String userName;
}
