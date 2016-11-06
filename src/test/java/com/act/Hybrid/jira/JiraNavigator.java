package com.act.Hybrid.jira;

public interface JiraNavigator {
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to logout from jira.
	 * @return The boolean value i.e. True or False.
	 */
	public boolean doLogout();
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to login to jira and it will show jira landing page.
	 * This method will take a map which contains  <b>JIRA_USERNAME, JIRA_PASSWORD</b>.
	 * @param values contains values for operation of this method.
	 * @param JIRA_USERNAME This parameter contains jira's username for lagin to jira.
	 * @param JIRA_PASSWORD This parameter contains jira's password for lagin to jira.
	 * @return The boolean value i.e. True or False.
	 */
	public boolean doLogin(String username, String password);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to search for new plugin in Atlassian Marketplace in JIRA.
	 * This method will take a map which contains  <b>ADMIN_AUTHENTICATE_USERNAME, ADMIN_AUTHENTICATE_PASSWORD, FIND_NEW_PLUGIN_NAME </b>.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>ADMIN_AUTHENTICATE_USERNAME</b> This parameter contains Administration authenticate username.<br/>
	 * <b>ADMIN_AUTHENTICATE_PASSWORD</b> This parameter contains Administration authenticate password <br/>
	 * <b>FIND_NEW_PLUGIN_NAME</b> This parameter contains zfj plugin name which need to search in Atlassian Marketplace. <br/>
	 * </p>
	 *  @return The boolean value i.e. True or False.
	 */
	
	public boolean selectProject(String projectName);
	public boolean checkAndCloseNewFeatureDialog();
}
