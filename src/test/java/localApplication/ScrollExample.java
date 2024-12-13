package localApplication;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScrollExample extends AppiumConfiguration{

    @Test
    public void scroll() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));

        driver.findElement(AppiumBy.accessibilityId("WebView")).click();

        Boolean SeleniumSandbox = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Views/WebView\"]")).isDisplayed();
        Assert.assertTrue(SeleniumSandbox);

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));




    }
}
