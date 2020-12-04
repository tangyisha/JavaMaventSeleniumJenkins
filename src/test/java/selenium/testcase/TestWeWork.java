package selenium.testcase;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import selenium.Page.App;

import java.util.concurrent.TimeUnit;

public class TestWeWork {
    public static String url = "https://work.weixin.qq.com/";

    @Before
    public void setUp(){}
        WebDriver driver = new ChromeDriver();


    @AfterMethod
    public void after(){
        driver.quit();
    }

    @Test
    public void testStart(){
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get(url);
            //窗口最大化
            driver.manage().window().maximize();
            driver.findElement(By.linkText("企业登录")).click();
            //获取浏览器的cookies
            //System.out.println(driver.manage().getCookies());
            //添加cookie
            driver.manage().addCookie(new Cookie("wwrtx.refid","40709640823144156"));
            driver.manage().addCookie(new Cookie("wwrtx.sid","xMKtvrK3Z9GsN9SUlgoQRkIRCHpu-okMOOCnDr8MSERhjJtd3H53CN6h-s5r8bto"));
            Thread.sleep(3000);
            //刷新浏览器
            driver.navigate().refresh();
            App.driver = driver;
            App app = new App();
            String mobile = "15600534762";
            app.toMebmerAdd().add(mobile, mobile, mobile);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
