package controller.productCommander.bill;

import controller.manager.bill.BillManager;
import controller.productCommander.Command;

public class DeleteBill implements Command {
    BillManager manager = new BillManager();
    @Override
    public Object excuse(Object o) {
        return null;
    }
}
