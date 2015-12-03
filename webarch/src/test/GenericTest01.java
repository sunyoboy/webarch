/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: GenericTest01.java
 * Author: DD240
 * Date: 2015-12-3 ����10:16:21
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼
 * <author> sunlj <time> <version> <desc>
 * �޸������� �޸����� �汾�� ����
 */
package test;

/**
 * Java��û����ν�ķ�������һ˵
 * 
 * @author sunlj
 * @see
 * @since 1.0
 */
public class GenericTest01 {
    public static void main(String[] args) {
        Box<String> boxStr = new Box<String>();
        boxStr.setT("String");
        Box<Integer> boxInteger = new Box<Integer>();
        boxInteger.setT(10);
        Box<Number> boxNumber = new Box<Number>();
        boxNumber.setT(20);

        print(boxStr);

        /*
         * compile error
         * error The method print(Box<String>) in the type GenericTest01 is
         * not applicable for the arguments (Box<Integer>)
         */
        // print(boxInteger);

        printTwo(boxStr);
        printTwo(boxInteger);

        /* compile error
         * The method printThree(Box<? extends Number>) in the type
         * GenericTest01 is not applicable for the arguments (Box<String>)
         */
        // printThree(boxStr);
        
        printThree(boxInteger);
        printThree(boxNumber);
        
        /*compile error*/
        // printFour(boxStr);
        // printFour(boxInteger);
        printFour(boxNumber);        
    }

    public static void print(Box<String> box) {
        System.out.println(box.getT());
    }

    /*
     * ����ͨ���һ����ʹ�� ? ������������ʵ�Ρ�ע���ˣ��˴�������ʵ�Σ������������βΣ�
     * ��Box<?>���߼�����Box<Integer>��Box<Number>...������Box<��������ʵ��>�ĸ���
     */
    public static void printTwo(Box<?> box) {
        System.out.println(box.getT());
    }

    /* ���ƣ�ֻ����Number�༰�����ࡣ��ʱ����Ҫ�õ�����ͨ������ޡ� */
    public static void printThree(Box<? extends Number> box) {
        System.out.println(box.getT());
    }
    
    /* ���ƣ�ֻ�ܽ���Number������Լ������ĸ������������*/
    public static void printFour(Box<? super Number> box) {
        System.out.println(box.getT());
    }

}
