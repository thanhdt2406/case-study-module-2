package controller.manager.bill;

import controller.storage.IOFileManager;
import model.Bill;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

public class BillManager implements IBillManager, Serializable {
    private HashMap<Integer, Bill> billMap = new HashMap<>();
    public static BillManager billManager;
    private static int nextID = 0;


    private BillManager() {
        readData();
    }

    public static BillManager getBillManager(){
        if(billManager==null){
            billManager = new BillManager();
        }
        return billManager;
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
        readData();
        bill.setBillID(nextID);
        billMap.put(nextID++, bill);
        writeData();
    }

    @Override
    public void showBill() {
        readData();
        for (Bill bill : billMap.values()) {
            System.out.println(bill.toString()+"\n\n");
        }
        //System.out.println(billMap);
    }

    @Override
    public boolean deleteBill(int ID) {
        readData();
        System.out.println("delete bill");
        if (billMap.containsKey(ID)) {
            billMap.remove(ID);
            writeData();
            return true;
        }
        return false;
    }

    @Override
    public Bill searchBill(int id) {
        readData();
        return billMap.get(id);
    }

    public Bill searchByID(int ID) {
        readData();
        if (billMap.containsKey(ID)) {
            return billMap.get(ID);
        }
        return null;
    }
}
