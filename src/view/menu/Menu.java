package view.menu;

import controller.io.Inputer;
import controller.manager.bill.BillManager;
import controller.manager.product.ProductManager;
import controller.manager.user.UserManager;
import controller.productCommander.Comander;
import controller.productCommander.Command;
import controller.productCommander.bill.AddBill;
import controller.productCommander.product.SearchProductById;
import controller.productCommander.product.SearchProductByName;
import controller.productCommander.product.ShowAllProduct;
import controller.productCommander.userAcount.AddUser;
import controller.productCommander.userAcount.ShowAllUser;
import model.Product;

import java.util.List;

public class Menu {

    protected Inputer inputer = new Inputer();

    protected ProductManager productManager = ProductManager.getProductManager();
    protected UserManager userManager = UserManager.getUserManager();

    protected BillManager billManager = BillManager.getBillManager();


    protected Command showAllProduct = new ShowAllProduct(productManager);
    protected Command searchProductByName = new SearchProductByName(productManager);
    protected Command searchProductById = new SearchProductById(productManager);

    protected Command showAllUser = new ShowAllUser(userManager);
    protected Command addUser = new AddUser(userManager);

    protected Command addBill = new AddBill(billManager);

    protected controller.productCommander.Comander comander = new Comander(showAllProduct, searchProductByName, addUser, showAllUser, addBill, searchProductById);

    public void setSearchProductByName() {
        String name = inputer.inputString("Enter product name: ");
        List rs = comander.chooseSearchProductByName(name);
        System.out.println(rs.size() + " results found!");
        for (Object r : rs) {
            System.out.println(r.toString());
        }
    }

    public void setSearchProductById(){
        int productID = inputer.inputInt("Enter product id: ");
        Product rs = comander.chooseSearchProductByID(productID);
        System.out.println(rs.toString());
    }

}
