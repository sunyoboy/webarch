/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: GenericTest.java
 * Author:   DD240
 * Date:     2015-12-3 上午10:00:25
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package test;

/**
 * 在于Java中的泛型这一概念提出的目的，导致其只是作用于代码编译阶段，在编译过程中，对于正确检验泛型结果后，会将泛型的相关信息擦出，
 * 也就是说，成功编译过后的class文件中是不包含任何泛型信息的。泛型信息不会进入到运行时阶段。
 * 对此总结成一句话：泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型。
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
        
        /* 输出对象地址 */
        System.out.println(boxStr); // test.Box@64c3c749
        System.out.println(boxInteger); // test.Box@7150bd4d
        
        /* 输出对象类型 */
        System.out.println(boxStr.getClass()); // class test.Box
        System.out.println(boxInteger.getClass()); // class test.Box
        
        /* 输出对象中参数t的值 */
        System.out.println(boxStr.getT()); // String
        System.out.println(boxInteger.getT()); // 10 
        
        /* 输出对象中参数t的类型 */
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