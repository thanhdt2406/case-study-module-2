package main;

<<<<<<< HEAD
import command.AddProduct;
import command.Command;
import command.ProductComander;
import command.ShowAllProduct;
import manager.product.ProductManager;
=======
import entity.Product;
import io.DataURLManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
>>>>>>> 600425c260a7ee53f2b4da56c8e14969e84ebfb0

public class Main {

    public static void main(String[] args) {
<<<<<<< HEAD
        ProductManager manager = new ProductManager();

        Command addProduct = new AddProduct(manager);
        Command showAllProduct = new ShowAllProduct(manager);

        ProductComander productComander = new ProductComander(addProduct,showAllProduct);

        productComander.chooseAddProduct();
        System.out.println("add2: ");
        productComander.chooseAddProduct();

        System.out.println("showww: ");
        productComander.chooseShowAllProduct();
=======


>>>>>>> 600425c260a7ee53f2b4da56c8e14969e84ebfb0
    }
}
