package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.annotations.Listeners;
import pages.AnnouncementsPage;
import testRunners.Listener;
import util.DriverFactory;

public class AnnouncementsPageStepDefinitions {

    AnnouncementsPage announcementsPage = new AnnouncementsPage(DriverFactory.getDriver());
    @Then("Verify Announcements post")
    public void verifyAnnouncementsPost() {
        announcementsPage.displayedAnnouncements();
    }
}
