package com.nuix.qa.cucumber.commons;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.nuix.qa.core.utils.HtmlReporter;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import com.aventstack.extentreports.Status;


public class ListernerPlugin implements ConcurrentEventListener {

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestSourceRead.class, this::featureRead);
        publisher.registerHandlerFor(TestCaseStarted.class, this::ScenarioStarted);
        publisher.registerHandlerFor(TestStepStarted.class, this::stepStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::stepFinished);
    }

    private void featureRead(TestSourceRead event) {
        String featureSource = event.getUri().toString();
        String featureName = featureSource.split(".*/")[1];
        TestContext tc = ContextManager.getTestContextWithThreadName(Thread.currentThread().getName());
        ExtentTest extentTest = HtmlReporter.extentReports.createTest(featureName);
        tc.feature.putIfAbsent(featureSource, extentTest);
    }

    private void ScenarioStarted(TestCaseStarted event) {
        String featureName = event.getTestCase().getUri().toString();
        TestContext tc = ContextManager.getTestContextWithThreadName(Thread.currentThread().getName());
        tc.scenario = tc.feature.get(featureName).createNode("Scenario: " + event.getTestCase().getName());
    }


    private void stepStarted(TestStepStarted event) {
        String stepName;
        String keyword;
        if (event.getTestStep() instanceof PickleStepTestStep) {
            TestContext tc = ContextManager.getTestContextWithThreadName(Thread.currentThread().getName());
            PickleStepTestStep steps = (PickleStepTestStep) event.getTestStep();
            stepName = steps.getStep().getText();
            keyword = steps.getStep().getKeyword();
            tc.step = tc.scenario.createNode(Given.class, keyword + " " + stepName);
        }
    }

    // This is triggered when TestStep is finished
    // for demo keeping minimum
    private void stepFinished(TestStepFinished event) {
        TestContext tc = ContextManager.getTestContextWithThreadName(Thread.currentThread().getName());
        if (event.getTestStep() instanceof PickleStepTestStep) {
            if (event.getResult().getStatus().toString().equals("PASSED")) {
                tc.step.log(Status.PASS, "Passed");
            } else if (event.getResult().getStatus().toString().equals("SKIPPED")) {
                tc.step.log(Status.SKIP, "Skipped ");
            } else {
                tc.step.log(Status.FAIL, event.getResult().getError());
                tc.step.info(event.getResult().getError().getMessage());
            }
        }
    }


}
