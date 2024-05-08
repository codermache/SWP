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
public class Voucher {
    private int voucher_id;
    private String voucher_name;
    private int quantity;
    private int discount;
    private Date create_date;
    private Date end_date;
    private boolean status;
    private String description;
    private int point;

    public Voucher() {
    }

    public Voucher(int voucher_id, String voucher_name, int quantity, int discount, Date create_date, Date end_date, boolean status, String description, int point) {
        this.voucher_id = voucher_id;
        this.voucher_name = voucher_name;
        this.quantity = quantity;
        this.discount = discount;
        this.create_date = create_date;
        this.end_date = end_date;
        this.status = status;
        this.description = description;
        this.point = point;
    }

    public int getVoucher_id() {
        return voucher_id;
    }

    public void setVoucher_id(int voucher_id) {
        this.voucher_id = voucher_id;
    }

    public String getVoucher_name() {
        return voucher_name;
    }

    public void setVoucher_name(String voucher_name) {
        this.voucher_name = voucher_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

  
    }
