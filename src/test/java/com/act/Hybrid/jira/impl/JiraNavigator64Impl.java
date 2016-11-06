package com.act.Hybrid.jira.impl;

import org.apache.log4j.Logger;

import com.act.Hybrid.jira.JiraNavigator;
import com.act.Hybrid.jira.impl.jira64.JiraLandingPage;
import com.act.Hybrid.jira.impl.jira64.LoginPage;



public class JiraNavigator64Impl implements JiraNavigator {
	private Logger logger = Logger.getLogger(this.getClass());
	private JiraLandingPage jiraLandingPage=JiraLandingPage.getInstance();
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean doLogout(){
		return jiraLandingPage.logout();
	}
	/**
	 * {@inheritDoc}
	 */
	public boolean checkAndCloseNewFeatureDialog(){
		return jiraLandingPage.checkAndCloseNewFeatureDialog();
	}
	@Override
	public boolean doLogin(String username, String password) {
		return LoginPage.getInstance().login(username, password);
	}
	/**
	 * {@inheritDoc}
	 */
	
	public boolean selectProject(String projectName){
		return jiraLandingPage.selectProject(projectName);
	}
}
