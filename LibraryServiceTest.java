package service;

import domain.LibraryItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.LibraryRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceTest {
    private LibraryService service;

    @BeforeEach
    void setUp() {
        service = new LibraryService(new LibraryRepository<>());   // in-memory, no file
        service.addBook(1, "Ion", 1920, "Liviu Rebreanu", 450);
        service.addBook(2, "Clean Code", 2008, "Robert C. Martin", 464);
        service.addMagazine(3, "National Geographic", 2008, 12, 25.5);
        service.addMagazine(4, "Science", 2024, 7, 30.0);
    }

    @Test
    void filterPublishedAfter2000() {
        List<LibraryItem> result = service.filterPublishedAfter(2000);
        assertEquals(3, result.size());
        for (LibraryItem item : result)
            assertTrue(item.getYear() > 2000);
    }

    @Test
    void filterPublishedAfterIsStrict() {
        // 2008 itself is NOT "after 2008"
        List<LibraryItem> result = service.filterPublishedAfter(2008);
        assertEquals(1, result.size());
        assertEquals("Science", result.get(0).getTitle());
    }

    @Test
    void filterNothingMatches() {
        assertTrue(service.filterPublishedAfter(2026).isEmpty());
    }

    @Test
    void duplicateIdThrows() {
        assertThrows(IllegalArgumentException.class, () -> service.addBook(1, "X", 2000, "Y", 10));
    }
}
