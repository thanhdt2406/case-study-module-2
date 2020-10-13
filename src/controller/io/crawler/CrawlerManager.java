package controller.io.crawler;

import model.Product;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class CrawlerManager extends Thread {
    public final String productRegex = "woocommerce-loop-product__title\">(.*?)</h2>";
    public final String priceRegex = "woocommerce-Price-amount amount\">(.*?)&nbsp;";
    private static int ID = 0;

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
        List<String> listProductName = getDataFromContent(link, productRegex);
        List<String> listPrice = getDataFromContent(link, priceRegex);
        List<Product> listProduct = new ArrayList<>();
        for (int i = 0; i < listProductName.size(); i++,ID++) {
            listProduct.add(new Product(ID,listProductName.get(i), Integer.parseInt(listPrice.get(i))));
        }
        return listProduct;
    }

    @Override
    public abstract void run();
}
