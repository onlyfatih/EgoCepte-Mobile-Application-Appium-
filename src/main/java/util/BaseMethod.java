package util;

import io.appium.java_client.MobileBy;                  // Appium ile mobil uygulama öğelerine erişmek için kullanılan kütüphane.
import io.appium.java_client.MobileElement;             // Appium ile mobil öğeleri temsil eden kütüphane.
import org.openqa.selenium.By;                          // Web öğelerine erişmek için kullanılan kütüphane.
import org.openqa.selenium.WebElement;                  // Web öğelerini temsil eden kütüphane.
import org.openqa.selenium.support.ui.ExpectedConditions;  // Belirli koşullar gerçekleşene kadar beklemek için kullanılan kütüphane.
import org.openqa.selenium.support.ui.WebDriverWait;     // Belirli bir koşul gerçekleşene kadar beklemek için kullanılan kütüphane.
import org.apache.log4j.LogManager;                     // Loglama için kullanılan kütüphane.
import org.apache.log4j.Logger;                         // Loglama için kullanılan kütüphane.
import java.util.concurrent.TimeUnit;                    // Zaman birimlerini kullanarak beklemeleri ayarlamak için gereklidir.

public class BaseMethod extends DriverFactory {
    WebDriverWait wait;                 // Bekleme nesnesi.

    final Logger LOG = LogManager.getLogger(BaseMethod.class);  // Loglama için logger.

    public BaseMethod() {
    }

    public WebElement presenceElement(By key){
        return
                wait.until(ExpectedConditions.presenceOfElementLocated(key));  // Belirli bir öğenin sayfada var olma durumunu bekler.
    }

    public WebElement findElement(By key){
        WebElement element = presenceElement(key);   // Öğeyi bulur.
        return element;
    }

    public void click(By key){
        getDriver().findElement(key).click();  // Öğeye tıklar.
    }

    public void sendKeys(By key , String text){
        getDriver().findElement(key).sendKeys(text);   // Öğeye metin gönderir.
    }

    public By scrollToElementAndClick(String targetText) {
        try {
            String uiAutomator = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + targetText + "\").instance(0))";
            getDriver().findElement(MobileBy.AndroidUIAutomator(uiAutomator)).click();  // Belirli bir metni taşıyarak öğeye kaydırır ve tıklar.
        } catch (Exception e) {
            // Hata durumlarını ele alın
            e.printStackTrace();
        }
        return null;
    }

    public WebElement checkVisible(By key){
        WebElement element= wait.until(ExpectedConditions.presenceOfElementLocated(key));  // Öğenin görünür olma durumunu bekler.
        return element;
    }

    public void wait(int time) throws InterruptedException {
        TimeUnit.SECONDS.sleep(time);  // Belirli bir süre bekler.
    }
}
