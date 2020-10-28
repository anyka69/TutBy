package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.OnlineCinemaPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
   OnlineCinemaPage onlineCinemaPage;



    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        onlineCinemaPage = new OnlineCinemaPage(driver);

    }
    @AfterMethod(alwaysRun = true)
    public void closeDriver(){
        if(driver!=null){
            driver.quit();
        }

    }
}
