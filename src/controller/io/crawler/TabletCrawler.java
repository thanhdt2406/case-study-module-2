package controller.io.crawler;

import model.Product;

import java.io.IOException;
import java.util.List;

public class TabletCrawler extends CrawlerManager{
    private final String TABLET_URL = "https://clickbuy.com.vn/danh-muc/tablet/";
    private List<Product> tabletList;

    public List<Product> getTabletList() {
        return tabletList;
    }

    public void setTabletList(String link) throws IOException {
        TabletCrawler tabletCrawler = new TabletCrawler();
        tabletList = tabletCrawler.getData(link, productRegex, priceRegex);
    }

    @Override
    public void run() {
        try {
            setTabletList(TABLET_URL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
