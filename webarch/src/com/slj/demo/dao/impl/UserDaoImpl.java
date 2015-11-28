/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: UserDaoImpl.java
 * Author:   DD240
 * Date:     2015-11-26 下午3:38:31
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.slj.demo.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.slj.basic.dao.GuzzDao;
import com.slj.demo.dao.UserDao;
import com.slj.demo.entity.User;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
@Repository("userDao")
public class UserDaoImpl extends GuzzDao implements UserDao {
    
/*    private GuzzDao guzzDao;
    
    public GuzzDao getGuzzDao() {
        return guzzDao;
    }

    @Autowired
    public void setGuzzDao(GuzzDao guzzDao) {
        this.guzzDao = guzzDao;
    }    */
    
    public Serializable create(Object object) {
        return this.insert(object);
    }
    
   
    public void delete(Object object) {
        super.delete(object);
    }
    
    public User getById(int id) {
        Map mapParams = new HashMap<String, Object>();
        mapParams.put("id", id);
        // mapParams.put("password", "liu");
        return (User)super.findObject("select_user", mapParams);
    }
    
/*    
    @Resource
    public void setGuzzContext(GuzzContext guzzContext) {
        super.setGuzzContext(guzzContext);
    }
    */
    
    
}
