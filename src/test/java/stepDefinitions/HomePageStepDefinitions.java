package stepDefinitions;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import jdk.jfr.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import util.DriverFactory;

public class HomePageStepDefinitions {
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    //String screenshotdir = System.getProperty("user.dir") + "/ExtentReport/Screenshots/";
    @Given("Click the Announcements button")
    public void clickTheAnnouncementsButton() {
        homePage.clickAnnouncementsBtn();
    }

    @Given("Click the Durak Ara button")
    public void clickTheDurakAraButton() {
        homePage.clickSearchBusStopBtn();
    }
}
