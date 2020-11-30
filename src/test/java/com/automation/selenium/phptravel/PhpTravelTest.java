package com.automation.selenium.phptravel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PhpTravelTest {

	private static final DesiredCapabilities CAPABILITY = DesiredCapabilities.firefox();

	private static final String SELENIUM_SERVER_URL = "http://127.0.0.1:4444/wd/hub";

	private static final String BASIC_URL = "https://www.qwant.com";

	private WebDriver mDriver = null;

	@Before
	public void setup() throws MalformedURLException, InterruptedException {
		mDriver = new RemoteWebDriver(new URL(SELENIUM_SERVER_URL), CAPABILITY);

		mDriver.navigate().to(BASIC_URL);

		mDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		mDriver.manage().window().maximize();
	}

	@Test
	public void qwantSearch() throws InterruptedException {

	}

	@After
	public void teardown() {
		mDriver.quit();
	}

}
