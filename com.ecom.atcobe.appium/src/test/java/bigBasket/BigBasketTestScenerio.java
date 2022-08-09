package bigBasket;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BigBasketTestScenerio {
	@Test
	public void bigBasketTestScenerio() throws Throwable
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 5");
		dc.setCapability("appPackage", "com.bigbasket.mobileapp");
		dc.setCapability("appActivity", ".activity.SplashActivity");
		dc.setCapability(MobileCapabilityType.NO_RESET, "true");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		SoftAssert sa=new SoftAssert();
		
		AndroidElement bigBasketOption=(AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='1 lakh+ products at lowest prices']"));
		driver.tap(1, bigBasketOption, 10);
		
		AndroidElement hambugerOption = (AndroidElement) driver.findElementById("com.bigbasket.mobileapp:id/iv_drawer");
		driver.tap(1, hambugerOption, 10);
		
		AndroidElement offersOption=(AndroidElement) driver.findElementByXPath("//android.widget.TextView[@text='Offers']");
		driver.tap(1, offersOption, 10);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		AndroidElement fruitsAndVegetables= (AndroidElement) driver.findElementByXPath("(//android.widget.ImageView[@content-desc=\"Product Image\"])[2]");
		
		wait.until(ExpectedConditions.elementToBeClickable(fruitsAndVegetables));
		
		driver.tap(1, fruitsAndVegetables, 10);
		
		String onionTitle = driver.findElementByXPath("//android.widget.TextView[@text='Onion (Loose)']").getText();
		String onionPrice = driver.findElementByXPath("//android.widget.TextView[@text='₹29']").getText();
		onionPrice.replace("₹","");
		int oPrice = Integer.parseInt(onionPrice);
		
		sa.assertEquals(oPrice, 29);
		if (oPrice>50) {
			System.out.println(onionTitle+" : "+onionPrice);
		}
		
		
		String potatoTitle = driver.findElementByXPath("//android.widget.TextView[@text='Potato (Loose)']").getText();
		String potatoPrice = driver.findElementByXPath("//android.widget.TextView[@text='₹76']").getText();
		potatoPrice.replace("₹","");
		int pPrice = Integer.parseInt(potatoPrice);
		sa.assertEquals(pPrice, 76);
		if (pPrice>50) {
			System.out.println(potatoTitle+" : "+potatoPrice);
		}
		
		
		String tomatoTitle = driver.findElementByXPath("//android.widget.TextView[@text='Tomato - Local (Loose)']").getText();
		String tomatoPrice = driver.findElementByXPath("//android.widget.TextView[@text='₹10']").getText();
		tomatoPrice.replace("₹","");
		int tPrice=Integer.parseInt(tomatoPrice);
		sa.assertEquals(tPrice, 10);
		
		if (tPrice>50) {
			System.out.println(tomatoTitle+" : "+tomatoPrice);
		}
		
		sa.assertAll();
	}
}