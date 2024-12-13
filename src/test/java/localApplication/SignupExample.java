package localApplication;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignupExample extends AppiumConfiguration {
    @Test
    public void Signup(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Haseeb");
        driver.findElement(AppiumBy.xpath("//android.widget.Spinner[@resource-id=\"com.androidsample.generalstore:id/spinnerCountry\"]")).click();

       WebElement Pakistan = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Pakistan\"))"));
       Pakistan.click();
       driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
       driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title"));
    }
    @Test
    public void ErrorAtFormFill(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.findElement(AppiumBy.xpath("//android.widget.Spinner[@resource-id=\"com.androidsample.generalstore:id/spinnerCountry\"]")).click();

        WebElement Pakistan = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Pakistan\"))"));
        Pakistan.click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String Toast= driver.findElement(AppiumBy.xpath("//android.widget.Toast[1]")).getText();
        Assert.assertEquals(Toast,"Please enter your name");

    }
}
