package com.imaginea.base;

import java.net.MalformedURLException;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public interface MobileOS {

	AppiumDriver getDriver(String url,DesiredCapabilities capability) throws MalformedURLException;

}
