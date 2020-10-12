package controller.manager.product;

import controller.io.crawler.AccessoriesCrawler;
import controller.io.crawler.IPhoneCrawler;
import controller.io.crawler.TabletCrawler;
import controller.io.crawler.WatchCrawler;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManager implements IProductManager {
    private List<Product> products;
    private List<Product> iPhoneList;
    private List<Product> watchList;
    private List<Product> accessoriesList;
    private List<Product> tabletList;
    private int numbersOfProduct;

    public ProductManager() {
        crawlData();
        products = new ArrayList<>();
        products.addAll(iPhoneList);
        products.addAll(watchList);
        products.addAll(accessoriesList);
        products.addAll(tabletList);
    }

    private void crawlData(){
        IPhoneCrawler iphoneCrawler = new IPhoneCrawler();
        iphoneCrawler.run();
        iPhoneList = iphoneCrawler.getIPhoneList();

        TabletCrawler tabletCrawler = new TabletCrawler();
        tabletCrawler.run();
        tabletList = tabletCrawler.getTabletList();

        WatchCrawler watchCrawler = new WatchCrawler();
        watchCrawler.run();
        watchList = watchCrawler.getWatchList();

        AccessoriesCrawler accessoriesCrawler = new AccessoriesCrawler();
        accessoriesCrawler.run();
        accessoriesList = accessoriesCrawler.getAccessoriesList();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setNumbersOfProduct(int numbersOfProduct) {
        this.numbersOfProduct = numbersOfProduct;
    }

    public int getNumbersOfProduct() {
        return numbersOfProduct;
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


}
