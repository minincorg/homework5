package homework5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class AbstractHomeworkTests {

    private static WebDriver driver;
    private static long time = 51;

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com");
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement webElement1 = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        WebElement webElement2 = driver.findElement(By.id("user"));
        WebElement webElement3 = driver.findElement(By.id("lj_loginwidget_password"));
        WebElement webElement4 = driver.findElement(By.name("action:login"));

        webElement1.click();
        webElement2.click();
        webElement2.sendKeys("minincorg");
        webElement3.click();
        webElement3.sendKeys("Aa12042003");
        webElement4.click();


    }

    @BeforeEach
    void goTo() {
        Assertions.assertDoesNotThrow(() -> driver.navigate().to("https://www.livejournal.com"),
                "Страница не доступна");
    }

    @AfterAll
    static void close() {
        //driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
