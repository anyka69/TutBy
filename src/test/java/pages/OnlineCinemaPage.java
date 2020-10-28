package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;


public class OnlineCinemaPage extends BasePage {
    public OnlineCinemaPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public OnlineCinemaPage openPage(String URL){
        driver.get(URL);
        isPageOpened();
        return this;
    }
    @Override
    public OnlineCinemaPage isPageOpened(){
        return this;
    }
    public OnlineCinemaPage onlineCinema(){
        driver.findElement(By.xpath("//*[contains (text(),'Афиша')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains (text(),'Онлайн-кинотеатры')]")));
        driver.findElement(By.xpath("//*[contains (text(),'Онлайн-кинотеатры')]")).click();
        return this;
    }
    public OnlineCinemaPage categorySelection(String categoryName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".filter.b-widget-tabs li")));
        List<WebElement> categories = driver.findElements(By.cssSelector(".filter.b-widget-tabs li"));

        for (WebElement category:categories) {
            if (category.findElement(By.cssSelector("a")).getText().equals(categoryName)) {
                category.click();
                break;
            }
        }

        return this;
    }
    public OnlineCinemaPage choiceOfGenre(String genreName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                (".tab-content.active .custom-select-holder button[title=\"Жанры\"]")));
        WebElement buttonGenre = driver.findElement(
                By.cssSelector(".tab-content.active .custom-select-holder button[title=\"Жанры\"]")
        );
        buttonGenre.click();
        List<WebElement> genres = driver.findElements
                (By.cssSelector(".tab-content.active .dropdown-menu.inner.selectpicker li"));

        for (WebElement genre:genres) {
            if (genre.findElement(By.className("text")).getText().equals(genreName)) {
                genre.click();
                break;
            }
        }

        driver.findElement(By.cssSelector("body")).click();
        List<WebElement> films = driver.findElements(By.cssSelector(".b-lists.list_afisha li"));

        for (WebElement film:films) {
            if (!film.findElement(By.cssSelector(".txt p")).getText().contains(genreName)) {
                Assert.fail("Присутствует недопустимый элемент");
            }
        }

        return this;
    }
}
