package repository;

import domain.LibraryItem;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BinaryFileLibraryRepository<T extends LibraryItem> extends LibraryRepository<T> {
    private final String fileName;

    public BinaryFileLibraryRepository(String fileName) {
        this.fileName = fileName;
        loadFromFile();
    }

    @Override
    public void add(T item) {
        super.add(item);     // throws if duplicate -> then we don't save
        saveToFile();
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        File file = new File(fileName);
        if (!file.exists()) return;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            items = (Map<Integer, T>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Could not load file: " + e.getMessage());
            items = new HashMap<>();
        }
    }

    private void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(items);      // HashMap is Serializable
        } catch (IOException e) {
            System.out.println("Could not save file: " + e.getMessage());
        }
    }
}
