package com.nuix.qa.core.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;

import java.awt.*;

public class HtmlReporter {
    public static ExtentReports extentReports;
    public static ExtentSparkReporter spark;
    public static Scenario scenario;
    public static Taskbar.Feature feature;
    public static ExtentTest extentTest;

}
