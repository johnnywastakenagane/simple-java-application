package repository;

import domain.LibraryItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Generic repository; items stored in a Map with the id as key
public class LibraryRepository<T extends LibraryItem> {
    protected Map<Integer, T> items = new HashMap<>();   // protected -> the file subclass can use it

    public void add(T item) {
        if (items.containsKey(item.getId()))
            throw new IllegalArgumentException("An item with id " + item.getId() + " already exists!");
        items.put(item.getId(), item);
    }

    public List<T> getAll() {
        return new ArrayList<>(items.values());
    }
}
