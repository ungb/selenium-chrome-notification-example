package org.notification.selenium.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverTest {

    private String testUrl;
    private WebDriver driver;

    @Before
    public void setup() {
        // setup chromedriver
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver");

        // URL that we can test notification on
        testUrl = "https://web-push-book.gauntface.com/demos/notification-examples/";

        // Create a map to store preferences
        Map<String, Object> prefs = new HashMap<String, Object>();

        // add key and value to map as follow to switch off browser notification
        // Pass the argument 1 to allow and 2 to block
        prefs.put("profile.default_content_setting_values.notifications", 1);

        // Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();

        // set ExperimentalOption - prefs
        options.setExperimentalOption("prefs", prefs);

        // Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize
        // chrome driver which will switch off this browser notification on the chrome
        // browser
        driver = new ChromeDriver(options);

        // maximize window
        driver.manage().window().maximize();

        // Open page
        driver.navigate().to(testUrl);
    }

    @Test
    public void testNotification() throws IOException, InterruptedException {
        // This test doesn't do anything but shows you that you can enable the
        // notification.
        // If you set the value to 1 it will disable it.
        Thread.sleep(10000);
    }

    @After
    public void teardown() throws IOException {
        driver.quit();
    }

}
