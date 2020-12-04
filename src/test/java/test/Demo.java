package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Demo {

    public static void main(String[] args){
        /*
        String path = "/src/test/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
        WebDriver driver = new ChromeDriver();
        */
        String path = "/src/test/drivers/geckodriver";
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+path);
        //启动firefox浏览器
        FirefoxDriver driver=new FirefoxDriver();

        driver.get("https://testerhome.com/");
        By logoBy = By.name("q");
        WebElement logoElement = driver.findElement(logoBy);
        logoElement.sendKeys("testerhome");
        System.out.println("pass");

    }

}

