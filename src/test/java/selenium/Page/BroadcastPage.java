package selenium.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class BroadcastPage extends BasePage {
    public BroadcastPage sendMessage(String range,String title, String body,String summary,String author){
        findElement(By.linkText("选择需要发消息的应用")).click();
        findElement(By.xpath("//*[@data-name='公告']")).click();
        findElement(By.linkText("确定")).click();
        findElement(By.linkText("选择发送范围")).click();
        //js执行时间超长，使用PageLoad策略改进
        findElement(By.cssSelector("#memberSearchInput")).sendKeys(range);
        findElement(By.cssSelector(".ww_searchResult_itemTxt")).click();
        findElement(By.linkText("确认")).click();
        findElement(By.cssSelector(".ww_editorTitle")).sendKeys(title);
        //切换iframe页面，由于ifarme的id会变化，使用index来切换
        driver.switchTo().frame("ueditor_0");
        //driver.switchTo().frame(0);
        findElement(By.cssSelector(".msg_noticeEditor_frameBody")).sendKeys(body);
        //切回主页面
        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        //可视化的坑，在页面下方，需要滚动到下方
        //滚动到指定元素位置
        WebElement element = driver.findElement(By.cssSelector(".msg_edit_infoItem_textWord"));
        String js = "arguments[0].scrollIntoView(true);";
        ((JavascriptExecutor)driver).executeScript(js, element);

//        String js = "window.scroll(0,1200)";
//        ((JavascriptExecutor)driver).executeScript(js);

        element.click();
        //依赖于上面的一次点击才能输入，内容
        findElement(By.cssSelector(".qui_textarea")).sendKeys(summary);
        findElement(By.cssSelector(".js_amrd_sendName")).sendKeys(author);
        //有两个发送，第二个发送按钮才是我们要的
        driver.findElements(By.linkText("发送")).get(1).click();
        findElement(By.linkText("确定")).click();
        return this;

    }

    public BroadcastPage gotoHavedSend(){
        findElement(By.linkText("已发送")).click();
        return this;
    }

    public List<String> getSendMessage(){
        findElement(By.linkText("已发送")).click();
        final List<String> msg = new ArrayList<>();
        driver.findElements(By.cssSelector(".msg_history_msgList_td")).forEach(element->{
            msg.add(element.getText());
        });
        return msg;
    }


}
