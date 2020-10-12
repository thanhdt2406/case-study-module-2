package controller.productCommander;

import model.Product;
import model.User;

import java.util.HashMap;

public class userComander {
    private Command addProduct;
    private Command showAllProduct;
    private Command addUser;
    private Command showAllUser;
    private Command searchProductByName;

    public userComander(Command addProduct, Command showAllProduct, Command searchProductByName, Command addUser, Command showAllUser) {
        this.addProduct = addProduct;
        this.showAllProduct = showAllProduct;
        this.addUser = addUser;
        this.showAllUser = showAllUser;
        this.searchProductByName = searchProductByName;
    }

    public userComander(Command addProduct, Command showAllProduct) {
        this.addProduct = addProduct;
        this.showAllProduct = showAllProduct;
    }

    //    public userComander(Command showAllProduct, Command searchProductByName) {
//        this.showAllProduct = showAllProduct;
//        this.searchProductByName = searchProductByName;
//    }

    public void chooseAddProduct(Product product){
        addProduct.excuse(product);
    }

    public void chooseShowAllProduct(){
        showAllProduct.excuse(new Product());
    }

    public HashMap chooseSearchProductByName(String name){

        return searchProductByName.excuse(name);
    }

    public void chooseAddUser(User user){
        addUser.excuse(user);
    }

    public void chooseShowAllUser(){
        showAllUser.excuse(new User());
    }
}
