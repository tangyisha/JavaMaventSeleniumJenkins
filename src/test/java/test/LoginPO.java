package test;

import Page.HomePage;
import Page.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPO {
    WebDriver driver;
    @BeforeMethod
    public void brfore(){
        String path = "/src/test/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
        driver = new ChromeDriver();
        driver.get("https://testerhome.com/");
    }

    @Test
    public void login(){
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("12344","1234r5");

        for (String handle:driver.getWindowHandles()){
            if(handle != driver.getWindowHandle()){
                driver.switchTo().window(handle);
            }
        }

        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().getText();

        driver.switchTo().frame(driver.findElement(By.cssSelector(".other_login_list_iframe")));

        driver.switchTo().defaultContent();

        for(Cookie cookie:driver.manage().getCookies()){
            System.out.println(cookie.getName());
            driver.manage().deleteAllCookies();
        }

        Cookie cookie = new Cookie("","","",null);
        driver.manage().addCookie(cookie);
    }

    @Test
    public void actionTest(){
        Actions action = new Actions(driver);
        action.keyDown(Keys.ENTER);
        action.doubleClick().perform();
    }

    @AfterMethod
    public void after(){
        driver.quit();
    }
}
