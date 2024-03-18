package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class JobsPage {
	private RemoteWebDriver driver;
	private FluentWait<RemoteWebDriver> wait;

	public JobsPage(RemoteWebDriver driver, FluentWait<RemoteWebDriver> wait) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}

	@FindBy(xpath = "//div[@class='search-box']//input[@role='textbox']")
	private WebElement searchBox;

	private By searchResult = By.className("search-results-item-title-url");

	@FindBy(xpath = "//div[@class='search-results']//div[@class='ais-hits--item']")
	private List<WebElement> seartchResultList;

	// Method 1 to return a list of WebElements
//    public List<WebElement> getYourWebElements() throws InterruptedException {
//    	
//    	 List<WebElement> elements =searchResult;
//    	 wait.until(ExpectedConditions.visibilityOfAllElements(searchResult));
//// 	    
//// 	    
//         // Now you can perform actions on these elements as needed
//         for (WebElement element : elements) {
//            System.out.println(element.getText()); // Get text of element.getText();     
//         }
//        return seartchResultList;
//    }
//    

	public boolean isResultFound() {
		System.out.println(seartchResultList.size());
		return seartchResultList.size() > 0;
	}

	public void enterOnSearchBox(String text) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(text);
		

	}

}
