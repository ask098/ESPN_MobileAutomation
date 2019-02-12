package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseRobot;

public class LoginScreen extends BaseRobot {

	public LoginScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Log In\"]") 
	private AndroidElement logInButton;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").descriptionContains(\"Enter your username\")")
	private AndroidElement errorMessage;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"Sign Up\")")
	private AndroidElement signupButton;
	
	public void emptyLogIn() {
		log.info("Login screen is showed");
		customWait.waitAndroidElementToBeClickable(driver, logInButton, customWait.MEDIUM_WAIT_SECONDS);
		logInButton.click();
		checkErrorLoginMsg();
	}
	
	public boolean checkErrorLoginMsg() {
		customWait.waitAndroidElementVisibility(driver, errorMessage, customWait.NORMAL_WAIT_SECONDS);
		if (errorMessage.isDisplayed()) {
			log.info("Error message is displayed: 'Enter your username or email address and password' as expected");
			return true;
		}return false;
	}
	
	/**
	 * redirects to sign up page to create an account
	 * @return CreateAccountPage
	 */
	public CreateAccountPage signUp() {
		customWait.waitAndroidElementToBeClickable(driver, signupButton, customWait.MEDIUM_WAIT_SECONDS);
		signupButton.click();
		return new CreateAccountPage(driver);
	}
}

