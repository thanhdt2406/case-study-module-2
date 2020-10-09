package io;

import entity.Product;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataURLManager {
    private String getContentFromURL(String link) throws IOException {
        URL url = new URL(link);
        Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
        scanner.useDelimiter("\\Z");
        String content = scanner.next();
        scanner.close();
        content = content.replaceAll("\\n+", "");
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

    public List<Product> getData(String link, String productRegex, String priceRegax) throws IOException {
        List<String> listProductName = new ArrayList();
        List<String> listPrice = new ArrayList();
        listProductName = getDataFromContent(link, productRegex);
        listPrice = getDataFromContent(link, priceRegax);
        List<Product> listProduct = new ArrayList<>();
        for (int i = 0; i < listProductName.size(); i++) {
            listProduct.add(new Product(listProductName.get(i), Integer.parseInt(listPrice.get(i))));
        }
        return listProduct;
    }
}
