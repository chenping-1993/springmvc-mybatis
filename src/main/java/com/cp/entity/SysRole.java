package com.cp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @description
 * @author: chenping
 * @create: 2019-10-31
 **/
@Data
public class SysRole {
    private Integer roleId;

    private String roleName;

    private String roleKey;

    private String roleSort;

    private String dataScope;

    private String status;

    private String delFlag;

    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String updateBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String remark;
}
