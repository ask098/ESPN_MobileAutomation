package screens;


import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseRobot;

public class SelectLeaguesScreen extends BaseRobot{

	public SelectLeaguesScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(id = "com.espn.score_center:id/nextText")
	private AndroidElement next;
	
	@AndroidFindBy(id="com.espn.score_center:id/xToolbarTitleTextView")
	private AndroidElement topText;


	public SelectTeamsScreen clickNext() {
		customWait.waitAndroidElementToBeClickable(driver, next, customWait.NORMAL_WAIT_SECONDS);
		log.info("Select leagues checked");
		checkTexTop();
		next.click();
		return new SelectTeamsScreen(driver);
	}
	
	public void checkTexTop() {
		Assert.assertTrue(topText.getText().equals("Tap your favorite leagues"),"The text top in screen is different to expected");
	}
}

