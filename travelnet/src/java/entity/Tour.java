/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author pc
 */
public class Tour {
    private int tour_id;
    private String tour_name;
    private int tour_category_id;
    private int number_of_days;
    private String status;
    private int capacity;
    private String introduction;
    private Date start_time;
    private String tour_image;
    private int tour_price;
    private int staff_id;
    private int vehicle_id;
    private int number_people;
    private User user;

    private ArrayList<Comment> comment = new ArrayList<>();

    public ArrayList<Comment> getComment() {
        return comment;
    }

    public void setComment(ArrayList<Comment> comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
//    private  Tour_category tour;

    public Tour(int tour_id, String tour_name, int tour_category_id, int number_of_days, String status, int capacity, String introduction, Date start_time, String tour_image, int tour_price, int staff_id, int vehicle_id, int number_people) {
        this.tour_id = tour_id;
        this.tour_name = tour_name;
        this.tour_category_id = tour_category_id;
        this.number_of_days = number_of_days;
        this.status = status;
        this.capacity = capacity;
        this.introduction = introduction;
        this.start_time = start_time;
        this.tour_image = tour_image;
        this.tour_price = tour_price;
        this.staff_id = staff_id;
        this.vehicle_id = vehicle_id;
        this.number_people = number_people;
    }

    public Tour() {
    }

    public int getTour_id() {
        return tour_id;
    }

    public void setTour_id(int tour_id) {
        this.tour_id = tour_id;
    }

    public String getTour_name() {
        return tour_name;
    }

    public void setTour_name(String tour_name) {
        this.tour_name = tour_name;
    }

    public int getTour_category_id() {
        return tour_category_id;
    }

    public void setTour_category_id(int tour_category_id) {
        this.tour_category_id = tour_category_id;
    }

    public int getNumber_of_days() {
        return number_of_days;
    }

    public void setNumber_of_days(int number_of_days) {
        this.number_of_days = number_of_days;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public String getTour_image() {
        return tour_image;
    }

    public void setTour_image(String tour_image) {
        this.tour_image = tour_image;
    }

    public int getTour_price() {
        return tour_price;
    }

    public void setTour_price(int tour_price) {
        this.tour_price = tour_price;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getNumber_people() {
        return number_people;
    }

    public void setNumber_people(int number_people) {
        this.number_people = number_people;
    }

   
}
