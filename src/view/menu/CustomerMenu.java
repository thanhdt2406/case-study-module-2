package view.menu;

import controller.productCommander.Command;
import controller.productCommander.Commander;
import controller.productCommander.bill.AddBill;
import controller.productCommander.bill.AddProductToBill;
import model.Bill;
import model.Product;
import model.User;

import java.time.LocalDate;
import java.util.List;


public class CustomerMenu extends Menu {
    private User customer = userManager.getCurrentUser();
    private Bill currentBill = customer.getCurrentBill();
    private Command addProductToBill = new AddProductToBill(currentBill);
    private Command addBill = new AddBill(billManager);

    private Commander billCommander = new Commander(addProductToBill, addBill);
    public CustomerMenu() {
    }

    public void run() {

        customer = userManager.getCurrentUser();
        String CUSTOMER_MENU =
                "\n|-------CUSTOMER MENU-------|" +
                        "\n|--1. Search product--------|" +
                        "\n|--2. Add product to cart---|" +
                        "\n|--3. Pay cart--------------|" +
                        "\n|--4. Show current cart-----|" +
                        "\n|--5. Edit account----------|" +
                        "\n|--6. Log out---------------|";
        int customerChoice;
        do {
            System.out.println("___________________________________________________");
            System.out.println(CUSTOMER_MENU);
            customerChoice = inputer.inputInt("Your choice: ");
            setupCustomerMenu(customerChoice);
        } while (customerChoice != 6);
    }

    public void setupCustomerMenu(int choice) {
        switch (choice) {
            case 1:
                int searchChoice;
                String SEARCH_MENU =
                        "\n|-----SEARCH MENU-----|" +
                                "\n|--1. Show products---|" +
                                "\n|--2. Search by name--|" +
                                "\n|--3. Search by ID----|" +
                                "\n|--4. Back------------|";
                do {
                    System.out.println("___________________________________________________");
                    System.out.println(SEARCH_MENU);
                    searchChoice = inputer.inputInt("Your choice: ");
                    setupSearchMENU(searchChoice);
                } while (searchChoice != 4);
                break;
            case 2:
                commander.chooseShowAllProduct();
                int id = inputer.inputInt("Enter product ID what you want to buy: ");
                Product product = getProduct(id);
                billCommander.chooseAddProductToBill(product);
                currentBill.setTotalPrice(currentBill.getTotalPrice() + product.getPrice());
                System.out.println("Done!");
                inputer.inputString("Press enter to continue...");
                break;
            case 3:
                currentBill.setUserName(customer.getUserName());
                currentBill.setDate(LocalDate.now());
                billCommander.chooseAddBill(currentBill);
                customer.setCurrentBill(new Bill());
                currentBill = customer.getCurrentBill();
                ((AddProductToBill) addProductToBill).setBill(currentBill);
                System.out.println("Done!");
                inputer.inputString("Press enter to continue...");
                break;
            case 4:
                List<Product> list = currentBill.getProductList();
                if (list.size() != 0) {
                    for (Product ele : list) {
                        System.out.println(ele.toString());
                    }
                } else {
                    System.out.println("Cart is empty now! :D");
                }
                inputer.inputString("Press enter to continue...");
                break;
            case 5:
                editUser(customer.getUserName());
                break;
            default:
                System.out.println("Choose an option!");
        }
    }

    public void setupSearchMENU(int choice) {
        switch (choice) {
            case 1:
                commander.chooseShowAllProduct();
                inputer.inputString("Press enter to continue...");
                break;
            case 2:
                searchProductByName();
                inputer.inputString("Press enter to continue...");
                break;
            case 3:
                searchProductById();
                inputer.inputString("Press enter to continue...");
                break;
            default:
                System.out.println("Choose an option!");
        }
    }
}
