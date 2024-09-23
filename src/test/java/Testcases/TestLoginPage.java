package Testcases;

import Pages.HomePage;
import Pages.LoginPage;
import Utilities.Dataset;
import Utilities.DriverSetup;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLoginPage extends DriverSetup{

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @BeforeMethod
    public void loadpage(){
        loginPage.navigatetologinpage();
    }

    @Test(description = "Test with valid username and password")
    @Description("User trying to login with valid credentials")
    @Severity(SeverityLevel.BLOCKER)
    public void test_login_with_valid_credentials(){

        loginPage.writeonelement(loginPage.loginemail, "shobuj@yopmail.com");
        loginPage.writeonelement(loginPage.loginpassword,"shobuj123");
        loginPage.addScreenshot("After entering the valid credentials");
        loginPage.clickonelement(loginPage.loginbutton);
        loginPage.addScreenshot("After click on the login button");
        Assert.assertTrue(homePage.getdisplaystatus(homePage.logoutbutton));
        Assert.assertFalse(loginPage.getdisplaystatus(loginPage.loginbutton));

    }

    @Test
    public void test_login_with_invalid_password(){

        loginPage.writeonelement(loginPage.loginemail, "shobuj@yopmail.com");
        loginPage.writeonelement(loginPage.loginpassword,"shobuj12");
        loginPage.clickonelement(loginPage.loginbutton);
        Assert.assertEquals(loginPage.getelementtext(loginPage.errormessage), "Your email or password is incorrect!");
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.loginbutton));

    }

    @Test
    public void test_login_with_wrong_email(){

        loginPage.writeonelement(loginPage.loginemail, "shobuj@yopmai.com");
        loginPage.writeonelement(loginPage.loginpassword,"shobuj123");
        loginPage.clickonelement(loginPage.loginbutton);
        Assert.assertEquals(loginPage.getelementtext(loginPage.errormessage), "Your email or password is incorrect!");
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.loginbutton));

    }
    @Test
    public void test_login_with_invalid_email(){

        loginPage.writeonelement(loginPage.loginemail, "shobuj.com");
        loginPage.writeonelement(loginPage.loginpassword,"shobuj12");
        loginPage.clickonelement(loginPage.loginbutton);
        Assert.assertEquals(loginPage.getattributetext(loginPage.loginemail, "validationMessage"), "Please include an '@' in the email address. 'shobuj.com' is missing an '@'.");
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.loginbutton));

    }

    @Test
    public void test_login_with_without_email(){

        //loginPage.writeonelement(loginPage.loginemail, "");
        loginPage.writeonelement(loginPage.loginpassword,"shobuj12");
        loginPage.clickonelement(loginPage.loginbutton);
        Assert.assertEquals(loginPage.getattributetext(loginPage.loginemail, "validationMessage"), "Please fill out this field.");
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.loginbutton));

    }

    @Test
    public void test_login_with_without_password(){

        loginPage.writeonelement(loginPage.loginemail, "shobuj@yopmail.com");
        //loginPage.writeonelement(loginPage.loginpassword,"shobuj12");
        loginPage.clickonelement(loginPage.loginbutton);
        Assert.assertEquals(loginPage.getattributetext(loginPage.loginpassword, "validationMessage"), "Please fill out this field.");
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.loginbutton));

    }

    @Test
    public void test_login_with_without_credentials(){

        //loginPage.writeonelement(loginPage.loginemail, "shobuj@yopmail.com");
        //loginPage.writeonelement(loginPage.loginpassword,"shobuj12");
        loginPage.clickonelement(loginPage.loginbutton);
        Assert.assertEquals(loginPage.getattributetext(loginPage.loginemail, "validationMessage"), "Please fill out this field.");
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.loginbutton));

    }

    @Test
    public void test_login_with_wrong_credentials(){

        loginPage.writeonelement(loginPage.loginemail, "shobuj@abc.com");
        loginPage.writeonelement(loginPage.loginpassword,"shobuj12");
        loginPage.clickonelement(loginPage.loginbutton);
        Assert.assertEquals(loginPage.getelementtext(loginPage.errormessage), "Your email or password is incorrect!");
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.loginbutton));

    }

    @Test
    public void test_login_with_invalid_email_password(){

        loginPage.writeonelement(loginPage.loginemail, "shobuj.com");
        loginPage.writeonelement(loginPage.loginpassword," shob uj12");
        loginPage.clickonelement(loginPage.loginbutton);
        Assert.assertEquals(loginPage.getattributetext(loginPage.loginemail, "validationMessage"), "Please include an '@' in the email address. 'shobuj.com' is missing an '@'.");
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.loginbutton));

    }

    @Test(dataProvider = "InvalidCredentials", dataProviderClass = Dataset.class)
    public void test_login_with_invalid_credentials(String email, String password, String errormessage, String emailvalidationmessage, String passwordvalidationmessage){

        loginPage.writeonelement(loginPage.loginemail, email);
        loginPage.writeonelement(loginPage.loginpassword, password);
        loginPage.clickonelement(loginPage.loginbutton);
        Assert.assertEquals(loginPage.getattributetext(loginPage.loginemail, "validationMessage"), emailvalidationmessage);
        Assert.assertEquals(loginPage.getattributetext(loginPage.loginpassword, "validationMessage"), passwordvalidationmessage);
        Assert.assertEquals(loginPage.GetErrorMessage(errormessage), errormessage);
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.loginbutton));

    }

}
