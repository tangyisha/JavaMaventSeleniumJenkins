package selenium.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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
        waitClickable(By.xpath("//a[text()='删除' and @class='qui_btn ww_btn js_del_member']"),2).click();
        findElement(By.linkText("确认")).click();
        return this;

    }

    public ContactPage deleteCurrentPage() throws InterruptedException {
        //等待元素可点击
        waitClickable(By.cssSelector(".ww_checkbox"));
        Thread.sleep(3000);
        List<WebElement> elements = driver.findElements(By.cssSelector(".ww_checkbox"));
        for (int i=1;i < elements.size();i++){
            elements.get(i).click();
            Thread.sleep(3000);

        }
        findElement(By.linkText("删除")).click();
        findElement(By.linkText("确认")).click();
        return this;

    }

    public ContactPage importFromFile(String filePath){
        findElement(By.linkText("批量导入/导出")).click();
        findElement(By.linkText("文件导入")).click();
        //上传文件
        findElement(By.cssSelector(".ww_fileImporter_fileContainer_uploadInputMask")).sendKeys(filePath);
        findElement(By.linkText("导入")).click();
        findElement(By.linkText("完成")).click();
        return this;
    }

    public void list(){


    }
}
