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
    private List<Product> products = new ArrayList<>();
    private List<Product> iPhoneList;
    private List<Product> watchList;
    private List<Product> accessoriesList;
    private List<Product> tabletList;
    private int nextID;

    public ProductManager() {
        crawlData();
        products.addAll(iPhoneList);
        products.addAll(watchList);
        products.addAll(accessoriesList);
        products.addAll(tabletList);
    }

    private void crawlData(){
        IPhoneCrawler iphoneCrawler = new IPhoneCrawler();
        AccessoriesCrawler accessoriesCrawler = new AccessoriesCrawler();
        TabletCrawler tabletCrawler = new TabletCrawler();
        WatchCrawler watchCrawler = new WatchCrawler();

        iphoneCrawler.start();
        tabletCrawler.start();
        watchCrawler.run();
        accessoriesCrawler.run();

        iPhoneList = iphoneCrawler.getIPhoneList();
        tabletList = tabletCrawler.getTabletList();
        watchList = watchCrawler.getWatchList();
        accessoriesList = accessoriesCrawler.getAccessoriesList();

    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getNextID() {
        nextID = products.get(products.size() - 1).getProductID();
        return nextID + 1;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void showProducts() {
        for (Product ele : products) {
            System.out.println(ele.toString());
        }
    }

    @Override
    public void updateProduct() {

    }

    @Override
    public void deleteProduct() {

    }


    @Override
    public HashMap<Integer, Product> searchByName(String name) {
        HashMap<Integer,Product> result = new HashMap<>();
        for (int i = 0; i < products.size(); i++) {
            String productName = products.get(i).getName();
            if (productName.contains(name)){
                result.put(i+1,products.get(i));
            }
        }
        return result;
    }

    @Override
    public Product searchByID(int id) {
        return null;
    }
}
