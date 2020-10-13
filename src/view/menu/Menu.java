package view.menu;

import controller.io.Inputer;
import controller.manager.product.ProductManager;
import controller.manager.user.UserManager;
import controller.productCommander.Comander;
import controller.productCommander.Command;
import controller.productCommander.product.SearchProductByName;
import controller.productCommander.product.ShowAllProduct;
import controller.productCommander.userAcount.AddUser;
import controller.productCommander.userAcount.ShowAllUser;

public class Menu {
    protected final String MAIN_MENU = "|--1. product management--|" +
            "\n|--2. User management--|" +
            "\n|--3. Exit-------------|";
    protected final String PRODUCT_MENU = "|--1. Add product" +
            "\n|--2. show products--|" +
            "\n|--3. Search by name--|" +
            "\n|--4. Exit------------|";
    protected final String USER_MENU = "|--1. Add user" +
            "\n|--2. show users";

    protected Inputer inputer = new Inputer();

    protected ProductManager productManager = new ProductManager();
    protected UserManager userManager = new UserManager();

    protected Command showAllProduct = new ShowAllProduct(productManager);
    protected Command searchProduct = new SearchProductByName(productManager);

    protected Command showAllUser = new ShowAllUser(userManager);
    protected Command addUser = new AddUser(userManager);

    protected controller.productCommander.Comander comander = new Comander(showAllProduct, searchProduct, addUser, showAllUser);
}
