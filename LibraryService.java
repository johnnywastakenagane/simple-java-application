package service;

import domain.Book;
import domain.LibraryItem;
import domain.Magazine;
import repository.LibraryRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class LibraryService {
    private final LibraryRepository<LibraryItem> repo;

    public LibraryService(LibraryRepository<LibraryItem> repo) {
        this.repo = repo;
    }

    public void addBook(int id, String title, int year, String author, int pages) {
        repo.add(new Book(id, title, year, author, pages));
    }

    public void addMagazine(int id, String title, int year, int issueNumber, double price) {
        repo.add(new Magazine(id, title, year, issueNumber, price));
    }

    // ascending by year, then alphabetically by title -> Comparator
    public List<LibraryItem> getAllSorted() {
        List<LibraryItem> list = repo.getAll();
        list.sort(Comparator.comparing(LibraryItem::getYear).thenComparing(LibraryItem::getTitle));
        return list;
    }

    public List<LibraryItem> filter(Predicate<LibraryItem> predicate) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : repo.getAll())
            if (predicate.test(item))
                result.add(item);
        return result;
    }

    public List<LibraryItem> filterPublishedAfter(int year) {
        return filter(item -> item.getYear() > year);
    }

    public boolean isEmpty() {
        return repo.getAll().isEmpty();
    }
}
