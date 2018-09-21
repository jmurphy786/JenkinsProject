package com.qa.MavenProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage {

	@FindBy(xpath = "//*[@id=\"tasks\"]/div[3]/a[2]")
	private WebElement createUser;
	
	public void goToCreateUsers()
	{
		createUser.click();
	}
	
}
