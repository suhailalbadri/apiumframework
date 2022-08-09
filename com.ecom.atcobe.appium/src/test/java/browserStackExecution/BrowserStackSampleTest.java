package browserStackExecution;



import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.remote.MobileCapabilityType;

public class BrowserStackSampleTest {
public static final String USERNAME = "suhailalbadri_GJnPd6";
public static final String AUTOMATE_KEY = "QRkxPuyfxFzKHvqvhTcw";
public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S22");
        
        caps.setCapability("appPackage", "com.facebook.katana");
        caps.setCapability("appActivity", ".LoginActivity");
        
        URL url=new URL("http://localhost:4723/wd/hub");
        
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        

        // Your test script like you usually write

        driver.quit();
}
}
