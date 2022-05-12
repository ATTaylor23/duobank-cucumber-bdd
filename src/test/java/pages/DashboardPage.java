package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.SeleniumUtils;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////
    //MORTGAGE APPLICATION

    @FindBy (xpath = "//span[.='Mortgage Application']")
    public WebElement mortApp;

@FindBy (xpath = "//a[@href='#next']")
public WebElement nextBtn;

@FindBy (xpath = "//a[@href='#previous']")
public WebElement prevBtn;

@FindBy (xpath = "//a[@href='#finish']")
public WebElement saveBtn;

@FindBy (xpath = "//li[@class='dropdown dropdown-user nav-item']")
public WebElement usernameBtn;

@FindBy (xpath = "//a[@class='dropdown-item']")
public WebElement logoutBtn;

@FindBy (xpath = "//i[@data-ticon='bx-disc']")
public WebElement menuCollapse;

@FindBy (xpath = "//span[@class='menu-title']")
public WebElement dashboardCollapse;


/////////////////////////////////////////////////////////////////////////////////////////////////////////
    //PREAPPROVAL DETAILS PAGE

    @FindBy (xpath = "//label[@for='realtor1']")
    public WebElement realtorYes;

    @FindBy (xpath = "//input[@name='realtor_info']")
    public WebElement realtorInfoBox;

    @FindBy (xpath = "//label[@for='realtor2']")
    public WebElement realtorNo;

    @FindBy (xpath = "//label[@for='loanofficer1']")
    public WebElement loanOfficerYes;

    @FindBy (xpath = "//label[@for='loanofficer2']")
    public WebElement loanOfficerNo;

    @FindBy (xpath = "//span[@aria-labelledby='select2-purpose_loan-xw-container']")
    public WebElement loanPurposeDrop;

        @FindBy (xpath = "//li[@role='treeitem']")
        public WebElement buyHomeChoice;

    @FindBy (xpath = "//input[@name='est_purchase_price']")
    public WebElement estPriceBox;

    @FindBy (xpath = "//input[@name='down_payment']")
    public WebElement downAmountBox;

    @FindBy (xpath = "//input[@name='down_payment_percent']")
    public WebElement downPercentage;

    @FindBy (xpath = "//div[@class='loanamount']//span")
    public WebElement estPriceConfirmBox;

    @FindBy (xpath = "//span[@title='Checking/Savings (most recent bank statement)']")
    public WebElement checkSaveDrop;

        @FindBy (xpath = "//li[@role='treeitem'][1]")
        public WebElement mostRecent;
        @FindBy (xpath = "//li[@role='treeitem'][2]")
        public WebElement equity;
        @FindBy (xpath = "//li[@role='treeitem'][3]")
        public WebElement otherChoice;

    @FindBy (xpath = "//label[@for='additionalfunds']")
    public WebElement addFundsBox;

