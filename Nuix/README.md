Demo Project for Nuix 
This is demo for booking.com but can have mutliple projects under it.
For demo only chorme 
Compiled, build and tested on Java version 17/Mac m1/Chrome version 95.0.4638.69

System requirments
1. Java JDK 11 or later
2. Maven version {version}

How to run:
This project can be run as maven project or as a stand alone jar or Jenlkins
For demo sticking to run via IDE
1. Sync the git repo or download on your local directory
2. Import the project in IntelliJ
3. Under, Src>main>test>Java> find the file DemoRun
4. Run the file as java program
5. Check the results in html format under targets folder
6. Under NuixDemo/resources folder extract the appropriate chrome driver

Core files/package location and definitions:
 package com.nuix.selinium contains three classes for creating new webdriver session and managing them.
 package cucumber.steps contains the steps file
 package pages contains the pages
 test/resources contains the feature files


Flow:
Call to driver factory to open browser will create a new session.
Both pages and steps extends Driver helper class so that they can have access to driver.
The base page class is NuixBasePage, which is extended by BookingsBase page and in turn will be extended by all other pages
In the same way all steps files extends Bookings base steps which in turn extends NuixBaseSteps 
 