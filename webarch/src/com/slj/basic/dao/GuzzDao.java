/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: GuzzDao.java
 * Author:   DD240
 * Date:     2015-11-27 ����11:31:36
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.slj.basic.dao;

import org.guzz.GuzzContext;
import org.guzz.dao.GuzzBaseDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
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