/////////////////////////////////////////////////////////////////////////////////////////////////////////
    //PERSONAL INFO PAGE

    @FindBy (xpath = "//label[@for='coborrower1']")
    public WebElement coborrowerYes;

    @FindBy (xpath = "//label[@for='coborrower2']")
    public WebElement coborrowerNo;

    @FindBy (xpath = "//div[@class='form-group']//label[@for='b_firstname']")
    public WebElement firstTitle;
    @FindBy (id = "b_firstName")
    public WebElement firstBox;

    @FindBy (xpath = "//div[@class='form-group']//label[@for='b_lastName']")
    public WebElement lastTitle;
    @FindBy (id = "b_lastName")
    public WebElement lastBox;

    @FindBy (xpath = "//span[@aria-labelledby='select2-b_suffix-container']")
    public WebElement suffixDrop;

        @FindBy (xpath = "//ul[@class='select2-results__options']//li[2]")
        public WebElement junior;
        @FindBy (xpath = "//ul[@class='select2-results__options']//li[3]")
        public WebElement senior;
        @FindBy (xpath = "//ul[@class='select2-results__options']//li[4]")
        public WebElement second;
        @FindBy (xpath = "//ul[@class='select2-results__options']//li[5]")
        public WebElement third;
        @FindBy (xpath = "//ul[@class='select2-results__options']//li[6]")
        public WebElement fourth;
        @FindBy (xpath = "//ul[@class='select2-results__options']//li[1]")
        public WebElement defaultOption73;

    @FindBy (xpath = "//div[@class='form-group']//label[@for='b_email']")
    public WebElement emailTitle;
    @FindBy (id = "b_email")
    public WebElement emailBox;

    @FindBy (xpath = "//div[@class='form-group']//label[@for='b_dob']")
    public WebElement dobTitle;
    @FindBy (id = "b_dob")
    public WebElement dobBox;

    @FindBy (xpath = "//div[@class='form-group']//label[@for='b_ssn']")
    public WebElement ssnTitle;
    @FindBy (id = "b_ssn")
    public WebElement socialBox;

    @FindBy (xpath = "//div[@class='form-group']//label[@for='b_marital']")
    public WebElement maritalTitle;
    @FindBy (id = "select2-b_marital-container")
    public WebElement maritalBox;

        @FindBy (xpath = "//select[@id='b_marital']//option[2]")
        public WebElement married;
        @FindBy (xpath = "//select[@id='b_marital']//option[3]")
        public WebElement divorced;
        @FindBy (xpath = "//select[@id='b_marital']//option[4]")
        public WebElement separated;
        @FindBy (xpath = "//select[@id='b_marital']//option[1]")
        public WebElement defaultOption84;

    @FindBy (xpath = "//div[@class='form-group']//label[@for='b_cell']")
    public WebElement cellTitle;
    @FindBy (id = "b_cell")
    public WebElement cellBox;

    @FindBy (xpath = "//label[@for='privacypolicy']")
    public WebElement privacyCheckbox;

    @FindBy (id = "c_firstName")
    public WebElement coFirstBox;

    @FindBy (id = "c_lastName")
    public WebElement coLastBox;

    @FindBy (xpath = "//span[@aria-labelledby='select2-c_suffix-container']")
    public WebElement coSuffixDrop;

        @FindBy (id = "select2-c_suffix-result-p7p4-Jr.")
        public WebElement coJunior;
        @FindBy (id = "select2-c_suffix-result-bwuj-Jr.")
        public WebElement coSenior;
        @FindBy (id = "select2-c_suffix-result-1l5h-II")
        public WebElement coSecond;
        @FindBy (id = "select2-c_suffix-result-5vz0-III")
        public WebElement coThird;
        @FindBy (id = "select2-c_suffix-result-4nw3-IV")
        public WebElement coFourth;
        @FindBy (xpath = "//li[@data-select2-id='96']")
        public WebElement defaultOption96;

    @FindBy (id = "c_email")
    public WebElement coEmail;

    @FindBy (id = "c_dob")
    public WebElement coDobBox;

    @FindBy (id = "c_ssn")
    public WebElement coSocialBox;

    @FindBy (id = "select2-c_marital-container")
    public WebElement coMaritalBox;

        @FindBy (xpath = "//select[@id='c_marital']//option[2]")
        public WebElement coMarried;
        @FindBy (xpath = "//select[@id='c_marital']//option[3]")
        public WebElement coDivorced;
        @FindBy (xpath = "//select[@id='c_marital']//option[4]")
        public WebElement coSeparated;
        @FindBy (xpath = "//select[@id='c_marital']//option[1]")
        public WebElement defaultOption105;

    @FindBy (id = "c_cell")
    public WebElement coCellBox;

