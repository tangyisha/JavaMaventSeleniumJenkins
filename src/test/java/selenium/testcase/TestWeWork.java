package selenium.testcase;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import selenium.Page.App;
import selenium.Page.ContactPage;

import java.util.concurrent.TimeUnit;

public class TestWeWork{
    public static App app;

    @BeforeMethod
    public static void beforeAll(){
        app = new App();
        app.loginWithCookie();

    }

    @AfterMethod
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
        app.toContact().delete(mobile);
        app.toMebmerAdd().add(mobile, mobile, mobile);

    }

    @Test
    public void testDelete(){
        String mobile = "15600534763";
        app.toMebmerAdd().add(mobile, mobile, mobile).delete(mobile);
    }

    @Test
    public void testDeleteCurrent() throws InterruptedException {
        app.toContact().deleteCurrentPage();
    }

    @Test
    public void testImportFromFile() {
        String filePath = "/Users/tangyisha/Downloads/通讯录批量导入模板.xlsx";
        app.toContact().importFromFile(filePath);
    }


}
