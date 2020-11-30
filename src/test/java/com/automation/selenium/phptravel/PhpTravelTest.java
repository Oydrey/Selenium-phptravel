package com.automation.selenium.phptravel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhpTravelTest {

	private static final DesiredCapabilities CAPABILITY = DesiredCapabilities.firefox();

	private static final String SELENIUM_SERVER_URL = "http://127.0.0.1:4444/wd/hub";

	private static final String BASIC_URL = "https://www.phptravels.net";

	private WebDriver mDriver = null;

	@Before
	public void setup() throws MalformedURLException, InterruptedException {
		mDriver = new RemoteWebDriver(new URL(SELENIUM_SERVER_URL), CAPABILITY);	

		mDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		mDriver.manage().window().maximize();
	}

	@Test
	public void initTest() throws InterruptedException {
		
		/* Etape 1 */
		mDriver.navigate().to(BASIC_URL);
		Thread.sleep(1000);
		assertTrue(mDriver.findElement(ByXPath.xpath("//*[@id=\"mobileMenuMain\"]/nav/ul[1]")).isDisplayed());
		assertTrue(mDriver.findElement(ByXPath.xpath("//*[@id=\"mobileMenuMain\"]/nav/ul[2]")).isDisplayed());
		assertTrue(mDriver.findElement(ByXPath.xpath("//*[@id=\"search\"]/div/div/div/div/div")).isDisplayed());
		assertTrue(mDriver.findElement(ByXPath.xpath("//*[@id=\"//header-waypoint-sticky\"]/div[1]/div/div/div[2]/div/ul/li[1]")).isDisplayed());
		assertTrue(mDriver.findElement(ByXPath.xpath("//*[@id=\"//header-waypoint-sticky\"]/div[1]/div/div/div[2]/div/ul/li[2]")).isDisplayed());
		assertTrue(mDriver.findElement(ByXPath.xpath("//*[@id=\"footer\"]/div[1]/div[1]/div[1]/h5/strong/span")).isDisplayed());
		assertTrue(mDriver.findElement(ByXPath.xpath("//*[@id=\"footer\"]/div[1]/div[1]/div[1]/h5/small/a")).isDisplayed());
		assertEquals("USD", mDriver.findElement(ByXPath.xpath("//*[@id=\"dropdownCurrency\"]")).getText());
		
		/* Etape 2 */
		mDriver.findElement(ByXPath.xpath("//*[@id=\"dropdownLangauge\"]")).click();
		mDriver.findElement(ByXPath.xpath("//*[@id=\"fr\"]")).click();
		assertEquals("ACCUEIL", mDriver.findElement(ByXPath.xpath("//*[@id=\"mobileMenuMain\"]/nav/ul[1]/li/a")).getText());
		
		/* Etape 3 */
		mDriver.findElement(ByXPath.xpath("//*[@id=\"dropdownCurrency\"]")).click();
		mDriver.findElement(ByXPath.xpath("//*[@id=\"//header-waypoint-sticky\"]/div[1]/div/div/div[2]/div/ul/li[1]/div/div/div/a[4]")).click();
		Thread.sleep(1000);
		assertEquals("EUR", mDriver.findElement(ByXPath.xpath("//*[@id=\"dropdownCurrency\"]")).getText());
		
	}

	@After
	public void teardown() {
		mDriver.quit();
	}

}
