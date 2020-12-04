package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AlertTest {
    WebDriver driver;
    @BeforeMethod
    public void brfore(){
        String path = "/src/test/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void alertTest(){
        try {
            driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");
            //跳转ifarme页面
            driver.switchTo().frame("iframeResult");
            Actions actions = new Actions(driver);
            // 把元素拖动到另外元素处
            actions.dragAndDrop(driver.findElement(By.id("draggable")),driver.findElement(By.id("droppable"))).perform();
            Thread.sleep(5000);
            // 允许弹框
            driver.switchTo().alert().accept();
            Thread.sleep(3000);
            //跳转返回到主ifarme
            driver.switchTo().parentFrame();
            System.out.println(driver.findElement(By.id("submitBTN")).getText());
            Thread.sleep(3000);
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
