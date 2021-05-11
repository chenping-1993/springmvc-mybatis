package com.cp.mapper;

import com.cp.controller.dto.SysRoleDTO;
import com.cp.entity.SysRole;

import java.util.List;

/**
 * @description
 * @author: chenping
 * @create: 2019-10-31
 **/
public interface SysRoleMapper  {

    public List<SysRole> list();

    public List<SysRole> getByRoleName(SysRole sysRole);

    /**
     * @description: 单参数数组
     * @param: [ids]
     * @return: java.util.List<com.cp.entity.SysRole>
     * @author: chenping
     * @date: 2019/10/31
     */
    public List<SysRole> getByArrayIds(String[] ids);

    public List<SysRole> selectLikeWithBind(String roleName);


    int insert(SysRole sysRole);

    List<SysRole> testMybatisWithListParam(SysRoleDTO dto);
}
