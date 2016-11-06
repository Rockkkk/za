package com.act.Hybrid.bvt;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.act.Hybrid.Config;
import com.act.Hybrid.Constants;
import com.act.Hybrid.util.CommonUtil;
import com.act.Hybrid.util.Driver;


public class AdminBvt_263 extends BaseTest {
	public AdminBvt_263() {
		logger = Logger.getLogger(this.getClass());
	}
	
	@Test(enabled = testEnabled, priority=1)
	public void testBvt1() {
		altID=1;
		//CommonUtil.alertMsg("executing bvt1...");
		logger.info("Executing bvt1...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("ADMIN_AUTHENTICATE_USERNAME", JIRA_ADMIN_USERNAME);	// Used for authenticate administration username.
		values.put("ADMIN_AUTHENTICATE_PASSWORD", JIRA_ADMIN_PASSWORD);	// Used for authenticate Administrative password.
		values.put("FIND_NEW_PLUGIN_NAME", "zephyr");	// Used for Find new plugin 
		
		//isSuccess=jiraNavigator.searchForNewPlugIn(values);
		//Assert.assertTrue(isSuccess,"New plugin is not found successfully.");
		
		//isSuccess = jiraNavigator.leavingAdministrationPage();
		//Assert.assertTrue( isSuccess, "Leaving from Administration is not successfully." );
		
		logger.info("bvt1 is executed successfully.");	
	}
	@BeforeClass
	public void beforeClass() throws Throwable{
		logger.info("beforeClass invoked");
		JIRA_ADMIN_USERNAME=Config.getValue("JIRA_ADMIN_USERNAME");
		JIRA_ADMIN_USERNAME.trim();
		JIRA_ADMIN_PASSWORD=Config.getValue("JIRA_ADMIN_PASSWORD");
		JIRA_ADMIN_PASSWORD.trim();
		System.out.println(JIRA_ADMIN_USERNAME);
		System.out.println(JIRA_ADMIN_PASSWORD);
		Assert.assertTrue(jiraNavigator.doLogin(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD), "Login to jira is not successfully...");
		jiraNavigator.checkAndCloseNewFeatureDialog();
		logger.info("Logged Into Jira Successfully...");
		Assert.assertTrue(jiraNavigator.selectProject(Config.getValue("JIRA_PROJECT")), " Project is not selected successfully.");
		logger.info("Project is selected successfully.");
		
	}
	
	@AfterClass
	public void afterClass(){
		logger.info("afterClass invoked");
		logger.info("logout from Jira successfully.");
		Assert.assertTrue(jiraNavigator.doLogout(),"Logout from jira is not successfully.");
		
	}

	@BeforeMethod
	public void beforeMethod(){
		logger.info("beforeMethod invoked");
		if(Driver.driver == null){
			Driver.driver=Driver.browserFactory();
		}
		if(Driver.driver.getTitle().contains("Log in")){
			Assert.assertTrue(jiraNavigator.doLogin(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD), "Login to jira is not successfully.");
			logger.info("logged in to Jira successfully.");
		}
		isSuccess = false;
		
	}
	
	@AfterMethod
	public void afterMethod() throws Exception{
		logger.info("afterMethod invoked");
		if(isSuccess == false){
			captureScreenshotInLog();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			CommonUtil.actionClass().sendKeys(Keys.ESCAPE).build().perform();
			Assert.assertTrue(jiraNavigator.doLogout(),"Logout from jira is not successfully.");
			logger.info("logged out from Jira successfully...");
			
		}
		updateStatusInExcel();
		logger.info("Excel sheet is updated successfully.");
	}

}
