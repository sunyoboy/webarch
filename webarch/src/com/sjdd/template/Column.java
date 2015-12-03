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
package com.sjdd.template;

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
    
    private String field;
    
    private String type;

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
    
    
    
}
