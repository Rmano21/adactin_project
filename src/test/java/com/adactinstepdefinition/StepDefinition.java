package com.adactinstepdefinition;

import org.openqa.selenium.WebDriver;

import com.adactinrunner.RunnerClass;
import com.baseclass.Test_Base;
import com.config.helper.FileReaderManager;
import com.pom.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends Test_Base {
	public static WebDriver driver = RunnerClass.driver;
	PageObjectManager pom = new PageObjectManager(driver);

	@Given("^user Launches The Application$")
	public void user_Launches_The_Application() throws Throwable {
		geturl(FileReaderManager.getInstanceFrm().getInstancecr().getUrl());
	}

	@When("^user Enters The Username In Usernamefield$")
	public void user_Enters_The_Username_In_Usernamefield() throws Throwable {
		inputValueElement(pom.getLp().getUsername(), FileReaderManager.getInstanceFrm().getInstancecr().getUsername());
	}

	@When("^user Enters The Password In Passwordfield$")
	public void user_Enters_The_Password_In_Passwordfield() throws Throwable {
		inputValueElement(pom.getLp().getPassword(), FileReaderManager.getInstanceFrm().getInstancecr().getPassword());

	}

	@Then("^user clicks The Login Button And It Navigates To The Search Hotel Page$")
	public void user_clicks_The_Login_Button_And_It_Navigates_To_The_Search_Hotel_Page() throws Throwable {
		onClickElement(pom.getLp().getLogin());
	}

	@When("^user Select The Location In Loacation Field$")
	public void user_Select_The_Location_In_Loacation_Field() throws Throwable {
		dropDown(pom.getSh().getLocation(), "value", FileReaderManager.getInstanceFrm().getInstancecr().getLocation());

	}

	@When("^user Select The Hotels In Select Hotel Field$")
	public void user_Select_The_Hotels_In_Select_Hotel_Field() throws Throwable {
		dropDown(pom.getSh().getHotel(), "value", FileReaderManager.getInstanceFrm().getInstancecr().getHotel());

	}

	@When("^user Select The Roomtype In Select Roomtype Field$")
	public void user_Select_The_Roomtype_In_Select_Roomtype_Field() throws Throwable {
		dropDown(pom.getSh().getRoomtype(), "value", FileReaderManager.getInstanceFrm().getInstancecr().getRoomtype());
	}

	@When("^user Enters The Number Of Rooms$")
	public void user_Enters_The_Number_Of_Rooms() throws Throwable {
		dropDown(pom.getSh().getRoomno(), "value", FileReaderManager.getInstanceFrm().getInstancecr().getRoomno());

	}

	@When("^user Select The CheckInDate$")
	public void user_Select_The_CheckInDate() throws Throwable {
		inputValueElement(pom.getSh().getDatein(), FileReaderManager.getInstanceFrm().getInstancecr().getCheckindate());

	}

	@When("^user Select The CheckOutDate$")
	public void user_Select_The_CheckOutDate() throws Throwable {
		inputValueElement(pom.getSh().getDateout(),
				FileReaderManager.getInstanceFrm().getInstancecr().getCheckoutdate());

	}

	@When("^user Enters Adults Per Room$")
	public void user_Enters_Adults_Per_Room() throws Throwable {
		dropDown(pom.getSh().getAdult(), "value", FileReaderManager.getInstanceFrm().getInstancecr().getAdultroom());
	}

	@When("^user Enters Child Per Room$")
	public void user_Enters_Child_Per_Room() throws Throwable {
		dropDown(pom.getSh().getChild(), "value", FileReaderManager.getInstanceFrm().getInstancecr().getChildroom());

	}

	@Then("^user Clicks The Search Button And It Navigates To Next Page$")
	public void user_Clicks_The_Search_Button_And_It_Navigates_To_Next_Page() throws Throwable {
		onClickElement(pom.getSh().getSubmit());

	}

	@Given("^user Selects The Radiobutton$")
	public void user_Selects_The_Radiobutton() throws Throwable {
		onClickElement(pom.getHp().getRadiobutton());

	}

	@Then("^user Clicks To Continue$")
	public void user_Clicks_To_Continue() throws Throwable {
		onClickElement(pom.getHp().getNext());

	}

	@Given("^user Enters Firstname In Required Field$")
	public void user_Enters_Firstname_In_Required_Field() throws Throwable {
		inputValueElement(pom.getHb().getFn(), FileReaderManager.getInstanceFrm().getInstancecr().getFirstname());

	}

	@Then("^user Enters Lastname In Required Field$")
	public void user_Enters_Lastname_In_Required_Field() throws Throwable {
		inputValueElement(pom.getHb().getLn(), FileReaderManager.getInstanceFrm().getInstancecr().getLastname());

	}

	@Then("^user Enters Address In Required Field$")
	public void user_Enters_Address_In_Required_Field() throws Throwable {
		inputValueElement(pom.getHb().getAddress(), FileReaderManager.getInstanceFrm().getInstancecr().getAddress());

	}

	@Then("^user Enters Card Number In Required Field$")
	public void user_Enters_Card_Number_In_Required_Field() throws Throwable {
		inputValueElement(pom.getHb().getCc(), FileReaderManager.getInstanceFrm().getInstancecr().getCcno());

	}

	@Then("^user Selects Card Type$")
	public void user_Selects_Card_Type() throws Throwable {
		dropDown(pom.getHb().getType(), "value", FileReaderManager.getInstanceFrm().getInstancecr().getCctype());

	}

	@Then("^user selects Card Expire Month$")
	public void user_selects_Card_Exire_Month() throws Throwable {
		dropDown(pom.getHb().getEm(), "value", FileReaderManager.getInstanceFrm().getInstancecr().getCcexpmonth());

	}

	@Then("^user Selects Card Expire Year$")
	public void user_Selects_Card_Expire_Year() throws Throwable {
		dropDown(pom.getHb().getEy(), "value", FileReaderManager.getInstanceFrm().getInstancecr().getCcexpyear());

	}

	@Then("^user Enters Cvv Number In Required Field$")
	public void user_Enters_Cvv_Number_In_Required_Field() throws Throwable {
		inputValueElement(pom.getHb().getCvv(), FileReaderManager.getInstanceFrm().getInstancecr().getCvvno());

	}

	@Then("^user Clicks The Book Now Button$")
	public void user_Clicks_The_Book_Now_Button() throws Throwable {
		onClickElement(pom.getHb().getBook());
		Thread.sleep(10000);
	}

	@Then("^user Takes Screenshot$")
	public void user_Takes_Screenshot() throws Throwable {
		screenshot("booked");
	}

	@Given("^user Clicks Logout Button$")
	public void user_Clicks_Logout_Button() throws Throwable {
		onClickElement(pom.getLo().getLogout());
		screenshot("loggedout");
	}

}
