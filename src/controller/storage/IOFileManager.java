package controller.storage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class IOFileManager<T, E> {

    public HashMap<T, E> getData(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        HashMap<T,E> map = (HashMap<T,E>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return map;
    }

    public void updateData(HashMap map, String fileName) {
        
    }
}
