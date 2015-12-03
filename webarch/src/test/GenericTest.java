/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: GenericTest.java
 * Author:   DD240
 * Date:     2015-12-3 ����10:00:25
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package test;

/**
 * ����Java�еķ�����һ���������Ŀ�ģ�������ֻ�������ڴ������׶Σ��ڱ�������У�������ȷ���鷺�ͽ���󣬻Ὣ���͵������Ϣ������
 * Ҳ����˵���ɹ���������class�ļ����ǲ������κη�����Ϣ�ġ�������Ϣ������뵽����ʱ�׶Ρ�
 * �Դ��ܽ��һ�仰�������������߼��Ͽ��Կ����Ƕ����ͬ�����ͣ�ʵ���϶�����ͬ�Ļ������͡�
 * @author sunlj
 * @see 
 * @since 1.0
 */
public class GenericTest {
    public static void main(String[] args) {
        Box<String> boxStr = new Box<String>();
        boxStr.setT("String");
        Box<Integer> boxInteger = new Box<Integer>();
        boxInteger.setT(10);
        
        /* ��������ַ */
        System.out.println(boxStr); // test.Box@64c3c749
        System.out.println(boxInteger); // test.Box@7150bd4d
        
        /* ����������� */
        System.out.println(boxStr.getClass()); // class test.Box
        System.out.println(boxInteger.getClass()); // class test.Box
        
        /* ��������в���t��ֵ */
        System.out.println(boxStr.getT()); // String
        System.out.println(boxInteger.getT()); // 10 
        
        /* ��������в���t������ */
        System.out.println(boxStr.getT().getClass()); // class java.lang.String
        System.out.println(boxInteger.getT().getClass()); // class java.lang.Integer          
    }
}

class Box<T> {
    
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
    
}