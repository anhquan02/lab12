/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab12;

import java.util.ArrayList;

/**
 *
 * @author Mypc
 */
public class BookDAO implements ManagerDAO{

    public BookDAO() {
    }
    
    ArrayList<Book>lst = new ArrayList<>();
    @Override
    public void add(Book book) {
        this.lst.add(book);
    }

    @Override
    public void remove(int i) {
        this.lst.remove(i);
    }

    @Override
    public void update(Book book, int i) {
        Book bk = this.lst.get(i);
        bk.setName(book.getName());
        bk.setCost(book.getCost());
        bk.setDate(book.getDate());
        bk.setQuantities(book.getQuantities());
    }

    @Override
    public ArrayList<Book> arr() {
        return this.lst;
    }
    
}
