package test;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JavaScriptTest {
    public static void main(String[] args) throws InterruptedException {
        // 获取chromedriver路径
        String  chromedriver= System.getProperty("user.dir")+"/src/test/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver",chromedriver);

        WebDriver driver = new ChromeDriver();
        driver.get("https://testerhome.com/");
        //隐式等待
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //执行Javascript
//        String js = "arguments[0].setAttribute('style', arguments[1])";
//        WebElement element = driver.findElement(By.cssSelector(".home-icons"));
//        String style = "background:yellow";
//        ((JavascriptExecutor)driver).executeScript(js, element, style);


        //滚动到元素处
//        WebElement element = driver.findElement(By.linkText("北京"));
//        String js = "arguments[0].scrollIntoView(true);";
//        ((JavascriptExecutor)driver).executeScript(js, element);
//        Thread.sleep(3000);
//        element.click();

        //滚动到页面指定位置
        String  js = "document.documentElement.scrollTop=500";
        ((JavascriptExecutor)driver).executeScript(js);
        Thread.sleep(3000);


    }
}
