package com.adactinrunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.baseclass.Test_Base;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src\\test\\java\\com\\Adactinfeature"}, glue = { "com\\adactinstepdefinition"},
monochrome = true, dryRun = false, strict = true,
plugin = {"pretty","json:target/My Reports/report.json","html:target/My Reports/report.html",
		"com.cucumber.listener.ExtentCucumberFormatter:target/My Reports/extent_cucumber.html"})
public class RunnerClass {
	public static WebDriver driver;
@BeforeClass
public static void setUp() {
	driver=Test_Base.browserLaunch();
}
@AfterClass
public static void tearDown() {
driver.close();

}
}
