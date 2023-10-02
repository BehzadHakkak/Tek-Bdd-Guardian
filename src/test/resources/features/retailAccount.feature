Feature: Retail Account Page

Background:
	Given User is on retail website homepage
	When User click on the login link
	And User enter email 'guardianscucumber@gmail.com' and password 'Guardians@123'
	And User click on login button
	Then Verify user is logged in

@updatePI
Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'GuardiansBDD' and Phone '4215553333'
    And User click on Update button
    Then user profile information should be updated

@addPaymentMethod
Scenario: Verify User can add a payment method
    When User click on Account option
    And User click on Add a payment method link
    And User fill Debit or credit card information
    |cardNumber|nameOnCard|expirationMonth|expirationYear|securityCode|
    |1111222233335555|Guardians|12|2024|561|
    And User click on Add your card button
    Then a message should be displayed 'Payment Method added sucessfully'
    
@addAddress
Scenario: Verify User can add an Address
    When User click on Account option
    And User click on Add address option
    And user fill new address form with below information
    |country|fullName|phoneNumber|streetAddress|apt       |city     | state |zipCode   |
    |countryValue|fullnameValue|PhoneValue|stAddress|aptValue|cityValue|stateValue|zipCodeValue|
    And User click Add Your Address button
    Then a message should be displayed 'Address Added Successfully'