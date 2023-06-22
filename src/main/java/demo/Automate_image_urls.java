package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.*;


public class Automate_image_urls {
    ChromeDriver driver;
    public Automate_image_urls()
    {
        System.out.println("Constructor:  Automate_image_urls");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        

    }

    public void endTest()
    {
        System.out.println("End Test: Automate_image_urls");
        driver.close();
        driver.quit();

    }

    
    public void imageUrls() throws InterruptedException{
        System.out.println("Start Test case: Automate_image_urls");
        driver.get("https://in.bookmyshow.com/explore/home/pune");
        Thread.sleep(15000);
        //Find the image URLs for all the “Recommended Movies” 
        List<WebElement> urls = driver.findElements(By.xpath("//*[@class='sc-133848s-4 gskzha']/descendant::img"));
        for (WebElement image : urls) {
            //Use getAtrribute for printing URLs
            String imageUrl = image.getAttribute("src");
            System.out.println("Image URL: " + imageUrl);
        }
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        //This will scroll the page till the element is found
        WebElement Element = driver.findElement(By.xpath("//h2[text()='Premieres']"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        System.out.println("good job");

    
    }
}
