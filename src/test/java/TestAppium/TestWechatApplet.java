package TestAppium;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


// 测试微信小程序
public class TestWechatApplet {
    public static AndroidDriver driver;

    @BeforeEach
    public void setUp() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.tencent.mm");
        //app入口活动名
        capabilities.setCapability("appActivity", ".ui.LauncherUI");
        //系统自动授权
        capabilities.setCapability("autoGrantPermissions", "true");
        //引擎设置为UiAutomator2
        capabilities.setCapability("automationName", "UiAutomator2");
        //是否在测试前后重置相关环境 ，默认false，不重置填写true
        capabilities.setCapability("noReset", "true");
        //是否需要输⼊⾮英⽂之外的语⾔，默认为false，输入中文，需要设置为true
        capabilities.setCapability("unicodeKeyBoard","true");
        //并在测试完成后重置输⼊法
        capabilities.setCapability("resetKeyBoard","true");
        //用于连接到ADB服务器的端口（如果不填默认5037）
        capabilities.setCapability("adbPort","5037");
        //跳过以开始捕获logcat。它可能会改善网络等性能。与日志相关的命令将不起作用。默认为false
        capabilities.setCapability("skipLogcatCapture","true");
        //在使用adb启动应用程序之前，不要停止被测应用程序的进程。如果被测试的应用程序是由另一个锚定应用程序创建的，则将其设置为false，则在使用adb启动测试应用程序的过程中，锚定应用程序的过程仍然可以运行。换句话说，将dontStopAppOnReset设置为true，我们将不会-S在adb shell am start呼叫中包含该标志。将此功能省略或设置为时false，我们包括该-S标志。默认false
        capabilities.setCapability("dontStopAppOnReset","true");
        //设置Webview浏览器驱动地址
        capabilities.setCapability("chromedriverExecutable","Users/tangyisha/driver/chromeDriver");
        //设置chromedrivers路径，把所有版本的chromedriver都放在该目录下
        capabilities.setCapability("chromedriverExecutableDir", "/Users/seveniruby/projects/chromedriver/chromedrivers");
        //设置chrome浏览器对应的chromdriver版本
        capabilities.setCapability("chromedriverChromeMappingFile", "/Users/seveniruby/projects/Java3/src/test/java/test_app/wechat/mapping.json");
        //打印详细的chromddriver日志
        capabilities.setCapability("showChromedriverLog", true);

        ChromeOptions chromeOptions = new ChromeOptions();
        //微信小程序的进程名，如果不设置，默认等于appPackage=com.tencent.mm
        chromeOptions.setExperimentalOption("androidProcess","com.tencent.mm:appbrand0");
        //CAPABILITY = "goog:chromeOptions"
        chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        capabilities.setCapability("browserName","");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, capabilities);
        //隐式等待
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void wxmicroApplication() throws InterruptedException {
        Thread.sleep(30000);
        Dimension size = driver.manage().window().getSize();
        TouchAction action = new TouchAction<>(driver);

        //action.longPress(PointOption.point(size.width/2,size.height/2))
        action.longPress(LongPressOptions.longPressOptions()
                //设置等待时间2秒
                .withDuration(Duration.ofSeconds(2))
                .withPosition(PointOption.point(size.width/2, size.height/2)))
                .moveTo(PointOption.point(size.width/2,(int)(size.height*0.8)))
                .release().perform();

        driver.findElementByClassName("android.widget.EditText").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("雪球");
        driver.findElementByClassName("android.widget.Button").click();
        String webview = driver.getContextHandles().stream().filter(context->
                //匹配WEBVIEW_xweb，避免切错webveiw
                context.toString().contains("WEBVIEW_xweb"))
                .findFirst().get().toString();
        System.out.println(webview);
        //切换context
        driver.context(webview);

    }
}
