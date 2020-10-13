package view.menu;

import controller.io.Inputer;
import controller.manager.bill.BillManager;
import controller.manager.product.ProductManager;
import controller.manager.user.UserManager;
import controller.productCommander.Comander;
import controller.productCommander.Command;
import controller.productCommander.bill.AddBill;
import controller.productCommander.product.SearchProductByName;
import controller.productCommander.product.ShowAllProduct;
import controller.productCommander.userAcount.AddUser;
import controller.productCommander.userAcount.ShowAllUser;
import model.Product;

import java.util.List;

public class Menu {
    protected final String CUSTOMER_MENU = "|--1. Add user" +
            "\n|--2. show users" +
            "\n|--3. Exit";

    protected Inputer inputer = new Inputer();

    protected ProductManager productManager = ProductManager.getProductManager();
    protected UserManager userManager = new UserManager();
    protected BillManager billManager = new BillManager();

    protected Command showAllProduct = new ShowAllProduct(productManager);
    protected Command searchProduct = new SearchProductByName(productManager);

    protected Command showAllUser = new ShowAllUser(userManager);
    protected Command addUser = new AddUser(userManager);

    protected Command addBill = new AddBill(billManager);

    protected controller.productCommander.Comander comander = new Comander(showAllProduct, searchProduct, addUser, showAllUser, addBill);

    public void searchProduct() {
        String name = inputer.inputString("Enter product name: ");
        List<Product> rs = comander.chooseSearchProductByName(name);
        System.out.println(rs.size() + " results found");
        for (int i = 0; i < rs.size(); i++) {
            System.out.println(rs.get(i).toString());
        }
    }
}
