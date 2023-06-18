package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class Automate_search_amazon {
    ChromeDriver driver;
    public Automate_search_amazon()
    {
        System.out.println("Constructor: Automate_search_amazon");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: Automate_search_amazon");
        driver.close();
        driver.quit();

    }

    
    public boolean AmazonSearch() throws InterruptedException{
        System.out.println("Start Test case: AmazonSearch");
        driver.get("https://www.google.com");
        //Locate search box  
        // SendKeys Amazon
        driver.findElement(By.id("APjFqb")).sendKeys("Amazon");
        //Locate Google Search Button
        driver.findElement(By.xpath("//div[@class='lJ9FBc']//input[@name='btnK']")).click();
        Thread.sleep(3000);
        //Verify "amazon.in" or "amazon.com" is displayed on next page
        boolean status = driver.findElement(By.xpath("//*[text()='https://www.amazon.in' or 'Amazon.com. Spend less. Smile more.']")).isDisplayed();
        System.out.println("Is amazon.com or amazon.in visible on next page:" +status);
        System.out.println("end Test case: AmazonSearch");
        return status;
    }

}
