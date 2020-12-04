package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DefaultSuiteTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void search(){
        String  chromedriver= System.getProperty("user.dir")+"/src/test/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver",chromedriver);
        driver.get("https://testerhome.com/");
        driver.manage().window().setSize(new Dimension(1440, 877));
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
    }

}
