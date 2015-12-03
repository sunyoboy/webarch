/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: UserDaoImpl.java
 * Author:   DD240
 * Date:     2015-11-30 下午6:20:39
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.slj.basic.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.slj.basic.dao.UserDao;
import com.slj.basic.entity.User;
import com.slj.basic.util.DbUtil;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    public User createUser(User user) {
        String sql = "insert into sys_users(username, password, salt, locked) values(?, ?, ?, ?)";
        Connection conn = DbUtil.getConnection();
        PreparedStatement pstmt = null;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getSalt());
            pstmt.setBoolean(4, user.getLocked());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findByUsername(user.getUsername());
    }

    /* 修改用户信息 */
    public void updateUser(User user) {
        String sql = "update sys_users set username = ?, password = ?, salt = ?, locked= ? where id = ?";
        Connection conn = DbUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getSalt());
            pstmt.setBoolean(4, user.getLocked());
            pstmt.setLong(5, user.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteUser(User user) {
        String sql = "delete from sys_users where id = ?";
        Connection conn = DbUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt.setLong(1, user.getId());
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void correlationRoles(Long userId, Long roleIds) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void uncorrelationRoles(Long userId, Long roleId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public User findById(Long userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findByUsername(String username) {
        String sql = "select * from sys_users where username = ?";
        Connection conn = DbUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            user = new User();
            if(rs.next()) {
                user.setId(rs.getLong(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setSalt(rs.getString(4));
                user.setLocked(rs.getBoolean(5));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Set<String> findRolesByUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<String> findPermissionsByUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
