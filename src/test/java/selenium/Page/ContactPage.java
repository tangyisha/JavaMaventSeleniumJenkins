package selenium.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends BasePage{
    public ContactPage add(String username, String id, String mobile){
        findElement(By.name("username")).sendKeys(username);
        findElement(By.name("acctid")).sendKeys(id);
        findElement(By.name("mobile")).sendKeys(mobile);
        findElement(By.linkText("保存")).click();
        return this;

    }

    public ContactPage delete(String keyword){
        findElement(By.id("memberSearchInput")).clear();
        findElement(By.id("memberSearchInput")).sendKeys(keyword);
        try{
            waitClickable(By.linkText("编辑"));
        }catch (Exception e){
            System.out.println("not found");
            return this;
        }
        //调用显式等待方法
        waitClickable(By.xpath("//a[text()='删除' and @class='qui_btn ww_btn js_del_member']"),5);
        findElement(By.linkText("确认")).click();
        return this;

    }

    public void list(){


    }
}
