package repository;

import domain.MedicalTest;

import java.util.ArrayList;
import java.util.List;

public class MedicalTestRepository<T extends MedicalTest> {
    protected List<T> items = new ArrayList<>();

    public void add(T item){
        items.add(item);
    }

    public List<T> getAll(){
        return new ArrayList<>(items);
    }
}
