package org.muir.bbc.tests;

import org.muir.bbc.pageobjects.HomePage;
import org.muir.bbc.pageobjects.LoggedInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This Test Case verifies that with a valid user id and a va;id password,
 * we can log into the BBC website.
 */
public class HappyPathLoginTest extends BaseTest {

    @Test
    public void testHappyPathLogin() {
        new HomePage( driver )
                .clickIDCTALink()
                .setEmailAddress( emailAddress )
                .clickSubmitButton()
                .setPassword( password )
                .clickSubmitButton();

        var loggedInPage = new LoggedInPage( driver );

        var expectedInitial = "" + emailAddress.toUpperCase().charAt( 0 );

        // this test verifies that the user is logged in
        Assert.assertTrue( loggedInPage.idctaLinkHasInitial( expectedInitial ) );
    }

}
