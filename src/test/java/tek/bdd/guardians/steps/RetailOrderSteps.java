package tek.bdd.guardians.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.*;

import tek.bdd.guardians.pages.POMFactory;
import tek.bdd.guardians.utilities.CommonUtility;

public class RetailOrderSteps extends CommonUtility{
	
	POMFactory pomFactory = new POMFactory();
	
	@Then("User change the category to {string}")
	public void userChangeTheCategoryTo(String category) {
		selectByVisibleText(pomFactory.retailOrderPage().allDepartmentDropdown, category);
		logger.info("Category was selected successfully from dropdown");
	}
	@Then("User search for an item {string}")
	public void userSearchForAnItem(String kasaOutdoorSmartPlug) {
		sendText(pomFactory.retailOrderPage().searchInputField, kasaOutdoorSmartPlug);
		logger.info("Item name was entered successfully");
	}
	@Then("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(pomFactory.retailOrderPage().searchBttn);
		logger.info("Search button was clicked successfully");
	}
	@Then("User click on item")
	public void userClickOnItem() {
		click(pomFactory.retailOrderPage().itemkasaoutdoorsmartplug);
		logger.info("item was clicked successfully");
	}
	@Then("User select quantity {string}")
	public void userSelectQuantity(String itemQty) {
		selectByVisibleText(pomFactory.retailOrderPage().qtyDropdown, itemQty);
		logger.info("item quantity was selected succcessfully");
	}
	@Then("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(pomFactory.retailOrderPage().addToCartBttn);
		logger.info("Add item to the cart button was clicked successfully");
	}
	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String itemQtyInTheCart) {
		Assert.assertEquals(itemQtyInTheCart, pomFactory.retailOrderPage().cartItemQty.getText());
		logger.info("Item qty in the cart was validated successfully");
	}
	
	//add item to the cart and place your order
	
	@Then("User change the category to {string} Apex Legends")
	public void userChangeTheCategoryToApexLegends(String electronics) {
		selectByVisibleText(pomFactory.retailOrderPage().allDepartmentDropdown, electronics);
		logger.info("Category changed to electronics successfully");
	}
	@Then("User search for an item {string} Apex Legends")
	public void userSearchForAnItemApexLegends(String apexLegends) {
		sendText(pomFactory.retailOrderPage().searchInputField, apexLegends);
		logger.info("Item name was entered successfully");
	}
	@Then("User click on item Apex Legends")
	public void userClickOnItemApexLegends() {
		click(pomFactory.retailOrderPage().apexLegendsItem);
		logger.info("Item Apex Legends was clicked successfully");
	}
	@Then("User select quantity {string} for Apex Legends")
	public void userSelectQuantityForApexLegends(String apexLegendsQty) {
		selectByVisibleText(pomFactory.retailOrderPage().qtyDropdown, apexLegendsQty);
		logger.info("Apex Legends qty was changed successfully");
	}
	@Then("the cart icon quantity should change to {string} Apex Legends")
	public void theCartIconQuantityShouldChangeToApexLegends(String itemQtyInTheCart) {
		Assert.assertEquals(itemQtyInTheCart, pomFactory.retailOrderPage().cartItemQty.getText());
		logger.info("Item qty in the cart was validated successfully");
	}
	@Then("User click on Cart option")
	public void userClickOnCartOption() {
		click(pomFactory.retailOrderPage().cartBttn);
		logger.info("Cart Button was clicked successfully");
	}
	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		click(pomFactory.retailOrderPage().proceedToCheckoutBttn);
		logger.info("Proceed to check out button was clicked successfully");
	}
	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		click(pomFactory.retailOrderPage().placeOrderBttn);
		logger.info("Place your order button was clicked successfully");
	}
	
	//Cancel Order
	@Then("User click on Orders section")
	public void userClickOnOrdersSection() {
		click(pomFactory.retailOrderPage().OrderLink);
		logger.info("Order link was clicked successfully");
	}
	@Then("User click on first order in list")
	public void userClickOnFirstOrderInList() {
		List<WebElement> listOfOrder = pomFactory.retailOrderPage().listOfOrders;
		for(int i = 0; i < listOfOrder.size(); i++) {
			if(listOfOrder.get(i).getText().equalsIgnoreCase("Hide Details")) {
				
			}else if(listOfOrder.get(i).getText().equalsIgnoreCase("Show Details")) {
				click(pomFactory.retailOrderPage().listOfOrders.get(i));
			}
		}
		logger.info("First order in the list of clicked");
	}
	@Then("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
		List<WebElement> cancelBttns = pomFactory.retailOrderPage().cancelOrderBttn;
		click(cancelBttns.get(0));
		
		//cancel all orders
//		for(int i = 0; i < cancelBttns.size(); i++) {
//			click(cancelBttns.get(i));
//		}
		logger.info("Order Cancel button was clicked");
	}
	@Then("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReason(String cancelationReason) {
		selectByVisibleText(pomFactory.retailOrderPage().reasonForCancelation, cancelationReason);
		logger.info("Cancelation reason was selected");
	}
	@Then("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(pomFactory.retailOrderPage().cancelationSubmitBttn);
		logger.info("Cancel Submit Button was clicked successfully");
	}
	@Then("a cancelation message should be displayed {string}")
	public void aCancelationMessageShouldBeDisplayed(String CancelationSuccessMssg) {
		Assert.assertEquals(CancelationSuccessMssg, pomFactory.retailOrderPage().orderCancelledSuccessMssg.getText());
		logger.info("Cancelation success message was verified successfully");
	}

}
