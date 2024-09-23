package Pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    public String homepageurl= "https://automationexercise.com";

    public By login_signup_button = By.xpath("//a[normalize-space()='Signup / Login']");
    public By products = By.xpath("//button[normalize-space()='Login']");
    public By testcases = By.xpath("//a[contains(text(),'Test Cases')]");
    public By apitesting = By.xpath("//a[normalize-space()='API Testing']");
    public By videotutorial = By.xpath("//a[normalize-space()='Video Tutorials']");
    public By contactus = By.xpath("//a[normalize-space()='Contact us']");
    public By logoutbutton = By.xpath("//*[text()=' Logout']");

    public void loadhomepage(){
        loadawebpage(homepageurl);
    }
}

