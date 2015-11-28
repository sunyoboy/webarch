/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: UserServiceImpl.java
 * Author:   DD240
 * Date:     2015-11-26 ����3:39:20
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.slj.demo.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slj.demo.dao.UserDao;
import com.slj.demo.entity.User;
import com.slj.demo.service.UserService;

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
    
    @Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }    
    
    public Serializable create(Object object) {
        return this.getUserDao().create(object);
    }
    
    public void delete(Object object) {
        this.getUserDao().delete(object);
    }
    
    public User getById(int id) {
        return this.getUserDao().getById(id);
    }
    
}
