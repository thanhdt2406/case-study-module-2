package controller.productCommander.bill;

import controller.manager.bill.BillManager;
import controller.productCommander.Command;

public class DeleteBill implements Command<Void, Integer> {
    BillManager manager;
    public DeleteBill(BillManager manager) {
        this.manager = manager;
    }
    @Override
    public Void excuse(Integer id) {
        manager.deleteBill(id);
        return null;
    }
}
