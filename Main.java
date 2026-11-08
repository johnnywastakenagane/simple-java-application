import domain.LibraryItem;
import repository.BinaryFileLibraryRepository;
import repository.LibraryRepository;
import service.LibraryService;
import ui.UI;

public class Main {
    public static void main(String[] args) {
        LibraryRepository<LibraryItem> repo = new BinaryFileLibraryRepository<>("library.bin");
        LibraryService service = new LibraryService(repo);

        if (service.isEmpty()) {
            service.addBook(1, "Ion", 1920, "Liviu Rebreanu", 450);
            service.addBook(2, "Clean Code", 2008, "Robert C. Martin", 464);
            service.addMagazine(3, "National Geographic", 2008, 12, 25.5);
            service.addMagazine(4, "Science", 2024, 7, 30.0);
        }

        new UI(service).run();
    }
}
