/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: PermissionService.java
 * Author:   DD240
 * Date:     2015-11-30 ����4:22:56
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.slj.basic.service;

import java.security.Permission;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public interface PermissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
