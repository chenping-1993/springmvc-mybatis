package com.cp.service;

import com.cp.entity.SysRole;
import com.cp.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description
 * @author: chenping
 * @create: 2019-10-31
 **/
@Service
public class SysRoleService {

    @Autowired
    SysRoleMapper sysRoleMapper;

    public List<SysRole> list() {
        return sysRoleMapper.list();
    }
}
