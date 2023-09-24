package Listener;

import com.aventstack.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.BaseMethod;
import util.Hooks;

import javax.mail.MessagingException;

public class Listener extends Hooks implements ITestListener {

    ExtentReports extentReports = new ExtentReports(); // ExtentReports nesnesini oluşturun

    @Override
    public void onFinish(ITestContext arg0) {
        // TestNG test süreci tamamlandığında çağrılır
        // Test sonuçlarını değerlendirmek veya temizlik işlemleri yapmak için kullanılabilir
        extentReports.flush();
        try {
            sendEmail();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onStart(ITestContext arg0) {
        // TestNG test süreci başladığında çağrılır
        // Başlangıçta gerekli başlatma işlemleri veya kaynakları ayırmak için kullanılabilir
        System.out.println("Test süreci başladı.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult sonuc) {
        // Bu metod, başarılı bir yüzde sınırlaması içinde başarısız olan bir test çağrıldığında çalışır
        // Genellikle istisnai durumlarla ilgilidir
        System.out.println("Test yüzde sınırlamasında başarısız oldu.");
    }

    @Override
    public void onTestFailure(ITestResult sonuc) {
        // Bir test başarısız olduğunda çağrılır
        // Testin adını veya başarısızlık nedenini yazdırabilir veya başka işlemler gerçekleştirebilirsiniz
        String testName = sonuc.getName();
        System.out.println("Başarısız olan testin adı: " + testName);
    }

    @Override
    public void onTestSkipped(ITestResult sonuc) {
        // Bir test atlandığında çağrılır
        // Test atlandığında yapılacak özel işlemleri burada gerçekleştirebilirsiniz
        String testName = sonuc.getName();
        System.out.println("Test atlandı: " + testName);
    }

    @Override
    public void onTestStart(ITestResult sonuc) {
        // Bir test başladığında çağrılır
        // Test başlamadan önce yapılacak işlemleri burada gerçekleştirebilirsiniz
        String testName = sonuc.getName();
        System.out.println("Test başladı: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult sonuc) {
        // Bir test başarıyla tamamlandığında çağrılır
        // Başarılı bir test sonrası yapılacak işlemleri burada gerçekleştirebilirsiniz
        String testName = sonuc.getName();
        System.out.println("Başarılı olan test: " + testName);
    }
}
