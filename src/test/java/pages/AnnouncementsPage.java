package pages;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.BaseMethod;
public class AnnouncementsPage extends BaseMethod {

    private static final Logger LOG = LogManager.getLogger(AnnouncementsPage.class);

    By announcementsTitle = MobileBy.xpath("//android.view.View[@content-desc=\"Duyurular\" and @index= 1]");

    public AnnouncementsPage(AppiumDriver driver) {
    }

    public void displayedAnnouncements () {
        try {
            getDriver().findElement(announcementsTitle).isDisplayed();
        }
        catch (Exception e) {
            LOG.info("Announcements Title is not displayed");
        }
    }
}
