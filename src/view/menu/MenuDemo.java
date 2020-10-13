package view.menu;

import controller.io.Inputer;
import controller.manager.product.ProductManager;
import controller.manager.user.UserManager;
import controller.productCommander.*;
import controller.productCommander.product.SearchProductByName;
import controller.productCommander.product.ShowAllProduct;
import controller.productCommander.userAcount.AddUser;
import controller.productCommander.userAcount.ShowAllUser;
import model.Product;
import model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Set;


public class MenuDemo {
    private final String MAIN_MENU = "|--1. product management--|" +
            "\n|--2. User management--|" +
            "\n|--3. Exit-------------|" +
            "\nYour choice:";
    private final String PRODUCT_MENU = "|--1. Add product" +
            "\n|--2. show products--|" +
            "\n|--3. Search by name--|" +
            "\n|--4. Exit------------|";
    private final String USER_MENU = "|--1. Add user" +
            "\n|--2. show users";

    private Inputer inputer = new Inputer();

    private ProductManager productManager = new ProductManager();
    private UserManager userManager = new UserManager();

    private Command showAllProduct = new ShowAllProduct(productManager);
    private Command searchProduct = new SearchProductByName(productManager);

    private Command showAllUser = new ShowAllUser(userManager);
    private Command addUser = new AddUser(userManager);

    private userComander userComander = new userComander(showAllProduct, searchProduct, addUser, showAllUser);

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
                while (choice1 != 4) {
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
                System.out.println("choose an option!");
        }
    }

    public void setUpProductMenu(int choice) {

        switch (choice) {
            case 1:
                System.out.println("enter product name: ");
                String name = inputer.inputString();
                System.out.println("enter price: ");
                int price = inputer.inputInt();
                Product product = new Product(productManager.getNextID(), name, price);
                break;
            case 2:
                userComander.chooseShowAllProduct();
                break;
            case 3:
                System.out.println("Enter product name: ");
                name = inputer.inputString();
                List<Product> rs = userComander.chooseSearchProductByName(name);
                System.out.println(rs.size() + " results found");
                for(int i=0;i< rs.size();i++){
                    System.out.println(rs.get(i).toString());
                }
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
                userComander.chooseAddUser(user);
                break;
            case 2:
                userComander.chooseShowAllUser();
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