/////////////////////////////////////////////////////////////////////////////////////////////////////////
    //EXPENSES PAGE

    @FindBy (xpath = "//label[@for='expense1']")
    public WebElement rentCheckbox;

    @FindBy (xpath = "//label[@for='expense2']")
    public WebElement ownCheckbox;

    @FindBy (id = "monthlyrentalpayment")
    public WebElement rentPayBox;

/////////////////////////////////////////////////////////////////
    //EMPLOYMENT AND INCOME PAGE

    @FindBy (id = "currentjobsls")
    public WebElement currentCheckbox;

    @FindBy (id = "employername1")
    public WebElement empNameBox;

    @FindBy (id = "position1")
    public WebElement posBox;

    @FindBy (xpath = "//input[@id='city']")
    public WebElement cityBox;

    @FindBy (xpath = "//select[@id='state1']")
    public WebElement stateDrop;

        @FindBy (xpath = "//select[@id='state1']//option[2]")
        public WebElement stateAK;
        @FindBy (xpath = "//select[@id='state1']//option[3]")
        public WebElement stateAL;
        @FindBy (xpath = "//select[@id='state1']//option[4]")
        public WebElement stateAM;
        @FindBy (xpath = "//select[@id='state1']//option[1]")
        public WebElement defaultNoState;

    @FindBy (id = "start_date1")
    public WebElement startDateBox;

    @FindBy (id = "end_date1")
    public WebElement endDateBox;

    @FindBy (id = "addemployer")
    public WebElement addEmpBtn;

    @FindBy (id = "clear1")
    public WebElement b_clearBtn;

    @FindBy (id = "co_currentjobsls")
    public WebElement coCurrentCheckbox;

    @FindBy (id = "co-employername1")
    public WebElement coEmpNameBox;

    @FindBy (id = "co-position1")
    public WebElement coPosBox;

    @FindBy (xpath = "//input[@id='co-city']")
    public WebElement coCityBox;

    @FindBy (xpath = "//select[@id='co-state1']")
    public WebElement coStateDrop;

        @FindBy (xpath = "//select[@id='co-state1']//option[2]")
        public WebElement coStateAK;
        @FindBy (xpath = "//select[@id='co-state1']//option[3]")
        public WebElement coStateAL;
        @FindBy (xpath = "//select[@id='co-state1']//option[4]")
        public WebElement coStateAM;
        @FindBy (xpath = "//select[@id='co-state1']//option[5]")
        public WebElement coStateVA;
        @FindBy (xpath = "//select[@id='co-state1']//option[1]")
        public WebElement coDefaultNoState;

    @FindBy (id = "co-start_date1")
    public WebElement coStartDateBox;

    @FindBy (id = "co-end_date1")
    public WebElement coEndDateBox;

    @FindBy (id = "co-addemployer")
    public WebElement coAddEmpBtn;

    @FindBy (id = "co-clear1")
    public WebElement coClearBtn;

    @FindBy (id = "grossmonthlyincome")
    public WebElement grossBox;

    @FindBy (id = "monthlyovertime")
    public WebElement overtime;

    @FindBy (id = "monthlybonuses")
    public WebElement bonus;

    @FindBy (id = "monthlycommission")
    public WebElement commiss;

    @FindBy (id = "monthlydividents")
    public WebElement dividents;

    @FindBy (xpath = "//div[@class='borrowertotalmonthlyincome']")
    public WebElement b_incomeConfirm;

    @FindBy (id = "co-grossmonthlyincome")
    public WebElement coGrossBox;

    @FindBy (id = "co-monthlyovertime")
    public WebElement coOvertime;

    @FindBy (id = "co-monthlybonuses")
    public WebElement coBonus;

    @FindBy (id = "co-monthlycommission")
    public WebElement coCommiss;

    @FindBy (id = "co-monthlydividents")
    public WebElement coDividents;

    @FindBy (xpath = "//div[@class=' co-borrowertotalmonthlyincome']")
    public WebElement c_incomeConfirm;

    @FindBy (xpath = "//select[@id='addtionalbelong1']")
    public WebElement AG_belongTO1;
        @FindBy (xpath = "//select[@id='addtionalbelong1']//option[1]")
        public WebElement defaultNone1;
        @FindBy (xpath = "//select[@id='addtionalbelong1']//option[2]")
        public WebElement B1;
        @FindBy (xpath = "//select[@id='addtionalbelong1']//option[3]")
        public WebElement co_B1;

    @FindBy (xpath = "//select[@id='addtionalbelong2']")
        public WebElement AG_belongTO2;
        @FindBy (xpath = "//select[@id='addtionalbelong2']//option[1]")
        public WebElement defaultNone2;
        @FindBy (xpath = "//select[@id='addtionalbelong2']//option[2]")
        public WebElement B2;
        @FindBy (xpath = "//select[@id='addtionalbelong2']//option[3]")
        public WebElement co_B2;

    @FindBy (xpath = "//select[@id='addtionalbelong3']")
    public WebElement AG_belongTO3;
        @FindBy (xpath = "//select[@id='addtionalbelong3']//option[1]")
        public WebElement defaultNone3;
        @FindBy (xpath = "//select[@id='addtionalbelong3']//option[2]")
        public WebElement B3;
        @FindBy (xpath = "//select[@id='addtionalbelong3']//option[3]")
        public WebElement co_B3;

    @FindBy (xpath = "//select[@id='incomesource1']")
    public WebElement AG_incomeSource1;
        @FindBy (xpath = "//select[@id='incomesource1']//option[1]")
        public WebElement defaultNo1;
        @FindBy (xpath = "//select[@id='incomesource1']//option[2]")
        public WebElement Ali1_A;
        @FindBy (xpath = "//select[@id='incomesource1']//option[3]")
        public WebElement Other1_A;
        @FindBy (xpath = "//select[@id='incomesource1']//option[4]")
        public WebElement Ali1_B;
        @FindBy (xpath = "//select[@id='incomesource1']//option[5]")
        public WebElement Other1_B;
        @FindBy (xpath = "//select[@id='incomesource1']//option[6]")
        public WebElement SocialSec1;

    @FindBy (xpath = "//select[@id='incomesource2']")
    public WebElement AG_incomeSource2;
        @FindBy (xpath = "//select[@id='incomesource2']//option[1]")
        public WebElement defaultNo2;
        @FindBy (xpath = "//select[@id='incomesource2']//option[2]")
        public WebElement Ali2_A;
        @FindBy (xpath = "//select[@id='incomesource2']//option[3]")
        public WebElement Other2_A;
        @FindBy (xpath = "//select[@id='incomesource2']//option[4]")
        public WebElement Ali2_B;
        @FindBy (xpath = "//select[@id='incomesource2']//option[5]")
        public WebElement Other2_B;
        @FindBy (xpath = "//select[@id='incomesource2']//option[6]")
        public WebElement SocialSec2;

    @FindBy (xpath = "//select[@id='incomesource3']")
    public WebElement AG_incomeSource3;
        @FindBy (xpath = "//select[@id='incomesource3']//option[1]")
        public WebElement defaultNo3;
        @FindBy (xpath = "//select[@id='incomesource3']//option[2]")
        public WebElement Ali3_A;
        @FindBy (xpath = "//select[@id='incomesource3']//option[3]")
        public WebElement Other3_A;
        @FindBy (xpath = "//select[@id='incomesource3']//option[4]")
        public WebElement Ali3_B;
        @FindBy (xpath = "//select[@id='incomesource3']//option[5]")
        public WebElement Other3_B;
        @FindBy (xpath = "//select[@id='incomesource3']//option[6]")
        public WebElement SocialSec3;

    @FindBy (id = "amount1")
    public WebElement AG_amount1;

    @FindBy (id = "amount2")
    public WebElement AG_amount2;

    @FindBy (id = "amount3")
    public WebElement AG_amount3;

