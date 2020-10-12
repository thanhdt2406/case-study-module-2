package controller.io.crawler;

import model.Product;

import java.io.IOException;
import java.util.List;

public class IPhoneCrawler extends CrawlerManager{
    private final String IPHONE_URL = "https://clickbuy.com.vn/danh-muc/iphone-moi-chinh-hang/";
    private List<Product> iPhoneList;

    public List<Product> getIPhoneList() {
        return iPhoneList;
    }

    public void setIPhoneList(String link) throws IOException {
        IPhoneCrawler iPhoneCrawler = new IPhoneCrawler();
        iPhoneList = iPhoneCrawler.getData(link, productRegex, priceRegex);
    }

    @Override
    public void run() {
        try {
            setIPhoneList(IPHONE_URL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
