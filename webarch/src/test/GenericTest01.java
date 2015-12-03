/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: GenericTest01.java
 * Author: DD240
 * Date: 2015-12-3 上午10:16:21
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author> sunlj <time> <version> <desc>
 * 修改人姓名 修改日期 版本号 描述
 */
package test;

/**
 * Java中没有所谓的泛型数组一说
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
     * 类型通配符一般是使用 ? 代替具体的类型实参。注意了，此处是类型实参，而不是类型形参！
     * 且Box<?>在逻辑上是Box<Integer>、Box<Number>...等所有Box<具体类型实参>的父类
     */
    public static void printTwo(Box<?> box) {
        System.out.println(box.getT());
    }

    /* 限制：只能是Number类及其子类。此时，需要用到类型通配符上限。 */
    public static void printThree(Box<? extends Number> box) {
        System.out.println(box.getT());
    }
    
    /* 限制：只能接收Number这个类以及这个类的父类的数据类型*/
    public static void printFour(Box<? super Number> box) {
        System.out.println(box.getT());
    }

}
