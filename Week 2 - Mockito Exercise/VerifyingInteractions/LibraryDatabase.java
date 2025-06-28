public interface LibraryDatabase {
    boolean addBook(Book book);
    Book findBookByIsbn(String isbn);
    boolean removeBook(String isbn);
}
