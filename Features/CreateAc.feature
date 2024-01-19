
Feature: Create Account in Marketing

Background:  steps  common for all scenario
 Given User Launch Chrome Broswser
    And User Open URL "http://localhost:8888/"
    When User enters UserName as "admin" and Password as "admin"
    And click On Login 
    Then User can view Home Page and Titile should be "admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM"
    When User Click on Marketing
    And Click On Account 
    Then User Can view Comfirmation Header "Marketing > Accounts"

@Sanity @regression
  Scenario: Create New Account sucessful
   
    When User click on Plus icon(Create new Account icon)
    Then User can view confirmation Header "Creating New Account"
    When User Enter Account info
    And Click On Save Button Account Should created
     And close browser
     
     
@regression
Scenario: search customer by Account Name

    When User enter Account Name in search Text Box
    And Select Account Name From DropDown
    And click On Serch Button
    Then User Should found  Account Name In the search Table
   And close browser