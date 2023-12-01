package practice.bookShop.dao;

import practice.bookShop.model.Book;

public interface Library {
    //добавить книгу;
    //удалить книгу;
    //найти книгу;
    //кол-во книг;
    //напечатать список книг.

    boolean addBook(Book book);
    Book removeBook(int isbn);
    Book findBook(int isbn);
    int quantityBook();
    void printBook();

}
