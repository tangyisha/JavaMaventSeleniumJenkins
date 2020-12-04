package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    @FindBy(id="user_login")
    WebElement InputUsername;

    @FindBy(id="user_password")
    WebElement InputPassword;

    @FindBy(name="commit")
    WebElement commit;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void Login(String Username,String Password){
        InputUsername.clear();
        InputUsername.sendKeys(Username);
        InputPassword.clear();
        InputPassword.sendKeys(Password);
        commit.click();
    }

}
