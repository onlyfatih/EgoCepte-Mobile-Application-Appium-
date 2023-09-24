package util;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.testng.Reporter;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class Hooks extends BaseMethod {
    AppiumDriver driver;
    Properties properties;

    @Before
    public void before() {
        String appium = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("appium");
        properties = ConfigReader.initialize_Properties();
        driver = initialize_Driver(appium);
    }

    @After
    public void after() {
        // Sürücüyü kapat
        if (driver != null) {
            driver.quit();
        }
    }

    @After
    public void ErrorScreenShot (Scenario scenario) {
        // Senaryo başarısızsa ekran görüntüsü al
        if (scenario.isFailed()) {
            final byte[] screenshot = (driver.getScreenshotAs(OutputType.BYTES));
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

    public void sendEmail() throws MessagingException {
        // E-posta Bilgileri Tanımlanıyor
        String gonderen = "fth.ars58@gmail.com";
        String alan = "farslan0699@gmail.com";
        String konu = "Ego Cepte Test Senaryoları Koşum Raporu";
        String metin = "Test Sonucu ekte gönderilmiştir. Lütfen gönderilen dosyayı indirin ve herhangi bir tarayıcıda açın.";

        // Eklenecek dosyanın yolu tanımlanıyor
        String ekDosyaAdi = "/Users/fatih/Desktop/AppiumProjects-main/egoCepteProject/Reports/PdfReport/ExtentPdf.pdf";

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
        msg.setFrom(new InternetAddress(gonderen));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(alan));
        msg.setSubject(konu);

        // E-posta içeriği oluşturuluyor
        MimeBodyPart metinKismi = new MimeBodyPart();
        metinKismi.setText(metin);

        // Dosya ekleniyor
        MimeBodyPart ekKismi = new MimeBodyPart();
        FileDataSource dosyaDataSource = new FileDataSource(ekDosyaAdi);
        ekKismi.setDataHandler(new DataHandler(dosyaDataSource));
        ekKismi.setFileName(dosyaDataSource.getName());

        // E-posta gövdesine içerik ve dosya ekleniyor
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(metinKismi);
        multipart.addBodyPart(ekKismi);
        msg.setContent(multipart);

        // E-posta gönderme işlemi
        Transport.send(msg);
    }
}
