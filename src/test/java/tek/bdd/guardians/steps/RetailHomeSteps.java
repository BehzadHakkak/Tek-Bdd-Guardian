package tek.bdd.guardians.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.cucumber.java.en.When;
import tek.bdd.guardians.pages.POMFactory;
import tek.bdd.guardians.utilities.CommonUtility;

public class RetailHomeSteps extends CommonUtility{
	
	//We will create object of POMFactory class to access the page objects in page object classes
	//using the get method we create in the POMFactory class
	
	POMFactory pomFactory = new POMFactory();

	@When("User click on All section")
	public void userClickOnAllSection() {
		
		click(pomFactory.homePage().allOptions);
		logger.info("All Options dropdown was clicked");

	}
	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
		
		List<List<String>> shopByDepartment = dataTable.asLists(String.class);
		for(int i = 0; i < shopByDepartment.get(0).size(); i++) {
			Assert.assertTrue(isElementDisplayed(
					getDriver().findElement(By.xpath("//div[@class='sidebar__content']//span[text()='"+shopByDepartment.get(0).get(i)+"']"))));
			logger.info("Option " + shopByDepartment.get(0).get(i) + " is displayed");
		}

	}
	
	@When("User on {string}")
	public void userOn(String department) {
		List<WebElement> departments = pomFactory.homePage().sidebarOptions;
		for(int i = 0; i < departments.size(); i++) {
			if(departments.get(i).getText().equalsIgnoreCase(department)) {
				departments.get(i).click();
				break;
			}
		}
	}
	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {
		List<List<String>> departmentOptions = dataTable.asLists(String.class);
		List<WebElement> options = pomFactory.homePage().sidebarAllOptions;
		
		for(int i = 0; i < departmentOptions.get(0).size(); i++) {
			for(WebElement elements : options) {
				if(elements.getText().equalsIgnoreCase(departmentOptions.get(0).get(i))) {
					Assert.assertTrue(elements.isDisplayed());
					logger.info("The option " + elements.getText() + " is present");
				}
			}
		}
		
	}
}
