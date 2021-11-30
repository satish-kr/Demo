package com.nuix.qa.cucumber.commons;

import java.util.HashMap;

public class ContextManager {
    static HashMap<String, TestContext> testThreadAndContext = new HashMap<>();

    synchronized static public void putContextForThread(String threadName, TestContext tc) {
        testThreadAndContext.put(threadName, tc);
    }

    public static TestContext getTestContextWithThreadName(String threadName) {
        return testThreadAndContext.get(threadName);
    }
}
