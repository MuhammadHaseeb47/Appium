package localApplication;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeExample extends AppiumConfiguration{
    @Test
    public void Swipe(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        WebElement PhotosButton = driver.findElement(AppiumBy.accessibilityId("1. Photos"));
        Assert.assertTrue(PhotosButton.isDisplayed());
        PhotosButton.click();

        WebElement firstImage = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[1]"));
        String Attribute = firstImage.getDomAttribute("focusable");
        Assert.assertEquals(Attribute,"true");

        swipe(firstImage, "left");

        String Attribute2 = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[2]")).getDomAttribute("focusable");
        Assert.assertEquals(Attribute2,"true");
    }
}
