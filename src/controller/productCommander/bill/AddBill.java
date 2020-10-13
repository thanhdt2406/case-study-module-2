package controller.productCommander.bill;

import controller.manager.bill.BillManager;
import controller.productCommander.Command;
import model.Product;

import java.util.List;

public class AddBill implements Command {
    BillManager manager = new BillManager();

    public AddBill(BillManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Product> excuse(Object o) {
        return null;
    }
}
