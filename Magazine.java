package domain;

public class Magazine extends LibraryItem {
    private int issueNumber;
    private double price;

    public Magazine(int id, String title, int year, int issueNumber, double price) {
        super(id, title, year);
        if (issueNumber <= 0 || price <= 0)
            throw new IllegalArgumentException("Issue number and price must be positive!");
        this.issueNumber = issueNumber;
        this.price = price;
    }

    public int getIssueNumber() { return issueNumber; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Magazine{" + super.toString() + ", issue=" + issueNumber + ", price=" + price + "}";
    }
}
