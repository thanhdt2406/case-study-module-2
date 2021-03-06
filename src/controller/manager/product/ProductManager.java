package controller.manager.product;

import controller.io.crawler.AccessoriesCrawler;
import controller.io.crawler.IPhoneCrawler;
import controller.io.crawler.TabletCrawler;
import controller.io.crawler.WatchCrawler;
import model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductManager implements IProductManager, SearchProduct {
    private static List<Product> productList = new ArrayList<>();
    private List<Product> iPhoneList;
    private List<Product> watchList;
    private List<Product> accessoriesList;
    private List<Product> tabletList;
    private static ProductManager productManager;

    private ProductManager() {
        crawlData();
        productList.addAll(iPhoneList);
        productList.addAll(watchList);
        productList.addAll(accessoriesList);
        productList.addAll(tabletList);
    }

    public static ProductManager getProductManager() {
        if (productManager == null) {
            productManager = new ProductManager();
        }
        return productManager;
    }

    private void crawlData() {
        IPhoneCrawler iphoneCrawler = new IPhoneCrawler();
        AccessoriesCrawler accessoriesCrawler = new AccessoriesCrawler();
        TabletCrawler tabletCrawler = new TabletCrawler();
        WatchCrawler watchCrawler = new WatchCrawler();
        iphoneCrawler.start();
        tabletCrawler.start();
        watchCrawler.start();
        accessoriesCrawler.start();
        try {
            iphoneCrawler.join();
            tabletCrawler.join();
            watchCrawler.join();
            accessoriesCrawler.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        iPhoneList = iphoneCrawler.getIPhoneList();
        tabletList = tabletCrawler.getTabletList();
        watchList = watchCrawler.getWatchList();
        accessoriesList = accessoriesCrawler.getAccessoriesList();
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public void showProducts() {
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            String productName = product.getName();
            if (productName.contains(name)) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public Product searchByID(int ID) {
        for (Product product : productList) {
            if (product.getProductID() == ID) {
                return product;
            }
        }
        return null;
    }
}
