Demo Project
The focus is on the framwork design and no so much on the actual test cases written for demo
This is demo for booking.com but can have mutliple projects under it.
For demo only chorme driver related code has been implemented

Compiled, built and tested on Java version 17/Mac m1/Chrome version 95.0.4638.69

System requirments
1. Java JDK 11 or later
2. Maven (If complied using cli) else you can use any IDE to run and compile

How to run:
This project can be run as maven project or as a stand alone jar or on Jenkins
For demo sticking to run via IDE
1. Sync the git repo or download on your local directory
3. Import the project in IntelliJ
4. Under NuixDemo/resources folder extract the appropriate chrome driver
5. Under, Src>main>test>Java> find the file DemoRun.java
6. Run the file as java program
7. Check the results in html format under project root Directory

Core files/package location and definitions:
 package com.nuix.selinium contains three classes for creating new webdriver session and managing them.
 package cucumber.steps contains the steps file
 package pages contains the pages
 test/resources contains the feature files


Flow:
Call to DriverFactory to open browser will create a new session.
Both pages and steps extends DriverHelper class so that they can have access to driver.
The base page class is NuixBasePage, which is extended by BookingsBase page and in turn will be extended by all other pages
In the same way all steps files extends Bookings base steps which in turn extends NuixBaseSteps
Extent reports is used for html reporting the final results
 
