package com.qa.MavenProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

	@FindBy (xpath = "//*[@id=\"j_username\"]")
	private WebElement inputUser;
	
	@FindBy (xpath = "//*[@id=\"main-panel\"]/div/form/table/tbody/tr[2]/td[2]/input")
	private WebElement inputPass;
	
	@FindBy(xpath = "//*[@id=\"yui-gen1-button\"]")
	private WebElement submitBut;
	
	public void Login()
	{
		inputUser.sendKeys("admin");
		inputPass.sendKeys("fb329f021b2243fc827ce88bef9d1b9a");
		submitBut.click();
	}
}
