Feature: Multiple Windows

@multipleWindows
Scenario: Verify user can add new element
	Given User is on retail website homepage
	Then User click on Test Selenium link
	And User verify 'Add or Remove Elements' page
	And User click on the Add Element button
	And User verify Remove element is added to the page