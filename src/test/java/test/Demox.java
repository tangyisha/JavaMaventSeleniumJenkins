package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Demox {
    public static void main(String[] args){
        // 获取chromedriver路径
        String  chromedriver= System.getProperty("user.dir")+"/src/test/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver",chromedriver);

        WebDriver driver = new ChromeDriver();
        //隐式等待
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://testerhome.com/");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.name("q"))).sendKeys("testerhome");

        //new Actions(driver).contextClick().perform();
        driver.findElement(By.name("q")).sendKeys("testerhome");
        //切换窗口
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
        //获取当前页面的url
        System.out.println(driver.getCurrentUrl());


        //页面内嵌iframe，跳转到frame页面
        driver.switchTo().frame(1);
        WebElement element = driver.findElement(By.partialLinkText("金数据"));
        System.out.println(element.getLocation());
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().accept();

        new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("金数据"));

        driver.manage().getCookies();
        driver.manage().deleteAllCookies();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
