package com.qa.MavenProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUser {

	@FindBy (xpath = "//*[@id=\"username\"]")
	private WebElement inputUserName;
	@FindBy (xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	private WebElement inputPassword;
	@FindBy (xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	private WebElement inputConfirmPassword;
	@FindBy (xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	private WebElement inputFullName;
	@FindBy (xpath = "//*[@id=\"yui-gen3-button\"]")
	private WebElement submitBut;

	@FindBy (xpath = "//*[@id=\"people\"]/tbody/tr[3]/td[2]/a")
	public WebElement selectUser;
	
	
	public void createUser(String username, String password, String confirmPass, String fullname)
	{
		inputUserName.sendKeys(username);
		inputPassword.sendKeys(password);
		inputConfirmPassword.sendKeys(confirmPass);
		inputFullName.sendKeys(fullname);
	}
	
	public void submitUser()
	{
		submitBut.click();
	}
	
	public void selectSecondUser()
	{
		selectUser.click();
	}
}
