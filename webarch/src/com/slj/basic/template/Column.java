/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: Column.java
 * Author:   DD240
 * Date:     2015-12-3 ����6:41:40
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.slj.basic.template;

import java.io.Serializable;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class Column implements Serializable {
    
    private String field; // �ֶ�����
    
    private String type;  // �ֶ���������
    
    private String propertyType; // field�ֶζ�Ӧ��ʵ��������������
    
    private String propertyName; // field�ֶζ�Ӧ��ʵ��������
    
    private String columnKey; // �ֶμ�������key�Ƿ�Ϊ���������
    
    private String extra; // ������id���ɲ��Եı�ʾ

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
    
}
