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
public interface ManagerDAO {
    public void add(Book book);
    public void remove(int i);
    public void update(Book book,int i);
    public ArrayList<Book> arr();
}
