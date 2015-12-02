/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: RoleService.java
 * Author:   DD240
 * Date:     2015-11-30 ����4:24:40
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.slj.basic.service;

import org.springframework.context.annotation.Role;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public interface RoleService {
    public Role createRole(Role role);
    
    public void deleteRole(Long roleId);
    
    public void correlationPermission(Long roleId, Long permissionId);
    
    public void uncorrelationPermission(Long roleId, Long permissionId);
}
