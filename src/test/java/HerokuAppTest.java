import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class HerokuAppTest {

    @BeforeClass
    public void setup() {
        // Explicitly set up the ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Configure Selenide
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 6000;
    }

    @Test
    public void testLinkPresence() {
        Configuration.startMaximized = true;
        open("http://the-internet.herokuapp.com/");

        $$("a").findBy(text("A/B Testing")).shouldBe(visible);
    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
