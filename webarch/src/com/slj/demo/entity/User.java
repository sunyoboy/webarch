/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: User.java
 * Author:   DD240
 * Date:     2015-11-26 ����3:35:32
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.slj.demo.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */

@Component
public class User implements Serializable {
    
    private int id;
    
    private String name;
    
    private String password;
    
    private int sex;
    
    private String work;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password
                + ", sex=" + sex + ", work=" + work + "]";
    }

}
