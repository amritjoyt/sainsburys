package scraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.math.BigDecimal;
import java.util.List;

public class SafariScraper implements Scraper {

    private WebDriver scraper = new SafariDriver();

    private final BigDecimal THOUSAND = BigDecimal.valueOf(1000);
    private final String KILO_BYTES = "kb";

    public void connect(String URL) {
        scraper.navigate().to(URL);
    }

    public void close() {
        scraper.quit();
    }

    public List<WebElement> getElementsByClassName(String className) {
        return scraper.findElements(By.className(className));
    }

    public WebElement getElementByClassName(String className) {
        return scraper.findElement(By.className(className));
    }

    public String getPageSizeInKb() {
        BigDecimal sizeInKiloBytes = new BigDecimal(scraper.getPageSource().getBytes().length).divide(THOUSAND);

        return sizeInKiloBytes.setScale(2, BigDecimal.ROUND_UP).toString() + KILO_BYTES;
    }

    protected String getCurrentUrl() {
        return scraper.getCurrentUrl();
    }
}
