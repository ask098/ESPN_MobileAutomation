package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseRobot;

/**
 * Screen of SignUp or LogIn screen.
 * 
 * @author Arley.Bolivar
 *
 */
public class SignUpOrLogInScreen extends BaseRobot {

	/**
	 * Constructor method.
	 * 
	 * @author Arley.Bolivar
	 * 
	 * @param androidDriver : AndroidDriver
	 */
	public SignUpOrLogInScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	// AndroidElements
	@AndroidFindBy(id = "com.espn.score_center:id/btn_signup")
	protected AndroidElement singUpButton;
	@AndroidFindBy(id = "com.espn.score_center:id/btn_login")
	private AndroidElement logInButton;
	@AndroidFindBy(id = "com.espn.score_center:id/btn_sign_up_later")
	protected AndroidElement signUpLaterOption;
	

	/**
	 * @author Helberth.Bolivar
	 * @return 
	 *
	 * @description: returns a new screen after click on login button.
	 *
	 */
	public LoginScreen clickOnLoginButton() {
		customWait.waitAndroidElementVisibility(driver, logInButton, customWait.MEDIUM_WAIT_SECONDS);
		logInButton.click();
		return new LoginScreen(driver);
	}
	
//	public LoginScreen clickOnSingUpButton() {
//		singUpButton.click();
//	}
	

	public SelectEditionScreen clickOnSingUpLaterOption() {
		customWait.waitAndroidElementVisibility(driver, signUpLaterOption, customWait.MEDIUM_WAIT_SECONDS);
		signUpLaterOption.click();
		log.info("Sign up later selected");
		return new SelectEditionScreen(driver);
	}
}
