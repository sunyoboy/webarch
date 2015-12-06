/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: Controller.java
 * Author:   DD240
 * Date:     2015-11-30 ����6:46:02
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.slj.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.slj.basic.entity.User;
import com.slj.basic.service.UserService;
import com.slj.basic.service.impl.UserServiceImpl;


/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class UserController {
    
    private UserService userService = new UserServiceImpl();

    public UserService getUserService() {
        return userService;
    }
    
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    public void createUser() {
        User user = new User();
        user.setUsername("zhang");
        user.setPassword("zhang");
        user.setSalt("zhang");
        user.setLocked(false);
        this.userService.createUser(user);
    }
    
    public static void main(String[] args) {
        UserController controller = new UserController();
        controller.createUser();
    }
}
