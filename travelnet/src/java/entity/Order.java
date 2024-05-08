/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author pc
 */
public class Order {
    private int order_id;   
    private int tour_id;
    private int user_id;
    private String cus_name;
    private String cus_phone;
    private String cus_email;
    private String cus_address;
    private String cus_note;
    private int voucher_id; 
    private double price;
    private Date order_time;
    private boolean status;

    
    
    
    public Order() {
    }

    
    public Order(int order_id, int tour_id, int user_id, String cus_name, String cus_phone, String cus_email, String cus_address, String cus_note, int voucher_id, double price, Date order_time, boolean status) {
        this.order_id = order_id;
        this.tour_id = tour_id;
        this.user_id = user_id;
        this.cus_name = cus_name;
        this.cus_phone = cus_phone;
        this.cus_email = cus_email;
        this.cus_address = cus_address;
        this.cus_note = cus_note;
        this.voucher_id = voucher_id;
        this.price = price;
        this.order_time = order_time;
        this.status = status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getTour_id() {
        return tour_id;
    }

    public void setTour_id(int tour_id) {
        this.tour_id = tour_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getCus_phone() {
        return cus_phone;
    }

    public void setCus_phone(String cus_phone) {
        this.cus_phone = cus_phone;
    }

    public String getCus_email() {
        return cus_email;
    }

    public void setCus_email(String cus_email) {
        this.cus_email = cus_email;
    }

    public String getCus_address() {
        return cus_address;
    }

    public void setCus_address(String cus_address) {
        this.cus_address = cus_address;
    }

    public String getCus_note() {
        return cus_note;
    }

    public void setCus_note(String cus_note) {
        this.cus_note = cus_note;
    }

    public int getVoucher_id() {
        return voucher_id;
    }

    public void setVoucher_id(int voucher_id) {
        this.voucher_id = voucher_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

   
   

}
