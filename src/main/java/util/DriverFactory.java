package util;

import io.appium.java_client.AppiumDriver;       // Appium ile sürücü işlevselliğini kullanabilmek için gerekli kütüphane.
import org.openqa.selenium.remote.DesiredCapabilities;   // Appium sürücü yapılandırmaları için kullanılır.
import java.net.MalformedURLException;         // URL'lerin geçersiz biçimde oluşturulması durumunda hata yakalamak için kullanılır.
import java.net.URL;                          // URL'leri oluşturmak ve kullanmak için gereklidir.
import java.util.Properties;                  // Ayarları saklamak ve yönetmek için kullanılır.
import java.util.concurrent.TimeUnit;          // Zaman birimlerini kullanarak beklemeleri ayarlamak için gereklidir.

public class DriverFactory {

    static AppiumDriver driver;                // AppiumDriver tipinde sürücü değişkeni.
    static Properties properties;              // Ayarları saklamak için özellikler değişkeni.
    static DesiredCapabilities capabilities;   // Appium sürücü yapılandırmalarını tutan nesne.

    public static AppiumDriver initialize_Driver(String appium) {
        properties = ConfigReader.getProperties();   // Ayarları ayar dosyasından almak için ConfigReader kullanılır.

        capabilities = new DesiredCapabilities();      // Yeni bir DesiredCapabilities nesnesi oluşturulur.
        if (appium.equals("Android")) {
            capabilities.setCapability("platformName", "Android");  // Android platformu için özellikler ayarlanır.
            capabilities.setCapability("udid", "emulator-5554");    // Android cihaz kimliği.
            capabilities.setCapability("appPackage", "com.ego.android");   // Test edilen uygulamanın paket adı.
            capabilities.setCapability("appActivity", "com.ego.android.MainActivity");  // Başlatılacak aktivite.
        } else if (appium.equals("iOS")) {
            capabilities.setCapability("platformName", "iOS");      // iOS platformu için özellikler ayarlanır.
            capabilities.setCapability("udid", "");                  // iOS cihaz kimliği.
            capabilities.setCapability("appPackage", "");            // Test edilen uygulamanın paket adı.
            capabilities.setCapability("appActivity", "");           // Başlatılacak aktivite.
        }
        try {
            driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);  // Appium sürücüsü başlatılır.
        } catch (MalformedURLException e) {   // URL oluşturma hatası yakalanır.
            throw new RuntimeException(e);    // Hata durumunda bir istisna (exception) fırlatılır.
        }

        int impWait = Integer.parseInt(properties.getProperty("implicityWait"));  // Bekleme süresi ayarlanır.
        driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);  // Zaman birimi belirtilerek beklemeler ayarlanır.
        return getDriver();  // Oluşturulan Appium sürücüsü döndürülür.
    }

    public static AppiumDriver getDriver() {
        return driver;  // Mevcut sürücü döndürülür.
    }
}
