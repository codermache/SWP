/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author win
 */
public class Validate {

    public String checkLengthName(String name) {
        if (name.length() > 20 || "".equals(name)) {
            return "Invalid";
        }
        return "Valid";
    }

    public String checkLengthAddress(String address) {
        if (address.length() > 255 || "".equals(address)) {
            return "Invalid";
        }
        return "Valid";
    }

    public String checkLengEmail(String email) {
        if (email.length() > 100 || email.equals("")) {
            return "Invalid";
        }
        return "Valid";
    }

    public String checkLengthPhoneNumber(String phone_number) {
        long checkPhone;
        if (phone_number.length() != 10) {
            try {
                checkPhone = Long.parseLong(phone_number);
            } catch (Exception e) {
                return "Invalid";
            }
        }
        return "Valid";
    }
}
