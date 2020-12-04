package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;
    @FindBy(linkText ="登录" )
    WebElement LinkLogin;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickLogin()
    {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        LinkLogin.click();
        Reporter.log("点击登录链接",true);
    }
}
