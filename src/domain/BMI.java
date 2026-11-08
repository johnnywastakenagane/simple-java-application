package domain;

public class BMI extends MedicalTest {
    private double value;

    public BMI(String date, Status status, double value){
        super(date, status);

        if(value<=0){
            throw new IllegalArgumentException("value must be positive");
        }
        this.value = value;
    }

    public double getValue(){
        return this.value;
    }

    public String toString(){
        return "BMI: " + super.toString() + "value= " + value;
    }
}
