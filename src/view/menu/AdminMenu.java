package view.menu;

import model.Product;
import controller.io.Inputer;
import controller.manager.product.ProductManager;

public class AdminMenu {
    private final String MAIN_MENU = "|--1. product management--|" +
            "\n|--2. User management--|" +
            "\nYour choice:";
    private final String PRODUCT_MENU = "|--1. Add product" +
            "\n|--2. show products";
    private Inputer inputer = new Inputer();
    private ProductManager managerProduct = new ProductManager();

    public AdminMenu() {
    }

    public void run() {
        System.out.println(MAIN_MENU);
        int choice = inputer.inputInt();
        while (choice != 4){
            setUpMainMenu(choice);
            System.out.println(MAIN_MENU);
            choice = inputer.inputInt();
        }
    }

    public void setUpMainMenu(int choice) {
        switch (choice) {
            case 1:
                System.out.println(PRODUCT_MENU);
                int choice1 = inputer.inputInt();
                while (choice1 !=3){
                    setUpProductMenu(choice1);
                    System.out.println(PRODUCT_MENU);
                    choice1 = inputer.inputInt();
                }
                break;
            case 2:
                System.out.println(PRODUCT_MENU);
                choice1 = inputer.inputInt();
                while (choice1 !=3){
                   setUpManageUserMenu(choice1);
                    System.out.println(PRODUCT_MENU);
                    choice1 = inputer.inputInt();
                }

                break;
            default:
        }
    }

    public void setUpProductMenu(int choice) {

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
    public void setUpManageUserMenu(int choice){
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
