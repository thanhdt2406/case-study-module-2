package view.menu;

import model.Product;
import model.User;

import java.util.List;


public class AdminMenu extends Menu {

    public AdminMenu() {
    }

    public void run() {
        System.out.println(MAIN_MENU);
        int choice = inputer.inputInt("Your choice: ");
        while (choice != 4) {
            setUpMainMenu(choice);
            System.out.println(MAIN_MENU);
            choice = inputer.inputInt("Your choice: ");
        }
    }

    public void setUpMainMenu(int choice) {
        switch (choice) {
            case 1:
                System.out.println("1");
                System.out.println(PRODUCT_MENU);
                int choice1 = inputer.inputInt("Your choice: ");
                while (choice1 != 4) {
                    setUpProductMenu(choice1);
                    System.out.println(PRODUCT_MENU);
                    choice1 = inputer.inputInt("Your choice: ");
                }
                break;
            case 2:
                System.out.println("2");
                System.out.println(USER_MENU);
                choice1 = inputer.inputInt("Your choice: ");
                while (choice1 != 3) {
                    setUpManageUserMenu(choice1);
                    System.out.println(USER_MENU);
                    choice1 = inputer.inputInt("Your choice: ");
                }

                break;
            default:
                System.out.println("choose an option!");
        }
    }

    public void setUpProductMenu(int choice) {
        switch (choice) {
            case 1:
                String name = inputer.inputString("enter product name: ");
                int price = inputer.inputInt("enter price");
                Product product = new Product(productManager.getNextID(), name, price);
                break;
            case 2:
                comander.chooseShowAllProduct();
                break;
            case 3:
                name = inputer.inputString("Enter product name: ");
                List<Product> rs = comander.chooseSearchProductByName(name);
                System.out.println(rs.size()+" results found");
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
                String name = inputer.inputString("enter username: ");
                User user = new User(name);
                comander.chooseAddUser(user);
                break;
            case 2:
                comander.chooseShowAllUser();
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
