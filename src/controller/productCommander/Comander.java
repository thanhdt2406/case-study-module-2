package controller.productCommander;

import model.Product;
import model.User;

import java.util.List;

public class Comander {
    private Command showAllProduct;
    private Command addUser;
    private Command showAllUser;
    private Command searchProductByName;
    private Command addBill;

    public Comander(Command showAllProduct, Command searchProductByName, Command addUser, Command showAllUser, Command addBill) {
        this.showAllProduct = showAllProduct;
        this.addUser = addUser;
        this.showAllUser = showAllUser;
        this.searchProductByName = searchProductByName;
        this.addBill = addBill;
    }

    public Comander(Command showAllProduct) {
        this.showAllProduct = showAllProduct;
    }


    public void chooseShowAllProduct(){
        showAllProduct.excuse(new Product());
    }

    public List<Product> chooseSearchProductByName(String name){

        return (List<Product>) searchProductByName.excuse(name);
    }

    public void chooseAddUser(User user){
        addUser.excuse(user);
    }

    public void chooseShowAllUser(){
        System.out.println("choose show user");
        showAllUser.excuse(new User());
    }
}
