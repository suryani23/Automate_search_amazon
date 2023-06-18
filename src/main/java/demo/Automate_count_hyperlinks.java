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


public class Automate_count_hyperlinks {
    ChromeDriver driver;
    public Automate_count_hyperlinks()
    {
        System.out.println("Constructor: Automate_count_hyperlinks");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: Automate_count_hyperlinks");
        driver.close();
        driver.quit();

    }

    public void hyperlinksCount() throws InterruptedException{
        System.out.println("Start Test case: Hyperlinks Count");
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        Thread.sleep(5000);
        //FindElements anchor tags //Get count of hrefs on page using size()
        int numberOfLinks = driver.findElements(By.tagName("a")).size();
        // print number of links on page
        System.out.println("Number of links on Web Page :" +numberOfLinks );
    }

}
