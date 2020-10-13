package controller.manager.bill;

import controller.storage.IOFileManager;
import model.Bill;

import java.io.IOException;
import java.util.HashMap;

public class BillManager implements IBillManager {
    private HashMap<Integer, Bill> billMap;

    public BillManager() {
        readData();
    }

    private void readData() {
        IOFileManager ioFileManager = IOFileManager.getInstance();
        if (ioFileManager.isEmpty("data/bill.dat")) {
            return;
        }
        try {
            billMap = ioFileManager.readData("data/bill.dat");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeData() {
        IOFileManager ioFileManager = IOFileManager.getInstance();
        try {
            ioFileManager.writeData(billMap, "data/bill.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBill(Bill bill) {
        billMap.put(bill.getBillID(), bill);
        writeData();
    }

    @Override
    public void showBill() {
        for (Bill bill : billMap.values()) {
            System.out.println(bill.toString());
        }
        System.out.println(billMap);
    }

    @Override
    public boolean deleteBill(int ID) {
        if (billMap.containsKey(ID)) {
            billMap.remove(ID);
            writeData();
            return true;
        }
        return false;
    }

    @Override
    public Bill searchBill(int id) {
        return billMap.get(id);
    }

    public Bill searchByID(int ID) {
        if (billMap.containsKey(ID)) {
            return billMap.get(ID);
        }
        return null;
    }
}
