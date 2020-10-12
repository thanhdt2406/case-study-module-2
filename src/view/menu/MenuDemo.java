package view.menu;

import controller.io.Inputer;
import controller.manager.product.ProductManager;
import controller.productCommander.*;
import model.Product;
import model.User;


public class MenuDemo {
    private final String MAIN_MENU = "|--1. product management--|" +
            "\n|--2. User management--|" +
            "\nYour choice:";
    private final String PRODUCT_MENU = "|--1. Add product" +
            "\n|--2. show products";
    private final String USER_MENU = "|--1. Add user" +
            "\n|--2. show users";

    private Inputer inputer = new Inputer();

    private ProductManager manager = new ProductManager();

    private Command addProduct = new AddProduct(manager);
    private Command showAllProduct = new ShowAllProduct(manager);

    private ProductComander productComander = new ProductComander(addProduct, showAllProduct);

    public MenuDemo() {
    }

    public void run() {
        System.out.println(MAIN_MENU);
        int choice = inputer.inputInt();
        while (choice != 4) {
            setUpMainMenu(choice);
            System.out.println(MAIN_MENU);
            choice = inputer.inputInt();
        }
    }

    public void setUpMainMenu(int choice) {
        switch (choice) {
            case 1:
                System.out.println("1");
                System.out.println(PRODUCT_MENU);
                int choice1 = inputer.inputInt();
                while (choice1 != 3) {
                    setUpProductMenu(choice1);
                    System.out.println(PRODUCT_MENU);
                    choice1 = inputer.inputInt();
                }
                break;
            case 2:
                System.out.println("2");
                System.out.println(USER_MENU);
                choice1 = inputer.inputInt();
                while (choice1 != 3) {
                    setUpManageUserMenu(choice1);
                    System.out.println(USER_MENU);
                    choice1 = inputer.inputInt();
                }

                break;
            default:
        }
    }

    public void setUpProductMenu(int choice) {

        switch (choice) {
            case 1:
                System.out.println("enter product name: ");
                String name = inputer.inputString();
                System.out.println("enter price: ");
                int price = inputer.inputInt();
                Product product = new Product(manager.getNextID(),name,price);
                productComander.chooseAddProduct(product);
                break;
            case 2:
                productComander.chooseShowAllProduct();
                break;
            default:
        }

    }

    public void setUpManageUserMenu(int choice) {
        switch (choice) {
            case 1:

                System.out.println("enter username: ");
//                //sc.nextLine();
                String name = inputer.inputString();
                User user = new User(name);
                productComander.chooseAddUser(user);
                break;
            case 2:
                productComander.chooseShowAllUser();
                break;
            default:
        }
    }

    public void setUpManageBillMenu() {
//        ProductManager managerProduct = new ProductManager();
//        int choice = inputer.inputInt();
//        System.out.println(PRODUCT_MENU);
//        switch (choice){
//            case 1:
//                managerProduct.addProduct();
//                break;
//            case 2:
//                managerProduct.showProducts();
//                break;
//            default:
//        }
    }
}
