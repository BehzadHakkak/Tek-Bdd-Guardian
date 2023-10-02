package tek.bdd.guardians.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import tek.bdd.guardians.pages.POMFactory;
import tek.bdd.guardians.utilities.CommonUtility;
import tek.bdd.guardians.utilities.DataGenerator;

public class RetailAccountSteps extends CommonUtility{
	
	POMFactory pomFactory = new POMFactory();
	
	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(pomFactory.retailAccountPage().accountLink);
		logger.info("Account link was clicked successfully");
	}
	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String name, String phoneNumber) {
		clearTextUsingSendKeys(pomFactory.retailAccountPage().nameField);
		sendText(pomFactory.retailAccountPage().nameField, name);
		logger.info("Name was entered successfully");
		clearTextUsingSendKeys(pomFactory.retailAccountPage().phoneField);
		sendText(pomFactory.retailAccountPage().phoneField, phoneNumber);
		logger.info("Phone Number was entered successfully");
	}
	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		click(pomFactory.retailAccountPage().updateBttn);
		logger.info("Update button was clicked successfully");
	}
	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(pomFactory.retailAccountPage().personalInfoUpdateSuccessMssg);
		String expectedMssg = "Personal Information Updated Successfully";
		String actualMssg = pomFactory.retailAccountPage().personalInfoUpdateSuccessMssg.getText();
		Assert.assertEquals(expectedMssg, actualMssg);
		logger.info("Account information was updated successfully");
	}
	
	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(pomFactory.retailAccountPage().addAPaymentMethodLink);
		logger.info("Add Payment Method link was clicked successfully");
	}
	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> paymentInfo = dataTable.asMaps(String.class, String.class);
		sendText(pomFactory.retailAccountPage().cardNumberField, paymentInfo.get(0).get("cardNumber"));
		sendText(pomFactory.retailAccountPage().nameOnCardField, paymentInfo.get(0).get("nameOnCard"));
		selectByVisibleText(pomFactory.retailAccountPage().expirationMonthField, paymentInfo.get(0).get("expirationMonth"));
		selectByVisibleText(pomFactory.retailAccountPage().expireationYearField, paymentInfo.get(0).get("expirationYear"));
		sendText(pomFactory.retailAccountPage().securityCodeField, paymentInfo.get(0).get("securityCode"));
		logger.info("Payment Information was entered successfully");
		
	}
	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(pomFactory.retailAccountPage().paymentSubmitBtn);
		logger.info("Payment Method Submit bttn clicked successfully");
	}
	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String expectedMssg) {
		
		if(expectedMssg.contains("Payment Method added")) {
			waitTillPresence(pomFactory.retailAccountPage().paymentMethodSuccessMssg);
			Assert.assertEquals(expectedMssg, pomFactory.retailAccountPage().paymentMethodSuccessMssg.getText());
			logger.info("Expected Message: " + expectedMssg);
		}else if(expectedMssg.contains("Address Added")) {
			waitTillPresence(pomFactory.retailAccountPage().addressSuccessMssg);
			Assert.assertEquals(expectedMssg, pomFactory.retailAccountPage().addressSuccessMssg.getText());
			logger.info("Expected Message: " + expectedMssg);
		}else if(expectedMssg.contains("Order Placed")) {
			waitTillPresence(pomFactory.retailOrderPage().orderPlacedSuccessfullyMssg);
			Assert.assertEquals(expectedMssg, pomFactory.retailOrderPage().orderPlacedSuccessfullyMssg.getText());
		}

	}
	//add Address
	@When("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(pomFactory.retailAccountPage().addAddressLink);
		logger.info("Add Address Link was clicked successfully");
	}
	@When("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> addressInfo = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(pomFactory.retailAccountPage().AddressCountryDropdown, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("country")));
		sendText(pomFactory.retailAccountPage().addressNameField, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("fullName")));
		sendText(pomFactory.retailAccountPage().addressPhoneField, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("phoneNumber")));
		sendText(pomFactory.retailAccountPage().addressStreetField, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("streetAddress")));
		sendText(pomFactory.retailAccountPage().addressApartmentNum, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("apt")));
		sendText(pomFactory.retailAccountPage().addressCityField, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("city")));
		selectByVisibleText(pomFactory.retailAccountPage().addressStateDropdown, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("state")));
		sendText(pomFactory.retailAccountPage().addressZipCodeField, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("zipCode")));
		
		logger.info("Address form was filled out successfully");
	}
	
	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(pomFactory.retailAccountPage().addressAddBttn);
		logger.info("Add Address Button was clicked successfully");
	}

}
