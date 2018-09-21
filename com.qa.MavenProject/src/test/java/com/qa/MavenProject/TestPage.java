package com.qa.MavenProject;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.qa.DemoSite.AddUser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestPage {

	WebDriver driver = null;
	public static ExtentReports reports = new ExtentReports("C:/Users/Admin/Documents/StoreTests/JenkinsWebTest.html", true);
	public static ExtentTest test = reports.startTest("My Details");
	private WebElement checkUserCreated;
	private CreateUser makeUser;
	private ManageJenkins manageJenkins;
	
	private Config config;
	private OnUserInfo user;
	
	private String inputFullName = "Mike Man";
	private String inputUserName = "Mikey";
	private String inputPassword = "Mike";
	private String inputConfirmPass = "Mike";
	
	private int counter = 2;


	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Documents/chromedriver.exe");
		driver = new ChromeDriver();

	}	
	
	
	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() throws InterruptedException {
	   driver.get(Constant.jenkinsURL);
	   Login login = PageFactory.initElements(driver, Login.class);
	   login.Login();
	   MainPage main = PageFactory.initElements(driver, MainPage.class);
	   main.goToManageJenkins();
	   manageJenkins = PageFactory.initElements(driver, ManageJenkins.class);
	   manageJenkins.goToManageUsers();
	   UsersPage userPage = PageFactory.initElements(driver, UsersPage.class);
	   userPage.goToCreateUsers();

	   System.out.println(driver.getTitle());
	   if(driver.getTitle().equals("Create User [Jenkins]"))
	   {
			test.log(LogStatus.PASS, "User Created");
	   }
	   else
	   {
			test.log(LogStatus.FAIL, "User isn't Created");
	   }
	   
	   
	   
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() throws Throwable {
		makeUser = PageFactory.initElements(driver, CreateUser.class);
		makeUser.createUser(inputUserName, inputPassword, inputConfirmPass, inputFullName);
		test.log(LogStatus.INFO, "Entering Details Of The User");
		System.out.println("Entering Details The User");
	}

	
	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() throws Throwable {
	   makeUser.submitUser();
		test.log(LogStatus.INFO, "Details Have been submitted.");
	   System.out.println("Details Have been sumbitted");
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() throws Throwable {
	    checkUserCreated = driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[3]/td[2]/a"));
	    OnUserInfo userinfo = PageFactory.initElements(driver, OnUserInfo.class);
	    System.out.println(checkUserCreated.getText());
	    if(checkUserCreated.getText().equals(inputUserName)) 
	    {
			test.log(LogStatus.PASS, "The user's account can be seen");
	    	System.out.println("User is Visible");
	    }
	    else
	    {
			test.log(LogStatus.FAIL, "The user's account cannot be seen");
	    	System.out.println("User isn't visible");
	    }
	    userinfo.goToPeoplePage();
		manageJenkins = PageFactory.initElements(driver, ManageJenkins.class);
		manageJenkins.goToManageUsers();
		UsersPage userPage = PageFactory.initElements(driver, UsersPage.class);
		userPage.goToCreateUsers();
	    
	}

	
	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, \"([^\"]*)\" Fullname and \"([^\"]*)\" EmailAddress are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_Fullname_and_EmailAddress_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		makeUser = PageFactory.initElements(driver, CreateUser.class);
		makeUser.createUser(arg1, arg2, arg3, arg4);
		test.log(LogStatus.INFO, "Entering Details of the user");
		System.out.println("Entering Details The User");
		
		
	}
	

	@When("^the detail are submitted to the Create UserScreen$")
	public void the_detail_are_submitted_to_the_Create_UserScreen() throws Throwable {
		makeUser.submitUser();
		System.out.println("Submitted");
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) throws Throwable {
		
		for (int i = 2; i < 10; i++) {
	    checkUserCreated = driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[" + i + "]/td[2]/a"));
	    if(checkUserCreated.getText().equals(arg1)) 
	    {	
			test.log(LogStatus.PASS, arg1 + "is visible");
	    	System.out.println(arg1 +  " is Visible");
	    }
	    else
	    {
	    }
		}
	    
		}
	

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) throws Throwable {
		  driver.get(Constant.jenkinsURL);
		  Login login = PageFactory.initElements(driver, Login.class);
		  login.Login();
	      MainPage main = PageFactory.initElements(driver, MainPage.class);
	      main.goToManageJenkins();		   
	      manageJenkins = PageFactory.initElements(driver, ManageJenkins.class);
		  manageJenkins.goToManageUsers();
		  Thread.sleep(2000);
		  checkUserCreated = driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[3]/td[2]/a"));
			for (int i = 2; i < 10; i++) {
			   checkUserCreated = driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[" + i + "]/td[2]/a"));
	
			    if(checkUserCreated.getText().equals(arg1)) 
			    {	
			    	counter = i;
					test.log(LogStatus.PASS, arg1 + " is visible");
			    	System.out.println(arg1 +  " is Visible");
			    	break;
			    }
			    else {
			    } }
			
			StringBuilder str = new StringBuilder();
			str.append("//*[@id=\"people\"]/tbody/tr[");
			str.append(counter);
			str.append("]/td[2]/a");
			String xpath = str.toString();
			checkUserCreated = driver.findElement(By.xpath(xpath));

		
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) throws Throwable {
		checkUserCreated.click();
		test.log(LogStatus.INFO, "Profile is selected");
		System.out.println("Profile is selected");
		System.out.println(driver.getTitle());
	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) throws Throwable {
		WebElement checkMe = driver.findElement(By.xpath("//*[@id=\"main-panel\"]/div[2]"));
		if(checkMe.getText().equals("Jenkins User Id: " + arg1))
	    {
			test.log(LogStatus.PASS, "User was Created");
	    	System.out.println("User Was Created");
	    }
	    else 
	    {
			test.log(LogStatus.FAIL, "User wasn't created.");
	    	System.out.println("User wasn't created");
	    }
    Thread.sleep(2000);

	}

	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable {
		driver.get(Constant.jenkinsURL);
		  Login login = PageFactory.initElements(driver, Login.class);
		  login.Login();
	      MainPage main = PageFactory.initElements(driver, MainPage.class);
	      main.goToManageJenkins();		   
	      manageJenkins = PageFactory.initElements(driver, ManageJenkins.class);
		  manageJenkins.goToManageUsers();
		  checkUserCreated = driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[3]/td[2]/a"));
			for (int i = 2; i < 10; i++) {
			   checkUserCreated = driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[" + i + "]/td[2]/a"));
	
			    if(checkUserCreated.getText().equals(arg1)) 
			    {	
			    	counter = i;
					test.log(LogStatus.PASS, arg1 + " is visible");
			    	System.out.println(arg1 +  " is Visible");
			    	break;
			    }
			    else {
			    } }
			
			StringBuilder str = new StringBuilder();
			str.append("//*[@id=\"people\"]/tbody/tr[");
			str.append(counter);
			str.append("]/td[2]/a");
			String xpath = str.toString();
			checkUserCreated = driver.findElement(By.xpath(xpath));
			checkUserCreated.click();
			test.log(LogStatus.INFO, "Person Page is loaded");
			System.out.println("Person Page is loaded");
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() throws Throwable {
		
		driver.get(Constant.jenkinsURL);
		Login login = PageFactory.initElements(driver, Login.class);
		login.Login();
	    MainPage main = PageFactory.initElements(driver, MainPage.class);
	    main.goToManageJenkins();		   
	    manageJenkins = PageFactory.initElements(driver, ManageJenkins.class);
	    manageJenkins.goToManageUsers();
		WebElement selectAdmin = driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[2]/td[2]/a"));
		selectAdmin.click();
		WebElement clickConfig = driver.findElement(By.xpath("//*[@id=\"tasks\"]/div[4]/a[2]"));
		clickConfig.click();
		test.log(LogStatus.INFO, "Configure Button is clicked");
	    System.out.println("Configure Button is clicked");
	    Thread.sleep(2000);
	}

	@When("^I change the old email address on the Configure Page to a new email address \"([^\"]*)\"$")
	public void i_change_the_old_email_address_on_the_Configure_Page_to_a_new_email_address(String arg1) throws Throwable {
	    Thread.sleep(2000);
	    config.configEmail(arg1);
		test.log(LogStatus.INFO, "Email Inputted");
	    System.out.println("Email Inputted");
	    Thread.sleep(2000);
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
	    config.hitApply();
		test.log(LogStatus.INFO, "Applying inputs");
	    System.out.println("Applied Input");
	}

	@Then("^the Configure Page should show the new email address \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_new_email_address(String arg1) throws Throwable {
	    config.hitSave();
		test.log(LogStatus.INFO, "Inputs saved");
	    System.out.println("Save Button has been clicked");
	    WebElement theEmail = driver.findElement(By.xpath("//*[@id=\"description\"]/div[1]"));
	    if(theEmail.getText().equals(arg1)) 
	    {
			test.log(LogStatus.PASS, "Email is shown");
	    	System.out.println("Email is shown");
	    }
	    else
	    {
			test.log(LogStatus.FAIL, "Email isn't shown");
	    	System.out.println("Email isn't shown");
	    }
	}
	
	@After
	public void endSetup() {
		driver.close();
		reports.flush();
	}
}
