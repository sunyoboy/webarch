/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: Util.java
 * Author: DD240
 * Date: 2015-12-3 ����3:34:17
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼
 * <author> sunlj <time> <version> <desc>
 * �޸������� �޸����� �汾�� ����
 */
package com.slj.basic.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
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
public class Util {

    private final static Log LOG = LogFactory.getLog(Util.class);
    
    private static DataSource dataSource;
    
    private static final Properties DRUID_PROPERTIES = new Properties();
    
    static {
        try {
            InputStream inputStream = null;
            try {
                inputStream = Util.class.getResourceAsStream("druid.properties");
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
    public Page<Goods> queryTables(int pageNum, int pageSize, String tableName) {
        QueryRunner run = new QueryRunner(getDataSource());
        
        ScalarHandler<Long> h = new ScalarHandler<Long>(); 
        Page page = new Page(pageNum, pageSize);
        
        try {
			long totalRow = run.query(" select count( * ) totalRow from goods ", h);
			page.setTotalRow(totalRow);
			page.setTotalPage((int)(totalRow - 1)/pageSize + 1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        // Use the BeanListHandler implementation to convert all
        // ResultSet rows into a List of Person JavaBeans.
        ResultSetHandler<List<Goods>> handler = new BeanListHandler<Goods>(Goods.class);
        List<Goods> tableList = null;
        try {
            tableList = run.query("select * from goods limit ?, ? ", handler, page.getStartRow(), page.getPageSize());
            page.setResultList(tableList);
        } catch (SQLException e) {
            LOG.error("fail to query items of " + tableName, e);
        }
        return page;
    }

    
    
    public static String captureLetter(String name) {
        char[] cs=name.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }    
    
    public static void main(String[] args) {
        Util util = new Util();
        Page<Goods> page = util.queryTables(1, 10, "goods");
        List<Goods> gList = page.getResultList();
        for(Goods good : gList) {
        	System.out.println("��==> " + good.toString());
        }
        page.getNextPage();
        page = util.queryTables(page.getNextPage(), page.getPageSize(), "goods");
        
        List<Goods> list = page.getResultList();
        System.out.println(list.size());
        for(Goods good : list) {
        	System.out.println("��==> " + good.toString());
        }
    }

}
