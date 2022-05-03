package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.SeleniumUtils;

public class SignUpPage {

    public SignUpPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='register.php']")
    public WebElement SignUpBtn;
    @FindBy(xpath = "//*[contains(text(), 'Sign up')]")
    public WebElement SignUpBtn2;

    @FindBy(xpath = "//label[@for='inputfirstname4']")
    public WebElement FirstBox;
    @FindBy(xpath = "//input[@name='first_name']")
    public WebElement FirstBox2;

    @FindBy(xpath = "//label[@for='inputlastname4']")
    public WebElement LastBox;
    @FindBy(xpath = "//input[@name='last_name']")
    public WebElement LastBox2;

    @FindBy(id = "exampleInputEmail1")
    public WebElement EmailBox;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement EmailBox2;

    @FindBy(id = "exampleInputPassword1")
    public WebElement PasswordBox;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement PasswordBox2;

    @FindBy(xpath = "//button[@name='register']")
    public WebElement OfficialSignUpBtn;
    @FindBy(xpath = "//button[@id='register']")
    public WebElement OfficialSignUpBtn2;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement LoginBtn;

    @FindBy(xpath = "//h4")
    public WebElement Greetings;

    @FindBy(xpath = "//span[@class='user-name']")
    public WebElement userName;

    @FindBy(xpath = "//a[@href='index.php']")
    public WebElement signInLink;

    public void signUpAction(){
        Faker faker = new Faker();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        String Fname = faker.name().firstName();
        String Lname = faker.name().lastName();
        String Email = Fname.charAt(0) + "." + Lname + "@email.com";
        String Pword = faker.internet().password(5, 8);

        FirstBox2.sendKeys(Fname);
        LastBox2.sendKeys(Lname);
        EmailBox2.sendKeys(Email);
        PasswordBox2.sendKeys(Pword);



    }


}
