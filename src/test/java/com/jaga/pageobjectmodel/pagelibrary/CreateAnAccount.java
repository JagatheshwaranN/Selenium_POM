/**
 * The below class is created to perform CreateAccount Functionality
 *
 * @author Jagatheshwaran
 */

/**
 * Importing Package
 */
package com.jaga.pageobjectmodel.pagelibrary;

/**
 * Importing the necessary predefined classes
 */
import java.lang.reflect.InvocationTargetException;
import org.apache.log4j.*;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.jaga.pageobjectmodel.testbase.Common_Functions;


/**
 * A class is created with name : CreateAnAccount
 * CreateAnAccount class extends Common_Functions class to utilize the reusable methods of the Common_Functions class
 *
 * @author Jagatheshwaran
 */
public class CreateAnAccount extends Common_Functions{
	
	/**
	 * Initializing Logger
	 * Common_Functions class Object is initialized
	 */
	static Logger logger = Logger.getLogger(CreateAnAccount.class.getName());
	Common_Functions cf = new Common_Functions();

	/**
	 * Declaring all the Page object locators using By class
	 * 
	 * @author Jagatheshwaran
	 */
	By CreateAccContinueBtn = By.xpath(".//*[@id='tdb4']//*[text()='Continue']");
	By Male = By.xpath(".//*[@name='gender'][1]");
	By FirstName = By.name("firstname");
	By LastName = By.name("lastname");
	By DateofBirth = By.id("dob");
	By Email = By.name("email_address");
	By Company = By.name("company");
	By Address = By.name("street_address");
	By Zipcode = By.name("postcode");
	By City = By.name("city");
	By State = By.name("state");
	By Country = By.name("country");
	By TelPhoneNo = By.name("telephone");
	By Password = By.name("password");
	By ConfirmPassword = By.name("confirmation");
	By Submit = By.id("tdb4");
	By SuccessMsg = By.xpath("//*[@class='grid_16 push_4']/h1");
	By AccountCreationError = By.xpath("//*[@class='messageStackError']//td");

	/**
	 * This method will enter the required Details to create the Account and then click Submit button
	 * 
	 * @author Jagatheshwaran
	 */
	public void createAccountRegistration(String firstName, String lastName, String dateofBirth, String email, String company, String address, String zipcode, String city, String state, String country, String telPhoneNo, String password, String confirmPassword) throws InvocationTargetException {
		
		//The Test Data fetched from the property file
		String ExpectedUrl = cf.getTestData("SuccessUrl");
		
		try {
			logger.info("Before Create Account");
			logger.info("The Registration Details for the Create Account");

			cf.clickByXpath(CreateAccContinueBtn);
			cf.clickByXpath(Male);
			cf.enterTextByName(FirstName, firstName);
			cf.enterTextByName(LastName, lastName);
			cf.enterTextById(DateofBirth, dateofBirth);
			cf.enterTextByName(Email, email);
			cf.enterTextByName(Company, company);
			cf.enterTextByName(Address, address);
			cf.enterTextByName(Zipcode, zipcode);
			cf.enterTextByName(City, city);
			cf.enterTextByName(State, state);
			cf.selectVisibleTextByName(Country, country);
			cf.enterTextByName(TelPhoneNo, telPhoneNo);
			cf.enterTextByName(Password, password);
			cf.enterTextByName(ConfirmPassword, confirmPassword);
			cf.clickById(Submit);
			
			logger.info("After Create Account");
			
			String ActualUrl = cf.getUrl();

			if (ActualUrl.contains(ExpectedUrl)) {
				logger.info("The Account has been Registered and Created Successfully");
				logger.info(cf.getTextByXpath(SuccessMsg));
				Assert.assertEquals(ActualUrl, ExpectedUrl);

			} else {
				logger.info("The Account has not been Registered and Created UnSuccessfully");
				logger.info(cf.getTextByXpath(AccountCreationError));
				Assert.assertEquals(ActualUrl, ExpectedUrl);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
