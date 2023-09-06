package stepDefinitions;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.java.en.Then;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AnnouncementsPage;
import pages.HomePage;
import util.DriverFactory;
public class AnnouncementsPageStepDefinitions {

    AnnouncementsPage announcementsPage = new AnnouncementsPage(DriverFactory.getDriver());
    @Test
    @Then("Verify Announcements post")
    public void verifyAnnouncementsPost() {
        announcementsPage.displayedAnnouncements();
    }
}