//////////////////////////////////////////////////////////////////////////////////////
    //CREDIT REPORT PAGE

    @FindBy (xpath = "//label[@for='creditreport1']")
    public WebElement creditAuthYes;

    @FindBy (xpath = "//label[@for='creditreport2']")
    public WebElement creditAuthNo;

//////////////////////////////////////////////////////////////////////////////////////
    //ECONSENT PAGE

    @FindBy (id = "eConsentdeclarer")
    public WebElement eConDecBox;

        @FindBy (xpath = "//select[@name='eConsent_declarer']//option[1]")
        public WebElement def;
        @FindBy (xpath = "//select[@name='eConsent_declarer']//option[2]")
        public WebElement borrower;
        @FindBy (xpath = "//select[@name='eConsent_declarer']//option[3]")
        public WebElement coBorrower;

    @FindBy (id = "eConsentdeclarerFirstName")
    public WebElement eConFirstBox;

    @FindBy (id = "eConsentdeclarerLastName")
    public WebElement eConLastBox;

    @FindBy (id = "eConsentdeclarerEmail")
    public WebElement eConEmailBox;

    @FindBy (xpath = "//label[@for='agree']")
    public WebElement agreeCheck;

    @FindBy (xpath = "//label[@for='dontagree']")
    public WebElement dontAgreeCheck;

