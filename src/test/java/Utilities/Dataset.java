package Utilities;

import org.testng.annotations.DataProvider;

public class Dataset {

    @DataProvider(name = "InvalidCredentials")
    public static Object InvalidUserDataset(){

        Object[][] data = {//{email, password, errormessage, emailvalidationmessage, passwordvalidationmessage},
                           {"shobuj@yopmai.com", "shobuj123", "Your email or password is incorrect!", "", ""},
                           {"shobuj.com", "shobuj12", "", "Please include an '@' in the email address. 'shobuj.com' is missing an '@'.", ""},
                           {"", "shobuj12", "", "Please fill out this field.", ""}
        };

        return data;
    }
}
