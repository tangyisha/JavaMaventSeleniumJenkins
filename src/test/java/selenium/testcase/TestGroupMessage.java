package selenium.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.Page.App;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

public class TestGroupMessage {
    public static App app;

    @BeforeMethod
    public static void beforeAll(){
        app = new App();
        app.loginWithCookie();

    }

    @AfterMethod
    public void after(){
        try {
            app.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSendMessage(){
        //app.toManageTools().toBroadcast();
//        List<String >msg = app.toManageTools().toBroadcast().sendMessage("汤依莎","快递通知",
//                "你的快递已到，请接收","快递通知","汤依莎").getSendMessage().subList(0,3);
        System.out.println(app.toManageTools().toBroadcast().gotoHavedSend().getSendMessage());
        //assertThat(msg,hasItem("快递通知"));


    }




}
