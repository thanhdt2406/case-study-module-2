package main;

import command.AddProduct;
import command.Command;
import command.ProductComander;
import command.ShowAllProduct;
import entity.Product;
import io.Inputer;
import manager.product.ProductManager;

import entity.Product;
import io.DataURLManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {


        Inputer inputer = new Inputer();

        ProductManager manager = new ProductManager();

        Command addProduct = new AddProduct(manager);
        Command showAllProduct = new ShowAllProduct(manager);

        ProductComander productComander = new ProductComander(addProduct,showAllProduct);

        System.out.println("enter product name: ");
        String name = inputer.inputString();
        Product newP = new Product(name);
        productComander.chooseAddProduct(newP);
        System.out.println("add2: ");
        name = inputer.inputString();
        Product newP2 = new Product(name);
        productComander.chooseAddProduct(newP2);

        System.out.println("showww: ");
        productComander.chooseShowAllProduct();
    }
}
