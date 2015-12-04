/*
 * Copyright (C), 2002-2015, 北京世纪鼎点软件有限公司
 * FileName: FreemarkerUtil.java
 * Author: DD240
 * Date: 2015-11-13 上午9:38:24
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author> sunlj <time> <version> <desc>
 * 修改人姓名 修改日期 版本号 描述
 */
package com.slj.basic.util;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
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
     * 输出到文件
     * 
     * @param name
     * @param root
     * @param outFile
     */
    public void fprint(String name, Map<String, Object> root, String destPath, String outFile) {
        FileWriter out = null;
        htmlPath = destPath;
        try {
            // 通过一个文件输出流，就可以写到相应的文件中
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
     * 输出到文件
     * 
     * @param name
     * @param root
     * @param outFile
     */
    public void fprint(String templatePath, String name, Map<String, Object> root, String outFile) {
        FileWriter out = null;
        try {
            // 通过一个文件输出流，就可以写到相应的文件中
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
     * 输出到文件
     * 
     * @param name
     * @param root
     * @param outFile
     */
    public void fprint(String templatePath, String name, Map<String, Object> root, String destPath, String outFile) {
        FileWriter out = null;
        htmlPath = destPath;
        try {
            // 通过一个文件输出流，就可以写到相应的文件中
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
     * 获取模板
     * 
     * @param name
     * @return
     */
    public Template getTemplate(String name) {
        try {
            // 通过Freemaker的Configuration读取相应的ftl
            Configuration cfg = new Configuration();
            cfg.setDefaultEncoding("GBK");
            // 设定去哪里读取相应的ftl模板文件
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
            // 在模板文件目录中找到名称为name的文件
            Template temp = cfg.getTemplate(name);
            return temp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }    

    /**
     * 获取模板
     * 
     * @param name
     * @return
     */
    public Template getTemplate(String path, String name) {
        try {
            // 通过Freemaker的Configuration读取相应的ftl
            Configuration cfg = new Configuration();
            cfg.setDefaultEncoding("GBK");
            // 设定去哪里读取相应的ftl模板文件
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
            // 在模板文件目录中找到名称为name的文件
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
            // 通过Template可以将模板文件输出到相应的流
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
     * 输出到控制台
     * 
     * @param name
     *            模板文件名
     * @param root
     */
    public void print(String name, Map<String, Object> root) {
        try {
            // 通过Template可以将模板文件输出到相应的流
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
            // 通过Template可以将模板文件输出到相应的流
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


