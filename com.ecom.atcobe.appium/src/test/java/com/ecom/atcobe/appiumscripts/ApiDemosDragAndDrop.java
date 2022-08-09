package com.ecom.atcobe.appiumscripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ApiDemosDragAndDrop {
	@Test
	public void apiDemosDragAndDrop() throws MalformedURLException
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "VirtualDevice");
		dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");
		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, dc);
		MobileElement  continuebtn=(MobileElement) driver.findElementById("com.android.permissioncontroller:id/continue_button");
		driver.tap(1, continuebtn, 10);
		MobileElement okbtn=(MobileElement) driver.findElementById("android:id/button1");
		driver.tap(1, okbtn, 10);
		MobileElement views=(MobileElement) driver.findElementByAccessibilityId("Views");
		driver.tap(1, views, 10);
		MobileElement dandd= (MobileElement) driver.findElementByAccessibilityId("Drag and Drop");
		driver.tap(1, dandd, 10);
		MobileElement ele1=(MobileElement) driver.findElementById("io.appium.android.apis:id/drag_dot_1");
		MobileElement ele2=(MobileElement) driver.findElementById("io.appium.android.apis:id/drag_dot_2");
		TouchAction action = new TouchAction(driver);
		action.longPress(ele1).moveTo(ele2).release().perform();
		driver.closeApp();
	}
}