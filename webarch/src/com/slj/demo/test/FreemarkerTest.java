/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: FreemarkerTest.java
 * Author:   DD240
 * Date:     2015-11-13 上午9:40:20
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.slj.demo.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.slj.basic.util.FreemarkerUtil;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
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
        // 1、创建数据模型
        Map<String, Object> root = new HashMap<String, Object>();
        // 2、为数据模型添加值
        root.put("username", "张三");
        // 3、将数据模型和模板组合的数据输出到控制台
        fu.print("ftl_01.ftl", root);
        // fu.fprint("ftl_01.ftl", root, "01.html");
    }
    

}