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
	
	public JobsPage(RemoteWebDriver driver, FluentWait<RemoteWebDriver> wait){
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;	
	}

	

	@FindBy(xpath = "//div[@class='search-box']//input[@role='textbox']")
	private WebElement searchBox;
	//@FindBy(xpath = "//div/div/div/div/div/div/div/input")
	//private By searchBox = By.xpath("//div/div/div/div/div/div/div/input");
	
	//@FindBy(css = "[class='search-results-item-title-url']")
	
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
    
    
    
    
   /* public  List<WebElement> getAll() throws InterruptedException {
    	
		 wait.until(ExpectedConditions.visibilityOfAllElements(seartchResultList));
    	  List<WebElement> elements = seartchResultList;

    	  
          // Print the number of elements found
          System.out.println("Number of elements found: " + elements.size());

          // Iterate through the list of elements and print their text
          for (WebElement element : elements) {
              System.out.println("Element text: " + element.getText());
          }
		return elements;

    }*/
    
    
    
    
//    public void waitForElementsVisibility(List<WebElement> elements) {
//    	
//    	
//    	  waitFor(ExpectedConditions.visibilityOfAllElements(elements));
//    	    
//    	}
    
    
    /*public List<String> searchResults(){
    	
    	//wait.until(ExpectedConditions.visibilityOfAllElements(seartchResultList));
    	List<String> results = new ArrayList<>();
    	        List<WebElement> elements = driver.findElements(searchResult);
    	        System.out.println("The number of elements found: " + elements.size());
    	        for (WebElement element : elements) {
    	        	String name  = element.getText();
    	            results.add(name);
    	            System.out.println(name);
    	        }
    	        return results;
    	
    	   }
    
    
    
    public List<String> searchResults2(List<WebElement> elements){
    	// wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete';")); 
    	
//    	wait.until(ExpectedConditions.visibilityOfAllElements(searchResult));
//    	List<String> results = new ArrayList<>();
//    	
//    	        List<WebElement> elements1 = searchResult;
//    	        
//    	        for (WebElement element : elements1) {
//    	            results.add(element.getText());
//    	        }
//    	        return results;
    	return null;
    	   }*/
    
//    public void waitForElementsVisibility(List<WebElement> elements) {
//    	  waitFor(ExpectedConditions.visibilityOfAllElements(elements));
//    	  
//    	}
////    public List<String> searchResults(){
//        List<String> results = new ArrayList<>();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultLocator));
//        List<WebElement> elements = seartchResultList;
//        for (WebElement element : elements) {
//            results.add(element.getText());
//        }
//        return results;
//    }

    	
//	public void clickOnSearchBox() throws InterruptedException {
//		wait.until(ExpectedConditions.visibilityOf(searchBox)).click();
//	}
	
	public void enterOnSearchBox(String text) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(text);
 
		//wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
		//driver.findElement(searchBox).sendKeys(text);
	}
	
	
	
	/*   public  void typeWithJavaScript(WebDriver driver, WebElement searchBox, String text) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].value = arguments[1]", searchBox, text);
	    }*/
//	public List<String> searchResults(){
//
//		List<String> results = new ArrayList<String>();
//
//		List<WebElement> allSearchResults = driver.findElements(By.xpath("[class='search-results-item-title-url']"));
//
//		for(WebElement e : allSearchResults) {
//
//		  System.out.println(e.getText());
//		  results = allSearchResults.add(e.getText();
//		}
//		return results;
//
//
//		}
	
	
}
//public void getSearchResults() {
//	List<WebElement> myElements =searchResult
//			for(WebElement e : myElements) {
//	  System.out.println(e.getText());
//	}
//}


