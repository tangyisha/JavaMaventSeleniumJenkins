package test;

import org.testng.Assert;
import org.testng.annotations.*;

public class testNG {
    @BeforeClass
    public void beforeClass() {
        System.out.println("class开始流程");
    }

    @BeforeMethod
    public void before() {
        System.out.println("开始流程");
    }

    @Test
    public void testPorcess1(){
        //testPorcess1断言失败，还继续执行testPorcess2
        Assert.assertEquals(1,2);
        System.out.println("开始流程1");
    }

    //依赖testPorcess1，如果testPorcess1失败，testPorcess2不会执行
    @Test(dependsOnMethods = "testPorcess1")
    public void testPorcess2(){
        Assert.assertEquals(1,1);
        System.out.println("开始流程2");
    }

    @AfterMethod
    public void after() {
        System.out.println("结束流程");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("class结束流程");
    }
}
