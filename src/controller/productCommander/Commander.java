package controller.productCommander;

import model.Bill;
import model.Product;
import model.User;

import java.util.List;

public class Commander {
    private Command addUser;
    private Command showAllUser;
    private Command deleteUser, updateUser;

    private Command showAllProduct;
    private Command searchProductByName;
    private Command searchProductByID;

    private Command addBill;
    private Command deleteBill;
    private Command showBill;
    private Command searchBill;
    private Command addProductToBill;


    public Commander(Command showAllProduct, Command searchProductByName, Command addUser, Command showAllUser, Command searchProductByID
    , Command deleteUser, Command updateUser) {
        this.showAllProduct = showAllProduct;
        this.addUser = addUser;
        this.showAllUser = showAllUser;
        this.searchProductByName = searchProductByName;
        this.searchProductByID = searchProductByID;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
    }

    public Commander( Command deleteBill, Command showBill, Command searchBill) {
        this.deleteBill = deleteBill;
        this.showBill = showBill;
        this.searchBill = searchBill;
    }

    public Commander(Command addProductToBill,Command addBill) {
        this.addBill = addBill;
        this.addProductToBill = addProductToBill;
    }

    public void chooseShowAllProduct() {
        showAllProduct.excuse(new Product());
    }
    public List<Product> chooseSearchProductByName(String name) {
        return (List<Product>) searchProductByName.excuse(name);
    }
    public Product chooseSearchProductByID(Integer id) {
        return (Product) searchProductByID.excuse(id);
    }

    public void chooseAddUser(User user) {
        addUser.excuse(user);
    }
    public void chooseShowAllUser() {
        System.out.println("choose show user");
        showAllUser.excuse(new User());
    }
    public void chooseDeleteUser(String username){
        deleteUser.excuse(username);
    }
    public void chooseUpdateUser(User user){
        updateUser.excuse(user);
    }


    public void chooseAddBill(Bill bill) {
        addBill.excuse(bill);
    }

    public void chooseDeleteBill(int id) {
        deleteBill.excuse(id);
    }

    public void chooseShowBill() {
        showBill.excuse(new Object());
    }

    public void chooseSearchBill(int id) {
        searchBill.excuse(id);
    }
    public void chooseAddProductToBill(Product product){
        addProductToBill.excuse(product);
    }

}
