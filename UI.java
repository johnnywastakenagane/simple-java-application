package ui;

import domain.LibraryItem;
import service.LibraryService;

import java.util.List;
import java.util.Scanner;

public class UI {
    private final LibraryService service;
    private final Scanner scanner = new Scanner(System.in);

    public UI(LibraryService service) {
        this.service = service;
    }

    public void run() {
        while (true) {
            System.out.println("\n1. Add item\n2. Show all (sorted)\n3. Show items published after a year\n0. Exit");
            String option = scanner.nextLine().trim();
            try {
                switch (option) {
                    case "1" -> addItem();
                    case "2" -> print(service.getAllSorted());
                    case "3" -> print(service.filterPublishedAfter(readInt("Year: ")));
                    case "0" -> { return; }
                    default -> System.out.println("Invalid option!");
                }
            } catch (IllegalArgumentException e) {      // also NumberFormatException
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addItem() {
        String type = readString("Type (book / magazine): ").toLowerCase();
        int id = readInt("Id: ");
        String title = readString("Title: ");
        int year = readInt("Year: ");
        if (type.equals("book")) {
            String author = readString("Author: ");
            int pages = readInt("Pages: ");
            service.addBook(id, title, year, author, pages);
        } else if (type.equals("magazine")) {
            int issue = readInt("Issue number: ");
            double price = Double.parseDouble(readString("Price: "));
            service.addMagazine(id, title, year, issue, price);
        } else {
            System.out.println("Unknown type!");
            return;
        }
        System.out.println("Added.");
    }

    private String readString(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    private int readInt(String message) {
        return Integer.parseInt(readString(message));
    }

    private void print(List<LibraryItem> list) {
        if (list.isEmpty()) System.out.println("Nothing to show.");
        for (LibraryItem item : list) System.out.println(item);
    }
}
