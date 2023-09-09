package util;

import com.aventstack.extentreports.ExtentReports;
import com.beust.ah.A;
import io.appium.java_client.AppiumDriver;       // Appium ile sürücü işlevselliğini kullanabilmek için gerekli kütüphane.
import io.cucumber.java.After;                   // Cucumber senaryo sonrası işlemleri yapabilmek için kullanılan kütüphane.
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;                  // Cucumber senaryo öncesi işlemleri yapabilmek için kullanılan kütüphane.
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;                      // TestNG test raporlama işlemleri için kullanılan kütüphane.
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;                    // Ayarları saklamak ve yönetmek için kullanılan kütüphane.

import static javax.mail.Transport.send;
import static util.DriverFactory.initialize_Driver;  // Sürücüyü başlatan metodu çağırmak için kullanılan import.

public class Hooks extends  BaseMethod {
    AppiumDriver driver;                // AppiumDriver tipinde sürücü değişkeni.
    Properties properties;              // Ayarları saklamak için özellikler değişkeni.
    private static int scenarioCount = 0; // Senaryo sayısını takip etmek için bir sayaç

    @Before
    public void before() {
        String appium = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("appium");  // TestNG'den tarayıcı parametresini alır.
        properties = ConfigReader.initialize_Properties();  // Ayarları ayar dosyasından almak için ConfigReader kullanılır.
        driver = initialize_Driver(appium);  // Appium sürücüsü başlatılır ve sürücü değişkenine atanır.
    }

    @After
    public void after(Scenario scenario) throws MessagingException, InterruptedException {
        // Sürücüyü kapat
        if (driver != null) {
            driver.quit();
        }

        // Senaryo sayısını bir artır
        scenarioCount++;

        // Toplam senaryo sayısını al (örneğin 2 senaryo varsa)
        int totalScenarios = 2; // Senaryo sayısını kendinize göre güncelleyin

        // Tüm senaryolar tamamlandığında e-posta gönderme işlemini yap

    }
    @After
    public void ErrorScreenShot(Scenario scenario) {

        //validate if scenario has failed
        if(scenario.isFailed()) {
            final byte[] screenshot = (driver.getScreenshotAs(OutputType.BYTES));
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

    public void sendEmail() throws MessagingException {
            // E-Mail Bilgileri Tanımlanıyor
            String from = "fth.ars58@gmail.com";
            String to = "farslan0699@gmail.com";
            String subject = "Ego Cepte Test Senaryoları Kosum Raporu";
            String bodyText = "Test Sonucu ekte gönderilmiştir. Lütfen gönderilen dosyayı indirin ve herhangi bir tarayıcıda açın.";

            // Attach edilecek dosyanın dizini tanımlanıyor
            String attachmentName = "/Users/fatih/Desktop/AppiumProjects-main/egoCepteProject/Reports/PdfReport/ExtentPdf.pdf";

            // SMTP Bilgileri Tanımlanıyor
            Properties props = new Properties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true"); // TLS kullanmak için bu satır eklenmelidir
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");

            // E-posta oturumu başlatılıyor
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("fth.ars58@gmail.com", "zahityersoskzrfe");
                }
            });

            // E-posta gönderme işlemi
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject(subject);

            // E-posta içeriği oluşturuluyor
            MimeBodyPart messagePart = new MimeBodyPart();
            messagePart.setText(bodyText);

            // Dosya ekleniyor
            MimeBodyPart attachmentPart = new MimeBodyPart();
            FileDataSource fileDataSource = new FileDataSource(attachmentName);
            attachmentPart.setDataHandler(new DataHandler(fileDataSource));
            attachmentPart.setFileName(fileDataSource.getName());


            // E-posta gövdesine içerik ve dosya ekleniyor
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messagePart);
            multipart.addBodyPart(attachmentPart);
            msg.setContent(multipart);

            // E-posta gönderme işlemi
            Transport.send(msg);

        }

    }


