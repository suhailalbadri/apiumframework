package com.qcom.instamart;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class PlaceOrderForCookingOil {
	@Test
	public void placeOrderForCookingOil() throws Throwable
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "VirtualDevice");
		dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		//dc.setCapability("appPackage", "in.swiggy.android");
		//dc.setCapability("appActivity", ".activities.HomeActivity");
		dc.setCapability(MobileCapabilityType.NO_RESET, "true");
		dc.setBrowserName("chrome");
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://swiggy.com");
		driver.findElementByXPath("//button[.='SETUP YOUR LOCATION']").click();
		driver.findElementByXPath("//input[@placeholder='Enter area, street name...']").sendKeys("bsk");
		driver.findElementByXPath("//span[.='BSK 3rd Stage, Banashankari']").click();
		driver.findElementByXPath("//button[@aria-label='Click to know more about Instamart.']").click();
		driver.findElementByXPath("//span[.='Search for groceries, veggies and more']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@type='search']").click();
		driver.findElementByXPath("//input[@type='search']").sendKeys("cooking oil");
		//System.out.println("value entered");
		driver.findElementByXPath("//input[@type='search']").sendKeys(Keys.ENTER);
		//System.out.println("enter btn");
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@style='background-image: url(\"https://res.cloudinary.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_304/fk2d1ujuoe9mq00bzoze\");']").click();
		//System.out.println("click on saffola");
		Thread.sleep(1000);
		driver.findElementByXPath("//div[@data-testid='add-button']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//div[@aria-label='1 L cost 220 rupee, tap to add to cart']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//span[.='Done']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//span[.='View Cart']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//div[.='Continue']").click();
		driver.closeApp();
	}
}