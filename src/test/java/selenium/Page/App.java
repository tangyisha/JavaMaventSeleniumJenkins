package selenium.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class App {
    public static WebDriver driver;


    public ContactPage toContact(){
        return new ContactPage();
    }

    public ContactPage toMebmerAdd(){
        driver.findElement(By.xpath("//span[text()='添加成员']")).click();
        return new ContactPage();

    }
}
