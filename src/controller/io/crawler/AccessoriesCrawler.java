package controller.io.crawler;

import model.Product;

import java.io.IOException;
import java.util.List;

public class AccessoriesCrawler extends CrawlerManager{
    public final String ACCESSORIES_URL = "https://clickbuy.com.vn/danh-muc/phu-kien/";
    private List<Product> accessoriesList;

    public List<Product> getAccessoriesList() {
        return accessoriesList;
    }

    public void setAccessoriesList(String link) throws IOException {
        AccessoriesCrawler accessoriesCrawler = new AccessoriesCrawler();
        accessoriesList = accessoriesCrawler.getData(link, productRegex, priceRegex);
    }

    @Override
    public void run() {
        try {
            setAccessoriesList(ACCESSORIES_URL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
