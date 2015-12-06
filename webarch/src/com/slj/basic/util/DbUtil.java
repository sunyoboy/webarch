/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: DbUtil.java
 * Author:   DD240
 * Date:     2015-11-30 下午5:07:28
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package com.slj.basic.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class DbUtil {
    private static final DruidDataSource dataSource = new DruidDataSource();
    
    static {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("flower");
        dataSource.setPassword("flower");
        dataSource.setUrl("jdbc:mysql://localhost:3306/flower");
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(1);
        dataSource.setPoolPreparedStatements(false);
    }
    
    public static DruidDataSource getDataSource() {
        return dataSource;
    }
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }
    
    public static void main(String[] args) {
        String sql = "select * from goods ";
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                System.out.print(rs.getInt(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3) + "\t");
                System.out.print(rs.getString(4) + "\t");
                System.out.println(rs.getString(5) + "\t");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }

}
