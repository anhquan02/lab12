/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab12;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Mypc
 */
public class Book {

    private int ID;
    private String name;
    private int quantities;
    private BigDecimal cost;
    private Date date;

    public Book() {
    }

    public Book(int ID, String name, int quantities, BigDecimal cost, Date date) {
        this.ID = ID;
        this.name = name;
        this.quantities = quantities;
        this.cost = cost;
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantities() {
        return quantities;
    }

    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        DecimalFormat f = new DecimalFormat("###");
        String gia =f.format(cost);
        this.cost = new BigDecimal(gia);
    }

    public Date getDate() {
        return date;
    }

    public String getStringDate() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");       
        return f.format(this.date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Book{" + "ID=" + ID + ", name=" + name + ", quantities=" + quantities + ", cost=" + cost + ", date=" + date + '}';
    }

}
