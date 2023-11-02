package orb.muir.bbc.tests;

import org.muir.bbc.pageobjects.HomePage;
import org.muir.bbc.pageobjects.SignInPage2;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This Test Cases verifies that we cannot log into the BBC Website if
 * we have a valid user Id and an invalid password.
 */
public class InvalidPasswordLoginTest extends BaseTest {

    @Test
    public void testInvalidPassword() {
        new HomePage( driver )
                .clickIDCTALink()
                .setEmailAddress( emailAddress )
                .clickSubmitButton()
                .setPassword( "Invalid-password!" )
                .clickSubmitButton();

        var signInPage2 = new SignInPage2( driver );
        var hasExpectedErrorMessage = signInPage2.hasErrorMessage(
                "That password isn’t right. You can try again or reset your password" );

        // Verifies the expected error message is shown.
        Assert.assertTrue( hasExpectedErrorMessage, "EXPECTED ERROR MESSAGE NOT FOUND" );
    }
}
