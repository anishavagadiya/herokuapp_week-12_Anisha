package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    //Browser setup
    public static WebDriver driver;

    //opening the Browser

    public void openBrowser(String baseUrl) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();//maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//implicity time

    }

    //Closing the Browser
    public void closeBrowser() {
        //   driver.quit();
    }
}
