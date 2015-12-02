/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: PermissionService.java
 * Author:   DD240
 * Date:     2015-11-30 下午4:22:56
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.slj.basic.service;

import java.security.Permission;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public interface PermissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
