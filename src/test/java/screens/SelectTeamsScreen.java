package screens;


import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseRobot;

public class SelectTeamsScreen extends BaseRobot{

	public SelectTeamsScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(id = "com.espn.score_center:id/nextText")
	private AndroidElement finish;
	
	@AndroidFindBy(id="com.espn.score_center:id/xToolbarTitleTextView")
	private AndroidElement topText;
	
	public AlertsOnAppScreen clickFinish() {
		customWait.waitAndroidElementToBeClickable(driver, finish, customWait.NORMAL_WAIT_SECONDS);
		log.info("Select teams Screen cheked");
		checkTopText();
		finish.click();
		return new AlertsOnAppScreen(driver);
	}
	
	public void checkTopText() {
		Assert.assertTrue(topText.getText().equals("Tap your favorite leagues"),"The text top in screen is different to expected");
	}
	
}
