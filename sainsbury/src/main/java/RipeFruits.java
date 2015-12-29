import com.google.gson.JsonObject;
import helper.JsonFormat;
import helper.ProductInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import scraper.SafariScraper;
import scraper.Scraper;

import java.util.ArrayList;
import java.util.List;

import static ripeFruits.RipeFruitsConstants.PRODUCT_INFO_CLASS_NAME;
import static ripeFruits.RipeFruitsConstants.PRODUCT_PRICE_CLASS_NAME;
import static ripeFruits.RipeFruitsConstants.PRODUCT_TEXT_CLASS_NAME;
import static ripeFruits.RipeFruitsConstants.RIPE_FRUITS_URL;

public class RipeFruits {

    private final String LINK_TAG = "href";
    private Scraper scraper;

    public RipeFruits() {
        scraper = new SafariScraper();
        scraper.connect(RIPE_FRUITS_URL);
    }

    public JsonObject scrapeRipeFruitsWebsite() {
        List<WebElement> prices = scraper.getElementsByClassName(PRODUCT_PRICE_CLASS_NAME);
        List<WebElement> links = scraper.getElementsByClassName(PRODUCT_INFO_CLASS_NAME);

        List<ProductInfo> productInfos = generateProductInfos(prices, links);

        scraper.close();

        return JsonFormat.convertToJson(productInfos);
    }

    private List<ProductInfo> generateProductInfos(List<WebElement> prices, List<WebElement> links) {
        List<ProductInfo> productInfos = new ArrayList<ProductInfo>();

        for (int i = 0; i < prices.size(); i++) {
            productInfos.add(createProductInfo(prices.get(i).getText(), links.get(i)));
        }

        return productInfos;
    }

    private ProductInfo createProductInfo(String unit_price, WebElement linkElement) {
        String title = linkElement.getText();

        Scraper linkScraper = new SafariScraper();
        linkScraper.connect(linkElement.findElement(By.linkText(title)).getAttribute(LINK_TAG));

        String size = linkScraper.getPageSizeInKb();
        String description = linkScraper.getElementByClassName(PRODUCT_TEXT_CLASS_NAME).getText();

        linkScraper.close();

        return new ProductInfo(title, size, unit_price, description);
    }

}