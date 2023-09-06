package util;

import java.io.FileInputStream;     // Dosya okuma işlemleri için gerekli kütüphane.
import java.io.FileNotFoundException;  // Dosyanın bulunamaması durumunda fırlatılacak istisnayı temsil eden kütüphane.
import java.io.IOException;          // Dosya okuma işlemlerinde oluşan hataları temsil eden kütüphane.
import java.io.InputStream;          // Dosya içeriğini okumak için kullanılacak giriş akışı kütüphanesi.
import java.nio.file.Files;          // Dosya ve dizin işlemleri için kullanılan kütüphane.
import java.nio.file.Paths;          // Dosya ve dizin yollarını temsil eden kütüphane.
import java.util.Properties;         // Ayarları saklamak ve yönetmek için kullanılan kütüphane.

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import static java.lang.System.getProperties;

public class ConfigReader {
    private static Properties properties;  // Ayarları saklamak için özellikler değişkeni.

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

