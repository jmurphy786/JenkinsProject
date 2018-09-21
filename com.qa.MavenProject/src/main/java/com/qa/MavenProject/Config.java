package com.qa.MavenProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Config {

	
	@FindBy (xpath = "//*[@id=\"main-panel\"]/form/table/tbody/tr[4]/td[3]/textarea")
	private WebElement inputEmail;
	
	
	@FindBy (xpath = "//*[@id=\"yui-gen2-button\"]")
	private WebElement applybut;
	
	@FindBy (xpath = "//*[@id=\"yui-gen5-button\"]")
	private WebElement savebut;
	
	public void configEmail(String arg1)
	{
		inputEmail.sendKeys(arg1);
	}
	
	public void hitApply() 
	{
		applybut.click();
	}
	
	public void hitSave()
	{
		savebut.click();
	}
}
