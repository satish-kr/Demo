package com.nuix.qa.cucumber.commons;

import com.aventstack.extentreports.ExtentTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestContext {

    public Map<String, ExtentTest> feature = new HashMap<>();
    public ExtentTest scenario;
    public ExtentTest step;

    public void setUp(String dirName) throws IOException {
        // Demo not needed
    }

    public void tearDown() throws InterruptedException, IOException {
        // For demo not needed
    }

      public void logInfo(String info) {
        this.step.info(info);
    }


}
