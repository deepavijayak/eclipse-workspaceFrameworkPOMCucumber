Feature: implementing login features

Scenario: Valid login using correct username and password
Given the url "https://login.salesforce.com/"
When i land in "LoginPage"
When i enter Username as "raghunathan@cognizant.com"
And  i enter Password as "Lavansri1516"
And i click on the "Login" button
When i land in "HomePage"
Then i should see the home page

Scenario: Invalid login using correct username and empty password
Given the url "https://login.salesforce.com/"
When i land in "LoginPage"
When i enter Username as "raghunathan@cognizant.com"
And  i enter Password as " "
And i click on the "Login" button
Then i should see the error message "Please enter your password."

Scenario: Test the remember username check box 
Given the url "https://login.salesforce.com/"
When i land in "LoginPage"
When i enter Username as "raghunathan@cognizant.com"
And  i enter Password as "Lavansri1516"
And i click on the "Remember me" checkbox
And i click on the "Login" button
When i land in "HomePage"
Then i should see the home page
And i click on the "User menu" Usermenubutton
And i click on the "Logout" option from usermenu 
When i land in "LoginPage"

Scenario: Test forgot password feature
Given the url "https://login.salesforce.com/"
When i land in "LoginPage"
When i click on the "Forgot Password" link
When i land in "ForgotPasswordPage"
Then i should see the Forgot Password page.
And i enter the username as "raghunathan@cognizant.com"
And i click on the "Continue" button
Then i should see the "Check your Email" text

Scenario: Validate Login Error Message using incorrect username and incorrect password
Given the url "https://login.salesforce.com/"
When i land in "LoginPage"
When i enter Username as "123"
And  i enter Password as "22131"
And i click on the "Login" button
Then i should see the error message "Please check your username and password. If you still can't log in, contact your Salesforce administrator.”
