package domain;

import java.io.Serializable;

public abstract class LibraryItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private int year;

    public LibraryItem(int id, String title, int year) {
        if (year > 2026)
            throw new IllegalArgumentException("Year cannot be after 2026!");
        this.id = id;
        this.title = title;
        this.year = year;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getYear() { return year; }

    @Override
    public String toString() {
        return "id=" + id + ", title=" + title + ", year=" + year;
    }
}
