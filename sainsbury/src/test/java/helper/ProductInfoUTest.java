package helper;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

public class ProductInfoUTest {
    private ProductInfo productInfo;

    @Test
    public void testCorrectBidDecimalReturned1() {
        productInfo = new ProductInfo("test", "1", "£2.30", "test fields");
        assertEquals(new BigDecimal(2.30).round(new MathContext(3, RoundingMode.HALF_UP)), productInfo.getBigDecimalUnit_price());
    }

    @Test
    public void testCorrectBidDecimalReturned2() {
        productInfo = new ProductInfo("test", "1", "£2.34", "test fields");
        assertEquals(new BigDecimal(2.34).round(new MathContext(3, RoundingMode.HALF_UP)), productInfo.getBigDecimalUnit_price());
    }

    @Test
    public void testCorrectBidDecimalReturned3() {
        productInfo = new ProductInfo("test", "1", "£2.37", "test fields");
        assertEquals(new BigDecimal(2.37).round(new MathContext(3, RoundingMode.HALF_UP)), productInfo.getBigDecimalUnit_price());
    }
}