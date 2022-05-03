package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;
import utilities.SeleniumUtils;

public class DashboardPage {


    @FindBy (xpath = "//li[@class='active is-shown']")
    public WebElement mortgageApp;

    @FindBy (xpath ="//li[@class='is-shown']")
    public WebElement appList;

    @FindBy (xpath = "//li[@class='active is-shown']//a")
    public WebElement mortgageItems;




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
