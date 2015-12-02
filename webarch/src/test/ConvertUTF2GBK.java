/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: ConvertUTF2GBK.java
 * Author:   DD240
 * Date:     2015-11-20 上午11:14:56
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author> sunlj     <time>      <version>    <desc>
 * 修改人姓名             修改日期            版本号                  描述
 */
package test;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import jodd.io.FileNameUtil;
import jodd.io.FileUtil;

 
/** 
 * @author  <a href="mailto:ketayao@gmail.com">ketayao</a>
 * @since   2014年2月20日 上午10:49:33 
 */

public class ConvertUTF2GBK { 
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        //GBK编码格式源码路径 
        String srcDirPath = "D:/work/GuzzEmptyProject/src/com/slj/basic/entity"; 
        //转为UTF-8编码格式源码路径 
        String utf8DirPath = "E:\\tmp\\guzzvote"; 
                 
         
        //获取所有java文件
        Collection<File> javaGbkFileCol = listAll(srcDirPath);
                 
        // Collection<File> classFileCol = listAllClassFile(srcDirPath);
        for (File javaGbkFile : javaGbkFileCol) { 
              //UTF8格式文件路径 
              String utf8FilePath = utf8DirPath+javaGbkFile.getAbsolutePath().substring(srcDirPath.length());
              //使用GBK读取数据，然后用UTF-8写入数据
              String path = FileNameUtil.getFullPath(utf8FilePath);
              File pf = new File(path);
              if (!pf.exists()) {
                  pf.mkdirs();
              }
               
              /*FileUtil.writeString(utf8FilePath, FileUtil.readString(javaGbkFile, "GBK"), "UTF-8");*/
              FileUtil.writeString(utf8FilePath, FileUtil.readString(javaGbkFile, "UTF-8"), "GBK");
              //FileUtils.writeLines(new File(utf8FilePath), "UTF-8", FileUtils.readLines(javaGbkFile, "GBK"));        
        }
        
/*        for(File classFile : classFileCol) {
            System.out.println("Path :" + classFile.getAbsolutePath());
        }*/
 
    }
 
    public static Collection<File> listAll(String srcDirPath) {
        Collection<File> files = new HashSet<File>();
        File rootDir = new File(srcDirPath);
        if (rootDir.isDirectory()) {
            File[] allFiles = rootDir.listFiles();
             
            for (File file : allFiles) {
                if (file.isDirectory()) {
                    files.addAll(listAll(file.getAbsolutePath()));
                } else if (FileNameUtil.getExtension(file.getName()).equalsIgnoreCase("java")) {
                    files.add(file);
                }
            }
        } 
         
        return files;
    }
    
    public static Collection<File> listAllClassFile(String srcDirPath) {
        Collection<File> files = new HashSet<File>();
        File rootDir = new File(srcDirPath);
        if (rootDir.isDirectory()) {
            File[] allFiles = rootDir.listFiles();
             
            for (File file : allFiles) {
                if (file.isDirectory()) {
                    files.addAll(listAllClassFile(file.getAbsolutePath()));
                } else if (!FileNameUtil.getExtension(file.getName()).equalsIgnoreCase("class")) {
                    files.add(file);
                }
            }
        } 
         
        return files;
    }    
    
}