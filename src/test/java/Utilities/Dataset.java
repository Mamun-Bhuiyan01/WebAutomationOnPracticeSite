package Utilities;

import org.testng.annotations.DataProvider;

public class Dataset {

    @DataProvider(name = "InvalidCredentials")
    public static Object InvalidUserDataset(){

        Object[][] data = {//{email, password, errormessage, emailvalidationmessage, passwordvalidationmessage},
                           {"mamun01@yopmai.com", "mamun123", "Your email or password is incorrect!", "", ""},
                           {"mamun01.com", "mamun12", "", "Please include an '@' in the email address. 'mamun01.com' is missing an '@'.", ""},
                           {"", "mamun12", "", "Please fill out this field.", ""}
        };

        return data;
    }
}
