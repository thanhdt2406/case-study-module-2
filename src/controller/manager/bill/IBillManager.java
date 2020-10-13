package controller.manager.bill;

import model.Bill;

public interface IBillManager {
    void addBill(Bill bill);
    void showBill();
    boolean deleteBill(int ID);
    Bill searchBill(int id);
}
