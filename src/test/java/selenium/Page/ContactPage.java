package selenium.Page;

import org.openqa.selenium.By;

public class ContactPage {
    public ContactPage add(String username, String id, String mobile){
        App.driver.findElement(By.name("username")).sendKeys(username);
        App.driver.findElement(By.name("acctid")).sendKeys(id);
        App.driver.findElement(By.name("mobile")).sendKeys(mobile);
        return this;

    }

    public void list(){

    }
}
