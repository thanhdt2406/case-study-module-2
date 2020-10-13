package controller.manager.bill;

import controller.storage.IOFileManager;
import model.Bill;

import java.io.IOException;
import java.util.HashMap;

public class BillManager {
    private HashMap<Integer, Bill> billMap;

    public BillManager() {
        readData();
    }

    private void readData() {
        IOFileManager ioFileManager = new IOFileManager();
        try {
            billMap = ioFileManager.readData("data/listBill.dat");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeData() {
        IOFileManager ioFileManager = new IOFileManager();
        try {
            ioFileManager.writeData(billMap, "data/listBill.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBill(Bill bill) {
        billMap.put(bill.getBillID(), bill);
        writeData();
    }

    public void showBill() {
        for (Bill bill : billMap.values()) {
            System.out.println(bill.toString());
        }
        System.out.println(billMap);
    }

    public boolean deleteBill(int ID){
        if(billMap.containsKey(ID)){
            billMap.remove(ID);
            writeData();
            return true;
        }
        return false;
    }


}
