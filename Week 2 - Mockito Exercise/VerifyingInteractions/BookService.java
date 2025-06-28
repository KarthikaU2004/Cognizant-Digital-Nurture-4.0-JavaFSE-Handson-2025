public class BookService {
    private LibraryDatabase db;

    public BookService(LibraryDatabase db) {
        this.db = db;
    }

    public boolean addBook(Book book) {
        if (book.getIsbn() == null || book.getIsbn().isEmpty()) return false;
        return db.addBook(book);
    }

    public Book getBook(String isbn) {
        return db.findBookByIsbn(isbn);
    }

    public boolean deleteBook(String isbn) {
        return db.removeBook(isbn);
    }
}
