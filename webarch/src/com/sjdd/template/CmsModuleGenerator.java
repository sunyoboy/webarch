package com.sjdd.template;


public class CmsModuleGenerator
{
  private static String packName = "com.slj.basic.template";
  private static String fileName = "pms.properties";

  public static void main(String[] args)
  {
    new ModuleGenerator(packName, fileName).generate();
  }
}