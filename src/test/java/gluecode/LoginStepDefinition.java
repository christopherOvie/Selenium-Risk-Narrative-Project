package gluecode;

//import java.util.Map;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AboutUsPage;
import pages.JobsPage;
import pages.LoginPage;

import utilities.WebSiteUtility;

public class LoginStepDefinition {
	WebSiteUtility su;
	RemoteWebDriver driver;
	FluentWait<RemoteWebDriver> wait;
	Scenario se;
	LoginPage lp;
	AboutUsPage ap;
	JobsPage jp;

	Shared sh;

	public LoginStepDefinition(Shared sh) {
		this.sh = sh;
		this.se = sh.se;

	}

	@Given("open {string} browser")
	public void method1(String bn) throws Exception {
		su = new WebSiteUtility();
		sh.driver = su.openBrowser(bn); // important to create shared driver
		this.driver = sh.driver; // important to assign shared driver to local driver
		wait = su.defineWait(driver);
		lp = new LoginPage(driver, wait);
		ap = new AboutUsPage(driver, wait);
		jp = new JobsPage(driver, wait);

	}

	@When("launch site")
	public void method2() throws Exception {
		su.launchSite(sh.driver);
	}

	@When("click on about us link")
	public void click_on_about_us_link() throws InterruptedException {
		lp.clickOnAcceptCookies();
		lp.clickOnAboutUs();
		se.log("click on about us");
	}

	@When("click on careers link")
	public void click_on_careers_link() throws InterruptedException {
		ap.clickOnCareers();
	}

	@When("I attempt to search all jobs")
	public void i_attempt_to_search_all_jobs() throws InterruptedException {
		ap.clickOnSearchAllJobs();
	}

	@Then("title should contain {string}")
	public void title_should_contain(String title) {
		if (driver.getTitle().contains(title)) {
			se.log("title is correct");
		} else {
			se.log("title is incorrect because it is " + driver.getTitle());
			Assert.fail();
		}
	}

	@When("I search for {string} in the search box")
	public void i_search_for_in_the_search_box(String job) throws InterruptedException {

		jp.enterOnSearchBox(job);
		Thread.sleep(5000);

	}

	@Then("search results should display at least one or more of the job")
	public void search_results_should_display_at_least_one_or_more_of_the_job() throws InterruptedException {

		if (jp.isResultFound()) {
			se.log("result found");
		} else {
			se.log("result not found");
			Assert.fail();
		}

		// JavascriptExecutor js = (JavascriptExecutor) driver;

		/*
		 * wait.until(d -> js.executeScript("return jQuery.active === 0").equals(true));
		 * wait.until(d
		 * ->js.executeScript("return document.readyState").equals("complete"));
		 */

		// java.util.List<WebElement> results = jp.getYourWebElements();
		// java.util.List<String> results =jp.searchResults();
		// Assert.assertTrue(jp.searchResults().size() > 0);
//		 JavascriptExecutor js = (JavascriptExecutor) driver;
//		 
//		 
//		  while (true) {
//	            boolean pageLoaded = (Boolean) js.executeScript("return document.readyState").equals("complete");
//	            if (pageLoaded)
//	                break;
//	            try {
//	                Thread.sleep(100);
//	            } catch (InterruptedException e) {
//	                e.printStackTrace();
//	            }
//	        }
//		

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//   	 wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete';")); 
//		
//		java.util.List<WebElement>  results =	jp.getAll();
//		Assert.assertTrue(results.size() > 1);

	}

	@When("accept cookies")
	public void accept_cookies() throws InterruptedException {
		lp.clickOnAcceptCookies();
	}

	@When("verify if elements are present and clickable")
	public void verify_if_elements_are_present_and_clickable() {

		boolean isTransformRiskHeadingDisplayed = lp.isTransformRiskHeadingDisplayed();
		Assert.assertTrue(isTransformRiskHeadingDisplayed);
		boolean isFinancialServicesLinkClickable = lp.isFinancialServicesLinkClickable();
		Assert.assertTrue(isFinancialServicesLinkClickable);
		boolean isCorporationsAndNonProfitsLinkClickable = lp.isCorporationsAndNonProfitsLinkClickable();
		Assert.assertTrue(isCorporationsAndNonProfitsLinkClickable);
		boolean isInsuranceLinkClickable = lp.isInsuranceLinkClickable();
		Assert.assertTrue(isInsuranceLinkClickable);
		boolean isLifeAndPensionsLinkClickable = lp.isLifeAndPensionsLinkClickable();
		Assert.assertTrue(isLifeAndPensionsLinkClickable);
	}

	@Then("close site")
	public void close_site() {
		driver.quit();
	}

}
