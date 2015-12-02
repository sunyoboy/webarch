/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: UserService.java
 * Author:   DD240
 * Date:     2015-11-30 下午4:28:05
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.slj.basic.service;

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
public interface UserService {
    public User createUser(User user); // 创建账户
    
    public void changePassword(Long userId, String newPassword); // 修改密码
    
    public void correlationRoles(Long userId, Long roleIds); // 添加用户-角色关系
    
    public void uncorrelationRoles(Long userId, Long roleId); // 删除用户-角色关系
    
    public User findById(Long userId);
    
    public User findByUsername(String username); // 根据用户名查找用户
    
    public Set<String> findRolesByUsername(String username); // 根据用户名查找其角色
    
    public Set<String> findPermissionsByUsername(String username); // 根据用户名查找其权限;
    
}
