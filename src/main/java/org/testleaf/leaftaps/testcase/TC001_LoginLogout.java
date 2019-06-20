package org.testleaf.leaftaps.testcase;

import org.testleaf.leaftaps.base.ProjectBase;
import org.testleaf.leaftaps.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC001_LoginLogout extends ProjectBase {

	@BeforeTest

	public void setData() {
		excelFileName = "TC001";
	}

	@Test(dataProvider = "fetchData")
	public void runLogin(String Uname, String pwd) {
		/*
		 * LoginPage page = new LoginPage(); page.enterUserName(); page.enterPassword();
		 * page.clickLoginButton();
		 */

		new LoginPage().enterUserName(Uname).enterPassword(pwd).clickLoginButton().verifyLoginName().logOut();

	}

}
