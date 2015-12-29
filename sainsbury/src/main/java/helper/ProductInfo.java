package helper;

import java.math.BigDecimal;

public class ProductInfo {
    private String title;
    private String size;
    private String unit_price;
    private String description;

    public ProductInfo(String title, String size, String unit_price, String description) {
        this.title = title;
        this.size = size;
        this.unit_price = unit_price;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getSize() {
        return size;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public BigDecimal getBigDecimalUnit_price() {
        String price;
        price = unit_price.replace("£", "");
        price = price.replace("/unit", "");
        return new BigDecimal(price);
    }

    public String getDescription() {
        return description;
    }
}
