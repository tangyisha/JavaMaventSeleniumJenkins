package test;

import Page.HomePage;
import Page.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptReturnTest {
    WebDriver driver;
    @BeforeMethod
    public void brfore(){
        String path = "/src/test/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void returnValue(){
        // 获取页面的宽度
        driver.get("https://testerhome.com/");
        String js = "return window.innerWidth";
        System.out.println(((JavascriptExecutor) driver).executeScript(js));


    }

    @Test
    public void returnValueScrollTop(){
        driver.get("https://testerhome.com/");
        // 获取滚动条位置
        String js = "return document.documentElement.scrollTop";
        System.out.println(((JavascriptExecutor) driver).executeScript(js));


    }


    @AfterMethod
    public void after(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
