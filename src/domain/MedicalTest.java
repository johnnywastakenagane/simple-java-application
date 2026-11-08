package domain;

import java.io.Serializable;

public abstract class MedicalTest implements Serializable, Comparable<MedicalTest> {
    private static final long serialVersionUID = 1L;

    private String date;
    private Status status;

    public MedicalTest(String date,Status status){
        this.date = date;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public int compareTo(MedicalTest other){
        return this.date.compareTo(other.date);
    }

    @Override
    public String toString(){
        return "date =" + date + " status= " + status;
    }
}
