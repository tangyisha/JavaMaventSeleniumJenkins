package test;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @DataProvider
    public Object[][] getData(){
        Object[][] o = {
                {"carol","12345"},
                {"jack","54321"}
        };
       return o;
    }

    @Test(dataProvider = "getData")
    public void testProcess1(String username, String password){
        System.out.println(username);
        System.out.println(password);
    }
}



