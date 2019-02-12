package screens;

import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseRobot;

/**
 * Screen of alerts on application.
 * 
 * @author helberth.bolivar
 *
 */
public class AlertsOnAppScreen extends BaseRobot {

	/**
	 * Constructor method.
	 * 
	 * @author Arley.Bolivar
	 * 
	 * @param driver
	 *            : AndroidDriver
	 */
	public AlertsOnAppScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	// Locators
	private static final String ALLOW_ACCESS_MESSAGE_ID = "com.android.packageinstaller:id/permission_message";
	private static final String ALLOW_BUTTON_ID = "com.android.packageinstaller:id/permission_allow_button";

	// AndroidElements
	@AndroidFindBy(id = ALLOW_ACCESS_MESSAGE_ID)
	private AndroidElement allowAccessMessage;
	@AndroidFindBy(id = ALLOW_BUTTON_ID)
	private AndroidElement allowButton;
	@AndroidFindBy(id="android:id/message")
	private AndroidElement costomizeMsg;
	@AndroidFindBy(id="android:id/button1")
	private AndroidElement okButton;

	/**
	 * @author Helberth.Bolivar
	 *
	 * @description: Returns the sign up or login screen after click on allow
	 *               button.
	 *
	 * @return SignUpOrLogInScreen
	 */
	public SignUpOrLogInScreen openSignUpOrLoginScreen() {
		// TODO: improve and complete this method.
		if (allowAccessMessage.isDisplayed() && allowButton.isDisplayed()) {
			allowButton.click();
			log.info("first allow message checked");
		}
		if (allowAccessMessage.isDisplayed() && allowButton.isDisplayed()) {
			allowButton.click();
			log.info("second allow message checked");
		}
		return new SignUpOrLogInScreen(driver);
	}
	
	/**
	 * 
	 * @author jc.castro
	 *
	 * @description: Returns home screen after click on OK
	 *               button.
	 * @return HomePage
	 */
	public HomePage openMainpage() {
		if (costomizeMsg.isDisplayed() && okButton.isDisplayed()) {
			checkCustomizeMsg();
			log.info("first allow message checked");
			okButton.click();
		}return new HomePage(driver);
	}
	
	public void checkCustomizeMsg() {
		 Assert.assertTrue(costomizeMsg.getText().equals("You didn't customize the app! Don't worry, you can always add favorites later on from the menu."),"The customize msg is different to expected");
		
	}
}
