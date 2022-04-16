package com.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test_Base {
	public static WebDriver driver;

	// BrowserLaunch
	public static WebDriver browserLaunch() {// return driver pannumbodhu void webdriver agirum
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\DELL\\eclipse-workspace\\Adactin\\driver\\chromedriver100.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;//idhu kudukalana null pointer exception varum ,idhula chrome call agum
	}

	// GetUrl
	public static void geturl(String url) {
		driver.get(url);
	}

	// GetTitle
	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	// CurrentUrl
	public static void currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	// Navigate
	public static void navigateUrl(String url) {
		driver.navigate().to(url);
	}

	// Refresh
	public static void refresh() {
		driver.navigate().refresh();

	}

	// Backward
	public static void backward() {
		driver.navigate().back();
	}

	// Quit
	public static void quit() {
		driver.quit();
	}

	// SendKeys
	public static void inputValueElement(WebElement element, String value) {
		element.sendKeys(value);
	}

	// Click
	public static void onClickElement(WebElement element) {
		element.click();
	}

	// Clear
	public static void clear(WebElement element) {
		element.clear();
	}

	// Is Enabled
	public static void isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println("isEnabled: " + enabled);
	}

	// Is Displayed
	public static void isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println("isDisplayed: " + displayed);

	}

	// Is Selected
	public static void isSelected(WebElement element) {
		boolean selected = element.isSelected();
		System.out.println("isSelected: " + selected);

	}

	// GetAttribute
	public static void getAttribute(WebElement element, String type) {
		if (type.equalsIgnoreCase("value")) {
			String attribute = element.getAttribute("value");
			System.out.println(attribute);

		} else if (type.equalsIgnoreCase("name")) {
			String attribute = element.getAttribute("name");
			System.out.println(attribute);
		}

	}

	// Wait
	public static void wait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	// DropDown
	public static void dropDown(WebElement element, String type, String value) {
		Select s = new Select(element);
		if (type.equalsIgnoreCase("value")) {
			s.selectByValue(value);

		} else if (type.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);

		} else if (type.equalsIgnoreCase("index")) {
			int parseInt = Integer.parseInt(value);//string to number
			s.selectByIndex(parseInt);

		}

	}

	// Alert
	public static void alert(String type) {
		Alert alert = driver.switchTo().alert();
		if (type.equalsIgnoreCase("accept")) {
			alert.accept();

		} else if (type.equalsIgnoreCase("dismiss")) {
			alert.dismiss();

		} else if (type.equalsIgnoreCase("gettext")) {
			alert.getText();

		}
	}

	// Actions
	public static void action(WebElement element, String type) {
		Actions act = new Actions(driver);
		if (type.equalsIgnoreCase("move")) {
			act.moveToElement(element).build().perform();
		} else if (type.equalsIgnoreCase("click")) {
			act.click(element).build().perform();
		} else if (type.equalsIgnoreCase("doubleclick")) {
			act.doubleClick(element).build().perform();
		} else if (type.equalsIgnoreCase("rightclick")) {
			act.contextClick(element).build().perform();
		}

	}

	// drag drop
	public static void dragdrop(WebElement source, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).build().perform();
	}

	// windows handles using index
	public static void windowhandles(int i) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>();
		list.addAll(windowHandles);
		driver.switchTo().window(list.get(i));
	}

	// windows handles using title
	public static void windowhandlestitle(String actual) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String all : windowHandles) {
			if (driver.switchTo().window(all).getTitle().equals(actual)) {
				break;
			}
		}
	}

	// frames
	public static void singleframe(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void defaultcontent() {
		driver.switchTo().defaultContent();
	}

	public static void multipleframe(WebElement outerframe, WebElement innerframe) {
		driver.switchTo().frame(outerframe);
		driver.switchTo().frame(innerframe);
	}

	// screen shot
	public static void screenshot(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\DELL\\eclipse-workspace\\Adactin\\Screenshot\\" + filename + ".png");
		FileUtils.copyFile(src, dest);
	}

	// Robot
	public static void robot(String type) throws AWTException {
		Robot r = new Robot();
		if (type.equalsIgnoreCase("down")) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);

		}

		else if (type.equalsIgnoreCase("up")) {
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
		}

		else if (type.equalsIgnoreCase("down")) {
			r.keyPress(KeyEvent.VK_ENTER);

		}

	}

	// scroll to element
	public static void scroll(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	// close
	public static void close() {
		driver.close();
	}
}
