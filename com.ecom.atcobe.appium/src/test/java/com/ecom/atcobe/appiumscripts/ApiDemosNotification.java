package com.ecom.atcobe.appiumscripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ApiDemosNotification {
	@Test
	public void apiDemosScreenOrientation() throws MalformedURLException
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "VirtualDevice");
		dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, dc);
		MobileElement  continuebtn=(MobileElement) driver.findElementById("com.android.permissioncontroller:id/continue_button");
		driver.tap(1, continuebtn, 10);
		MobileElement okbtn=(MobileElement) driver.findElementById("android:id/button1");
		driver.tap(1, okbtn, 10);
		MobileElement app =(MobileElement) driver.findElementByAccessibilityId("App");
		driver.tap(1, app, 10);
		MobileElement notification = (MobileElement) driver.findElementByAccessibilityId("Notification");
		driver.tap(1, notification, 10);
		MobileElement incomingMessage = (MobileElement) driver.findElementByAccessibilityId("IncomingMessage");
		driver.tap(1, incomingMessage, 10);
		MobileElement showAppNotification = (MobileElement) driver.findElementByAccessibilityId("Show App Notification");
		driver.tap(1, showAppNotification, 10);
		driver.swipe(40, 500, 1200, 500, 1000);
		driver.openNotifications();
		//driver.tap(1, 100, 1100, 10);
		MobileElement notification1=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Joe']");
		//driver.tap(1, notification1, 10);
		notification1.click();
		String messageSender=driver.findElementById("io.appium.android.apis:id/from").getText();
		if (messageSender.contains("Joe")) {
			System.out.println("Message received");
		} else {
			System.out.println("Message not received");
		}
		driver.closeApp();
	}	
}