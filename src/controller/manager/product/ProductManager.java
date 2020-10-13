package controller.manager.product;

import controller.io.crawler.AccessoriesCrawler;
import controller.io.crawler.IPhoneCrawler;
import controller.io.crawler.TabletCrawler;
import controller.io.crawler.WatchCrawler;
import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ProductManager implements IProductManager, SearchProduct {
    private List<Product> productList = new ArrayList<>();
    private List<Product> iPhoneList;
    private List<Product> watchList;
    private List<Product> accessoriesList;
    private List<Product> tabletList;
    private int nextID;

    public ProductManager() {
        crawlData();
        productList.addAll(iPhoneList);
        productList.addAll(watchList);
        productList.addAll(accessoriesList);
        productList.addAll(tabletList);
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

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getNextID() {
        nextID = productList.get(productList.size() - 1).getProductID();
        return nextID + 1;
    }


    @Override
    public void showProducts() {
        for (Product ele : productList) {
            System.out.println(ele.toString());
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            String productName = productList.get(i).getName();
            if (productName.contains(name)) {
                result.add(productList.get(i));
            }
        }
        return result;
    }

    @Override
    public Product searchByID(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductID() == id) {
                return productList.get(i);
            }
        }
        return null;
    }
}
