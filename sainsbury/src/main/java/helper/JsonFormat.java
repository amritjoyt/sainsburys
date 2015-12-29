package helper;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.math.BigDecimal;
import java.util.List;

public class JsonFormat {

    /**
     * @param productInfos list of products that need to be converted to json
     * @return json object of productInfos
     */
    public static JsonObject convertToJson(List<ProductInfo> productInfos) {
        JsonObject jsonObject = new JsonObject();
        JsonArray resultsArray = new JsonArray();
        BigDecimal totalUnitPrice = new BigDecimal(0);

        for (ProductInfo productInfo : productInfos) {
            resultsArray.add(createJsonObject(productInfo));
            totalUnitPrice = totalUnitPrice.add(productInfo.getBigDecimalUnit_price());
        }

        jsonObject.add("results", resultsArray);
        jsonObject.add("total", new JsonPrimitive(totalUnitPrice.toString()));

        return jsonObject;
    }

    /**
     * @param productInfo the product to convert to JsonObject
     * @return JsonObject of product
     */
    private static JsonObject createJsonObject(ProductInfo productInfo) {
        JsonObject jsonObject = new JsonObject();

        jsonObject.add("title", new JsonPrimitive(productInfo.getTitle()));
        jsonObject.add("size", new JsonPrimitive(productInfo.getSize()));
        jsonObject.add("unit_price", new JsonPrimitive(productInfo.getUnit_price()));
        jsonObject.add("description", new JsonPrimitive(productInfo.getDescription()));

        return jsonObject;
    }
}
