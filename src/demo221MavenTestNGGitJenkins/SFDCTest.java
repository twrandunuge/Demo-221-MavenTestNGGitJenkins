package demo221MavenTestNGGitJenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

public class SFDCTest extends ReusableMethods{
	
	
	@BeforeTest
	public void BeforeTest() {
	System.out.println("BeforeTest");	
	}
	
	
	@BeforeClass
	public void Initialize() {
	InitializeDriver();
	CreateReport();
	}
	
	@Test
	@Parameters("browser")
	public void LoginSFDC() throws InterruptedException {
		logger = report.startTest("LoginSFDC");
		OpenUrl("https://login.salesforce.com");
		Thread.sleep(2000);
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		EnterText(Uname, "twr@company.com", "Username");
		
		Thread.sleep(7000);
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		EnterText(pwd, "Lychee@123", "Password");
		// pwd.sendKeys("Test4321");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		// loginBtn.click();
	}
	
	@AfterClass
	public void CloseTest() {
		CloseBrowser();
		CloseReport();
	}
	
	@AfterTest
	public void AfterTest() {
	System.out.println("AfterTest");	
	}
	

}