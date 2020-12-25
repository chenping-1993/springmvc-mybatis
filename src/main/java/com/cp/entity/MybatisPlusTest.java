package com.cp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.util.Date;

/**
 * @Author: chenping
 * @Date: 2019/6/12
 */
@Data
@TableName(value = "mybatis_plus_test")//指定表名
public class MybatisPlusTest {
    private Long id;

    private String name;

    private Integer age;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "update_time")
    private Date updateTime;

}
