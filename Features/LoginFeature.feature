Feature: Login

@Sanity
  Scenario: Successfully Login with Valid Crendential
    Given User Launch Chrome Broswser
    And User Open URL "http://localhost:8888/"
    When User enters UserName as "admin" and Password as "admin"
    And click On Login 
    Then Page Tittle should be "admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM"
    When User Click on log Out Link 
    Then Page title should be "vtiger CRM 5 - Commercial Open Source CRM"
    And close browser
@regression  
Scenario Outline: Successful Login with valid credential
     Given User Launch Chrome Broswser
    And User Open URL "http://localhost:8888/"
    When User enters UserName as "<userName>" and Password as "<password>"
    And click On Login 
    Then Page Tittle should be "admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM"
    When User Click on log Out Link 
    Then Page title should be "vtiger CRM 5 - Commercial Open Source CRM"
    And close browser
    
   
Examples:
|userName|password|
|admin|admin|
|ajeet|admin|