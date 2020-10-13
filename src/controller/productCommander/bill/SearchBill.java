package controller.productCommander.bill;

import controller.manager.bill.BillManager;
import controller.productCommander.Command;

public class SearchBill implements Command<Void, Integer> {
    BillManager manager = new BillManager();

    public SearchBill(BillManager manager) {
        this.manager = manager;
    }

    @Override
    public Void excuse(Integer id) {
        manager.searchBill(id.intValue());
        return null;
    }
}
