package localApplication;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;

public class MobileFeaturesExample extends AppiumConfiguration{
    @Test
    public void MobileFeatures(){
        //make sure the amulator is running by --> adb devices
        // find activity in window by --> adb shell dumpsys window | findstr "mCurrentFocus"
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent",
                "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));

        //The below lines are commented because as we mentioned the upper piece of code will start from the activity

//        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
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
        driver.hideKeyboard();

        driver.findElement(By.id("android:id/button1")).click();

        try{
            driver.findElement(By.id("android:id/parentPanel"));
            assert false;
        }
        catch (NoSuchElementException e){
            System.out.println("Wifi Settings added");
        }

        driver.pressKey(new KeyEvent(AndroidKey.HOME));

    }
}
