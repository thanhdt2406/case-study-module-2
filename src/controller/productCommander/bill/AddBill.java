package controller.productCommander.bill;

import controller.manager.bill.BillManager;
import controller.productCommander.Command;
import model.Bill;
import model.Product;

import java.util.List;

public class AddBill implements Command<Bill,Bill> {
    BillManager manager = BillManager.getBillManager();

    public AddBill(BillManager manager) {
        this.manager = manager;
    }

    @Override
    public Bill excuse(Bill bill) {
        manager.addBill(bill);
        return null;
    }
}
