package selenium.testcase;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium.Page.App;
import selenium.Page.ContactPage;

import java.util.concurrent.TimeUnit;

public class TestWeWork{
    public static App app;
    public static ContactPage contactPage;

    @BeforeClass
    public static void beforeAll(){
        app = new App();
        app.loginWithCookie();
        String mobile = "15600534762";
        app.toContact().delete(mobile);
    }

    @AfterClass
    public void after(){
        try {
            app.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAdd(){
        String mobile = "15600534762";
        app.toMebmerAdd().add(mobile, mobile, mobile);

    }

    @Test
    public void testDelete(){
        String mobile = "15600534763";
        app.toMebmerAdd().add(mobile, mobile, mobile).delete(mobile);
    }

}
