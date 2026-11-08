package service;

import domain.BMI;
import domain.BP;
import domain.MedicalTest;
import domain.Status;
import repository.MedicalTestRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class MedicalTestSerive {
    private MedicalTestRepository<MedicalTest> repo;

    public MedicalTestSerive(MedicalTestRepository<MedicalTest> repo){
        this.repo = repo;
    }

    public void addBMI(String date, Status status, double value){
        repo.add(new BMI(date, status, value));
    }

    public void addBP(String date, Status status, int systolic, int diastolic){
        repo.add(new BP(date, status, systolic, diastolic));
    }

    public List<MedicalTest> getAllSorted(){
        List<MedicalTest> list = repo.getAll();
        Collections.sort(list);
        return list;
    }

    public List<MedicalTest> filter(Predicate<MedicalTest> predicate){
        List<MedicalTest> result = new ArrayList<>();
        for(MedicalTest a : repo.getAll()){
            if(predicate.test(a)){
                result.add(a);
            }
        }
        return result;
    }

    public List<MedicalTest> filterByStatus(Status status) {
        return filter(a -> a.getStatus() == status);
    }

    public boolean isEmpty(){
        return repo.getAll().isEmpty();
    }

}
