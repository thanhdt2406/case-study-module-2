package controller.io;

import model.Product;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataURLManager {
    public static String TABLET_URL = "https://clickbuy.com.vn/danh-muc/tablet/";
    public static String PHONE_URL = "https://clickbuy.com.vn/danh-muc/dien-thoai/";
    public static String WATCH_URL = "https://clickbuy.com.vn/danh-muc/dong-ho/";
    public static String IPHONE_URL = "https://clickbuy.com.vn/danh-muc/iphone-moi-chinh-hang/";
    public static String ACCESSORIES_URL = "https://clickbuy.com.vn/danh-muc/phu-kien/";
    public static String PRODUCT_REGEX = "woocommerce-loop-product__title\">(.*?)</h2>";
    public static String PRICE_REGEX = "woocommerce-Price-amount amount\">(.*?)&nbsp;";

    private String getContentFromURL(String link) throws IOException {
        URL url = new URL(link);
        Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
        scanner.useDelimiter("\\Z");
        String content = scanner.next();
        scanner.close();
        content = content.replaceAll("\\n+", "");
        content = content.replaceAll("[,]", "");
        content = content.replaceAll("&#8211;", "-");
        return content;
    }

    private List<String> getDataFromContent(String link, String regex) throws IOException {
        String content = getContentFromURL(link);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        List<String> data = new ArrayList<>();
        while (matcher.find()) {
            data.add(matcher.group(1));
        }
        return data;
    }

    public List<Product> getData(String link, String productRegex, String priceRegex) throws IOException {
        List<String> listProductName = new ArrayList();
        List<String> listPrice = new ArrayList();
        listProductName = getDataFromContent(link, productRegex);
        listPrice = getDataFromContent(link, priceRegex);
        List<Product> listProduct = new ArrayList<>();
        for (int i = 0; i < listProductName.size(); i++) {
            listProduct.add(new Product(i,listProductName.get(i), Integer.parseInt(listPrice.get(i))));
        }
        return listProduct;
    }
}
