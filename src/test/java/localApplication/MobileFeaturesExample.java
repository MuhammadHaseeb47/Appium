package localApplication;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileFeaturesExample extends AppiumConfiguration{
    @Test
    public void MobileFeatures(){
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        WebElement checkBox = driver.findElement(By.id("android:id/checkbox"));
        checkBox.click();
        String checked = checkBox.getDomAttribute("checked");
        Assert.assertEquals(checked, "true");

        DeviceRotation landscape = new DeviceRotation(0, 0, 90);
        driver.rotate(landscape);

        driver.findElement(By.xpath("//android.widget.TextView[@text=\"WiFi settings\"]")).click();
        WebElement WifiSettingBox = driver.findElement(By.id("android:id/parentPanel"));
        WifiSettingBox.isDisplayed();

        driver.findElement(By.id("android:id/edit")).sendKeys("Haseeb");
        driver.findElement(By.id("android:id/button1")).click();

        try{
            driver.findElement(By.id("android:id/parentPanel"));
            assert false;
        }
        catch (NoSuchElementException e){
            System.out.println("Wifi Settings added");
        }

    }
}
