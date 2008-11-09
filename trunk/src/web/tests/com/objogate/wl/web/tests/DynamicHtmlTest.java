package com.objogate.wl.web.tests;

import static org.hamcrest.Matchers.containsString;

import java.net.URL;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.objogate.wl.UnsynchronizedProber;
import com.objogate.wl.web.AsyncWebDriver;

public class DynamicHtmlTest {
    AsyncWebDriver browser = new AsyncWebDriver(new UnsynchronizedProber(), new FirefoxDriver());
        
    @Test 
    public void asynchronousText() {
        URL asyncPage = getClass().getResource("async-text.html");
        
        browser.navigate().to(asyncPage.toExternalForm());
        
        browser.element(By.id("x")).assertText(containsString("Changed"));
    }

    @Test 
    public void asynchronousTitle() {
        URL asyncPage = getClass().getResource("async-title.html");
        
        browser.navigate().to(asyncPage.toExternalForm());
        
        browser.assertTitle(containsString("Changed"));
    }

    @Test 
    public void dynamicElement() {
        URL asyncPage = getClass().getResource("async-element.html");
        
        browser.navigate().to(asyncPage.toExternalForm());
        
        browser.element(By.id("x")).assertText(containsString("Created"));
    }

    @After
    public void quitBrowser() {
        browser.quit();
    }
}
