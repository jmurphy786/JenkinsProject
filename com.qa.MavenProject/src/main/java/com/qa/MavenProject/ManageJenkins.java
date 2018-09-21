package com.qa.MavenProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageJenkins {

	@FindBy(xpath = "//*[@id=\"management-links\"]/tbody/tr[15]/td[2]/div[1]/a")
	private WebElement manageUsers;
	
	public void goToManageUsers()
	{
		manageUsers.click();
	}
	
}
