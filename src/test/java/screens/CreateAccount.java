package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseRobot;

public class CreateAccount extends BaseRobot {

	public CreateAccount(AndroidDriver<AndroidElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(accessibility = "Create Account")
	private AndroidElement title;
	@AndroidFindBy(accessibility = "First Name")
	private AndroidElement firstNameField;
	@AndroidFindBy(accessibility = "Last Name")
	private AndroidElement lastNameField;
	@AndroidFindBy(accessibility = "Email Address")
	private AndroidElement emailField;
	@AndroidFindBy(accessibility = "Sign Up")
	private AndroidElement signupButton;
	@AndroidFindBy(id = "com.espn.score_center:id/did_webview_group")
	private AndroidElement content;


}
