package manager.bill;

import entity.Bill;
import manager.IManager;

import java.util.HashMap;

public class BillManager implements IBillManager {
    private HashMap<Integer, Bill> billMap = new HashMap<>();
    private int key =0;
    public void addBill(Bill bill){
        billMap.put(key, bill);
        key++;
    }
    public void showBill(){
        for (Bill bill : billMap.values()){
            System.out.println(bill.toString());
        }
        System.out.println(billMap);
    }
}
