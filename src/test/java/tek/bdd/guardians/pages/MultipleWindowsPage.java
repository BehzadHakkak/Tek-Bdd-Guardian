package tek.bdd.guardians.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.bdd.guardians.base.BaseSetup;

public class MultipleWindowsPage extends BaseSetup{
	
	public MultipleWindowsPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(linkText = "Test Selenium")
	public WebElement testSeleniumLink;
	
	@FindBy(xpath = "//p[text()='Add or Remove Elements']")
	public WebElement addOrRemoveElements;
	
	@FindBy(xpath = "//button[text()='Add New Element']")
	public WebElement addNewElementBttn;
	
	@FindBy(xpath = "//button[text()='Remove']")
	public WebElement removeElement;

}
