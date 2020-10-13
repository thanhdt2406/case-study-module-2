package controller.productCommander.bill;

import controller.manager.bill.BillManager;
import controller.productCommander.Command;

public class DeleteBill implements Command {
    BillManager billManager = BillManager.getBillManager();
    @Override
    public Object excuse(Object o) {
        return null;
    }
}
