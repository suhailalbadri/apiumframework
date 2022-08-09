package com.ecom.atcobe.appiumscripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class GeneralStoresVerifyProductPrice {
	@Test
	public void generalStoresVerifyProductPrice() throws MalformedURLException, InterruptedException
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
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("hello");
		MobileElement letsshop = (MobileElement) driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");
		driver.tap(1, letsshop, 10);
		MobileElement addtocart=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Air Jordan 4 Retro']/..//android.widget.TextView[@text='ADD TO CART']");
		driver.tap(1, addtocart, 10);
		MobileElement cart=(MobileElement) driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart");
		driver.tap(1, cart, 10);
		String cartprice = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
		if (cartprice.equals("$ 160.97")) {
			System.out.println("The price is same");
		} else {
			System.out.println("The price is not same");
		}
		
	}
}
