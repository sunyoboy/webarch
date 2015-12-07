package com.slj.basic.template;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

public class CmsModuleGenerator
{

    private final static Log LOG = LogFactory.getLog(CmsModuleGenerator.class);
    
    private static DataSource dataSource;
    
    private static final Properties DRUID_PROPERTIES = new Properties();
    
    static {
        try {
            InputStream inputStream = null;
            try {
                inputStream = CmsModuleGenerator.class.getResourceAsStream("druid.properties");
                DRUID_PROPERTIES.load(inputStream);
            } finally {
                JdbcUtils.close(inputStream);
            }
        } catch (IOException e) {
            LOG.error("load druid.properties error", e);
        }
    }

    /*
     * 获取数据源
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

    /* 查询dbName数据库中的所有表  */
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

    @Test
    public void queryTable() {
        
        String dbName = "qsoccer";
        QueryRunner run = new QueryRunner(getDataSource());
        
        // Use the BeanListHandler implementation to convert all
        // ResultSet rows into a List of Person JavaBeans.
        ResultSetHandler<List<Table>> handler = new BeanListHandler<Table>(Table.class);
        
        List<Table> tableList = null;
        try {
            Table table = run.query("SELECT " +
                        "t.table_name name " +
                    "FROM " +
                        "information_schema.tables t " +
                    "WHERE " +
                        "t.table_schema = ?", new BeanHandler<Table>(Table.class), dbName);
            
            System.out.println("ScalarHander  " + table.toString());
            
        } catch (SQLException e) {
            LOG.error("fail to query all tables of database " + dbName, e);
        }
        // return tableList;
    }    
    
    /* 查询tableName表的所有字段 */
    public List<Column> queryColumns(String tableName, String dbName) {
        QueryRunner run = new QueryRunner(getDataSource());
        
        // Use the BeanListHandler implementation to convert all
        // ResultSet rows into a List of Person JavaBeans.
        ResultSetHandler<List<Column>> handler = new BeanListHandler<Column>(Column.class);
        List<Column> columnList = null;
        try {
            columnList = run.query("SELECT " + tableName + " tableName, " +
                    " t.column_name field, t.data_type type, t.is_nullable , t.column_key columnKey, t.extra extra" +
                " FROM information_schema.columns t " +
                "WHERE t.table_name = ? AND t.table_schema = ? ", handler, tableName, dbName);
        } catch (SQLException e) {
            LOG.error("fail to query all column of table " + tableName + " for " + dbName, e);
        }
        return columnList;
    }
    
    @Test
    public void queryColumn() {
        QueryRunner run = new QueryRunner(getDataSource());
        String tableName = "tq_video";
        String dbName = "qsoccer";
        
        // Use the BeanListHandler implementation to convert all
        // ResultSet rows into a List of Person JavaBeans.
        ResultSetHandler<List<Column>> handler = new BeanListHandler<Column>(Column.class);
        List<Column> columnList = null;
        try {
            columnList = run.query("SELECT " + tableName + " tableName, " +
                    " t.column_name field, t.data_type type, t.is_nullable , t.column_key columnKey, t.extra extra" +
                " FROM information_schema.columns t " +
                "WHERE t.table_name = ? AND t.table_schema = ? ", handler, tableName, dbName);
            
            for(Column column : columnList) {
                System.out.println("     " + column.toString());
            }
            
        } catch (SQLException e) {
            LOG.error("fail to query all column of table " + tableName + " for " + dbName, e);
        }
        // return columnList;
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
            } else if (column.getType().indexOf("float") > -1) {
                column.setType("float");
                column.setPropertyType("float");
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
        CmsModuleGenerator generator = new CmsModuleGenerator();
        List<Table> tableList = generator.queryTables("qsoccer");
        System.out.println("table len \t" + tableList.size());
/*        for(Table t : tableList) {
            generator.generate(t.getName(),"qsoccer");
        }*/
    }
    
}