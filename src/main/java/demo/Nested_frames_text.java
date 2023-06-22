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


public class Nested_frames_text {
    ChromeDriver driver;
    public Nested_frames_text()
    {
        System.out.println("Constructor: nested_frames_text");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: nested_frames_text");
        driver.close();
        driver.quit();

    }

    public void nestedFrames() throws InterruptedException{
        System.out.println("Start Test case: nested_frames_text");
        // Go to https://the-internet.herokuapp.com/nested_frames  
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        Thread.sleep(3000);
        
        // Switch to Top Frame Using Locator "Name" frame-top
        driver.switchTo().frame("frame-top");

        // Switch to Left Frame Using Locator "Name" frame-left.getText();
        driver.switchTo().frame("frame-left");
        WebElement frameTextLeft = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println(frameTextLeft.getText());

        // Switch back to Top Frame Using Locator "Name" frame-top
        driver.switchTo().parentFrame();
        
        // Switch to Middle Frame Using Locator "Name" frame-middle.getText();
        driver.switchTo().frame("frame-middle");
        WebElement frameTextMiddle = driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"));
        System.out.println(frameTextMiddle.getText());

        // Switch back to Top Frame Using Locator "Name" frame-top
        driver.switchTo().parentFrame();
        
        // Switch to Right Frame Using Locator "Name" frame-right.getText();
        driver.switchTo().frame("frame-right");
        WebElement frameTextRight = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(frameTextRight.getText());

        // Switch back to Top Frame Using Locator "Name" frame-top
        driver.switchTo().defaultContent();

        // Switch back to Bottom Frame Using Locator "Name" frame-bottom.getText()
        driver.switchTo().frame("frame-bottom");
        WebElement frameTextBottom = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(frameTextBottom.getText());

}


}
