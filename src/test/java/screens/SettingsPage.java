package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseRobot;

public class SettingsPage extends BaseRobot {

	public SettingsPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Log In\")")
	private AndroidElement logInButton;
	
	
	public boolean logInIsDisplayed() {
		scrollToText("Log In to ESPN Account");
		return logInButton.isDisplayed();
	}
	
	public LoginScreen clickLogIn() {
		scrollToText("Log In to ESPN Account");
		customWait.waitAndroidElementToBeClickable(driver, logInButton, customWait.NORMAL_WAIT_SECONDS);
		logInButton.click();
		return new LoginScreen(driver);
	}

}
