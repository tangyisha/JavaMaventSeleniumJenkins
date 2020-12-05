package selenium.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class App extends BasePage{

    public App loginWithCookie(){
        String url = "https://work.weixin.qq.com/";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        //窗口最大化
        driver.manage().window().maximize();
        findElement(By.linkText("企业登录")).click();
        //获取浏览器的cookies
        //System.out.println(driver.manage().getCookies());
        //添加cookie
        driver.manage().addCookie(new Cookie("wwrtx.refid","40709640823144156"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "xMKtvrK3Z9GsN9SUlgoQRjoFj_bq9OhRj-pBj9pM9agfVfX5C2g7ut1ePwztjmMA"));
        //刷新浏览器
        driver.navigate().refresh();
        return this;
    }


    public ContactPage toContact(){
        findElement(By.linkText("通讯录")).click();
        return new ContactPage();
    }

    public ContactPage toMebmerAdd(){
        findElement(By.linkText("添加成员")).click();
        return new ContactPage();

    }
}
