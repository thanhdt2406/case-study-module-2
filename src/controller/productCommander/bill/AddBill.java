package controller.productCommander.bill;

import controller.manager.bill.BillManager;
import controller.productCommander.Command;
import model.Bill;

public class AddBill implements Command<Bill,Bill> {
    BillManager billManager;

    public AddBill(BillManager billManager) {
        this.billManager = billManager;
    }

    @Override
    public Bill excuse(Bill bill) {
        billManager.addBill(bill);
        return null;
    }
}
