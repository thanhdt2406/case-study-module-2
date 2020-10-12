package controller.io.crawler;

import model.Product;

import java.io.IOException;
import java.util.List;

public class WatchCrawler extends CrawlerManager{
    private final String WATCH_URL = "https://clickbuy.com.vn/danh-muc/dong-ho/";
    private List<Product> watchList;

    public List<Product> getWatchList() {
        return watchList;
    }

    public void setWatchList(String link) throws IOException {
        WatchCrawler watchCrawler = new WatchCrawler();
        watchList = watchCrawler.getData(link, productRegex, priceRegex);
    }

    @Override
    public void run() {
        try {
            setWatchList(WATCH_URL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
