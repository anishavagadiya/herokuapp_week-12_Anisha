package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void UserSholdLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.name("username"), "tomsmith"); //Enter valid username
        sendTextToElement(By.name("password"), "SuperSecretPassword!"); //Enter valid password
        //click on login button
        clickOnElement(By.xpath("//button/i[text() =' Login']"));
        // verify the "Secure Area" text is display
        //This is form requirement
        String expectedMessage = "Secure Area";
        String actualMessage = getTextFromElement(By.xpath("//div[@class = 'example']/h2[contains(text(), 'Secure Area')]")); //verify Secure Area is display
        // Validate actual and expected message
        Assert.assertEquals("Not navigate to Secure Area is display", expectedMessage, actualMessage);


    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        sendTextToElement(By.name("username"), "tomsmith1"); //Enter valid username
        sendTextToElement(By.name("password"), "SuperSecretPassword!"); //Enter valid password
        //click on login button
        clickOnElement(By.xpath("//button/i[text() =' Login']"));
        //This is form requirement
        String expectedMessage = "Your username is invalid!\n" + "×";
        String actualMessage = getTextFromElement(By.xpath("//div[@id='flash']"));  //verify username is invalid
        // Validate actual and expected message
        Assert.assertEquals("message display: your username is invalid!", expectedMessage, actualMessage);

    }

    @Test
    public void verifyThePasswordErrorMessage() {
        sendTextToElement(By.name("username"), "tomsmith"); //Enter valid username
        sendTextToElement(By.name("password"), "SuperSecretPassword"); //Enter Invalid password
        //click on login button
        clickOnElement(By.xpath("//button/i[text() =' Login']"));
        //This is form requirement
        String expectedMessage = "Your password is invalid!\n" + "×";
        String actualMessage = getTextFromElement(By.xpath("//div[@id='flash']"));  //verify username is invalid
        // Validate actual and expected message
        Assert.assertEquals("message display: your password is invalid!", expectedMessage, actualMessage);

    }

    @After
    public void testDown() {
        closeBrowser();
    }
}