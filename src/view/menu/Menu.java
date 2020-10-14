package view.menu;

import controller.io.validate.Inputer;
import controller.manager.bill.BillManager;
import controller.manager.product.ProductManager;
import controller.manager.user.UserManager;
import controller.productCommander.Commander;
import controller.productCommander.Command;
import controller.productCommander.bill.*;
import controller.productCommander.product.SearchProductById;
import controller.productCommander.product.SearchProductByName;
import controller.productCommander.product.ShowAllProduct;
import controller.productCommander.userAccount.AddUser;
import controller.productCommander.userAccount.DeleteUser;
import controller.productCommander.userAccount.ShowAllUser;
import controller.productCommander.userAccount.UpdateUser;
import model.Product;
import model.User;

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
    protected Command deleteUser = new DeleteUser(userManager);
    protected Command updateUser = new UpdateUser(userManager);

    protected Command deleteBill = new DeleteBill(billManager);
    protected Command showBill = new ShowBills(billManager);
    protected Command searchBill = new SearchBill(billManager);

    protected Commander commander = new Commander(showAllProduct, searchProductByName, addUser, showAllUser, searchProductById, deleteUser, updateUser);
    protected Commander billCommander = new Commander(deleteBill, showBill, searchBill);

    public Product getProduct(int ID) {
        List<Product> list = productManager.getProductList();
        Product product;
        product = null;
        for (Product product1 : list) {
            if (product1.getProductID() == ID) {
                product = product1;
            }
        }
        return product;
    }

    public void searchProductByName() {
        String name = inputer.inputString("Enter product name: ");
        List rs = commander.chooseSearchProductByName(name);
        System.out.println(rs.size() + " results found!");
        for (Object r : rs) {
            System.out.println(r.toString());
        }
    }

    public void searchProductById() {
        int productID = inputer.inputInt("Enter product ID: ");
        Product rs = commander.chooseSearchProductByID(productID);
        if (rs == null) {
            System.out.println("Not found product!");
            return;
        }
        System.out.println(rs.toString());
    }

    public boolean isExistUser(String userName) {
        UserManager userManager = UserManager.getUserManager();
        return userManager.getListUser().containsKey(userName) || userName.equals("admin");
    }

    public void editUser(String userName) {
        String password = inputer.inputString("Enter Password: ");
        String fullName = inputer.inputString("Enter your full name: ");
        int phoneNumber = inputer.inputInt("Enter your phone number: ");
        String address = inputer.inputString("Enter your address");

        User user = new User(userName, password, fullName, phoneNumber, address);
        commander.chooseUpdateUser(user);
    }

}
