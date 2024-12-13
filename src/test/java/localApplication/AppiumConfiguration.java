package localApplication;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.text.html.Option;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.PublicKey;

public class AppiumConfiguration {

    public AppiumDriverLocalService service;
    public AndroidDriver driver;

//    String Ip = "192.168.100.28";
    String Ip = "192.168.0.104";

    @BeforeClass
    public void StartAppium() throws URISyntaxException, MalformedURLException {

    service= new AppiumServiceBuilder().withAppiumJS(new File("C:\\\\Users\\\\mspam\\\\AppData\\\\Roaming\\\\npm\\\\node_modules\\\\appium\\\\build\\\\lib\\\\main.js")).
                withIPAddress(Ip).usingPort(4723).build();
    service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("MobileName");
//        options.setApp("D:\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
        options.setApp("D:\\Appium\\src\\test\\java\\resources\\General-Store.apk");
        driver = new AndroidDriver(new URI("http://"+ Ip+":4723").toURL(), options);
        }

    public void LongClickGesture(WebElement ele){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
                        "duration",2000));
    }

    public void swipe(WebElement ele,String direct){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)ele).getId(),
                "direction",direct,
                "percent",0.10
        ));
    }

    public void TearDown(){
        service.stop();
        driver.quit();
    }
}