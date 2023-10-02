package tek.bdd.guardians.steps;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;

import io.cucumber.java.en.Then;

import tek.bdd.guardians.pages.POMFactory;
import tek.bdd.guardians.utilities.CommonUtility;

public class MultipleWindowsSteps extends CommonUtility{
	
	POMFactory pomFactory = new POMFactory();
	public static String parentWindow;
	
	@Then("User click on Test Selenium link")
	public void userClickOnTestSeleniumLink() {
		parentWindow = getDriver().getWindowHandle();
		click(pomFactory.multipleWinPage().testSeleniumLink);
		logger.info("Test Selenium link was clicked sucessfully");
	}
	@Then("User verify {string} page")
	public void userVerifyPage(String string) {
		
		switchToNewWindow(parentWindow);
		logger.info("Switched to new window successfully");
		
		Assert.assertEquals(string, pomFactory.multipleWinPage().addOrRemoveElements.getText());
		logger.info("Add or Remove Element text was verified successfully");

	}
	@Then("User click on the Add Element button")
	public void userClickOnTheAddElementButton() {
		click(pomFactory.multipleWinPage().addNewElementBttn);
		logger.info("Add New Element button was clicked successfully");
	}
	@Then("User verify Remove element is added to the page")
	public void userVerifyRemoveElementIsAddedToThePage() {
		String expected = "Remove";
		String actual = pomFactory.multipleWinPage().removeElement.getText();
		Assert.assertEquals(expected, actual);
		logger.info("Remove element was verified successfully");
	}
}
