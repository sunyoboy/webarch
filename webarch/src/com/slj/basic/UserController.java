/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: Controller.java
 * Author:   DD240
 * Date:     2015-11-30 下午6:46:02
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.slj.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.slj.basic.entity.User;
import com.slj.basic.service.UserService;
import com.slj.basic.service.impl.UserServiceImpl;


/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
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
