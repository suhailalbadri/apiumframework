package com.ecom.atcobe.appiumscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ScaleViewZoomAndPinch {
	@Test
	public void scaleViewZoomAndPinch() throws MalformedURLException
	{
	DesiredCapabilities dc = new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
	dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 5");
	//dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
	dc.setCapability("appPackage", "com.davemorrissey.labs.subscaleview.sample");
	dc.setCapability("appActivity", ".MainActivity");
	URL url=new URL("http://localhost:4723/wd/hub");
	AndroidDriver driver=new AndroidDriver(url, dc);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	MobileElement basicFeatures= (MobileElement) driver.findElementById("com.davemorrissey.labs.subscaleview.sample:id/basicFeatures");
	driver.tap(1, basicFeatures, 10);
	MobileElement squirreImg=(MobileElement) driver.findElementById("com.davemorrissey.labs.subscaleview.sample:id/imageView");
	driver.zoom(squirreImg);
	driver.pinch(squirreImg);
	}
}