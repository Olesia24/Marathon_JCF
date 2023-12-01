package practice.bookShop.dao;

import practice.bookShop.model.Book;

import java.util.LinkedList;

public class LibraryLinkedListImpl implements Library {
    private LinkedList<Book> librariesList;
    private int capacity;

    public LibraryLinkedListImpl(int capacity){
        this.capacity = capacity;
        this.librariesList = new LinkedList<>();
    }

    @Override
    public boolean addBook(Book book) {
        if (book == null || librariesList.size() == capacity || findBook(book.getIsbn()) != null) {
            return false;
        }
        librariesList.add(book);
        return true;
    }

    @Override
    public Book removeBook(int isbn) {
        Book foundBook = findBook(isbn);
        if (foundBook != null){
            librariesList.remove(foundBook);
            }
        return foundBook;
    }

    @Override
    public Book findBook(int isbn) {
        for (Book book: librariesList) {
            if (book.getIsbn()==isbn){
                return book;
            }
        } return null;
    }

    @Override
    public int quantityBook() {
        return librariesList.size();
    }

    @Override
    public void printBook() {
        for (Book book:librariesList) {
            System.out.println(book);

        }

    }
}
