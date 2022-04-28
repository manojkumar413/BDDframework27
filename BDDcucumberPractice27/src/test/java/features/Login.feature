@TestSetup @LoginTest @TestCleanup
Feature: Application Login

  # prereq that runs before each test
  Background:
    Given Browser is opened
    Then Navigate to the Github login page
    And Check if page is ready
    
  
  @Negative
  Scenario: TC0001_ForgetPasswordTest
    Given User clicks forget password link
    And Enters email "sdet.testautomation@gmail.com" and clicks retrieve button
  
  @Positive
  Scenario: TC0002_FormAuthentication
      Given title of login page is Github
	  And user enters "devasanimanojkumar@gmail.com " and "MKDevasa@143"
    Then user clicks on login button
    Then user is on home page
  @Negative 
  Scenario: TC0003_FormAuthenticationBadInfo
    Given User clicks form authentication link
    And Enters userid "sdetAutomatiom" and password "pass@word"
    Then Verify LoginPage message "Incorrect username or password." is displayed
    
 
