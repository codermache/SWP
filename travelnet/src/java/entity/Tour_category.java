/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author pc
 */
public class Tour_category {
    private int tour_category_id;
    private String tour_category_name;
    private Tour tour;
    
        public Tour_category() {
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
    

//    public Tour_category(int tour_category_id, String tour_category_name) {
//        this.tour_category_id = tour_category_id;
//        this.tour_category_name = tour_category_name;
//    }

    public Tour_category(int tour_category_id, String tour_category_name, Tour tour) {
        this.tour_category_id = tour_category_id;
        this.tour_category_name = tour_category_name;
        this.tour = tour;
    }




    public int getTour_category_id() {
        return tour_category_id;
    }

    public void setTour_category_id(int tour_category_id) {
        this.tour_category_id = tour_category_id;
    }

    public String getTour_category_name() {
        return tour_category_name;
    }

    public void setTour_category_name(String tour_category_name) {
        this.tour_category_name = tour_category_name;
    }
    
}
