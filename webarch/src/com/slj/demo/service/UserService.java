/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: UserService.java
 * Author:   DD240
 * Date:     2015-11-26 下午3:39:01
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.slj.demo.service;

import java.io.Serializable;

import com.slj.demo.entity.User;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public interface UserService {
    public Serializable create(Object object);
    
    public void delete(Object object);
    
    public User getById(int id);
    
}
