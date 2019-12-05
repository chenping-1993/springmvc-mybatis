package com.cp.controller;

import com.cp.entity.SysRole;
import com.cp.mapper.SysRoleMapper;
import com.cp.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description 通过 mybatis 的xml操作数据
 * @author: chenping
 * @create: 2019-10-31
 **/
@RestController
@Slf4j
@RequestMapping("/xml")
public class XmlMybatisSysRoleController {
    @Autowired
    SysRoleService sysRoleService;

    @Autowired
    SysRoleMapper sysRoleMapper;

    @RequestMapping("/sysrole")
    public List<SysRole> sysrole() {
        log.info("1111111111111111111111111");
        return sysRoleService.list();
    }

    @PostMapping("/selectByRoleName")
    public List<SysRole> selectByRoleName(@RequestBody SysRole sysRole) {
        return sysRoleMapper.getByRoleName(sysRole);
    }


    /**
     * @description: string 参数，批量查询
     * @param: [params]
     * @return: java.util.List<com.cp.entity.SysRole>
     * @author: chenping
     * @date: 2019/10/31
     */
    @GetMapping("/selectByIds")
    public List<SysRole> selectByIds(@RequestParam String params) {
        String[] str = params.split(",");
        return sysRoleMapper.getByArrayIds(str);
    }

    /**
     * @description: mybatis 使用bind模糊查询，兼容不同的数据库
     * @param: [roleName]
     * @return: java.util.List<com.cp.entity.SysRole>
     * @author: chenping
     * @date: 2019/11/1
     */
    @GetMapping("/selectLikeWithBind")
    public List<SysRole> selectLikeWithBind(@RequestParam String roleName) {
        return sysRoleMapper.selectLikeWithBind(roleName);
    }

    /** 
     * @Description:  插入
     * @param: sysRole 
     * @return: int 
     * @Author: chenping
     * @Date: 2019/12/5
     **/
    @PostMapping("/insert")
    public int insert(@RequestBody SysRole sysRole) {
        return sysRoleMapper.insert(sysRole);
    }

}
