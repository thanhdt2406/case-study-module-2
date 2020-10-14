package controller.productCommander.bill;

import controller.manager.bill.BillManager;
import controller.productCommander.Command;
import model.Bill;

public class SearchBill implements Command<Bill, Integer> {
    BillManager manager = BillManager.getBillManager();

    public SearchBill(BillManager manager) {
        this.manager = manager;
    }

    @Override
    public Bill excuse(Integer id) {
       return manager.searchBill(id.intValue());
    }
}
