Feature: Facebook Login Validation


@Negative
@FacebookHomePage
Scenario: To check the functionality for the Facebook Login Page with invalid login credentials

Given User Login to the Facebook Login Page
When User Enter email as "Username45777****^&rt"
And User Enter Password as "password1"
And Click on Log In button
Then Login should be Unsuccessful and error message should be displayed

@Positive
@ForgottenAccountPage
Scenario: To Check Facebook Forgotten Account Page Functionality

Given User Login to the Facebook Login Page
And User Navigate to the Facebook Forgotten Account Page

When User enters "UserName123" as email address or mobile number
And User clicks on the Cancel button

Then User should navigate to the Facebook Home page again