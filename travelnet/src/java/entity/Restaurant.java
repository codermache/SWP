/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author User
 */
public class Restaurant {
    private int res_id;
    private String res_name;
    private Place place;
    private int average_price;
    private String introduction;
    private String res_address;
    private String res_phone;
    private String res_image;
    private int res_rate;

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }

    public String getRes_name() {
        return res_name;
    }

    public void setRes_name(String res_name) {
        this.res_name = res_name;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public int getAverage_price() {
        return average_price;
    }

    public void setAverage_price(int average_price) {
        this.average_price = average_price;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getRes_address() {
        return res_address;
    }

    public void setRes_address(String res_address) {
        this.res_address = res_address;
    }

    public String getRes_phone() {
        return res_phone;
    }

    public void setRes_phone(String res_phone) {
        this.res_phone = res_phone;
    }

    public String getRes_image() {
        return res_image;
    }

    public void setRes_image(String res_image) {
        this.res_image = res_image;
    }

    public int getRes_rate() {
        return res_rate;
    }

    public void setRes_rate(int res_rate) {
        this.res_rate = res_rate;
    }
    
}
