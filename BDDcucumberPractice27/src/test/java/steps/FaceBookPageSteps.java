package steps;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

public class FaceBookPageSteps {
	public static WebDriver driver;
	//hooks
	@Before
	public static void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@After
	public static void tearDown(Scenario scenario) throws Exception
	{
				if(scenario.isFailed())
				{
					File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					//FileHandler.copy(srcfile, new File("D:\\screenshot.png"));
				
					FileHandler.copy(srcfile, new File(System.getProperty("user.dir") +"\\target\\screenshot.png"));
					
				}
		driver.quit();
	}
	
	//Facebook Login Home Page - FacebookLoginPage.feature
	@Given("User Login to the Facebook Login Page")
	public void user_login_to_the_facebook_login_page() {
		driver.get("https://www.facebook.com/");
	    
	}

	@When("User Enter email as {string}")
	public void user_enter_email_as(String email) {
		driver.findElement(By.id("email")).sendKeys(email);
	   
	}

	@When("User Enter Password as {string}")
	public void user_enter_password_as(String password) {
		driver.findElement(By.id("pass")).sendKeys(password);
	   
	}

	@When("Click on Log In button")
	public void click_on_log_in_button() {
		driver.findElement(By.name("login")).click();
	    
	}

	@Then("Login should be Unsuccessful and error message should be displayed")
	public void login_should_be_unsuccessful_and_error_message_should_be_displayed() {
	   String expectederror = "2The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
	   String actualerror = driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
       Assert.assertEquals(expectederror, actualerror);	}
	
	//ForgottenPasswordPage.feature
	
	@Given("User Navigate to the Facebook Forgotten Account Page")
	public void user_navigate_to_the_facebook_forgotten_account_page() {
		driver.findElement(By.partialLinkText("Forgotten")).click();
	}

	@When("User enters {string} as email address or mobile number")
	public void user_enters_as_email_address_or_mobile_number(String email) {
		driver.findElement(By.id("identify_email")).sendKeys(email);

	}

	@When("User clicks on the Cancel button")
	public void user_clicks_on_the_cancel_button() {
	   driver.findElement(By.xpath("//div[@class = 'clearfix']/div/a")).click();
	}

	@Then("User should navigate to the Facebook Home page again")
	public void user_should_navigate_to_the_facebook_home_page_again() {
		
		String expectedTitle = "Log in to Facebook";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
	    Assert.assertEquals(expectedTitle, actualTitle);
	    
	}

}
