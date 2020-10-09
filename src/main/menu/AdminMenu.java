package main.menu;

import entity.Product;
import io.Inputer;
import manager.product.ProductManager;

public class AdminMenu {
    private final String MAIN_MENU = "|--1. product management--|" +
            "\n|--2. User management--|" +
            "\nYour choice:";
    private final String PRODUCT_MENU = "|--1. Add product" +
            "\n|--2. show products";
    private Inputer inputer = new Inputer();

    public AdminMenu() {
    }

    public void run() {
        System.out.println(MAIN_MENU);
        int choice = inputer.inputInt();
        while (choice !=  4){
            setUpMainMenu(choice);
            System.out.println(MAIN_MENU);
            choice = inputer.inputInt();
        }
    }

    public void setUpMainMenu(int choice) {
        switch (choice) {
            case 1:
                setUpProductMenu();
                break;
            case 2:
                setUpManageUserMenu();
                break;
            default:
        }
    }

    public void setUpProductMenu() {
        ProductManager managerProduct = new ProductManager();
        int choice = inputer.inputInt();
        System.out.println(PRODUCT_MENU);
        switch (choice){
            case 1:
                System.out.println("ten sp: ");
//                //sc.nextLine();
                String name = inputer.inputString();
                Product product = new Product(name);
                managerProduct.addProduct(product);
                break;
            case 2:
                managerProduct.showProducts();
                break;
            default:
        }

    }
    public void setUpManageUserMenu(){
//        UserManager userManager = new UserManager();
//        int choice = inputer.inputInt();
//        System.out.println(PRODUCT_MENU);
//        switch (choice){
//            case 1:
//                System.out.println("enter fullname user: ");
//                //sc.nextLine();
//                String name = inputer.inputString();
//                User user = new User(name);
//                userManager.addUser(user);
//                break;
//            case 2:
//                userManager.showAllUser();
//                break;
//            default:
//        }
    }
    public void setUpManageBillMenu(){
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
