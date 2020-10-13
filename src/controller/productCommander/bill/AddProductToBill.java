package controller.productCommander.bill;

import controller.productCommander.Command;
import model.Bill;
import model.Product;

public class AddProductToBill implements Command<Object,Product> {
    Bill bill = new Bill();

    public AddProductToBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public Object excuse(Product product) {
        bill.addProduct(product);
        return null;
    }
}
