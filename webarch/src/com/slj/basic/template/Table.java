/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: Table.java
 * Author:   DD240
 * Date:     2015-12-3 ����6:40:08
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.slj.basic.template;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class Table implements Serializable 
{
    /*
     */
    private static final long serialVersionUID = -916709016244462067L;

    private String name ; // ����
    
    private String entityName;
    
    private List<Column> columnList = new ArrayList<Column>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public List<Column> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<Column> columnList) {
        this.columnList = columnList;
    }
}
