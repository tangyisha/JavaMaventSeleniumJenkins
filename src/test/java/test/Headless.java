package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Headless {

    public static void main(String[] args) {
        String path = "/src/test/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);

        //启动chrome浏览器
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless");
        WebDriver driver = new ChromeDriver(option);

        driver.get("https://testerhome.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.linkText("登录")).click();
        //设置等待时间,硬等待
        try{
            Thread.sleep(6000);
        }catch (Exception e){
            System.out.println(e);
        }

        driver.findElement(By.id("user_login")).clear();
        //显式等待
        //程序一共等待30s，默认0.5秒检查一次元素是否加载完成
        WebDriverWait wait = new WebDriverWait(driver,30);
        //until方法，返回一个Boolean类型，判断元素现在是否存在在页面上。locator的元素如果可见就停止等待，如果不可见就继续等待直到超过规定的时间后，报超时异常；
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login")));
        element.sendKeys("1491198849@qq.com");

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_login")));

        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys("apple13269835517");
        driver.findElement(By.name("commit")).click();
        driver.quit();
        System.out.println("passed");
    }

}