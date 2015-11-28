/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: UserServiceImpl.java
 * Author:   DD240
 * Date:     2015-11-26 下午3:39:20
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.slj.demo.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slj.demo.dao.UserDao;
import com.slj.demo.entity.User;
import com.slj.demo.service.UserService;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
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
