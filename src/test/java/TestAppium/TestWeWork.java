package TestAppium;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

// 测试webview
public class TestWeWork {
    public static AndroidDriver driver;

    @BeforeEach
    public void setUp() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.tencent.wework");
        capabilities.setCapability("appActivity", ".launch.LaunchSplashActivity");
        capabilities.setCapability("noReset", "true");
        //capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("automationName", "UiAutomator1");
        //设置Webview浏览器驱动地址
        capabilities.setCapability("chromedriverExecutable","Users/tangyisha/driver/chromeDriver");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, capabilities);
        //隐式等待
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
    }

    @Test
    public void webview() throws InterruptedException {
        for (Object c : driver.getContextHandles()) {
            System.out.println(c.toString());
        }
        Thread.sleep(3000);
        for (Object c : driver.getContextHandles()) {
            System.out.println(c.toString());
        }

        driver.getWindowHandle();
        driver.switchTo().window(driver.getWindowHandle());
    }

}
