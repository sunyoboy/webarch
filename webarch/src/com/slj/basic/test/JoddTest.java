/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: JoddTest.java
 * Author:   DD240
 * Date:     2015-12-2 ����5:36:43
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.slj.basic.test;

import jodd.bean.BeanUtil;

import org.junit.Test;

import com.slj.basic.entity.User;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
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
