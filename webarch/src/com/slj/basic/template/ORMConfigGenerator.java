/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: ORMConfigGenerator.java
 * Author: DD240
 * Date: 2015-12-3 ����3:34:17
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼
 * <author> sunlj <time> <version> <desc>
 * �޸������� �޸����� �汾�� ����
 */
package com.slj.basic.template;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

/**
 * ��һ�仰���ܼ�����<br>
 * ��������ϸ������
 * 
 * @author sunlj
 * @see
 * @since 1.0
 */
public class ORMConfigGenerator {

    private final static Log LOG = LogFactory.getLog(ORMConfigGenerator.class);
    
    private static DataSource dataSource;
    
    private static final Properties DRUID_PROPERTIES = new Properties();
    
    static {
        try {
            InputStream inputStream = null;
            try {
                inputStream = ORMConfigGenerator.class.getResourceAsStream("druid.properties");
                DRUID_PROPERTIES.load(inputStream);
            } finally {
                JdbcUtils.close(inputStream);
            }
        } catch (IOException e) {
            LOG.error("load druid.properties error", e);
        }
        
        
    }

    /*
     * ��ȡ����Դ
     */
    public DataSource getDataSource() {
        DataSource dataSource = null;
        try {
            dataSource = DruidDataSourceFactory.createDataSource(DRUID_PROPERTIES);
        } catch (Exception e) {
            LOG.error("fail to create DruidDataSource ", e);
        }
        return dataSource;
    }

    /* ��ѯdbName���ݿ��е����б�  */
    public List<Table> queryTables(String dbName) {
        QueryRunner run = new QueryRunner(getDataSource());
        
        // Use the BeanListHandler implementation to convert all
        // ResultSet rows into a List of Person JavaBeans.
        ResultSetHandler<List<Table>> handler = new BeanListHandler<Table>(Table.class);
        List<Table> tableList = null;
        try {
            tableList = run.query("SELECT " +
            		    "t.table_name name " +
            		"FROM " +
            		    "information_schema.tables t " +
            		"WHERE " +
            		    "t.table_schema = ?", handler, dbName);
            
        } catch (SQLException e) {
            LOG.error("fail to query all tables of database " + dbName, e);
        }
        return tableList;
    }

    /* ��ѯtableName��������ֶ� */
    public List<Column> queryColumns(String tableName, String dbName) {
        QueryRunner run = new QueryRunner(getDataSource());
        
        // Use the BeanListHandler implementation to convert all
        // ResultSet rows into a List of Person JavaBeans.
        ResultSetHandler<List<Column>> handler = new BeanListHandler<Column>(Column.class);
        List<Column> columnList = null;
        try {
            columnList = run.query("SELECT" + 
                    " t.column_name field, t.data_type type, t.is_nullable , t.column_key columnKey, t.extra extra" +
                " FROM information_schema.columns t " +
                "WHERE t.table_name = ? AND t.table_schema = ? ", handler, tableName, dbName);
        } catch (SQLException e) {
            LOG.error("fail to query all column of table " + tableName + " for " + dbName, e);
        }
        return columnList;
    }    
    
    public List<Column> getColumns(String tableName, String dbName) {
        List<Column> columnList =  this.queryColumns(tableName, dbName);
        for(Column column : columnList) {
            column.setPropertyName(column.getField());
            /*
            if(column.getType().indexOf("text") > -1) {
                System.out.println("tableName ->  " + tableName);
            }*/
            
            if(column.getType().indexOf("char") > -1 | column.getType().indexOf("text") > -1) {
                column.setType("string");
                column.setPropertyType("String");
            } else if (column.getType().indexOf("date") > -1){
                column.setType("Date");
                column.setPropertyType("String");
            } else if (column.getType().indexOf("int") > -1) {
                column.setType("int");
                column.setPropertyType("int");
            } 
        }
        return columnList;
    }
    
    public static String captureLetter(String name) {
        char[] cs=name.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }    
    
    public static void main(String[] args) {
        ORMConfigGenerator generator = new ORMConfigGenerator();
        List<Table> tableList = generator.queryTables("qsoccer");
        System.out.println("table len \t" + tableList.size());
/*        for(Table t : tableList) {
            generator.generate(t.getName(),"qsoccer");
        }*/
    }

}
