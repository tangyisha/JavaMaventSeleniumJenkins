package test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class TackScreenShotTest {
    WebDriver driver;
    @BeforeMethod
    public void brfore(){
        String path = "/src/test/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void ScreenShot(){
        //网页截图
        driver.get("https://testerhome.com/");
        //File file = ((TacksScreenshot)driver).getScreenShotAs(OutputType.FILE);

    }

    @Test
    public void uploadTest(){
        //上传
        driver.get("https://www.baidu.com/");
        driver.findElement(By.xpath("//span[@class='soutu-btn']")).click();
        try {
            Thread.sleep(4000);
            driver.findElement(By.xpath("//input[@class='upload-pic']")).sendKeys("/Users/tangyisha/Downloads/4.png");
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
