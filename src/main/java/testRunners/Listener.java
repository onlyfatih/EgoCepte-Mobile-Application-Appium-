package testRunners;

import com.aventstack.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.BaseMethod;
import util.Hooks;

import javax.mail.MessagingException;

public class Listener extends Hooks implements ITestListener {

    ExtentReports extend = new ExtentReports(); // ExtendReports nesnesini oluşturun


    @Override
    public void onFinish(ITestContext arg0) {
        // TestNG test süreci tamamlandığında çağrılır
        // Test sonuçlarını değerlendirmek veya temizlik işlemleri yapmak için kullanılabilir
        extend.flush();
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
        System.out.println("Test süreci başladı");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // Bu metod, başarılı bir yüzde sınırlaması içinde başarısız olan bir test çağrıldığında çalışır
        // Genellikle istisnai durumlarla ilgilidir

    }

    @Override
    public void onTestFailure(ITestResult Result) {
        // Bir test başarısız olduğunda çağrılır
        // Testin adını veya başarısızlık nedenini yazdırabilir veya başka işlemler gerçekleştirebilirsiniz
        System.out.println("Başarısız olan testin adı: " + Result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // Bir test atlandığında çağrılır
        // Test atlandığında yapılacak özel işlemleri burada gerçekleştirebilirsiniz
        System.out.println("Test atlandı");
    }

    @Override
    public void onTestStart(ITestResult arg0) {
        // Bir test başladığında çağrılır
        // Test başlamadan önce yapılacak işlemleri burada gerçekleştirebilirsiniz

    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        // Bir test başarıyla tamamlandığında çağrılır
        // Başarılı bir test sonrası yapılacak işlemleri burada gerçekleştirebilirsiniz

    }
}
