package controller.productCommander.bill;

import controller.manager.bill.BillManager;
import controller.productCommander.Command;

public class showAllBills implements Command {
    BillManager manager = new BillManager();

    public showAllBills(BillManager manager) {
        this.manager = manager;
    }

    @Override
    public Object excuse(Object o) {
        return null;
    }
}
