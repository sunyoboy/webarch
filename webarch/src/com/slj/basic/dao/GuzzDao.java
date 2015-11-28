/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: GuzzDao.java
 * Author:   DD240
 * Date:     2015-11-27 上午11:31:36
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.slj.basic.dao;

import org.guzz.GuzzContext;
import org.guzz.dao.GuzzBaseDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public abstract class GuzzDao extends GuzzBaseDao {
    
/*    public Serializable insert(Object object) {
        return super.insert(object);
    }*/
    
    public GuzzDao() {
        System.out.println(" init GuzzDao");
    }
    
    @Autowired
    public void setGuzzContext(GuzzContext guzzContext) {
        // TODO Auto-generated method stub
        super.setGuzzContext(guzzContext);
    }
    
    
    
}
