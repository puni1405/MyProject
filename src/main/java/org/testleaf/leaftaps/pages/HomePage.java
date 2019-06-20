package org.testleaf.leaftaps.pages;

import org.openqa.selenium.By;
import org.testleaf.leaftaps.base.ProjectBase;

public class HomePage extends ProjectBase {

	public HomePage() {

	}

	public HomePage verifyLoginName() {

		if (driver.findElement(By.tagName("h2")).getText().contains("Demosalesmanager")) {
			System.out.println("Login Verified");
		} else {
			System.out.println("Login Mismatch");
		}
		return this;

	}

	public LoginPage logOut() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return new LoginPage();

	}

	public MyHomePage clickCRMSFA() {

		driver.findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage();

	}

}
