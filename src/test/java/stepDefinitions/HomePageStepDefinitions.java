package stepDefinitions;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import jdk.jfr.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import util.DriverFactory;

public class HomePageStepDefinitions {
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    @Given("Click the Announcements button")
    public void clickTheAnnouncementsButton() {
        homePage.clickAnnouncementsBtn();
    }


    @Given("Click the Durak Ara button")
    public void clickTheDurakAraButton() {
        homePage.clickSearchBusStopBtn();
    }
}
