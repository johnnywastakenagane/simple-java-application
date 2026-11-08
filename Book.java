package domain;

public class Book extends LibraryItem {
    private String author;
    private int pages;

    public Book(int id, String title, int year, String author, int pages) {
        super(id, title, year);
        if (pages <= 0)
            throw new IllegalArgumentException("Number of pages must be positive!");
        this.author = author;
        this.pages = pages;
    }

    public String getAuthor() { return author; }
    public int getPages() { return pages; }

    @Override
    public String toString() {
        return "Book{" + super.toString() + ", author=" + author + ", pages=" + pages + "}";
    }
}
