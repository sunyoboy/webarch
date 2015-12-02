/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: JoddTest.java
 * Author:   DD240
 * Date:     2015-12-2 下午5:36:43
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.slj.basic.test;

import jodd.bean.BeanUtil;

import org.junit.Test;

import com.slj.basic.entity.User;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class JoddTest {
    
    @Test
    public void testBeanUtil() {
        User user = new User();
        BeanUtil.setProperty(user, "username", "zhangsan");
        
        System.out.println(">>>>>>" + user.toString());
        System.out.println(">>>>>>" + BeanUtil.getProperty(user, "username"));

    }
    

}
