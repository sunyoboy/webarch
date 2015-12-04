/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: FreemarkerUtil.java
 * Author: DD240
 * Date: 2015-11-13 ����9:38:24
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼
 * <author> sunlj <time> <version> <desc>
 * �޸������� �޸����� �汾�� ����
 */
package com.slj.basic.util;

/**
 * ��һ�仰���ܼ�����<br>
 * ��������ϸ������
 * 
 * @author sunlj
 * @see
 * @since 1.0
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerUtil {
    
    
    private String ftlPath;


    private String htmlPath;

    public FreemarkerUtil() {
        String classesPath = this.getClass().getResource("/").toString();
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.indexOf("win") >= 0) {
            classesPath = classesPath.replace("file:/", "");
        } else if (osName.indexOf("linux") >= 0) {
            classesPath = classesPath.replace("file:", "");
        }
        
        this.ftlPath = classesPath.replace("classes", "ftl");
        // this.htmlPath = classesPath.replace("classes", "view/portal");;
        this.htmlPath = classesPath.replace("classes", "view/portal");;
	}
    public FreemarkerUtil(String htmlPath, String ftlPath) {
        this.ftlPath = ftlPath;
        this.htmlPath = htmlPath;
    }
    
    /**
     * ������ļ�
     * 
     * @param name
     * @param root
     * @param outFile
     */
    public void fprint(String name, Map<String, Object> root, String destPath, String outFile) {
        FileWriter out = null;
        htmlPath = destPath;
        try {
            // ͨ��һ���ļ���������Ϳ���д����Ӧ���ļ���
            File f = new File(htmlPath);
            if(!f.exists()) {
                f.mkdirs();
            }
            out = new FileWriter(new File(htmlPath + outFile));
            Template temp = this.getTemplate(name);
            temp.process(root, out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * ������ļ�
     * 
     * @param name
     * @param root
     * @param outFile
     */
    public void fprint(String templatePath, String name, Map<String, Object> root, String outFile) {
        FileWriter out = null;
        try {
            // ͨ��һ���ļ���������Ϳ���д����Ӧ���ļ���
            File f = new File(htmlPath);
            if(!f.exists()) {
                f.mkdirs();
            }
            out = new FileWriter(new File(htmlPath + outFile));
            Template temp = this.getTemplate(templatePath, name);
            temp.process(root, out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * ������ļ�
     * 
     * @param name
     * @param root
     * @param outFile
     */
    public void fprint(String templatePath, String name, Map<String, Object> root, String destPath, String outFile) {
        FileWriter out = null;
        htmlPath = destPath;
        try {
            // ͨ��һ���ļ���������Ϳ���д����Ӧ���ļ���
            File f = new File(htmlPath);
            if(!f.exists()) {
                f.mkdirs();
            }
            out = new FileWriter(new File(htmlPath + outFile));
            Template temp = this.getTemplate(templatePath, name);
            temp.process(root, out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public String getFtlPath() {
        return ftlPath;
    }
    
    
    public String getHtmlPath() {
        return htmlPath;
    }
    
    /**
     * ��ȡģ��
     * 
     * @param name
     * @return
     */
    public Template getTemplate(String name) {
        try {
            // ͨ��Freemaker��Configuration��ȡ��Ӧ��ftl
            Configuration cfg = new Configuration();
            cfg.setDefaultEncoding("GBK");
            // �趨ȥ�����ȡ��Ӧ��ftlģ���ļ�
/*            cfg.setServletContextForTemplateLoading(pageContext.getServletContext(),   
                    "WEB-INF/templates");  */
            String classesPath = this.getClass().getResource("/").toString();
            String osName = System.getProperty("os.name").toLowerCase();
            if (osName.indexOf("win") >= 0) {
                classesPath = classesPath.replace("file:/", "");
            } else if (osName.indexOf("linux") >= 0) {
                classesPath = classesPath.replace("file:", "");
            }
            
            
            cfg.setDirectoryForTemplateLoading(new File(classesPath.substring(0, classesPath.indexOf("WEB-INF")) + "WEB-INF/ftl"));
            // cfg.setClassForTemplateLoading(this.getClass(), "/ftl");
            // ��ģ���ļ�Ŀ¼���ҵ�����Ϊname���ļ�
            Template temp = cfg.getTemplate(name);
            return temp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }    

    /**
     * ��ȡģ��
     * 
     * @param name
     * @return
     */
    public Template getTemplate(String path, String name) {
        try {
            // ͨ��Freemaker��Configuration��ȡ��Ӧ��ftl
            Configuration cfg = new Configuration();
            cfg.setDefaultEncoding("GBK");
            // �趨ȥ�����ȡ��Ӧ��ftlģ���ļ�
/*            cfg.setServletContextForTemplateLoading(pageContext.getServletContext(),   
                    "WEB-INF/templates");  */
            String classesPath = this.getClass().getResource("/").toString();
            String osName = System.getProperty("os.name").toLowerCase();
            if (osName.indexOf("win") >= 0) {
                classesPath = classesPath.replace("file:/", "");
            } else if (osName.indexOf("linux") >= 0) {
                classesPath = classesPath.replace("file:", "");
            }
            
            
            // cfg.setDirectoryForTemplateLoading(new File(classesPath.substring(0, classesPath.indexOf("WEB-INF")) + "WEB-INF/ftl"));
            cfg.setDirectoryForTemplateLoading(new File(path));
            // cfg.setClassForTemplateLoading(this.getClass(), "/ftl");
            // ��ģ���ļ�Ŀ¼���ҵ�����Ϊname���ļ�
            Template temp = cfg.getTemplate(name);
            return temp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getTemplateText(String name, Map<String, Object> root) {
        StringWriter out = new StringWriter(); 
        try {
            // ͨ��Template���Խ�ģ���ļ��������Ӧ����
            Template temp = this.getTemplate(name); 
            temp.process(root, out);  
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.getBuffer().toString();  
    }    
    
    /**
     * ���������̨
     * 
     * @param name
     *            ģ���ļ���
     * @param root
     */
    public void print(String name, Map<String, Object> root) {
        try {
            // ͨ��Template���Խ�ģ���ļ��������Ӧ����
            Template temp = this.getTemplate(name);
            temp.process(root, new PrintWriter(System.out));
            /*
            Writer writer = new OutputStreamWriter(System.out);
            temp.process(root, writer);
            */
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print(String path, String name, Map<String, Object> root) {
        try {
            // ͨ��Template���Խ�ģ���ļ��������Ӧ����
            Template temp = this.getTemplate(path, name);
            temp.process(root, new PrintWriter(System.out));
            /*
            Writer writer = new OutputStreamWriter(System.out);
            temp.process(root, writer);
            */
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


