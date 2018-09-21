package com.qa.MavenProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnUserInfo {
	
	@FindBy (xpath = "//*[@id=\"tasks\"]/div[1]/a[2]")
	private WebElement goToPeople;
	
	@FindBy (xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement goToConfigure;

	
	public void goToPeoplePage() {
		goToPeople.click();
	}
	
	public void goConfigure()
	{
		goToConfigure.click();
	}


}
