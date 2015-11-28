/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: FreemarkerTest.java
 * Author:   DD240
 * Date:     2015-11-13 ����9:40:20
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.slj.demo.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.slj.basic.util.FreemarkerUtil;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class FreemarkerTest {
    FreemarkerUtil fu;
    Map<String, Object> root = null;

    @Before
    public void setUp() {
        fu = new FreemarkerUtil();
        root = new HashMap<String, Object>();
    }

    @Test
    public void test01() {
        // 1����������ģ��
        Map<String, Object> root = new HashMap<String, Object>();
        // 2��Ϊ����ģ�����ֵ
        root.put("username", "����");
        // 3��������ģ�ͺ�ģ����ϵ��������������̨
        fu.print("ftl_01.ftl", root);
        // fu.fprint("ftl_01.ftl", root, "01.html");
    }
    

}