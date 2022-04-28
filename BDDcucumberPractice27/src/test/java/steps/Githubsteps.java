package steps;

//import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Githubsteps {
    
    WebDriver driver;
    
    
  @Given("^user is already on Login Page$")
  public void user_already_on_login_page(){
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
  driver.get("https://github.com/login");
  }
 
 
  @When("^title of login page is Github$")
  public void title_of_login_page_is_Github(){
  String title = driver.getTitle();
  System.out.println(title);
  Assert.assertEquals("Sign in to GitHub · GitHub", title);
  }
 
  //Reg Exp:
  //1. \"([^\"]*)\"
  //2. \"(.*)\"
 
  @Then("^user enters \"(.*)\" and \"(.*)\"$")
  public void user_enters_username_and_password(String username, String password){
  driver.findElement(By.id("login_field")).sendKeys(username);
  driver.findElement(By.id("password")).sendKeys(password);
  }
 
  @Then("^user clicks on login button$")
  public void user_clicks_on_login_button() {
  WebElement loginBtn =
  driver.findElement(By.name("commit"));
  JavascriptExecutor js = (JavascriptExecutor)driver;
  js.executeScript("arguments[0].click();", loginBtn);
  }
 
 
  @Then("^user is on home page$")
  public void user_is_on_hopme_page() throws InterruptedException{
  String title = driver.getTitle();
  System.out.println("-------------------------------------------Home Page title :"+ title+"------------------------------------------");
  Assert.assertEquals("GitHub", title);
  driver.findElement(By.xpath("(//span[@class='dropdown-caret'])[2]")).click();
//  List<WebElement> list=driver.findElements(By.xpath("(//details-menu[@class='dropdown-menu dropdown-menu-sw'])[2]//button"));
//  System.out.println(list.size());
//  for(int i=0;i<list.size();i++) {
//      System.out.println(list.get(i).getText());
//      if(list.get(i).getText().contains("Sign")) {
//          list.get(i).click();
//          break;
//          
//      } }(//details-menu[@class='dropdown-menu dropdown-menu-sw'])[2]//button
//  List<WebElement> allDropDownValues=driver.findElements(By.xpath("(//details-menu[@class='dropdown-menu dropdown-menu-sw'])[2]/*"));
//  
//  //Finding the count of all elements
//  int dropDownCount= allDropDownValues.size();
//  
//  //Printing count of all items
//  System.out.println("Total items present in the dropdown : "+dropDownCount);
//
//  //For loop to go each and every element in the dropdown
//  for(int i=0;i<dropDownCount;i++)
//  {
//       //if condition to check specific element "Java"
//      if(allDropDownValues.get(i).getText().contains("Sign Out"))
//      {
//          
//          //Clicking the desired element
//          allDropDownValues.get(i).click();
//          //Stop continuing the loop as we already found the desired element
//          break;
//      }



//  }
  
  

  }
  
 
 
  @Then("^Close the browser$")
  public void close_the_browser(){
      driver.quit();
  }

}
