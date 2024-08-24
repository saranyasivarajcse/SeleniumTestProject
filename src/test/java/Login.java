import org.testng.annotations.*;
public class Login {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }
    @Test(groups = {"smoke"})
    public void testMethod1(){
        System.out.println("Test1");
    }
    @Test(groups = {"regression"})
    public void testMethod2(){
        System.out.println("test2");
    }
    @Test(groups = {"smoke", "regression"})
    public void testMethod3(){
        System.out.println("Test3");
    }
    @Test
    public void testMethod4(){
        System.out.println("Test4");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
}
