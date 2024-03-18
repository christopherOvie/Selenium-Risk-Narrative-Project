package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class AboutUsPage {
	private RemoteWebDriver driver;
	private FluentWait<RemoteWebDriver> wait;

	
	public AboutUsPage(RemoteWebDriver driver, FluentWait<RemoteWebDriver> wait) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}
	
	@FindBy(xpath = "//*[contains(text(),'Careers')]")
	private WebElement careers;
	
	
	public void clickOnCareers() throws InterruptedException {
		
		WebElement elementToHoverAndClick = careers;

        // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Perform mouse hover
        actions.moveToElement(elementToHoverAndClick).perform();

        // Perform click after the hover
        actions.click().perform();	
		}
	
	

	
	
}
