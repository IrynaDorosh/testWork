@all
Feature: Log in functionality

Scenario: log in via "Log in with email" link
 #actions at a Start page
 Given User is on the Start page
 When User logins with his email
 Then User redirects to Dashboard page

 #Scenario: log in via FB button






