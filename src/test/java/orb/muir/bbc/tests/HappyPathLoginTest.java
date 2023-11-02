package orb.muir.bbc.tests;

import org.muir.bbc.pageobjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HappyPathLoginTest extends BaseTest {

    @Test
    public void testHappyPathLogin() {
        var loggedInPage = new HomePage( driver )
                .clickIDCTALink()
                .setEmailAddress( emailAddress )
                .clickSubmitButton()
                .setPassword( password )
                .clickSubmitButton();

        var expectedInitial = "" + emailAddress.toUpperCase().charAt( 0 );

        // this test verifies that the user is logged in
        Assert.assertTrue(loggedInPage.idctaLinkHasInitial( expectedInitial ) );
    }

}
