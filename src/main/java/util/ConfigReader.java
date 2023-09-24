package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ConfigReader {
    private static Properties properties;  // Ayarları saklamak için özellikler değişkeni.

    // Properties dosyasını yükler ve ayarları döndürür.
    public static Properties initialize_Properties() throws RuntimeException {
        properties = new Properties();  // Yeni bir Properties nesnesi oluşturulur.
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");  // Ayar dosyasının yolunu belirtir.
            properties.load(fileInputStream);  // Ayarları yükler.

        } catch (FileNotFoundException e) {  // Dosya bulunamazsa...
            throw new RuntimeException(e);    // Hata durumunda bir istisna (exception) fırlatılır.
        } catch (IOException e) {  // Giriş/çıkış hatası oluşursa...
            throw new RuntimeException(e);  // Hata durumunda bir istisna (exception) fırlatılır.
        }
        return getProperties();  // Yüklenen ayarları döndürür.
    }

    public static Properties getProperties() {
        return properties;
    }
}
