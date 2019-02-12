package screens;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseRobot;

public class HomePage extends BaseRobot {

	public HomePage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@AndroidFindBy(id="	com.espn.score_center:id/clubhouse_browser_bottom_navigation")
	private List<AndroidElement> NavBar;
	
	@AndroidFindBy(id = "com.espn.score_center:id/listview")
	private AndroidElement settingsListItems;
	
	@AndroidFindBy(id = "com.espn.score_center:id/clubhouse_browser_bottom_navigation")
	private AndroidElement navigationBar;
	
	List<MobileElement> navigationBarOptions = new ArrayList<MobileElement>();
	
	@AndroidFindBy(accessibility= "Settings")
	private AndroidElement settingsButton;
	
	public void checkHomepage() {
		
		navigationBarOptions = navigationBar.findElements(By.className("android.widget.TextView"));
		log.info("NavBar checked");
		Assert.assertTrue(checkNavbar("home"),"Home NavBar not found");
		Assert.assertTrue(checkNavbar("ESPN+"),"ESPN NavBar not found");
		Assert.assertTrue(checkNavbar("Scores"),"Scores NavBar not found");
		Assert.assertTrue(checkNavbar("More"),"Moree NavBar not found");
		Assert.assertTrue(checkNavbar("Watch"),"Watch NavBar not found");
	}
	
	
	public boolean checkNavbar(String check) {
		return navigationBarOptions.stream().anyMatch(element -> element.getText().equalsIgnoreCase(check));
	}
	
	public SettingsPage selectSettingsOption() {
		
		 customWait.waitAndroidElementToBeClickable(driver, settingsButton, this.customWait.NORMAL_WAIT_SECONDS);
		 checkHomepage();
		 settingsButton.click();
		 return new SettingsPage(driver);
	}

}
