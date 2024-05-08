/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constant;

/**
 *
 */
public class Constant {
    public static String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static String PHONE_REGEX = "[0][0-9]{9}";
    public static int COMMON_ROLE = 0;
    public static int ADMIN_ROLE = 1;
    public static int SELLER_ROLE = 2;
    public static int CUSTOMER_ROLE = 3;

    public static String commonUrl[] = {"/login", "/register", "/search", "/home", "/product"};
    public static String customerUrl[] = {"/faq", "/order", "/cart", "/checkout"};
    public static String sellerUrl[] = {"/listmanage", "/editproduct", "/ordermanage"};
    public static String adminUrl[] = {"/editfaq", "/faq", "/usermanage", "/adduser", "/edituser", "/deleteuser"};
    public static String allUrlString[][] = {
        commonUrl, adminUrl, sellerUrl, customerUrl
    };
}
