package stepDefinitions;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AnkarakartPage;
import pages.AnnouncementsPage;
import pages.HomePage;
import util.DriverFactory;
public class AnkarakartPageStepDefinitions {

    AnkarakartPage ankarakartPage = new AnkarakartPage(DriverFactory.getDriver());
    @Given("Click the add card button")
    public void clickTheAddCardButton() {
    }

    @Given("Add card number")
    public void addCardNumber() {
        
    }

    @Given("Add card title")
    public void addCardTitle() {
        
    }

    @Given("Choose card color")
    public void chooseCardColor() {

    }
}
