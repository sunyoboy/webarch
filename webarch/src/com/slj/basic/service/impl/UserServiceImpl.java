/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: UserServiceImpl.java
 * Author:   DD240
 * Date:     2015-11-30 ����6:15:59
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.slj.basic.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slj.basic.dao.UserDao;
import com.slj.basic.dao.impl.UserDaoImpl;
import com.slj.basic.entity.User;
import com.slj.basic.service.UserService;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    
    public UserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User createUser(User user) {
        return this.userDao.createUser(user);
    }

    @Override
    public void changePassword(Long userId, String newPassword) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void correlationRoles(Long userId, Long roleIds) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void uncorrelationRoles(Long userId, Long roleId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public User findById(Long userId) {
        // TODO Auto-generated method stub
        return null;
    }

    public User findByUsername(String username) {
        return this.userDao.findByUsername(username);
    }

    @Override
    public Set<String> findRolesByUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<String> findPermissionsByUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }

}
