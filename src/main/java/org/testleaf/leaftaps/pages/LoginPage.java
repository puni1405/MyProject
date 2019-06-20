package org.testleaf.leaftaps.pages;

import org.openqa.selenium.By;
import org.testleaf.leaftaps.base.ProjectBase;

public class LoginPage extends ProjectBase {

	public LoginPage() {

	}

	public LoginPage enterUserName(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
		return this;
	}

	public LoginPage enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
		return this;
	}

	public HomePage clickLoginButton() {
		driver.findElement(By.className("decorativeSubmit")).click();
		// HomePage page = new HomePage();
		// return page;
		return new HomePage();
	}

}