//////////////////////////////////////////////////////////////////////////////////////
//SUMMARY PAGE

    @FindBy (id = "PreApprovalEdit")
    public WebElement preEdit;

    @FindBy (id = "PersonalnformationEdit")
    public WebElement persEdit;

    @FindBy (id = "ExpenseEdit")
    public WebElement exEdit;

    @FindBy (id = "EmploymentIncomeEdit")
    public WebElement empEdit;

    @FindBy (id = "eConsentEdit")
    public WebElement eConEdit;

//////////////////////////////////////////////////////////////////////////////////////
//APPLICATION LIST

    @FindBy (xpath ="//span[.='Application List']")
    public WebElement applicationList;

    @FindBy (xpath = "//a[@class='btn btn-info']")
    public WebElement detailsBtn;

    @FindBy (xpath = "//select[@name='DataTables_Table_0_length']")
    public WebElement numEntriesDrop;

        @FindBy (xpath = "//select[@name='DataTables_Table_0_length']//option[1]")
        public WebElement entries10;
        @FindBy (xpath = "//select[@name='DataTables_Table_0_length']//option[2]")
        public WebElement entries25;
        @FindBy (xpath = "//select[@name='DataTables_Table_0_length']//option[3]")
        public WebElement entries50;
        @FindBy (xpath = "//select[@name='DataTables_Table_0_length']//option[4]")
        public WebElement entries100;

    @FindBy (xpath = "//tr[@class='odd']//td[2]")
    public WebElement bNameContent1;



    public void signUpSignIn(){
        SignUpPage signUpPage = new SignUpPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions act = new Actions(Driver.getDriver());
        Faker fake = new Faker();

        act.click(signUpPage.SignUpBtn2).build().perform();

        String first = fake.name().firstName();
        String last = fake.name().lastName();
        String newEmail = (first.charAt(0) + "." + last + "@email.com");
        String password = fake.internet().password(5, 8);

        signUpPage.FirstBox2.sendKeys(first);
        signUpPage.LastBox2.sendKeys(last);
        signUpPage.EmailBox2.clear();
        signUpPage.EmailBox2.sendKeys(newEmail);
        signUpPage.PasswordBox2.sendKeys(password);

        js.executeScript("arguments[0].click();", signUpPage.OfficialSignUpBtn2);
        SeleniumUtils.waitFor(5);

        signUpPage.EmailBox.sendKeys(newEmail);
        signUpPage.PasswordBox.sendKeys(password);

        js.executeScript("arguments[0].click();", signUpPage.LoginBtn);

    }

}
