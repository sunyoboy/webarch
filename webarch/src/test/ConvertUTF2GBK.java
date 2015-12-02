/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: ConvertUTF2GBK.java
 * Author:   DD240
 * Date:     2015-11-20 ����11:14:56
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
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
 * @since   2014��2��20�� ����10:49:33 
 */

public class ConvertUTF2GBK { 
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        //GBK�����ʽԴ��·�� 
        String srcDirPath = "D:/work/GuzzEmptyProject/src/com/slj/basic/entity"; 
        //תΪUTF-8�����ʽԴ��·�� 
        String utf8DirPath = "E:\\tmp\\guzzvote"; 
                 
         
        //��ȡ����java�ļ�
        Collection<File> javaGbkFileCol = listAll(srcDirPath);
                 
        // Collection<File> classFileCol = listAllClassFile(srcDirPath);
        for (File javaGbkFile : javaGbkFileCol) { 
              //UTF8��ʽ�ļ�·�� 
              String utf8FilePath = utf8DirPath+javaGbkFile.getAbsolutePath().substring(srcDirPath.length());
              //ʹ��GBK��ȡ���ݣ�Ȼ����UTF-8д������
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