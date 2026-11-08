package ui;

import service.MedicalTestSerive;
import domain.Status;
import domain.MedicalTest;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class UI {
    private final MedicalTestSerive service;
    private final Scanner scanner = new Scanner(System.in);

    public UI(MedicalTestSerive service) {
        this.service = service;
    }

    public void run(){
        while(true){
            System.out.println("\n1. Add analysis\n2.Show all sorted by date\n3.Filter by status\n0.exit");
            String option = scanner.nextLine().trim();
            try{
                switch(option){
                    case"1" -> addAnalysis();
                    case "2" -> print(service.getAllSorted());
                    case "3" -> print(service.filterByStatus(readStatus()));
                    case "0" -> {return;}
                    default -> System.out.println("invalid");
                }
            }catch (IllegalArgumentException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addAnalysis() {
        System.out.print("Type (BMI/BP): ");
        String type = scanner.nextLine().trim().toUpperCase();
        System.out.print("Date (yyyy.mm.dd");
        String date = scanner.nextLine().trim();
        Status status = readStatus();

        if (type.equals("BMI")){
            System.out.print("value: ");
            double value = Double.parseDouble(scanner.nextLine().trim());
            service.addBMI(date, status, value);
        }else if(type.equals("BP")){
            System.out.print("Systolic: ");
            int sys = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Diastolci");
            int dia = Integer.parseInt(scanner.nextLine().trim());
            service.addBP(date, status, sys, dia);
        }else{
            System.out.println("Unknown type");
            return;
        }
        System.out.println("added");
    }

    private Status readStatus(){
        System.out.print("status (done/in_progress");
        return Status.valueOf(scanner.nextLine().trim().toUpperCase());
    }

    private void print(List<MedicalTest> list){
        if(list.isEmpty()) System.out.println("nothing to show");
        for(MedicalTest a : list) System.out.println(a);
    }

}
