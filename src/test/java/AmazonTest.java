import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class AmazonTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void navigateToAmazon() {
        // Navigate to Amazon homepage before each test
        driver.get("https://www.amazon.com/");
    }
    @Test(priority = 1)
    public void loginTest() {
        // Click on Sign-in button
        WebElement signInButton = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        signInButton.click();

        // Enter email/phone number
        WebElement emailField = driver.findElement(By.id("ap_email"));
        emailField.sendKeys("your_email@example.com");
        // Click continue
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        // Enter password
        WebElement passwordField = driver.findElement(By.id("ap_password"));
        passwordField.sendKeys("your_password");

        // Click Sign-In
        WebElement loginButton = driver.findElement(By.id("signInSubmit"));
        loginButton.click();
        // Assertion to confirm login by checking account name
        WebElement accountName = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Assert.assertTrue(accountName.getText().contains("Your Name"), "Login Failed!");
    }
    @Test(priority = 2, dependsOnMethods = "loginTest")
    public void addToCartTest() {
        // Search for a product
        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
        searchBar.sendKeys("Laptop");
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        // Click on the first product
        WebElement firstProduct = driver.findElement(By.cssSelector("span.a-size-medium"));
        firstProduct.click();
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // Assertion to confirm product was added to cart
        WebElement cartConfirmation = driver.findElement(By.cssSelector("span#nav-cart-count"));
        Assert.assertNotEquals(cartConfirmation.getText(), "0", "Add to Cart Failed!");
    }
    @AfterMethod
    public void logout() {
        // Logout after each test
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        accountList.click();

        WebElement signOutButton = driver.findElement(By.xpath("//span[text()='Sign Out']"));
        signOutButton.click();
    }
    @AfterClass
    public void tearDown() {
        // Quit the browser session
        if (driver != null) {
            driver.quit();
        }
    }
}



