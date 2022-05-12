package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SignUpPage;
import utilities.DBUtility;
import utilities.Driver;
import utilities.PropertyReader;
import utilities.SeleniumUtils;

import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class SignUpStepDefs {

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        Driver.getDriver().get(PropertyReader.getTheProperties("url"));

    }
    @When("I click on the Sign Up link")
    public void iClickOnTheSignUpLink() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.SignUpBtn.click();

    }
    @Then("The url should be {string}")
    public void theUrlShouldBe(String string) {
        string = "http://qa-duobank.us-east-2.elasticbeanstalk.com/register.php";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), string);

    }
    @Then("I should see the expected List of Strings")
    public void iShouldSeeTheExpectedListOfStrings(List<String> dataTable) {
        SignUpPage signUpPage = new SignUpPage();

        Assert.assertEquals(dataTable.get(0), signUpPage.FirstBox.getText());
        Assert.assertEquals(dataTable.get(1), signUpPage.LastBox.getText());
        Assert.assertTrue(signUpPage.EmailBox2.isDisplayed());
        Assert.assertTrue(signUpPage.PasswordBox2.isDisplayed());

    }
    @When("I enter each required text")
    public void iEnterEachRequiredText() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signUpAction();

    }
    @Then("I click Sign Up")
    public void iClickSignUp() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.OfficialSignUpBtn.click();

    }
    @Then("The new url should be {string}")
    public void theNewUrlShouldBe(String string) {
        string = "http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php";

        SeleniumUtils.waitForUrlContains("index", 5);
        Assert.assertEquals(string, Driver.getDriver().getCurrentUrl());

    }
    @When("I click to sign up")
    public void i_click_to_sign_up() {
        SignUpPage signUpPage = new SignUpPage();
        Actions act = new Actions(Driver.getDriver());
        act.click(signUpPage.SignUpBtn2).build().perform();

    }
    Faker fake = new Faker();

    String first = fake.name().firstName();
    String last = fake.name().lastName();
    String newEmail = (first.charAt(0) + "." + last + "@email.com");
    String password = fake.internet().password(5, 8);

    @Then("I enter faker generated text")
    public void i_enter_faker_generated_text() {
        SignUpPage signUpPage = new SignUpPage();


        signUpPage.FirstBox2.sendKeys(first);
        signUpPage.LastBox2.sendKeys(last);
        signUpPage.EmailBox2.clear();
        signUpPage.EmailBox2.sendKeys(newEmail);
        signUpPage.PasswordBox2.sendKeys(password);
    }
    @Then("I click the Sign Up button")
    public void i_click_the_sign_up_button() {
        SignUpPage signUpPage = new SignUpPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].click();", signUpPage.OfficialSignUpBtn2);
        SeleniumUtils.waitFor(5);

    }
    @When("The new page appears")
    public void the_new_page_appears() {
        SignUpPage signUpPage = new SignUpPage();

        SeleniumUtils.waitForVisibility(signUpPage.Greetings, 8);
        Assert.assertTrue("Welcome Back", true);

    }
    @Then("I enter the saved faker text")
    public void i_enter_the_saved_faker_text() {
        SignUpPage signUpPage = new SignUpPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOf(signUpPage.EmailBox));
        wait.until(ExpectedConditions.elementToBeClickable(signUpPage.EmailBox));
        signUpPage.EmailBox.sendKeys(newEmail);

        wait.until(ExpectedConditions.visibilityOf(signUpPage.PasswordBox));
        wait.until(ExpectedConditions.elementToBeClickable(signUpPage.PasswordBox));
        signUpPage.PasswordBox.sendKeys(password);

    }
    @Then("I click the Login button")
    public void i_click_the_login_button() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        SignUpPage signUpPage = new SignUpPage();

        js.executeScript("arguments[0].click();", signUpPage.LoginBtn);

    }
    @Then("I should see my {string} on the page")
    public void iShouldSeeMyOnThePage(String fullName) throws SQLException {
        SignUpPage signUpPage = new SignUpPage();
        fullName = first + " " + last;
        String newName = signUpPage.userName.getText();

        Assert.assertEquals(fullName, newName);


    }
    @Then("The {string} should remain the same")
    public void theShouldRemainTheSame(String url) {
        url = "http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php";
        Assert.assertEquals(url, Driver.getDriver().getCurrentUrl());

    }
    @When("I enter a generic {string}")
    public void iEnterAGeneric(String generic) {
        generic = "email23@email.com";
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.EmailBox.sendKeys(generic);

    }
    @And("Leave the password blank")
    public void leaveThePasswordBlank() {
        SignUpPage signUpPage = new SignUpPage();

        Assert.assertEquals(signUpPage.PasswordBox.getAttribute("value"),"");

    }
    @When("I enter an incorrect password")
    public void iEnterAnIncorrectPassword() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.PasswordBox.sendKeys("blah");

    }
    @Then("I should see that it failed")
    public void iShouldSeeThatItFailed() {
        System.out.println(Driver.getDriver().findElement(By.xpath("//div[@class='card-header pb-1']")).getText());

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@class='card-header pb-1']")).getText().contains("Login Failed"));

    }
    @When("I do not enter an email")
    public void iDoNotEnterAnEmail() {
        SignUpPage signUpPage = new SignUpPage();

        Assert.assertEquals(signUpPage.EmailBox.getAttribute("value"), "");

    }
    @When("I do enter a random {string}")
    public void iDoEnterARandom(String password) {
        Faker fake = new Faker();
        password = fake.internet().password(5, 10);

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.PasswordBox.sendKeys(password);

    }
    @Then("I see the page change")
    public void iSeeThePageChange() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/register.php");

    }
    @When("I click on the Sign up link again")
    public void iClickOnTheSignUpLinkAgain() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.signInLink.click();

    }
    @Then("I see the page change back to the original")
    public void iSeeThePageChangeBackToTheOriginal() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php");

    }
    @When("I find an element")
    public void iFindAnElement() {
        SignUpPage signUpPage = new SignUpPage();

        Assert.assertTrue(signUpPage.Greetings.isDisplayed());

    }
    @Then("I should see its text {string}")
    public void iShouldSeeItsText(String text) {
        SignUpPage signUpPage = new SignUpPage();
        text = "Welcome Back, Automation Testers!";

        Assert.assertEquals(signUpPage.Greetings.getText().trim(), text);

    }
    String expectedFirst;
    String expectedLast;
    String expectedEmail;
    String expectedPassword;

    @Then("I sign up using the following credentials")
    public void iSignUpUsingTheFollowingCredentials(List<Map<String,String>> dataTable) {

        Map<String,String> map = dataTable.get(0);
        SignUpPage signUpPage = new SignUpPage();

        expectedFirst = map.get("FIRST NAME");
        signUpPage.FirstBox2.sendKeys(expectedFirst);

        expectedLast = map.get("LAST NAME");
        signUpPage.LastBox2.sendKeys(expectedLast);

        expectedEmail = map.get("EMAIL ADDRESS");
        signUpPage.EmailBox2.sendKeys(expectedEmail);

        expectedPassword = map.get("PASSWORD");
        signUpPage.PasswordBox2.sendKeys(expectedPassword);


    }
    @Then("I enter the saved email {string} and password {string}")
    public void iEnterTheSavedEmailAndPassword(String email, String pass) {

        SignUpPage signUpPage = new SignUpPage();
        email = expectedEmail;
        pass = expectedPassword;

        signUpPage.EmailBox.sendKeys(email);
        signUpPage.PasswordBox.sendKeys(pass);

    }
    @Then("I should be able to verify the {string} located on the page")
    public void iShouldBeAbleToVerifyTheLocatedOnThePage(String name) throws SQLException {

        SignUpPage signUpPage = new SignUpPage();
        name = expectedFirst + " " + expectedLast;

        String newName = signUpPage.userName.getText();

        Assert.assertEquals(name, newName);

        String updateQueryNow = "delete from tbl_user where email='"+expectedEmail+"'";
        DBUtility.updateQuery(updateQueryNow);

    }













}
