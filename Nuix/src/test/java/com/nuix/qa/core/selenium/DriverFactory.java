package com.nuix.qa.core.selenium;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    @Getter
    @Setter
    public static final String DEFAULT_DRIVER_NAME = "DEFAULT";
    @Getter
    @Setter
    private static String chromeDriverExePath;
    @Getter
    private static boolean isRemote = false;


    private static RemoteWebDriver getGridWebDriver(String browser) {
        RemoteWebDriver remoteWebDriver = null;
        return remoteWebDriver; // just for demo, it is null at this point
    }

    private static WebDriver getLocalWebDriver(String browser) {
        WebDriver webDriver = null;
        try {
            switch (browser.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver","resources/chromedriver");
                    //Set chrome options like download dir, ssl disabling etc
                    HashMap<String, Object> chromePref = new HashMap<>();
                    chromePref.put("download.prompt_for_download", false);
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--disable--extensions");
                    chromeOptions.addArguments("--ssl-protocol=any");
                    chromeOptions.addArguments("--test-type");
                    chromeOptions.addArguments("--start-fullscreen");

                    chromeOptions.setExperimentalOption("prefs", chromePref);
                    // for demo just setting one
                    webDriver = new ChromeDriver(chromeOptions);
                    break;
                case "ie":
                    // Int and set for ie
                    break;
                case "firefox":
                    // Init and set options firefox
                    break;
                default:
                    throw new AssertionError("Browser not configured correctly");
            }

        } catch (Exception e) {
            // TODO: Log error
            return null;
        }
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return webDriver;
    }

    public static void openBrowser(String browser, String executionType) {
        final WebDriver webDriver;
        switch (executionType.toLowerCase()) {
            case "grid":
                isRemote = false;
                // Code for grid
                webDriver = getGridWebDriver(browser);
                break;
            case "local":
                webDriver = getLocalWebDriver(browser);
                break;
            default:
                throw new AssertionError("Execution type not configured correctly");
        }
        DriverManager.setDriver(DEFAULT_DRIVER_NAME, webDriver);

    }
}
