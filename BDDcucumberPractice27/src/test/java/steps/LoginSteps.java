package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginSteps {
    WebDriver driver;
   @Before()
    public void testSetup()  {
       System.out.println("Hi Welcome to BDD framework.....");
       
        
       
    }

    @After()
    public void afterValidation(){
        driver.quit();
        System.out.println("closing browser for this scenerio");
        }
    
    
    @Given("Browser is opened")
    public void browser_is_opened() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
      }

    
    @Then("Navigate to the Github login page")
    public void navigate_to_the_github_login_page() {
        
      driver.get("https://github.com/login");
    }

    @Then("Check if page is ready")
    public void check_if_page_is_ready() {
        String title = driver.getTitle();
        System.out.println(title);
        
    }

    @Given("User clicks forget password link")
    public void user_clicks_forget_password_link() {
        driver.findElement(By.xpath("//a[@class='label-link position-absolute top-0 right-0']")).click();
       
       
    }

    @Given("Enters email {string} and clicks retrieve button")
    public void enters_email_and_clicks_retrieve_button(String string) {
        driver.findElement(By.name("email")).sendKeys(string);
    }

    @Given("title of login page is Github")
    public void title_of_login_page_is_github() {
        String title = driver.getTitle();
        System.out.println(title);
        
    }

    @Given("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        driver.findElement(By.id("login_field")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("user clicks on login button")
    public void user_clicks_on_login_button() {
        WebElement loginBtn =
                driver.findElement(By.name("commit"));
                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("arguments[0].click();", loginBtn);
               }

    @Then("user is on home page")
    public void user_is_on_home_page() {
        String title = driver.getTitle();
        System.out.println("--------Home Page title :"+ title+"--------");
       
    }

    @Given("User clicks form authentication link")
    public void user_clicks_form_authentication_link() {
        driver.get("https://github.com/login");
    }

    @Given("Enters userid {string} and password {string}")
    public void enters_userid_and_password(String username, String password) throws InterruptedException {
        driver.findElement(By.id("login_field")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(4000);
        driver.findElement(By.name("commit")).click();
        Thread.sleep(4000);
        
    }

    @Then("Verify LoginPage message {string} is displayed")
    public void verify_login_page_message_is_displayed(String string) {
        String str=driver.findElement(By.xpath("//div[@class='px-2']")).getText();
        System.out.println(str);
        Assert.assertEquals(string, str);
    }
    
    

}
