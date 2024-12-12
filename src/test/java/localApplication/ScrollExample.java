package localApplication;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollExample extends AppiumConfiguration{

    @Test
    public void scroll(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));



    }
}
