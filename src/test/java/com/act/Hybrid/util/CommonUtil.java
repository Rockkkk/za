package com.act.Hybrid.util;

import java.io.File;
import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.act.Hybrid.Config;
import com.act.Hybrid.Constants;
import com.act.Hybrid.util.Driver;













public class CommonUtil {
	private Logger logger = Logger.getLogger(this.getClass());
	private static boolean flag=false;
	private static WebDriverWait wait=null;
	
	public static File getPropertyFilePath(String path) throws URISyntaxException {
        URL url = path.getClass().getResource(path);
	    File inputFile = new File(url.toURI());
	    return inputFile ;
	}
	
	public static Properties loadProperties(String path) {
		Properties properties = new Properties();
		FileInputStream fis = null ;
		try {
			File file = getPropertyFilePath(path); 
			fis = new FileInputStream(file);
			properties.load(fis);
			fis.close();
		} catch (Exception e) {
			return null ;
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					;
				}
			}
		}
		return properties ;
	}
	public static void implicitWait(int timetowait){
		Driver.driver.manage().timeouts().implicitlyWait(timetowait, TimeUnit.SECONDS);
	}
	
	public static void javaWait(int time) throws InterruptedException{
		if(time==1){
			Thread.sleep(1000);
		}else if (time==2) {
			Thread.sleep(2000);
		}else if (time==3) {
			Thread.sleep(3000);
		}else if (time==4) {
			Thread.sleep(4000);
		}else if (time==5){
			Thread.sleep(5000);
		}
	}
	
	public static boolean titleContains(String title, int time){
		try{
			wait = new WebDriverWait(Driver.driver, time);
			wait.until(ExpectedConditions.titleContains(title));
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public static boolean visibilityOfElementLocated(String xpath){
		try{
			WebDriverWait wb=new WebDriverWait(Driver.driver, Constants.EXPLICIT_WAIT_EXTREME_HIGH);
			wb.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public static boolean isElementPresent(String xpath, int time){
		boolean flag = false;
		try{
			long time1=System.currentTimeMillis();
			long expWaitTime = System.currentTimeMillis() + time;
			while (System.currentTimeMillis() < expWaitTime) {
				try{
					List<WebElement> wb=Driver.driver.findElements(By.xpath(xpath));
					//WebElement wb=Driver.driver.findElement(By.xpath(xpath));
			       /*if (wb.isDisplayed()) {
			    	   flag=true;
			    	   break;
			       }*/
					if(wb.size() != 0){
						flag=true;
				    	break;
					}
				}catch(Exception e){
					flag=false;
				}
			}
			long time2=System.currentTimeMillis();
			System.out.println("Total time: "+(time2-time1));
			System.out.println("Total time: "+((time2-time1)/1000));
			
		}catch(Exception e){
			return flag;
		}
		return flag;
	}
	public static String getAttributeValue(String xpath,String attributeName){
		return Driver.driver.findElement(By.xpath(xpath)).getAttribute(attributeName);
	}
	
	public static boolean searchAndClickFromList(List<WebElement> list, String searchText){
		try{
			flag=false;
			for(int i=0; i<list.size(); i++){
				if(list.get(i).getText().equals(searchText)){
					list.get(i).click();
					flag=true;
					break;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return flag;
		}
		return flag;
	}
	
	public static boolean isElementPresent(String xpath) {
	    try {
	        Driver.driver.findElement(By.xpath(xpath));
	    } catch (Throwable e) {
	        return false;
	    }
	    return true;
	}
	public static boolean isElementPresent(WebElement element) {
	    try {
	        WebElement webElement=element;
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public static String captureScreenshotInLog() {
		CommonUtil.captureScreenshot(Config.getScreenPath());
		String imgPath = CommonUtil.captureScreenshot(Config.getScreenPath());
		//logger.info(CustomHTMLLayout.IMAGE_PREFIX + "src=\"../" + imgPath + "\"/>");
		return CustomHTMLLayout.IMAGE_PREFIX + "src=\"../" + imgPath + "\"/>";
	}
	public static String captureScreenshot(String destPath){
		try{
			EventFiringWebDriver edriver=new EventFiringWebDriver(Driver.driver);
			File src=edriver.getScreenshotAs(OutputType.FILE);
			System.out.println("output: " + src.getAbsolutePath());
			File dest=new File(destPath);
			FileUtils.copyFile(src, new File(destPath));
			return destPath;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null ;
	}
	
	public static boolean launchBrowser(String url){
		try{
			Driver.driver.manage().window().maximize();
			Driver.driver.get(url);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public static void closeTheDriver(){
		Driver.driver.quit();
	}
	
	public static boolean isElementDisplayed(WebElement element){
		try{
			element.isDisplayed();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public static boolean isElementEnabled(WebElement element){
		try{
			element.isEnabled();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public static Actions actionClass(){
		Actions act=new Actions(Driver.driver);
		return act;
	}
}
