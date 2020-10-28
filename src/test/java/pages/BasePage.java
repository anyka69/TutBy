package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 20);
    }

    public abstract OnlineCinemaPage openPage(String URL);

    public abstract OnlineCinemaPage isPageOpened();
}
