package com.slj.basic.tool;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CodeGenerator {

	private String[] strP = {"dao","dao/impl","service", "service/impl"};
	
	public static void main(String[] args) {
		CodeGenerator codegen = new CodeGenerator();
		String beanName = CodeGenerator.getBeanName();
		String projectDir = System.getProperty("user.dir");
		String path = beanName.substring(0,beanName.lastIndexOf(".")).replace(".", "/");
		String entityPath = projectDir + "/src/" + path;
		codegen.createPackage(entityPath);
/*		File f = null;
		try {
			f = new File(entityPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!f.exists()) {
			f.mkdirs();
		}*/
		
		
		
		
		System.out.println(path);
		System.out.println(beanName);
	}

	public static Properties getTemplateConfig() {
		InputStream is = CodeGenerator.class
				.getResourceAsStream("codegen.properties");
		Properties prop = new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static String getBeanName() {
		return CodeGenerator.getTemplateConfig().getProperty("entity");
	}
	
	public void createPackage(String entityPath) {
		if(entityPath.indexOf("entity") > 0) {
			createFile(entityPath);
			for(int i=0; i<strP.length; i++) {
				createFile(entityPath.replace("entity", strP[i]));
			}
		}
	}
	
	public void createFile(String path) {
		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}
	}
	
	
}
