package com.ecom.atcobe.appiumscripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TouchScreenTestPattern {
	@Test
	public void touchScreenTestPattern() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "VirtualDevice");
		dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		dc.setCapability("appPackage", "jp.rallwell.siriuth.touchscreentest");
		dc.setCapability("appActivity", ".TouchScreenTestActivity");
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, dc);
		Dimension size = driver.manage().window().getSize();
		int width = size.getWidth();
		int height = size.getHeight();
		
		//vertical swipe
		driver.swipe(width/2, (int) (height*0.1), width/2, height, 2000);
		driver.swipe(width/4, (int) (height*0.1), width/4, height, 2000);
		driver.swipe((int) (width*0.75), (int) (height*0.1), (int) (width*0.75), height, 2000);
		//horizontal swipe
		driver.swipe(0, height/2, width, height/2, 2000);
		driver.swipe(0, height/4, width, height/4, 2000);
		driver.swipe(0, (int) (height*0.75), width, (int) (height*0.75), 2000);
	}	
}