package com.slj.basic.tool;

import java.util.Properties;

public class CodeApp {
	public static void main(String[] args) {
		Properties prop = CodeGenerator.getTemplateConfig();
		System.out.println(prop.getProperty("entity"));
	}
}
