package scraper;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface Scraper {

    /**
     * @param URL address to connect to
     */
    void connect(final String URL);

    /**
     * kill the scraper
     */
    void close();

    /**
     * @param className className of element to get from site
     * @return list of all className elements on current page
     */
    List<WebElement> getElementsByClassName(String className);

    /**
     * @param className className of element to get from site
     * @return the single WebElement
     */
    WebElement getElementByClassName(String className);

    /**
     * @return size of current webpage in kb
     */
    String getPageSizeInKb();
}
