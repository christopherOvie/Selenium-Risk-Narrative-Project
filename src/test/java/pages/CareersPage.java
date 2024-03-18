package pages;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class CareersPage {
	private RemoteWebDriver driver;
	private FluentWait<RemoteWebDriver> wait;
	
	
	
	public CareersPage(RemoteWebDriver driver, FluentWait<RemoteWebDriver> wait) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}
	
	@FindBy(xpath = "//div/a[contains(text(),'Search all jobs')]")
	private WebElement searchAllJobs;
	
	
	
	public void clickOnSearchAllJobs() throws InterruptedException {
		ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles()) ;
        driver.switchTo().window(wid.get(1));
        wait.until(ExpectedConditions.visibilityOf(searchAllJobs)).click();
	}
		
	
	
	
	
}
