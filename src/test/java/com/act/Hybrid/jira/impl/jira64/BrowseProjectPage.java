package com.act.Hybrid.jira.impl.jira64;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.act.Hybrid.Constants;
import com.act.Hybrid.util.CommonUtil;
import com.act.Hybrid.util.Driver;




public class BrowseProjectPage {
	private Logger logger = Logger.getLogger( this.getClass() );
	public static BrowseProjectPage getInstance() {
		return PageFactory.initElements( Driver.driver, BrowseProjectPage.class);
	}
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	
	// All projects link text.
	@FindBy(id="all-panel-tab-lnk")
	private WebElement allProjectsLink;
	
	// xpath for all projects list
	@FindBy(xpath="//table/descendant::tbody[@class='projects-list']/tr/td[@data-cell-type='name']/a")
	private List<WebElement> allProjectList;
	
	// id of create project
	@FindBy(id="browse-projects-create-project")
	private WebElement createProjectButton;

	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	/**
	 * This method will selecting project from browse project page and returns a boolean value if it selected successfully.
	 * First it will validate the page then irt will select the project from the list of projects.
	 * It takes as arguments as project name.
	 * @param <b>ProjectName</b> This parameter it will take for selecting that project.
	 * @return The boolean value.
	 */
	
	public boolean selectProject(String projectName){
		try{
			Assert.assertTrue(CommonUtil.titleContains("Browse Projects", Constants.EXPLICIT_WAIT_LOW), "Browse Project Page title is not same.");
			logger.info("Browse Projects page is selected successfully.");
			//allProjectsLink.click();
			//Assert.assertTrue(CommonUtil.visibilityOfElementLocated("//div[@id='none-panel' and @class='module inall active']"));
			Assert.assertTrue(CommonUtil.searchAndClickFromList(allProjectList, projectName), "Project is not selected successfully.");
			logger.info(projectName + " is selected successfully.");
			
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
