/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: Table.java
 * Author:   DD240
 * Date:     2015-12-3 下午6:40:08
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.sjdd.template;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
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

    private String name ; // 表名

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    private List<Column> columnsList;

    public List<Column> getColumnsList() {
        return columnsList;
    }

    public void setColumnsList(List<Column> columnsList) {
        this.columnsList = columnsList;
    } 
}
