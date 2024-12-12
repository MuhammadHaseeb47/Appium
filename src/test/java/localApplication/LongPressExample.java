package localApplication;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPressExample extends AppiumConfiguration{
    @Test
    public void LongPressGesture() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));

        LongClickGesture(element);
        WebElement SampleMenuText = driver.findElement(By.id("android:id/title"));
        Assert.assertTrue(SampleMenuText.isDisplayed());


    }
}
