/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: Column.java
 * Author:   DD240
 * Date:     2015-12-3 下午6:41:40
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.slj.basic.template;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class Column implements Serializable {
    
    private String field; // 字段名称
    
    private String type;  // 字段数据类型
    
    private String propertyType; // field字段对应的实体属性数据类型
    
    private String propertyName; // field字段对应的实体属性名
    
    private String columnKey; // 字段键，表名key是否为主键、外键
    
    private String extra; // 主键的id生成策略的表示

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
