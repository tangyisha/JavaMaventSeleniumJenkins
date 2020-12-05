package selenium.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static WebDriver driver;

    public WebElement findElement(By by){
        return driver.findElement(by);

    }

    public void waitClickable(By by, int timeout){
        //显式等待
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void waitClickable(By by){
        //显式等待
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
