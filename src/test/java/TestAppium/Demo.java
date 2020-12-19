package TestAppium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import javafx.scene.web.WebView;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static AndroidDriver driver;

    @BeforeEach
    public void setUp() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "127.0.0.1:62001");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.xueqiu.android");
        capabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, capabilities);
        //隐式等待
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
    }

    @Test
    public void scroll() throws InterruptedException{
        driver.findElement(By.id("tv_agree")).click();
        Thread.sleep(3000);
        for(int i=1; i<20; i++){
            //滑动
            swipe(0.8,0.8,0.4,0.4);
        }
    }

    @Test
    public void swipe(Double startX, Double startY,Double endX,Double endY) throws InterruptedException {
        driver.findElement(By.id("tv_agree")).click();
        TouchAction action =  new TouchAction(driver);
        //获取当前页面的屏幕大小
        Dimension size = driver.manage().window().getSize();
        //短按
        action.press(PointOption.point((int)(size.width*startX),(int)(size.height*startY)));
        //等待1秒
        action.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)));
        //移动
        action.moveTo(PointOption.point((int)(size.width*endX),(int)(size.height*endY)));
        //释放
        action.release();
        //执行
        action.perform();

    }

    @Test
    public void testDevice() throws InterruptedException {
        driver.findElement(By.id("tv_agree")).click();
        //将app放在后台运行5秒
        driver.runAppInBackground(Duration.ofSeconds(5));
        Thread.sleep(3000);
        //打开提醒框
        //driver.openNotifications();
        //获取电量信息
        //driver.getBatteryInfo().getState().ordinal();
        //获取日志,getAvailableLogTypes()获取可用日志类型
        driver.manage().logs().getAvailableLogTypes().forEach(x->System.out.println(x));
        //get("logcat")打印logcat类型日志
        System.out.println(driver.manage().logs().get("logcat").toJson().toString());

    }


    @Test
    public void testApp() throws InterruptedException {
        driver.findElement(By.id("tv_agree")).click();
        //屏幕切换横向-横屏
        driver.rotate(ScreenOrientation.LANDSCAPE);
        Thread.sleep(3000);
        //屏幕切换纵向-竖屏
        driver.rotate(ScreenOrientation.PORTRAIT);
        //navigate：导航，refresh：刷新， back返回
        driver.navigate().refresh();
        driver.navigate().back();
        // Java
        //获取屏幕方向
        ScreenOrientation orientation = driver.getOrientation();
        System.out.println(orientation);


    }

    @Test
    public void testCall()  {
        //模拟发短信，只能模拟器有这个功能
//        driver.sendSMS("13269835517","hello from sms");
//        driver.makeGsmCall("13269835517");

    }

    @Test
    public void testScreenshot() throws IOException {
        //截图
        FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),new File("1.png"));
    }

    @Test
    public void testScroll() throws InterruptedException {
        driver.findElement(By.id("tv_agree")).click();
        //获取屏幕的大小
        Dimension size = driver.manage().window().getSize();   //返回(720, 1280)
        Double startX = 0.5;
        Double startY = 0.8;
        Double endX = 0.5;
        Double endY = 0.2;
        //滑动
        for(int i= 0;i<=20;i++){
            Thread.sleep(1000);
            TouchAction action = new TouchAction(driver);
            //longPress 长按，使用屏幕相对大小
            action.longPress(PointOption.point((int)(size.width*startX),(int)(size.height*startY)));
            //等待1秒
            //action.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)));
            // moveTo 移动
            action.moveTo(PointOption.point((int)(size.width*endX),(int)(size.height*endY)));
            //release 释放
            action.release();
            //perform 执行
            action.perform();
        }
    }

    @Test
    public void testScroll2() {
        driver.findElement(By.id("tv_agree")).click();
        //切换横屏,rotate:旋转,ScreenOrientation:屏幕方向,LANDSCAPE:横向
        driver.rotate(ScreenOrientation.LANDSCAPE);
        //返回
        driver.navigate().back();
        //切换纵屏，PORTRAIT：纵向
        driver.rotate(ScreenOrientation.PORTRAIT);
        //打开通知栏
        driver.openNotifications();
        //摇一摇
        //driver.shake();

    }

    @Test
    public void testLog() {
        driver.findElement(By.id("tv_agree")).click();
        System.out.println(driver.manage().logs());
        //getAvailableLogTypes:获取可用日志类型
        System.out.println(driver.manage().logs().getAvailableLogTypes());  //返回：[logcat, bugreport, server, client]
        System.out.println(driver.manage().logs().get("logcat").getAll().toArray());
    }

    @Test
    public void Performance() {
        driver.findElement(By.id("tv_agree")).click();
        //获取支持性能数据类型
        driver.getSupportedPerformanceDataTypes();
        //获得性能数据cpu数据
        List<List<Object>> performanceData = driver.getPerformanceData("com.xueqiu.android", "cpuinfo", 5);


    }

    @Test
    public void testContent() throws InterruptedException{
        driver.findElement(By.id("tv_agree")).click();
        driver.findElement(By.xpath("//*[@text='交易']")).click();
        Thread.sleep(3000);
        System.out.println(driver.getContext());
        System.out.println(driver.getContextHandles());
        Set<String> contextNames = driver.getContextHandles();
        driver.context((String) contextNames.toArray()[1]);
        System.out.println(driver.getContext());
        driver.context("NATIVE_APP");

    }

    @Test
    public void testsrcoll3() throws InterruptedException{
        driver.findElement(By.id("tv_agree")).click();
        driver.findElement(By.xpath("//*[@text='交易']")).click();
        Thread.sleep(3000);
        //滚动
        //找到一个列表
        AndroidElement list = (AndroidElement) driver.findElement(By.className("android.view.View"));
        //在列表中滚动打到指定的元素
        MobileElement WebView = list.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)" +
                ".instance(0)).scrollIntoView(new Uiselector().text('WebView'));"));

        WebView.click();
        System.out.println(driver.getContextHandles());
        System.out.println(driver.getContextHandles());
        System.out.println(driver.getContextHandles());

    }

    @Test
    public void testToast() throws InterruptedException{
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".scrollIntoView(new UiSelector().text('Popup Menu').instance(0));").click();
        driver.findElementByXPath("//*[contains(@text,'Make')]").click();
        driver.findElementByXPath("//*[@text='Search']").click();
        for(int i=0;i<=5;i++){
            //ClassName无法找到，只能用XPath才能找到
            System.out.println(driver.findElementByClassName("android.widget.Toast").getText());
            // 获取Toast文本
            driver.findElementByXPath("//*[@class='android.widget.Toast']").getText();
            Thread.sleep(1000);
        }
    }
}