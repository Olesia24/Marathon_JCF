package practice.bookShop.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.bookShop.dao.Library;
import practice.bookShop.dao.LibraryTreeSetImpl;
import practice.bookShop.model.Book;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryImplTest {

    Library library;
    Book[] books;

    @BeforeEach
    void setUp() {
        library = new LibraryTreeSetImpl(6);
        books= new Book[5];
            books[0] = new Book(9234, "Gustave Flaubert", "Madame Bovary", 1856);
            books[1] = new Book(4321, "Leo Tolstoy", "War and Peace", 1869);
            books[2] = new Book(2345, "Homer", "Odyssey", 1614);
            books[3] = new Book(5432, "Vladimir Nabokov", "Lolita", 1955);
            books[4] = new Book(6789, "Fyodor Dostoyevsky", "The Brothers Karamazov", 1880);

            for (int i = 0; i <books.length ; i++) {
            library.addBook(books[i]);
        }
    }
    @Test
    void addBookTest() {
        assertFalse(library.addBook(null));
        assertFalse(library.addBook(books[1]));
        Book book1 = new Book(777, "Fitzgerald", "The Great Gatsby", 1925);
        assertTrue(library.addBook(book1));
        Book book2 = new Book(8888, "Fitzgerald", "The Great Gatsby", 1925);
        assertFalse(library.addBook(book2));
        assertEquals(6, library.quantityBook());
        library.printBook();
    }
    @Test
    void removeBookTest() {
        assertEquals(books[0], library.removeBook(9234));
        assertEquals(4, library.quantityBook());
    }
    @Test
    void findBookTest() {
        assertEquals(books[1], library.findBook(4321));
        System.out.println(books[1]);
    }
    @Test
    void quantityBookTest() {
        assertEquals(5, library.quantityBook());
    }
    @Test
    void printBookTest() {
        library.printBook();
    }
    @Test
    void sortBooksByIsbn(){
        Arrays.sort(books, (b1, b2)-> Integer.compare(b1.getIsbn(), b2.getIsbn()));
        sortArray(books);
    }
    @Test
    void sortBooksByAuthor(){
        Arrays.sort(books, (b1, b2)-> b1.getAutor().compareTo(b2.getAutor()));
        sortArray(books);
    }
    private static void sortArray(Object[] arr){
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
}