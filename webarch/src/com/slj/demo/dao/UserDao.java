/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: UserDao.java
 * Author:   DD240
 * Date:     2015-11-26 ����3:38:08
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.slj.demo.dao;

import java.io.Serializable;

import com.slj.demo.entity.User;


/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public interface UserDao {
    
    public Serializable create(Object object);
    
    public void delete(Object object);
    
    public User getById(int id);
}
