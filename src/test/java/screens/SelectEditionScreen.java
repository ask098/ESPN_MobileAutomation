package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseRobot;

public class SelectEditionScreen extends BaseRobot{

	public SelectEditionScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text=\"U.S. - English\"] | //android.widget.RadioButton[@text=\"EE.UU - Inglés\"]")
	protected AndroidElement radioButtonUS;
	@AndroidFindBy(id = "com.espn.score_center:id/nextText")
	private AndroidElement next;

	public SelectLeaguesScreen selection()	{
		customWait.waitAndroidElementToBeClickable(driver, radioButtonUS, customWait.NORMAL_WAIT_SECONDS);
		log.info("Selet edition page shown");
		radioButtonUS.click();
		customWait.waitAndroidElementToBeClickable(driver, next, customWait.NORMAL_WAIT_SECONDS);
		next.click();
		return new SelectLeaguesScreen(driver);
	}
}
