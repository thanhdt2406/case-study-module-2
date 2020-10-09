package view;

import controller.command.AddProduct;
import controller.command.Command;
import controller.command.ProductComander;
import controller.command.ShowAllProduct;
import model.Product;
import controller.io.Inputer;
import controller.manager.product.ProductManager;


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
