package scraper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ripeFruits.RipeFruitsConstants.RIPE_FRUITS_URL;

public class SafariScraperUTest {

    private SafariScraper scraper;

    @Before
    public void setUp() {
        scraper = new SafariScraper();
        scraper.connect(RIPE_FRUITS_URL);
    }

    @After
    public void tearDown() {
        scraper.close();
    }

    @Test
    public void testConnectedToRipeFruitsWebSite() {
        assertEquals(RIPE_FRUITS_URL, scraper.getCurrentUrl());
    }

    @Test
    public void testCorrectSizeOfUrlReturned() {
        assertEquals("84.42kb", scraper.getPageSizeInKb());
    }

}