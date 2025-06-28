import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Test
    public void testAddBook_ValidBook() {
        LibraryDatabase mockDb = mock(LibraryDatabase.class);
        Book book = new Book("12345", "Java Basics", "John");
        when(mockDb.addBook(book)).thenReturn(true);

        BookService service = new BookService(mockDb);
        boolean result = service.addBook(book);

        assertTrue(result);
        verify(mockDb).addBook(book);
    }

    @Test
    public void testAddBook_InvalidIsbn() {
        LibraryDatabase mockDb = mock(LibraryDatabase.class);
        Book book = new Book("", "No ISBN", "Author");

        BookService service = new BookService(mockDb);
        boolean result = service.addBook(book);

        assertFalse(result);
        verify(mockDb, never()).addBook(any());
    }

    @Test
    public void testGetBook() {
        LibraryDatabase mockDb = mock(LibraryDatabase.class);
        Book book = new Book("abc", "Mockito for Beginners", "Jane");
        when(mockDb.findBookByIsbn("abc")).thenReturn(book);

        BookService service = new BookService(mockDb);
        Book found = service.getBook("abc");

        assertNotNull(found);
        assertEquals("Mockito for Beginners", found.getTitle());
    }

    @Test
    public void testDeleteBook() {
        LibraryDatabase mockDb = mock(LibraryDatabase.class);
        when(mockDb.removeBook("del123")).thenReturn(true);

        BookService service = new BookService(mockDb);
        boolean deleted = service.deleteBook("del123");

        assertTrue(deleted);
        verify(mockDb).removeBook("del123");
    }
}
