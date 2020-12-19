package selenium.Page;

import org.openqa.selenium.By;

public class ManageToolPage extends BasePage {
    public BroadcastPage toBroadcast(){
        //点击消息群发到消息群发页面
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findElement(By.xpath("//*[@href='#createMessage']")).click();
        return new BroadcastPage();
    }
}
