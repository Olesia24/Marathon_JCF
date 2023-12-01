package practice.bookShop.dao;

import practice.bookShop.model.Book;

import java.util.TreeSet;

public class LibraryTreeSetImpl implements Library {

    private TreeSet<Book> bookTreeSet;
    int capacity;

    public LibraryTreeSetImpl(int capacity){
        this.capacity = capacity;
        this.bookTreeSet = new TreeSet<>();
    }

    @Override
    public boolean addBook(Book book) {
        return book != null && bookTreeSet.size()<capacity ? bookTreeSet.add(book) : false;
    }

    @Override
    public Book removeBook(int isbn) {
        Book removed = findBook(isbn);
        return bookTreeSet.removeIf(b ->b.getIsbn()==isbn) ? removed : null;
    }

    @Override
    public Book findBook(int isbn) {
        return bookTreeSet.stream()
                .filter(b ->b.getIsbn()==isbn)
                .findFirst()
                .orElse(null);
    }

    @Override
    public int quantityBook() {
        return bookTreeSet.size();
    }

    @Override
    public void printBook() {
        bookTreeSet.stream().forEach(System.out::println);
    }
}
