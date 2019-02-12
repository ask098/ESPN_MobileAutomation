package screens;

import java.util.List;
import java.util.Random;

import org.testng.annotations.Parameters;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseRobot;

public class CreateAccountPage extends BaseRobot{

	public CreateAccountPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").textContains(\"Create Account\")")
	private AndroidElement title;
	
	@AndroidFindBy(className="android.widget.EditText")
	private List<AndroidElement> accountData;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"Sign Up\")")
	private AndroidElement singUpButton;
	
	AndroidElement firstNameField = accountData.get(0);
	AndroidElement lastNameField = accountData.get(1);
	AndroidElement emailAddressField = accountData.get(2);
	AndroidElement passwordField = accountData.get(3);

	/**
	 * 
	 * 
	 */
	//@Parameters({"name","lastname","address","password"})
	public void createAccount() { //String name,String lastname, String address, String password
		
		System.out.println(randomname());
		completefirstNamefield(null);
		completeLastNamefield();
		completeAddressfield();
		completePassfield();
		}
	
	public char randomname() {
		
		Random r = new Random();
		char random_Char = (char) (97 + r.nextInt(25));
		return random_Char;
		
	}
	
	
	@Parameters({"name"})
	public void completefirstNamefield(String name){		

		customWait.waitAndroidElementToBeClickable(driver, firstNameField, customWait.NORMAL_WAIT_SECONDS);
		firstNameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	@Parameters({"lastname"})
	public void completeLastNamefield() {
		
		customWait.waitAndroidElementToBeClickable(driver, lastNameField, customWait.NORMAL_WAIT_SECONDS);
		lastNameField.sendKeys("JOSEFE");
		driver.hideKeyboard();
	}
	
	@Parameters({"address"})
	public void completeAddressfield() {
		
		customWait.waitAndroidElementToBeClickable(driver, emailAddressField, customWait.NORMAL_WAIT_SECONDS);
		emailAddressField.sendKeys("t357m41l"+randomname()+"c"+randomname()+"r7@gmaile.com");
		driver.hideKeyboard();
	}
	
	@Parameters({"password"})
	public void completePassfield() {
		
		customWait.waitAndroidElementToBeClickable(driver, passwordField, customWait.NORMAL_WAIT_SECONDS);
		passwordField.sendKeys("dfs03945f+");
		driver.hideKeyboard();
	}
	
	
	public SettingsPage clickSingUp() {
		createAccount();
		driver.hideKeyboard();
		customWait.waitAndroidElementToBeClickable(driver, singUpButton, customWait.NORMAL_WAIT_SECONDS);
		firstNameField.click();
		driver.hideKeyboard();
		singUpButton.click();
		return new SettingsPage(driver);
	}
	
	
}
