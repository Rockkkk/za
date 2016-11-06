package com.act.Hybrid.zfj;

import com.act.Hybrid.zfj.impl.ZfjNavigator263Impl;


public class ZfjNavigatorFactory {
private static String SUPPORTED_VERSIONS = "1.7.3,2.1,2.2, 2.5,2.6.3";
	
	public static ZfjNavigator getInstance() {
		return instance ;
	}
	private static ZfjNavigator instance ;
	
	public static void init(String version) {
		if (version.equalsIgnoreCase("2.6.3")) {
			
			instance = new ZfjNavigator263Impl();
		/*	
			instance = new ZfjNavigator173Impl();
		}
		else if(version.equalsIgnoreCase("2.1")){
			instance = new ZfjNavigator21Impl();
		}
		else if(version.equalsIgnoreCase("2.2")){
			instance = new ZfjNavigator22Impl();
		}
		else if(version.equalsIgnoreCase("2.5")){
			instance = new ZfjNavigator25Impl();*/
		}
		else{
			throw new RuntimeException("Zephyr For JIRA versions " + SUPPORTED_VERSIONS + " are supported. "
					+ "Version " + version + " is not supported");
		}
	}
	
	
}
