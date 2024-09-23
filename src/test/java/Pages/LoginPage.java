package Pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    public By loginemail = By.xpath("//input[@data-qa='login-email']");
    public By loginpassword = By.xpath("//input[@placeholder='Password']");
    public By loginbutton = By.xpath("//button[normalize-space()='Login']");
    public By errormessage = By.xpath("//input[@placeholder='Password']/following-sibling::p");

    HomePage homePage = new HomePage();


    public void navigatetologinpage(){
       homePage.loadhomepage();
       homePage.clickonelement(homePage.login_signup_button);
    }

    public String GetErrorMessage(String error){
        if(error.equals("")){
            return "";
        }else {
            return getelement(errormessage).getText();
        }
    }
}
