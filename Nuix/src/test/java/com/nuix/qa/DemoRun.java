package com.nuix.qa;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.nuix.qa.core.selenium.DriverFactory;
import com.nuix.qa.core.utils.HtmlReporter;
import com.nuix.qa.cucumber.commons.ContextManager;
import com.nuix.qa.cucumber.commons.TestContext;

public class DemoRun {

    // For demo hard coding the tags
    static String tags = "@stay_search or @carRental or @auth";

    public static void main(String[] args) throws InterruptedException {
        HtmlReporter.extentReports = new ExtentReports();
        HtmlReporter.spark = new ExtentSparkReporter("NuixDemoTestReport.html");
        HtmlReporter.spark.config().setEncoding("utf-8");
        HtmlReporter.spark.config().setDocumentTitle("Nuix-Booking.com Demo");
        HtmlReporter.extentReports.attachReporter(HtmlReporter.spark);

        Thread thread = new Thread() {
            public void run() {
                // For demo only, env like browser, exe type etc should come from env props or jenkins pipeline etc
                DriverFactory.openBrowser("chrome", "local");
                ContextManager.putContextForThread(Thread.currentThread().getName(), new TestContext());
                io.cucumber.core.cli.Main.run(
                        "-g",
                        "com/nuix/qa/cucumber/steps", // the package which contains the glue classes
                        "classpath:features",
                        "-t",
                        tags,
                        "-p",
                        "com.nuix.qa.cucumber.commons.ListernerPlugin"
                );
            }
        };

        thread.start();
        thread.join();
        HtmlReporter.extentReports.flush();
    }
}
