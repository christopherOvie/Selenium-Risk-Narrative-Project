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
import pages.CareersPage;
import pages.JobsPage;
import pages.LoginPage;

import utilities.WebSiteUtility;

public class SearchingForJobs {
	WebSiteUtility su;
	RemoteWebDriver driver;
	FluentWait<RemoteWebDriver> wait;
	Scenario se;
	LoginPage lp;
	AboutUsPage ap;
	JobsPage jp;
	CareersPage cp;

	Shared sh;

	public SearchingForJobs(Shared sh) {
		this.sh = sh;
		this.se = sh.se;

	}

	@Given("User open {string} browser")
	public void method1(String bn) throws Exception {
		su = new WebSiteUtility();
		sh.driver = su.openBrowser(bn); // important to create shared driver
		this.driver = sh.driver; // important to assign shared driver to local driver
		wait = su.defineWait(driver);
		lp = new LoginPage(driver, wait);
		ap = new AboutUsPage(driver, wait);
		jp = new JobsPage(driver, wait);
		cp = new CareersPage(driver, wait);
	}

	@When("User opens the LexisNexis Risk website")
	public void method2() throws Exception {
		su.launchSite(sh.driver);
		
	}

	@When("navigates to About us page")
	public void click_on_about_us_link() throws InterruptedException {
		lp.clickOnAcceptCookies();
		lp.clickOnAboutUs();
		se.log("click on about us");

	}

	@When("click on careers link")
	public void click_on_careers_link() throws InterruptedException {
		ap.clickOnCareers();
	}

	@When("User clicks on Search all jobs")
	public void i_attempt_to_search_all_jobs() throws InterruptedException {
		cp.clickOnSearchAllJobs();
	}

//	@Then("title should contain {string}")
//	public void title_should_contain(String title) {
//		if (driver.getTitle().contains(title)) {
//			se.log("title is correct");
//		} else {
//			se.log("title is incorrect because it is " + driver.getTitle());
//			Assert.fail();
//		}
//	}

	@When("User searches for {string}")
	public void user_searches_for(String job) throws InterruptedException {
		Thread.sleep(3000);
		jp.enterOnSearchBox(job);
	}

	@Then("At least one or more search result is displayed")
	public void search_results_should_display_at_least_one_or_more_of_the_job() throws InterruptedException {
		Thread.sleep(3000);
		if (jp.isResultFound()) {
			se.log("result found");
		} else {
			se.log("result not found");
			Assert.fail();
		}

//		@Then("At least one or more search result is displayed")
//		public void at_least_one_or_more_search_result_is_displayed() {
//		    // Write code here that turns the phrase above into concrete actions
//		    throw new io.cucumber.java.PendingException();
//		}

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

	@Then("close site")
	public void close_site() {
		driver.quit();
	}

}
