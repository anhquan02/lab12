/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
import lab12.Book;
import lab12.ManagerDAO;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mypc
 */
public class BookDBDAO implements ManagerDAO {

    String url = "jdbc:sqlserver://localhost:1433;databaseName=QLBK";
    ArrayList<Book> lst = new ArrayList<>();

    public BookDBDAO() {
        loadData();
    }

    @Override
    public void add(Book book) {
        try (Connection conn = DriverManager.getConnection(url, "sa", "123")) {
            PreparedStatement st = conn.prepareStatement("insert into Book values(?,?,?,?,?)");
            st.setInt(1, book.getID());
            st.setString(2, book.getName());
            st.setInt(3, book.getQuantities());
            st.setBigDecimal(4, book.getCost());
            long date = book.getDate().getTime();
            st.setDate(5, new Date(date));
            st.executeUpdate();
            lst.add(book);
            System.out.println("Thành công");
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void loadData() {
        try (Connection conn = DriverManager.getConnection(url, "sa", "123")) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from Book");
            while (rs.next()) {
                Book bk = new Book();
                bk.setID(rs.getInt(1));
                bk.setName(rs.getString(2));
                bk.setQuantities(rs.getInt(3));
                bk.setCost(rs.getBigDecimal(4));
                bk.setDate(rs.getDate(5));
                lst.add(bk);
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(int i) {
        try (Connection conn = DriverManager.getConnection(url, "sa", "123")) {
            PreparedStatement st = conn.prepareStatement("delete book where ID =?");
            st.setInt(1, lst.get(i).getID());
            st.executeUpdate();
            System.out.println("Thành công");
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Book book, int i) {
        try (Connection conn = DriverManager.getConnection(url, "sa", "123")) {
            PreparedStatement st = conn.prepareStatement("update book set name = ?,Quantities=?, Cost=?,PublishDay=? where id =?");
            st.setString(1, book.getName());
            st.setInt(2, book.getQuantities());
            st.setBigDecimal(3, book.getCost());
            long date = book.getDate().getTime();
            st.setDate(4, new Date(date));
            st.setInt(5, lst.get(i).getID());
            st.executeUpdate();
            System.out.println("Thành công");
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<Book> arr() {
        return lst;
    }

}
