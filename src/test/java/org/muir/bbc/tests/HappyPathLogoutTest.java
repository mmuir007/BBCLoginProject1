package org.muir.bbc.tests;

import org.muir.bbc.pageobjects.HomePage;
import org.muir.bbc.pageobjects.LoggedInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HappyPathLogoutTest extends BaseTest {

    @Test
    public void testHappyPathLogout() {
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

        loggedInPage
                .clickIDCTALink()
                .clickSignOut();

        // this test verifies that the user is logged out
        Assert.assertFalse( loggedInPage.idctaLinkHasInitial( expectedInitial ) );
    }

}
