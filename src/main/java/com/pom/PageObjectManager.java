package com.pom;

import org.openqa.selenium.WebDriver;

import com.pojo.HotelBookingPage;
import com.pojo.LogOutPage;
import com.pojo.LoginPage;
import com.pojo.SearchHotelPage;
import com.pojo.SelectHotelPage;

public class PageObjectManager {
	public static WebDriver driver;
	public PageObjectManager(WebDriver driver2) {
		this.driver = driver2;
	}
	private LoginPage lp;
	private SearchHotelPage sh;
	private SelectHotelPage hp;
	private HotelBookingPage hb;
	private LogOutPage lo;
	
	
	public LoginPage getLp() {
		lp = new LoginPage(driver);
		return lp;
	}
	public SearchHotelPage getSh() {
		sh = new SearchHotelPage(driver);
		return sh;
	}
	public SelectHotelPage getHp() {
		hp = new SelectHotelPage(driver);
		return hp;
	}
	public HotelBookingPage getHb() {
		hb = new HotelBookingPage(driver);
		return hb;
	}
	public LogOutPage getLo() {
		lo = new LogOutPage(driver);
		return lo;
	}
	
	

}
