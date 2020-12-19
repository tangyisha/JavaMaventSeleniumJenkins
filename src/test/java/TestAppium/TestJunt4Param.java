package TestAppium;



import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

// 测试参数化
public class TestJunt4Param {
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {1,2},
                {2,2},
                {3,4},
                {5,6}
        });
    }

    @Parameterized.Parameter(0)
    public int actual;
    @Parameterized.Parameter(1)
    public int expection;

    @Test
    public void testDemo(){
        int actual = 10;
        int expection = 9;
        assertThat("demo",actual, equalTo(expection));
    }
}
