package tek.bdd.guardians.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.bdd.guardians.base.BaseSetup;

public class HomePage extends BaseSetup{
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(linkText = "TEKSCHOOL")
	public WebElement tekschoolLogo;
	
	@FindBy(id = "hamburgerBtn")
	public WebElement allOptions;
	
	@FindBy(xpath = "//div[@class='sidebar__content']//span")
	public List<WebElement> sidebarOptions;
	
	@FindBy(xpath = "//div[@class='sidebar_content-item']//span")
	public List<WebElement> sidebarAllOptions;
	
}
	

