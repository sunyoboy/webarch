/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: UserController.java
 * Author:   DD240
 * Date:     2015-11-27 ����11:55:29
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.slj.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.slj.basic.util.Util;
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

@Controller
public class UserController {
    
    @RequestMapping(value = "/add")
    public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "sunlj");
        mv.setViewName("addUser");
        
        User user = new User();
        user.setName("zhu");
        user.setPassword("password");
        user.setSex(1);
        user.setWork("work");
        this.getUserService().create(user);
        return mv;
    }
    
    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
    public String deleteUser(@PathVariable("id") int id) {
        User user = this.getUserService().getById(id);
        this.getUserService().delete(user);
        return "deleteUser";
    }
    

    @RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
    public ModelAndView addUser(@PathVariable("id") int id) {
        // map.put("name", "sunlj");
        ModelAndView mv = new ModelAndView();
        User user = this.getUserService().getById(id);
        mv.addObject("user", user);
        mv.setViewName("ftl_03");
        return mv;
    }
    
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView query() {
        // map.put("name", "sunlj");
        ModelAndView mv = new ModelAndView();
        Util util = new Util();
        // User user = this.getUserService().getById(id);
        mv.addObject("page", util.queryTables(1, 10, "goods"));
        mv.setViewName("page");
        return mv;
    }    
}
