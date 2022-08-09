package browserStackExecution;

import java.net.URL;
import java.util.List;
import java.net.MalformedURLException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserStackAndroid {

  public static String userName = "suhailalbadri_GJnPd6";
  public static String accessKey = "QRkxPuyfxFzKHvqvhTcw";

  public static void main(String args[]) throws MalformedURLException, InterruptedException {
    DesiredCapabilities caps = new DesiredCapabilities();

    caps.setCapability("device", "Samsung Galaxy S22");
    caps.setCapability("os_version", "12.0");
    caps.setCapability("project", "My First Project");
    caps.setCapability("build", "My First Build");
    caps.setCapability("name", "Bstack-[Java] Sample Test");
    caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

    AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

//    AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
//        ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
//    searchElement.click();
//    AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
//        ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
//    insertTextElement.sendKeys("BrowserStack");
//    Thread.sleep(5000);
//
//    List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
//    assert(allProductsName.size() > 0);

    // The driver.quit statement is required, otherwise the test continues to execute, leading to a timeout.
    driver.quit();
  }
}