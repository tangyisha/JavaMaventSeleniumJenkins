package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class assertTest {
    public static void main(String[] args){
        String expect = "登录成功";
        String actual = "登录成功";
        Assert.assertEquals(expect, actual);
    }

    public static class LoginTestNG {
        WebDriver driver;

        @BeforeMethod
        public void before(){
            String path = "/src/test/drivers/chromedriver";
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
            driver = new ChromeDriver();
        }

        @Test
        public void LoginTest(){
            driver.get("https://testerhome.com/");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(By.linkText("登录")).click();
            driver.findElement(By.id("user_login")).clear();
            //显式等待
            //程序一共等待30s，默认0.5秒检查一次元素是否加载完成
            WebDriverWait wait = new WebDriverWait(driver,30);
            //until方法，返回一个Boolean类型，判断元素现在是否存在在页面上。locator的元素如果可见就停止等待，如果不可见就继续等待直到超过规定的时间后，报超时异常；
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login")));
            element.sendKeys("1491198849@qq.com");
            driver.findElement(By.id("user_password")).clear();
            driver.findElement(By.id("user_password")).sendKeys("apple13269835517");
            driver.findElement(By.name("commit")).click();
            System.out.println("passed");
        }

        @AfterMethod
        public void after(){
            driver.quit();
        }
    }

    public static class PriorityTest {
        @Test
        public void testPorcess1(){
            //testPorcess1断言失败，还继续执行testPorcess2
            Assert.assertEquals(1,2);
            System.out.println("开始流程1");
        }

        //依赖testPorcess1，如果testPorcess1失败，testPorcess2不会执行
        @Test(dependsOnMethods = "testPorcess1")
        public void testPorcess2(){
            Assert.assertEquals(1,1);
            System.out.println("开始流程2");
        }
    }
}
