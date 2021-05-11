package com.cp.controller.dto;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author: chenping
 * @Date: 2021-05-11
 */
@Data
public class SysRoleDTO {
    private List<String> status;
    private String roleName;
}
