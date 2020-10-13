package view.menu;

import controller.io.Inputer;
import controller.manager.bill.BillManager;
import controller.manager.product.ProductManager;
import controller.manager.user.UserManager;
import controller.productCommander.Commander;
import controller.productCommander.Command;
import controller.productCommander.bill.*;
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

    protected Command deleteBill = new DeleteBill(billManager);
    protected Command showBill = new ShowBills(billManager);
    protected Command searchBill = new SearchBill(billManager);

    protected Commander commander = new Commander(showAllProduct, searchProductByName, addUser, showAllUser, searchProductById);

    protected Commander billCommander = new Commander(deleteBill,showBill,searchBill);

    public Product getProduct(int id){
        List<Product> list = productManager.getProductList();
        Product product = new Product();
        product = null;
        for(Product ele : list){
            if (ele.getProductID() == id){
                product = ele;
            }
        }
        return product;
    }

    public void setSearchProductByName() {
        String name = inputer.inputString("Enter product name: ");
        List rs = commander.chooseSearchProductByName(name);
        System.out.println(rs.size() + " results found!");
        for (Object r : rs) {
            System.out.println(r.toString());
        }
    }

    public void setSearchProductById(){
        int productID = inputer.inputInt("Enter product id: ");
        Product rs = commander.chooseSearchProductByID(productID);
        System.out.println(rs.toString());
    }


}
