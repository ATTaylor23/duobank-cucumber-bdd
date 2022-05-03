package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.DashboardPage;
import utilities.Driver;
import utilities.PropertyReader;

import java.util.List;
import java.util.Map;

public class DashboardStepDefs {

    @Given("I am on the homepage, first")
    public void iAmOnTheHomepageFirst() {
        Driver.getDriver().get(PropertyReader.getTheProperties("url"));

    }
    @Given("I'm on the dashboard, now")
    public void iMOnTheDashboardNow() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.signUpSignIn();

    }
    @Then("I may verify the url {string}")
    public void iMayVerifyTheUrl(String string) {
        string = "http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php";

        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), string);

    }



}
