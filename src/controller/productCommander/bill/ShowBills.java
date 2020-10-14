package controller.productCommander.bill;

import controller.manager.bill.BillManager;
import controller.productCommander.Command;


public class ShowBills implements Command {
    BillManager manager;

    public ShowBills(BillManager manager) {
        this.manager = manager;
    }

    @Override
    public Object excuse(Object o) {
        manager.showBill();
        return null;
    }
}
