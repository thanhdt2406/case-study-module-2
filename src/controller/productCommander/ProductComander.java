package controller.productCommander;

import model.Product;
import model.User;

public class ProductComander {
    private Command addProduct;
    private Command showAllProduct;
    private Command addUser;
    private Command showAllUser;

    public ProductComander(Command addProduct, Command showAllProduct, Command addUser, Command showAllUser) {
        this.addProduct = addProduct;
        this.showAllProduct = showAllProduct;
        this.addUser = addUser;
        this.showAllUser = showAllUser;
    }

    public ProductComander(Command addProduct, Command showAllProduct) {
        this.addProduct = addProduct;
        this.showAllProduct = showAllProduct;
    }

    public void chooseAddProduct(Product product){
        addProduct.excuse(product);
    }

    public void chooseShowAllProduct(){
        showAllProduct.excuse(new Product());
    }

    public void chooseAddUser(User user){
        addUser.excuse(user);
    }

    public void chooseShowAllUser(){
        showAllUser.excuse(new User());
    }
}
