package util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    static AppiumDriver driver;
    static Properties properties;
    static DesiredCapabilities capabilities;

    // Sürücüyü başlatan metot
    public static AppiumDriver initialize_Driver(String appium) {
        properties = ConfigReader.getProperties();

        capabilities = new DesiredCapabilities();
        if (appium.equals("Android")) {
            // Android platformu için özellikleri ayarla
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("udid", "emulator-5554");
            capabilities.setCapability("appPackage", "com.ego.android");
            capabilities.setCapability("appActivity", "com.ego.android.MainActivity");
        } else if (appium.equals("iOS")) {
            // iOS platformu için özellikleri ayarla
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("udid", "");
            capabilities.setCapability("appPackage", "");
            capabilities.setCapability("appActivity", "");
        }
        try {
            driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            // URL oluşturma hatası durumunda istisna fırlat
            throw new RuntimeException(e);
        }

        int impWait = Integer.parseInt(properties.getProperty("implicityWait"));

        // Bekleme süresini ayarla
        driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);

        return getDriver();
    }

    // Mevcut sürücüyü döndüren metot
    public static AppiumDriver getDriver() {
        return driver;
    }
}
