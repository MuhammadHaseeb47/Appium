package localApplication;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertDialogsExample extends AppiumConfiguration{
    @Test
    public void AlertDialogs(){
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"App\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Alert Dialogs\"]")).click();
        String PageTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"App/Alert Dialogs\"]")).getText();
        Assert.assertEquals(PageTitle,"App/Alert Dialogs");

        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        Boolean AlertMessage = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]")).isDisplayed();
        Assert.assertTrue(AlertMessage);

        driver.findElement(AppiumBy.id("android:id/button2")).click();

        try {
            WebElement alert = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]"));
            assert false : "The alert is still present!";
        } catch (NoSuchElementException e) {
            System.out.println("The alert has been dismissed successfully.");
        }

    }
}
