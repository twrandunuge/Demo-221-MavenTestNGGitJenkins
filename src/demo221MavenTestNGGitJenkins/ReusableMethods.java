package demo221MavenTestNGGitJenkins;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableMethods {

	static ExtentTest logger;
	static ExtentReports report;
	static WebDriver driver;

	public static void InitializeDriver() {
		WebDriverManager.chromedriver().setup();
	 	driver = new ChromeDriver();
	}

	
	public static void OpenUrl(String url) {
		driver.get(url);
		// driver.manage().window().maximize();
	}

	public static void CloseBrowser() {
		driver.quit();
	}

	public static void CloseReport() {
		report.flush();
	}

	/*
	 * Name of the method: selectDropdown Brief Description: Select the Dropdown
	 * list Arguments: obj --> web object, objName--> name of the object Created by:
	 * Automation team Creation Date: Feb 12 2019 Last Modified: Feb 12 2019
	 */
	public static void SelectDropdown(WebElement obj, String objName) {

		if (obj.isDisplayed()) {
			System.out.println("Pass: " + objName + " is  selected");
			obj.click();
		} else {

			System.out.println("Fail:" + objName + " is not present.Please chk application");
//				
		}
	}

	/*
	 * name of the method: switchFrameid BriefDescription : iframe using webelement
	 * Arguments : driver--->driver obj--->iframe id createdby : Automation team
	 * created date :02/13/19 LastModified Date:02/13/19
	 */

	public static void SwitchFrame(String id) {
		driver.switchTo().frame(id);
		System.out.println("Pass: we can switch to the " + id + " frame");
	}
	
	public static void SwitchFrame(WebElement element) {
		driver.switchTo().frame(element);
		System.out.println("Pass: we can switch to the frame");
	}

	public static void SwitchFrame() {
		driver.switchTo().defaultContent();
		System.out.println("Pass: we can switch to the frame");
	}

	/*
	 * name of the Method: CreateReport BriedDescriotion : This will create a empty
	 * Extent Report. Arguments : No Arguments Created By : Automation Team created
	 * Date : 14/02/2020 Last Modified : 14/02/2020
	 */
	public static void CreateReport() {
		String fileName = new SimpleDateFormat("'SFDCReport_'YYYYMMddHHmm'.html'").format(new Date());
		String path = "C:\\GIT\\Demo-221-MavenTestNGGitJenkins\\Reports\\" + fileName;
		report = new ExtentReports(path);
	}
	
	/* name of the method:   mouseOver
	 * BriefDescription  :   mouseOver  
	 * Arguments         :  obj,index 
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */ 

	public static void MouseOver(WebDriver driver,WebElement obj) {
		if(obj.isDisplayed()) {
	    Actions action=new Actions(driver);
	   action.moveToElement(obj).build().perform();
		System.out.println("Pass: "+obj+" is present");
		//logger.log(LogStatus.PASS,  "obj is present" );
		}
	 else {
			System.out.println("Fail:"+obj+" is not present.Please chk application");
		//	logger.log(LogStatus.FAIL,  "obj is not present.Please chk application" );
		}
	}


	/*
	 * name of the method: EnterText BriefDescription : entering textvalue for
	 * textbox Arguments : element --->object text --->to be entered objName
	 * --->object name createdby : Automation team created date : 14/02/20209
	 * LastModified Date: 14/02/2020
	 */
	public static void EnterText(WebElement element, String text, String objName) {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName + " Textbox is not found.");
		} else {
			logger.log(LogStatus.INFO, objName + " Textbox is found");
			element.sendKeys(text);
		}
	}

	public static void Click(WebElement element, String objName) {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName + " Element is not found.");
		} else {
			logger.log(LogStatus.INFO, objName + " Element is found");
			element.click();
		}
	}
}
