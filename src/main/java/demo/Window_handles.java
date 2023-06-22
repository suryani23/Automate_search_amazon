package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Window_handles {
    ChromeDriver driver;
    public Window_handles()
    {
        System.out.println("Constructor: Window_handles");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: Window_handles");
        driver.close();
        driver.quit();

    }

    public void windowHandles() throws InterruptedException, IOException{
        System.out.println("Start Test case: Window_handles");

        //Go to URL
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("iframeResult")));
        driver.switchTo().frame("iframeResult");

        //Locate Try it button and click() Using Locator "XPath" //button[text()="Try it"]
        System.out.println("About to click on TRY IT");
        driver.findElement(By.xpath("//button[normalize-space()='Try it']")).click();
        System.out.println("Just clicked on TRY it switching to new tab now");



        //Switch to child window   
        Set<String> handles = driver.getWindowHandles();

            Iterator<String> it = handles.iterator();

            String parentwin = (String) it.next();
            String childwin = (String) it.next();

            driver.switchTo().window(childwin);

        //Get current URL  
            String url = driver.getCurrentUrl();
            System.out.println("URL of new tab is: " +url);

        //Get Title of current page  
            String pageTitle = driver.getTitle();
            System.out.println("Title of new tab is: "+pageTitle);

        //Capture screenshot and store the image
            File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(s, new File("windowhandle.png"));
            System.out.println("Screenshot taken & saved");

            
        //Close driver  
            driver.close();

        //Switch to parent window  
            driver.switchTo().window(parentwin);
        }

    }
