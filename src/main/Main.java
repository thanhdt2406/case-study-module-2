package main;

import command.AddProduct;
import command.Command;
import command.ProductComander;
import command.ShowAllProduct;
import manager.product.ProductManager;

public class Main {

    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        Command addProduct = new AddProduct(manager);
        Command showAllProduct = new ShowAllProduct(manager);

        ProductComander productComander = new ProductComander(addProduct,showAllProduct);

        productComander.chooseAddProduct();
        System.out.println("add2: ");
        productComander.chooseAddProduct();

        System.out.println("showww: ");
        productComander.chooseShowAllProduct();
    }
}
