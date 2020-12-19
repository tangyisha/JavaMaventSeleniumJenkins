package selenium.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class App extends BasePage{

    public App loginWithCookie(){
        String url = "https://work.weixin.qq.com/";
        /*
        其中PageLoadStrategy有三种选择：
        NONE: 当html下载完成之后，不等待解析完成，selenium会直接返回
        EAGER: 要等待整个dom树加载完成，即DOMContentLoaded这个事件完成，仅对html的内容进行下载解析
        NORMAL: 即正常情况下，selenium会等待整个界面加载完成（指对html和子资源的下载与解析,如JS文件，图片等，不包括ajax）
         */
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        //本地执行
        driver=new ChromeDriver(options);


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

    public ManageToolPage toManageTools(){
        //点击管理工具，到管理工具页面
        findElement(By.linkText("管理工具")).click();
        return new ManageToolPage();
    }
}
