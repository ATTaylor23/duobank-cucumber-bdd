package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pages.DashboardPage;
import pages.SignUpPage;
import utilities.DBUtility;
import utilities.Driver;
import utilities.PropertyReader;
import utilities.SeleniumUtils;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class DashboardStepDefs {

    public DashboardStepDefs() throws SQLException {
    }

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
    @Then("I sign out completely")
    public void iSignOutCompletely() {

        Actions act = new Actions(Driver.getDriver());
        DashboardPage dashboardPage = new DashboardPage();

        act.click(dashboardPage.usernameBtn).perform();
        act.click(dashboardPage.logoutBtn).perform();


    }
    @Given("I'm signed out")
    public void iMSignedOut() {

        Assert.assertEquals(PropertyReader.getTheProperties("url"), Driver.getDriver().getCurrentUrl());

    }
    String first;
    String last;
    String email;
    String password;

    @Then("I enter new random user info")
    public void iEnterNewRandomUserInfo() {
        Faker faker = new Faker();
        SignUpPage signUpPage = new SignUpPage();

        first = faker.name().firstName();
        last = faker.name().lastName();
        email = faker.internet().emailAddress();
        password = faker.internet().password(5, 10);

        signUpPage.SignUpBtn.click();
        signUpPage.FirstBox2.sendKeys(first);
        signUpPage.LastBox2.sendKeys(last);
        signUpPage.EmailBox2.sendKeys(email);
        signUpPage.PasswordBox2.sendKeys(password);
        signUpPage.OfficialSignUpBtn.click();

    }
    @When("This happens I should be able to sign in through UI using the new user info")
    public void thisHappensIShouldBeAbleToSignInThroughUIUsingTheNewUserInfo() {

        SignUpPage signUpPage = new SignUpPage();

        signUpPage.EmailBox.sendKeys(email);
        signUpPage.PasswordBox.sendKeys(password);
        signUpPage.LoginBtn.click();

        String newName = signUpPage.userName.getText();
        String userName = first + " " + last;

        Assert.assertEquals(userName, newName);


    }
    @Then("I may delete this new user info through the database")
    public void iMayDeleteThisNewUserInfoThroughTheDatabase() throws SQLException {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.usernameBtn.click();
        dashboardPage.logoutBtn.click();

        String query = "delete from tbl_user where email='"+email+"'";
        DBUtility.updateQuery(query);

    }
    @Then("verify this deletion by failing to sign in with the same information")
    public void verifyThisDeletionByFailingToSignInWithTheSameInformation() {

        SignUpPage signUpPage = new SignUpPage();


        signUpPage.EmailBox.sendKeys(email);
        signUpPage.PasswordBox.sendKeys(password);
        signUpPage.LoginBtn.click();

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Login Failed"));

    }
    @Then("I enter new user info through the database")
    public void iEnterNewUserInfoThroughTheDatabase() throws SQLException {

        String newQuery = "Insert into tbl_user (id, email, password, first_name, last_name, phone, image, type, " +
                "created_at, modified_at, zone_id, church_id, country_id) values(3323, 'emailUSER@email.com', 'passwordPASSWORD'," +
                " 'Denzel', 'Curry','2129000909', 'assets/images/profile-pics/head', 1, 1, 1, 1, 1, 1)";
        DBUtility.updateQuery(newQuery);

    }
    @When("This happens I should be able to verify by attempting to sign in through the UI")
    public void thisHappensIShouldBeAbleToVerifyThisBySigningInThroughTheUI() throws SQLException {

        SignUpPage signUpPage = new SignUpPage();

        signUpPage.SignUpBtn.click();
        signUpPage.FirstBox2.sendKeys("Denzel");
        signUpPage.LastBox2.sendKeys("Curry");
        signUpPage.EmailBox2.sendKeys("emailUSER@email.com");
        signUpPage.PasswordBox2.click();

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("This email already used"));

        String deleteQuery = "delete from tbl_user where email='emailUSER@email.com'";
        DBUtility.updateQuery(deleteQuery);

    }
    String bName;
    String expectedBName;

    @Then("I fill out the entire application")
    public void iFillOutTheEntireApplication() {

        DashboardPage dashboardPage = new DashboardPage();
        Faker faker = new Faker();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        dashboardPage.mortApp.click();

        String realName = faker.name().fullName();
        dashboardPage.realtorInfoBox.sendKeys(realName);

        String estPrice = "500000";
        dashboardPage.estPriceBox.sendKeys(estPrice);
        String downAmount = "50000";
        dashboardPage.downAmountBox.sendKeys(downAmount);

        dashboardPage.nextBtn.click();

        js.executeScript("arguments[0].click();", dashboardPage.coborrowerYes);

        String FN = faker.name().firstName();
        dashboardPage.firstBox.sendKeys(FN);
        String LN = faker.name().lastName();
        dashboardPage.lastBox.sendKeys(LN);
        dashboardPage.suffixDrop.click();
        dashboardPage.third.click();

        bName = (FN + " " + LN);

        String EM = faker.internet().emailAddress();
        dashboardPage.emailBox.sendKeys(EM);
        String DOB = "10021955";
        dashboardPage.dobBox.sendKeys(DOB);

        String SSN = "111111111";
        dashboardPage.socialBox.sendKeys(SSN);
        dashboardPage.maritalBox.click();
        dashboardPage.married.click();

        String PN = "5555555555";
        dashboardPage.cellBox.sendKeys(PN);

        String coFN = faker.name().firstName();
        dashboardPage.coFirstBox.sendKeys(coFN);
        String coLN = faker.name().lastName();
        dashboardPage.coLastBox.sendKeys(coLN);

        String coEM = faker.internet().emailAddress();
        dashboardPage.coEmail.sendKeys(coEM);
        String coDOB = "06291948";
        dashboardPage.coDobBox.sendKeys(coDOB);

        String coSSN = "222222222";
        dashboardPage.coSocialBox.sendKeys(coSSN);
        dashboardPage.coMaritalBox.click();
        dashboardPage.coDivorced.click();

        String coPN = "3042636695";
        dashboardPage.coCellBox.sendKeys(coPN);

        dashboardPage.nextBtn.click();


        String rent = "2100";
        dashboardPage.rentPayBox.sendKeys(rent);

        dashboardPage.nextBtn.click();



        String EMP = faker.company().name();
        dashboardPage.empNameBox.sendKeys(EMP);
        String POS = faker.company().profession();
        dashboardPage.posBox.sendKeys(POS);

        String CITY = faker.address().city();
        dashboardPage.cityBox.sendKeys(CITY);
        dashboardPage.stateDrop.click();
        dashboardPage.stateAM.click();

        String stDate = "01012001";
        dashboardPage.startDateBox.sendKeys(stDate);

        String coEMP = faker.company().name();
        dashboardPage.coEmpNameBox.sendKeys(coEMP);
        String coPOS = faker.company().profession();
        dashboardPage.coPosBox.sendKeys(coPOS);

        String coCITY = faker.address().city();
        dashboardPage.coCityBox.sendKeys(coCITY);
        dashboardPage.coStateDrop.click();
        dashboardPage.coStateVA.click();

        String coStDATE = "01011990";
        dashboardPage.coStartDateBox.sendKeys(coStDATE);

        String GROSS = "100000";
        dashboardPage.grossBox.sendKeys(GROSS);
        String OT = "2300";
        dashboardPage.overtime.sendKeys(OT);
        String BONUS = "8000";
        dashboardPage.bonus.sendKeys(BONUS);
        String COMM = "63000";
        dashboardPage.commiss.sendKeys(COMM);
        String DIV = "37000";
        dashboardPage.dividents.sendKeys(DIV);

        String coGROSS = "100000";
        dashboardPage.coGrossBox.sendKeys(coGROSS);
        String coOT = "2300";
        dashboardPage.coOvertime.sendKeys(coOT);
        String coBONUS = "8000";
        dashboardPage.coBonus.sendKeys(coBONUS);
        String coCOMM = "63000";
        dashboardPage.coCommiss.sendKeys(coCOMM);
        String coDIV = "37000";
        dashboardPage.coDividents.sendKeys(coDIV);

        dashboardPage.nextBtn.click();



        dashboardPage.creditAuthNo.click();

        dashboardPage.nextBtn.click();



        dashboardPage.eConDecBox.click();
        dashboardPage.borrower.click();

        dashboardPage.eConFirstBox.sendKeys(FN);
        dashboardPage.eConLastBox.sendKeys(LN);
        dashboardPage.eConEmailBox.sendKeys(EM);

        dashboardPage.agreeCheck.click();

        dashboardPage.nextBtn.click();


        dashboardPage.saveBtn.click();


        dashboardPage.applicationList.click();

    }
    @When("This happens the borrower's name should be present")
    public void thisHappensTheBorrowerSNameShouldBePresent() {

        DashboardPage dashboardPage = new DashboardPage();

        expectedBName = dashboardPage.bNameContent1.getText();
        Assert.assertEquals(bName, expectedBName);

    }
    String expectedRI;
    String expectedEPP;
    String expectedDPA;

    @Then("I fill out the required fields using the following credentials")
    public void iFillOutTheRequiredFieldsUsingTheFollowingCredentials(List<Map<String,String>> dataTable) {

        Map<String,String> map = dataTable.get(0);
        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.mortApp.click();

        expectedRI = map.get("Realtor Information");
        dashboardPage.realtorInfoBox.sendKeys(expectedRI);

        expectedEPP = map.get("Estimated Purchase Price");
        dashboardPage.estPriceBox.sendKeys(expectedEPP);

        expectedDPA = map.get("Down Payment Amount");
        dashboardPage.downAmountBox.sendKeys(expectedDPA);

    }
    @When("This happens I should be able to verify through the credentials presence")
    public void thisHappensIShouldBeAbleToVerifyThroughTheCredentialsPresence() {

        DashboardPage dashboardPage = new DashboardPage();

        String actualRI = dashboardPage.realtorInfoBox.getAttribute("value");
        String actualEPP = dashboardPage.estPriceBox.getAttribute("value");
        String actualDPA = dashboardPage.downAmountBox.getAttribute("value");

        Assert.assertEquals(expectedRI, actualRI);
        Assert.assertEquals(expectedEPP, actualEPP);
        Assert.assertEquals(expectedDPA, actualDPA);

    }
    @When("See the correct math through the Loan Amount remaining total")
    public void seeTheCorrectMathThroughTheLoanAmountRemainingTotal() {

        DashboardPage dashboardPage = new DashboardPage();

        int price = Integer.parseInt(expectedEPP);
        int downP = Integer.parseInt(expectedDPA);

        String YLA = dashboardPage.estPriceConfirmBox.getText().replace("$","").replace(" ","");
        int total = Integer.parseInt(YLA);

        Assert.assertEquals(total, (price - downP));

    }
    List<String> actualColumnNames;

//    @When("I send a query to retrieve column names for tbl_mortagage table")
//    public void iSendAQueryToRetrieveColumnNamesForTblMortagageTable() {
//
//        actualColumnNames = DBUtility.getColumnNames("Select * from tbl_mortagage");
//
//    }
//    @Then("The column names should be the following")
//    public void theColumnNamesShouldBeTheFollowing(List<String> expectedColumnNames) {
//
//        Assert.assertEquals(expectedColumnNames, actualColumnNames);
//
//    }



}
