package com.nuix.qa.core.selenium;

import org.openqa.selenium.WebDriver;

import java.util.*;

public class DriverManager {

    // Add, Remove and manage multiple drivers, For demo assuming one driver only

    public static ThreadLocal<HashMap<String, WebDriver>> activeDriver = ThreadLocal.withInitial(HashMap::new);
    public static ThreadLocal<String> currentDriver = new ThreadLocal<String>();

    private static final List<WebDriver> allDrivers = Collections.synchronizedList(new ArrayList<>());

    public static WebDriver getDriver() {
        String driverName = currentDriver.get();
        WebDriver driver = activeDriver.get().get(driverName);
        return driver;
    }

    public static void setDriver(String driverName, WebDriver driver) {
        allDrivers.add(driver);
        addWebDriver(driverName, driver);
        currentDriver.set(driverName);
    }


    static {
        java.lang.Runtime.getRuntime().addShutdownHook(new Thread(DriverManager::quitAllDriver, "Shutdown hook"));
    }


    private static void addWebDriver(String driverName, WebDriver driver) {
        // TODO: Do basic checks before adding, for demo skipping
        activeDriver.get().put(driverName, driver);
    }

    private static void quitAllDriver() {
        // Just for demo, else loop and shut down all drivers
        allDrivers.get(0).quit();
    }

    //Add quit driver, switch driver and other required methods, skipping for demo

}
