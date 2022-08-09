package com.ecom.atcobe.appiumscripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class GeneralStoresToastMessage {
	@Test
	public void generalStoresToastMessage() throws Throwable
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "VirtualDevice");
		dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		dc.setCapability("appPackage", "com.androidsample.generalstore");
		dc.setCapability("appActivity", ".SplashActivity");
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, dc);
		Thread.sleep(5000);
		MobileElement letsshop = (MobileElement) driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");
		//driver.tap(1, letsshop, 10);
		letsshop.click();
		Thread.sleep(1000);
		String toastmsg = driver.findElementByXPath("//hierarchy/android.widget.Toast[1]").getText();
		System.out.println(toastmsg);
	}
}