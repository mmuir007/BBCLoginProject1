package orb.muir.bbc.tests;

import org.muir.bbc.util.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    protected String emailAddress;

    protected String password;

    public static final Parameters PARAMETERS = new Parameters();

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://www.bbc.com");

        emailAddress = PARAMETERS.getProperty( Parameters.PROPERTY_NAME_EMAIL_ADDRESS );
        password = PARAMETERS.getProperty( Parameters.PROPERTY_NAME_PASSWORD );
    }

    @AfterTest
    public void tearDown() {
        if ( null != driver ) {
            driver.quit();
        }
    }
}
