/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: UserService.java
 * Author:   DD240
 * Date:     2015-11-30 ����4:28:05
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.slj.basic.service;

import java.util.Set;

import com.slj.basic.entity.User;


/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public interface UserService {
    public User createUser(User user); // �����˻�
    
    public void changePassword(Long userId, String newPassword); // �޸�����
    
    public void correlationRoles(Long userId, Long roleIds); // ����û�-��ɫ��ϵ
    
    public void uncorrelationRoles(Long userId, Long roleId); // ɾ���û�-��ɫ��ϵ
    
    public User findById(Long userId);
    
    public User findByUsername(String username); // �����û��������û�
    
    public Set<String> findRolesByUsername(String username); // �����û����������ɫ
    
    public Set<String> findPermissionsByUsername(String username); // �����û���������Ȩ��;
    
}
