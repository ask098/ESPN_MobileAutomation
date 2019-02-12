package tests;

import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;

import screens.AlertsOnAppScreen;
import screens.HomePage;
import screens.LoginScreen;
import screens.SelectEditionScreen;
import screens.SelectLeaguesScreen;
import screens.SelectTeamsScreen;
import screens.SettingsPage;
import screens.SignUpOrLogInScreen;
import screens.CreateAccountPage;
import util.tests.BaseMobileTest;

public class LoginAppTest extends BaseMobileTest {
	
	LoginScreen test;
	SelectEditionScreen edition;
	SelectLeaguesScreen leagues;
	SelectTeamsScreen teams; 
	HomePage home;
	AlertsOnAppScreen alert;
	SignUpOrLogInScreen loginOrCreateAccount;
	SettingsPage settings;
	CreateAccountPage create;
	
	/**
	 * Verify login with empty data.
	 */
	@Description(value = "login with empty data TC:01")
	@Test()
	public void loginEmptyData() {
		
		log.info("emptyDataLoginTest");
		loginOrCreateAccount = loadAppOnSignUpOrLoginScreen();
		test = loginOrCreateAccount.clickOnLoginButton();
		test.emptyLogIn();
	}
	
	@Description(value = "login with anonymus account")
	@Test()
	public void anonymousAccount() {
		
		log.info("loginUsingAnonymousAccount");
		loginOrCreateAccount = loadAppOnSignUpOrLoginScreen();
		edition = loginOrCreateAccount.clickOnSingUpLaterOption();
		leagues= edition.selection();
		teams = leagues.clickNext();
		alert =teams.clickFinish();
		home = alert.openMainpage();
		home.checkHomepage();
	}
	
	
	@Description(value = "create Account")
	@Test()
	public void createAccount() {
		
		log.info("createAccount");
		loginOrCreateAccount = loadAppOnSignUpOrLoginScreen();
		edition = loginOrCreateAccount.clickOnSingUpLaterOption();
		leagues= edition.selection();
		teams = leagues.clickNext();
		alert =teams.clickFinish();
		home = alert.openMainpage();
		settings = home.selectSettingsOption();
		test = settings.clickLogIn();
		create = test.signUp();
		settings = create.clickSingUp();	
	}

	@Description(value = "create Account")
	@Test()
	public void feedbackPage() {
		
		
	}
	

}
