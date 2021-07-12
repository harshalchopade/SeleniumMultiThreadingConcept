package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Without using testng implementing the multi-threading concept.
 * We need to run from cmd prompt so that time to compile the classes we cant use
 * javac or java command directly as it is maven project, to do that use follow steps.
 * 
 * From cmd prompt using maven
 * 1.Go to project dir.
 * 2.open cmd and type command 'mvn compile'
 * 3.type command 'mvn exec:java -Dexec.mainClass="com.test.runner.GoogleTestRunner" -Dchrome=2 -Dfirefox=2'
 *
 *From Jenkins
 *1.Run the jenkins.
 *2.Create a new job.(Mention the pom.xml location from local m/c)
 *3.Specify the goal as 'exec:java -Dexec.mainClass="com.test.runner.GoogleTestRunner" -Dchrome=2 -Dfirefox=2'
 *4.To user choice parameters go to jenkins>Manage Jenkins> Manage plugins.
 *5.Add 'Active Choices Plug-in'
 *6.Goto created project setting > General Tab > Check 'This Project is parameterized'.
 *7.Add string parameter with required details.
 *8.Go to Pre setps tab and configure the paramter
 *   exec:java -Dexec.mainClass="com.test.runner.GoogleTestRunner" -Dchrome=${chrome} -Dfirefox=${firefox}
 *9.Build now again.
 */
public class BasePage {

	public WebDriver driver;

	// init driver:
	public WebDriver setUp(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D://Software Setup//Selenium - Java//chromedriver_win32//chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:/Software Setup/Selenium - Java/geckodriver-v0.29.0-win64/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

}
