package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;

public class LoginPage {

	// Properties for locating elements
	private RemoteWebDriver driver;
	private FluentWait<RemoteWebDriver> wait;
	

	
	@FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
	private WebElement acceptCookies;
	
	@FindBy(linkText = "About Us")
	private WebElement AboutUs;
	
	
	@FindBy(xpath = "(//h1[contains(text(),'Transform Your Risk Decision Making')])")
    private WebElement transformRiskHeading;

    @FindBy(xpath = "(//h4[contains(text(),'Financial Services')])")
    private WebElement financialServicesLink;

    @FindBy(xpath = "(//h4[contains(text(),'Insurance')])[1]")
    private WebElement insuranceLink;

    @FindBy(xpath = "//h4[contains(text(),'Life and Pensions')]")
    private WebElement lifeAndPensionsLink;

    @FindBy(xpath = "//h4[contains(text(),'Corporations and Non-Profits')]")
    private WebElement corporationsAndNonProfitsLink;
	
	

	//[class='search-results-item-title-url']
	// Constructor method for connecting to step definition classes and runner
	// classes
	public LoginPage(RemoteWebDriver driver, FluentWait<RemoteWebDriver> wait) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
		
	}

	// Operational methods to operate. and observe elements
	public void clickOnAcceptCookies() throws InterruptedException {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(acceptCookies)).click();
	}
//	
	public void clickOnAboutUs() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(AboutUs)).click();
	}
	
	 public boolean isTransformRiskHeadingDisplayed() {
	        return transformRiskHeading.isDisplayed();
	    }

	    public boolean isFinancialServicesLinkClickable() {
	        return financialServicesLink.isEnabled();
	    }

	    public boolean isInsuranceLinkClickable() {
	        return insuranceLink.isEnabled();
	    }

	    public boolean isLifeAndPensionsLinkClickable() {
	        return lifeAndPensionsLink.isEnabled();
	    }

	    public boolean isCorporationsAndNonProfitsLinkClickable() {
	        return corporationsAndNonProfitsLink.isEnabled();
	    }
	
	
//	  public void clickOnElementWithJavaScript() {
//	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//	        jsExecutor.executeScript("arguments[0].click();", acceptCookies);
//	    }
//	
	
	
	
	
	



}
