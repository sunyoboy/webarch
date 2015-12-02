package com.slj.basic.test;

import com.slj.basic.tool.CodeGenerator;

public class ThreadTest extends Thread {

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(CodeGenerator.getTemplateConfig().hashCode());
		}
	}

}
