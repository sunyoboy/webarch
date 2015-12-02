/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: UserDao.java
 * Author:   DD240
 * Date:     2015-11-30 下午6:20:07
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.slj.basic.dao;

import java.util.Set;

import com.slj.basic.entity.User;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public interface UserDao {
    
    public User createUser(User user); // 创建账户
    
    public void updateUser(User user);
    
    public void deleteUser(User user);
    
    public void correlationRoles(Long userId, Long roleIds); // 添加用户-角色关系
    
    public void uncorrelationRoles(Long userId, Long roleId); // 删除用户-角色关系
    
    public User findById(Long userId);
    
    public User findByUsername(String username); // 根据用户名查找用户
    
    public Set<String> findRolesByUsername(String username); // 根据用户名查找其角色
    
    public Set<String> findPermissionsByUsername(String username); // 根据用户名查找其权限;
}
