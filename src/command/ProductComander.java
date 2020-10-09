package command;

import entity.Product;

public class ProductComander {
    private Command addProduct;
    private Command showAllProduct;

    public ProductComander(Command addProduct, Command showAllProduct) {
        this.addProduct = addProduct;
        this.showAllProduct = showAllProduct;
    }

    public void chooseAddProduct(){
        addProduct.excuse(new Product());
    }

    public void chooseShowAllProduct(){
        showAllProduct.excuse(new Product());
    }
}
