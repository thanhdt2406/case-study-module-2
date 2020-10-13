package controller.storage;

import java.io.*;
import java.util.HashMap;

public class IOFileManager<T, E> {
    private static IOFileManager instance = new IOFileManager();
    private IOFileManager() {
    }

    public static IOFileManager getInstance(){
        if (instance == null){
            instance = new IOFileManager();
        }
        return instance;
    }

    public boolean isEmpty(String fileName){
        File file = new File(fileName);
        if(file.length()==0){
            return true;
        }
        return false;
    }
    public HashMap<T, E> readData(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        HashMap<T,E> map = (HashMap<T,E>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return map;
    }

    public void writeData(HashMap map, String fileName) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(map);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
