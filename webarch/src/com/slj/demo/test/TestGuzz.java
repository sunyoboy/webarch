/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: TestGuzz.java
 * Author: DD240
 * Date: 2015-11-26 ����4:00:24
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼
 * <author> sunlj <time> <version> <desc>
 * �޸������� �޸����� �汾�� ����
 */
package com.slj.demo.test;

import java.util.HashMap;
import java.util.Map;

import org.guzz.Configuration;
import org.guzz.GuzzContext;
import org.guzz.transaction.ReadonlyTranSession;
import org.guzz.transaction.TransactionManager;
import org.guzz.transaction.WriteTranSession;

/**
 * ��һ�仰���ܼ�����<br>
 * ��������ϸ������
 * 
 * @author sunlj
 * @see
 * @since 1.0
 */
public class TestGuzz {
    private GuzzContext guzzContext;
    private TransactionManager tm;
    

    public static void main(String[] args) throws Exception {
        
        
        
        
        /*
         * ApplicationContext context = new
         * ClassPathXmlApplicationContext("applicationContext.xml");
         * Object bean = context.getBean("UserServiceImpl");
         */
/*        GuzzContext guzzContext = new Configuration("classpath:guzz.xml")
                .newGuzzContext();

        TransactionManager tm = guzzContext.getTransactionManager();

        ReadonlyTranSession session = tm.openDelayReadTran();*/
        
        TestGuzz guzz = new TestGuzz();
        
        ReadonlyTranSession session = guzz.getReadonlyTranSession();

        try {
/*            SearchExpression se = SearchExpression.forClass(User.class);
            se.and(Terms.eq("id", 1));
            se.setOrderBy("id asc");*/
            //List<User> userList = session.list(se);

            // System.out.println("user :" + userList.get(0).toString());
            
            
/*            System.out.println("sqlMap ��ʽ");
            List<User> list = session.list("select_user", null);
            for(User user : list) {
                System.out.println(user.toString());
            }*/
            
            
            // guzz.updateUser();
            guzz.deleteUser();
            
            // WriteTranSession rwSession = guzz.guzzContext.getTransactionManager().openRWTran(true);

            
            
        } finally {
            session.close();
        }
        // perform you actions......

        // .....

        // shutting it down when you application exit.

        guzz.shutdownGuzzContext();
    }

    public ReadonlyTranSession getReadonlyTranSession() {        
        try {
            guzzContext = new Configuration("classpath:guzz.xml")
                    .newGuzzContext();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        tm = guzzContext.getTransactionManager();
        ReadonlyTranSession session = tm.openDelayReadTran();
        return session;

    }
    
    public void updateUser() {
        WriteTranSession rwSession = this.tm.openRWTran(true);
        Map mapParams = new HashMap<String, Object>();
        mapParams.put("id", "1");
        mapParams.put("password", "liu");
        rwSession.executeUpdate("update_user", mapParams);
    }
    
    public void deleteUser() {
        WriteTranSession rwSession = this.tm.openRWTran(true);
        Map mapParams = new HashMap<String, Object>();
        mapParams.put("id", "1");
        rwSession.executeUpdate("delete_user", mapParams);        
    }
    
    public void shutdownGuzzContext() {
        guzzContext.shutdown();
    }

}
