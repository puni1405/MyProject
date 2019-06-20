package org.testleaf.leaftaps.pages;

import org.openqa.selenium.By;
import org.testleaf.leaftaps.base.ProjectBase;

public class MyHomePage extends ProjectBase {

	public MyHomePage() {

	}

	public MyHomePage clickLeadsTab() {
		driver.findElement(By.linkText("Create Lead")).click();
		return this;

	}

}
