package elizCurtnazar.teorie;

import org.testng.annotations.*;


public class TestNgAnnotations {

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After suite");
    }

    @BeforeGroups(groups = "test2")//groups ruleaza dupa anumite grupuri care sunt definite in cadrul metodelor
    public void beforeGroups() {
        System.out.println("Before groups");
    }

    @AfterGroups(groups = "test2")
    public void afterGroups() {
        System.out.println("After groups");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method");
        //inainte de test,deci/before method, test, after method, before method, test 2, after method
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method");
    }

    @Test
    public void test() {
        System.out.println("Test method");
    }

    @Test(groups = "test2")
    public void test2() {
        System.out.println("Test method 2");
    }
}
