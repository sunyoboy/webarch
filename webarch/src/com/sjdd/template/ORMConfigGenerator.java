/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: ORMConfigGenerator.java
 * Author: DD240
 * Date: 2015-12-3 下午3:34:17
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author> sunlj <time> <version> <desc>
 * 修改人姓名 修改日期 版本号 描述
 */
package com.sjdd.template;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author sunlj
 * @see
 * @since 1.0
 */
public class ORMConfigGenerator {

    public void queryTable() throws SQLException {
        ResultSetHandler<Object[]> h = null; // Define a handler the same as
                                             // above example

        // No DataSource so we must handle Connections manually
        QueryRunner run = new QueryRunner();

        Connection conn = null; // open a connection
        try {
            Object[] result = run.query(conn,
                    "SELECT * FROM Person WHERE name=?", h, "John Doe");
            // do something with the result
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // Use this helper method so we don't have to check for null
            DbUtils.close(conn);
        }
    }

    public Properties getDruidConfig() {
        Properties prop = new Properties();
        try {
            prop.load(this.getClass().getResourceAsStream("druid.properties"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return prop;
    }

    public DataSource getDataSource(Properties prop) {
        DataSource dataSource = null;
        try {
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dataSource;
    }

    public void query() {
        // Create a ResultSetHandler implementation to convert the
        // first row into an Object[].
        ResultSetHandler<Object[]> h = new ResultSetHandler<Object[]>() {
            public Object[] handle(ResultSet rs) throws SQLException {
                if (!rs.next()) {
                    return null;
                }

                ResultSetMetaData meta = rs.getMetaData();
                int cols = meta.getColumnCount();
                Object[] result = new Object[cols];

                for (int i = 0; i < cols; i++) {
                    result[i] = rs.getObject(i + 1);
                }

                return result;
            }
        };

        // Create a QueryRunner that will use connections from
        // the given DataSource
        QueryRunner run = new QueryRunner(getDataSource(getDruidConfig()));

        // Execute the query and get the results back from the handler
        try {
            // Object[] result =
            // run.query("SELECT * FROM tq_video WHERE viewAngle = ?", h, 1);
            Object[] result = run.query("show columns from tq_video", h); // show tables
            
/*            System.out.println("the length of array result : " + result.length);
            for (int i = 0; i < result.length; i++) {
                if (result[i] != null) {
                    System.out.print(i + "\t" + result[i].getClass() + "\t");
                    if (String.class.equals((result[i].getClass()))) {
                        System.out.println((result[i]).toString());
                    }
                } else {
                    System.out.println(" null ");
                }
            }*/
            
            // List<Map<String, Object>> result = run.query(sql, rsh);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public List<Table> queryTables() {
        QueryRunner run = new QueryRunner(getDataSource(getDruidConfig()));
        
        // Use the BeanListHandler implementation to convert all
        // ResultSet rows into a List of Person JavaBeans.
        ResultSetHandler<List<Table>> handler = new BeanListHandler<Table>(Table.class);
        
        List<Table> tableList = null;
        try {
            tableList = run.query("show table status", handler);
            for(Table table : tableList) {
                System.out.println("tableName \t" + table.getName());
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tableList;
    }

    public List<Column> queryColumns(String tableName) {
        QueryRunner run = new QueryRunner(getDataSource(getDruidConfig()));
        
        // Use the BeanListHandler implementation to convert all
        // ResultSet rows into a List of Person JavaBeans.
        ResultSetHandler<List<Column>> handler = new BeanListHandler<Column>(Column.class);
        
        List<Column> columnList = null;
        try {
            columnList = run.query("show columns from " + tableName, handler);
            for(Column column : columnList) {
                System.out.print("fieldName \t" + column.getField());
                System.out.println("  fieldType \t" + column.getType());
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return columnList;
    }    
    
    public static void main(String[] args) {
        ORMConfigGenerator generator = new ORMConfigGenerator();
        generator.queryTables();
        generator.queryColumns("tq_video");
    }

}
