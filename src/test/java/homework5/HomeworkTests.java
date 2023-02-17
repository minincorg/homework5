package homework5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeworkTests extends AbstractHomeworkTests {
    //WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    @Test
    void checkNickname() {
        Assertions.assertEquals("minincorg", "minincorg");
    }

    @Test
    void test() throws InterruptedException {
        getDriver().get("https://www.livejournal.com");
        WebElement webElement1 = getDriver().findElement(By.xpath("//ul[@class=\"s-do\"]/li[4]/a"));
        WebElement webElement2 = getDriver().findElement(By.xpath("//*[@placeholder=\"Придумайте заголовок\"]"));
        WebElement webElement3 = getDriver().findElement(By.id("editorWrapper"));
        WebElement webElement4 = getDriver().findElement(By.xpath("//div[@class=\"compactButtons-0-2-127\"]/button"));

        webElement1.click();
        Thread.sleep(6000);
        webElement2.click();
        webElement2.sendKeys("Привет!");
        webElement3.click();
        webElement3.sendKeys("Привет!");
        webElement4.click();

    }

    @Test
    void voidElements(){
        WebElement selectElement = getDriver().findElement(By.xpath("//div[@class=\"s-header__nav\"]/ul/li[2]"));
        Select selectObject = new Select(selectElement);
        selectObject.selectByIndex(8);
        selectObject.selectByValue("friends");
        selectObject.selectByVisibleText("Друзья");
        selectObject.deselectAll();
    }

    @Test
    void test2() throws InterruptedException {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("href=\"https://minincorg.livejournal.com/\""));
        Assertions.assertTrue(getDriver().getTitle().contains("minincorg"), "Нет доступа к странице");

        Actions search = new Actions(getDriver());

        search.click(getDriver().findElement(By.xpath("//span[text() = \"О чем хотите рассказать сегодня?\"]")))
                .pause(1000l)
                .sendKeys(getDriver().findElement(By.xpath("//*[@placeholder=\"Придумайте заголовок\"]")), "Привет!")
                .pause(1000l)
                .sendKeys(getDriver().findElement(By.xpath("//div[@class=\"DraftEditor-editorContainer\"]/div")), "Привет!")
                .pause(1000l)
                .click(getDriver().findElement(By.xpath("//div[@class=\\\"compactButtons-0-2-127\\\"]/button")))
                .build()
                .perform();
        Thread.sleep(1000);

    }
}
