import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class SampleTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Setup WebDriverManager to download and configure ChromeDriver automatically
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        System.out.println("Page title is: " + driver.getTitle());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}