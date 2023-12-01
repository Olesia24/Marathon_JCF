package practice.bookShop.dao;

import practice.bookShop.model.Book;

import java.util.HashSet;

public class LibraryHashSetImpl implements Library {
    private HashSet<Book> bookHashSet;
    int capacity;

    public LibraryHashSetImpl(int capacity){
        this.capacity = capacity;
        this.bookHashSet = new HashSet<>();
    }
    @Override
    public boolean addBook(Book book) {
        if (book == null || bookHashSet.size()==capacity){
            return false;
        }
        return bookHashSet.add(book);
    }

    @Override
    public Book removeBook(int isbn) {
        Book removed = findBook(isbn);
        bookHashSet.remove(removed);
        return removed;
    }

    @Override
    public Book findBook(int isbn) {
        for (Book book:bookHashSet) {
            if (book.getIsbn()==isbn){
                return book;
            }
        } return null;
    }

    @Override
    public int quantityBook() {
        return bookHashSet.size();
    }

    @Override
    public void printBook() {
        for (Book book:bookHashSet) {
            System.out.println(book);
        }
    }
}
