package domain;

public class BP extends MedicalTest {
    private int systolic;
    private int diastolic;

    public BP(String date, Status status, int systolic, int diastolic){
        super(date, status);
        if(systolic <= 0 || diastolic <= 0){
            throw new IllegalArgumentException("values must be postiive");
        }
        this.systolic = systolic;
        this.diastolic = diastolic;
    }


    public int getSystolic(){
        return this.systolic;
    }

    public int getDiastolic(){
        return this.diastolic;
    }

    @Override
    public String toString(){
        return "BP: " + super.toString() + "systolic= " + systolic + "diastolic= " + diastolic;
    }
}
