package controller.productCommander.bill;

import controller.manager.bill.BillManager;
import controller.productCommander.Command;

public class showAllBills implements Command {
    BillManager billManager = BillManager.getBillManager();

    public showAllBills(BillManager billManager) {
        this.billManager = billManager;
    }

    @Override
    public Object excuse(Object o) {
        return null;
    }
}
