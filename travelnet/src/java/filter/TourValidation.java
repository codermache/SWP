/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author pc
 */
public class TourValidation {

    public boolean checkTourTime(String xTime) throws ParseException {
        boolean check;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = formatter1.parse(xTime);
        check = (date.before(date1));
        return check;
    }

    public boolean checkVoucherTime(String xTime1, String xTime2) throws ParseException {
        boolean check;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = formatter1.parse(xTime1);
        Date date2 = formatter1.parse(xTime2);
        if (date.before(date1) == true || date1.after(date2) == true || date.after(date2) == true) {
            check = false;
        } else {
            check = true;
        }
        return check;
    }

    public boolean checkImage(String xIMage) {
        boolean check = true;
        int length = xIMage.length();

        if (xIMage.substring(0, 16).equalsIgnoreCase("image\\tour_image") == false) {
            System.out.println("Image source is wrong link");
            check = false;
        }
        if (xIMage.substring(length - 4, length).equalsIgnoreCase(".jpg") == false) {
            System.out.println("Image must be .jpg");
            check = false;
        }
        return check;
    }

    public boolean checkEmptyInput(String xInput) {
        boolean check = true;
        if (xInput.trim().length() == 0) {
            check = false;
        }
        return check;
    }

    public boolean checkNumber(int x) {
        boolean check = true;

        if (x > 0) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    public static void main(String[] args) throws ParseException {
        TourValidation u = new TourValidation();
        boolean check = u.checkNumber(-1);
        System.out.println(check);

    }
}
