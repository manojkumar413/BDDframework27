Feature: Github Website

Scenario Outline: Github Website scenario test

Given user is already on Login Page
When title of login page is Github
Then user enters "<username>" and "<password>"
Then user clicks on login button
Then user is on home page
Then Close the browser


Examples:
	| username | password |
	| devasanimanojkumar@gmail.com  | MKDevasa@143 |
	| devasanimanojkumar@gmail.com  | MKDevasa@143 |	