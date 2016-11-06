package com.act.Hybrid.jira;

import com.act.Hybrid.jira.impl.JiraNavigator64Impl;

public class JiraNavigatorFactory {
private static String SUPPORTED_VERSIONS = "5.2.x,6.0.x,6.1.x,6.2.x, 6.3.x,6.4.x";
	
	public static JiraNavigator getInstance() {
		return instance ;
	}
	
	private static JiraNavigator instance ;
	
	public static void init(String version) {
		if (version.equalsIgnoreCase("6.4")) {
			
			instance = new JiraNavigator64Impl();
			/*instance = new JiraNavigator52Impl();
		}else if(version.equalsIgnoreCase("6.0")){
			instance = new JiraNavigator60Impl();
		}else if(version.equalsIgnoreCase("6.1")){
			instance = new JiraNavigator616Impl();
		}else if(version.equalsIgnoreCase("6.2")){
			instance = new JiraNavigator62Impl();
		}else if(version.equalsIgnoreCase("6.3")){
			instance = new JiraNavigator62Impl();
		}else if(version.equalsIgnoreCase("6.4")){
			instance = new JiraNavigator64Impl();*/
		}
		else{
			throw new RuntimeException("JIRA versions " + SUPPORTED_VERSIONS + " are supported. "
					+ "Version " + version + " is not supported");
		}
		
	}
}
