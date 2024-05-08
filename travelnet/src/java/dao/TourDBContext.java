/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Tour;
import entity.Tour_category;
import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class TourDBContext extends DBContext<Tour> {

    public int getTotalTour() {
        try {
            String sql = "select count(*) from Tour";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {

        }
        return 0;
    }

    public List<Tour> pagingTour(int index) {
        List<Tour> list = new ArrayList<>();
        String sql = "SELECT * FROM Tour\n"
                + "ORDER BY tour_id\n"
                + "OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, (index - 1) * 3);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Tour q = new Tour();
                q.setTour_id(rs.getInt("tour_id"));
                q.setTour_name(rs.getString("tour_name"));
                q.setTour_category_id(rs.getInt("tour_category_id"));
                q.setNumber_of_days(rs.getInt("number_of_days"));
                q.setStatus(rs.getString("status"));
                q.setCapacity(rs.getInt("capacity"));
                q.setIntroduction(rs.getString("introduction"));
                q.setStart_time(rs.getDate("start_time"));
                q.setTour_image(rs.getString("tour_image"));
                q.setTour_price(rs.getInt("tour_price"));
                q.setStaff_id(rs.getInt("staff_id"));
                q.setVehicle_id(rs.getInt("vehicle_id"));

                list.add(q);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Tour> listTour() {
        List<Tour> list = new ArrayList<>();
        String sql = "SELECT * \n"
                + "FROM Tour t\n"
                + "left join Tour_category tr on t.tour_category_id = tr.tour_category_id";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
//                list.add(new Tour(rs.getInt(1),
//                        rs.getString(2),
//                        rs.getInt(3),
//                        rs.getInt(4),
//                        rs.getString(5),
//                        rs.getInt(6),
//                        rs.getString(7),
//                        rs.getDate(8),
//                        rs.getString(9),
//                        rs.getInt(10),
//                        rs.getInt(11),
//                        rs.getInt(12)));

                Tour q = new Tour();
                q.setTour_id(rs.getInt("tour_id"));
                q.setTour_name(rs.getString("tour_name"));
                q.setTour_category_id(rs.getInt("tour_category_id"));
                q.setNumber_of_days(rs.getInt("number_of_days"));
                q.setStatus(rs.getString("status"));
                q.setCapacity(rs.getInt("capacity"));
                q.setIntroduction(rs.getString("introduction"));
                q.setStart_time(rs.getDate("start_time"));
                q.setTour_image(rs.getString("tour_image"));
                q.setTour_price(rs.getInt("tour_price"));
                q.setStaff_id(rs.getInt("staff_id"));
                q.setVehicle_id(rs.getInt("vehicle_id"));

                list.add(q);

            }
        } catch (SQLException e) {
        }
        return list;
    }

//    public static void main(String[] args){
//        TourDBContext tour = new TourDBContext();
//        List<Tour> list = tour.pagingTour(2);
//        for (Tour tour1 : list) {
//            System.out.println("uu"+ tour1.getStatus());   
//        }    
//    }
//    public static void main(String[] args) {
//        TourDBContext tour = new TourDBContext();
//        int count = tour.getTotalTour();
//        System.out.println(count);
//    }
//     private int order_id;
//    private int tour_id;
//    private int user_id;
//    private int voucher_id;
//    private int price;
//    private Date order_time;
//    private boolean status;
    @Override
    public void insert(Tour model) {

    }

    @Override
    public void update(Tour model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Tour model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Tour get(int id) {
        Tour tour = new Tour();
        try {
            String sql = "SELECT * \n"
                    + "FROM Tour t\n"
                    + "left join Tour_category tr on t.tour_category_id = tr.tour_category_id\n"
                    + "where tour_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
//                Tour_category tr = new Tour_category();
//                int t= rs.getInt("tour_category_id");
//                tr.setTour_category_name(rs.getString("tour_category_name"));
                tour.setTour_id(rs.getInt("tour_id"));
                tour.setTour_name(rs.getString("tour_name"));
                tour.setTour_category_id(rs.getInt("tour_category_id"));
                tour.setTour_image(rs.getString("tour_image"));
                tour.setVehicle_id(rs.getInt("vehicle_id"));
                tour.setCapacity(rs.getInt("capacity"));
                tour.setStart_time(rs.getDate("start_time"));
                tour.setNumber_of_days(rs.getInt("number_of_days"));
                tour.setStaff_id(rs.getInt("staff_id"));
                tour.setTour_price(rs.getInt("tour_price"));
                tour.setIntroduction(rs.getString("introduction"));
                tour.setStatus(rs.getString("status"));
            }
            return tour;

        } catch (SQLException ex) {
            Logger.getLogger(TourDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Tour> getTourByCategoryId(int xCateId) {
        ArrayList<Tour> tour = new ArrayList<>();
        try {
            String sql = "select * from Tour where tour_category_id= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, xCateId);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Tour q = new Tour();
                q.setTour_id(rs.getInt("tour_id"));
                q.setTour_name(rs.getString("tour_name"));
                q.setTour_category_id(rs.getInt("tour_category_id"));
                q.setNumber_of_days(rs.getInt("number_of_days"));
                q.setStatus(rs.getString("status"));
                q.setCapacity(rs.getInt("capacity"));
                q.setIntroduction(rs.getString("introduction"));
                q.setStart_time(rs.getDate("start_time"));
                q.setTour_image(rs.getString("tour_image"));
                q.setTour_price(rs.getInt("tour_price"));
                q.setStaff_id(rs.getInt("staff_id"));
                q.setVehicle_id(rs.getInt("vehicle_id"));

                tour.add(q);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tour;
    }

     public ArrayList<Tour> getTourByName(String xName) {
        ArrayList<Tour> tour = new ArrayList<>();
        try {
            String sql = "select * from Tour where tour_name like '%%%s%%' or introduction like '%%%s%%'";
            sql = String.format(sql, xName.trim(), xName.trim());
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Tour q = new Tour();
                q.setTour_id(rs.getInt("tour_id"));
                q.setTour_name(rs.getString("tour_name"));
                q.setTour_category_id(rs.getInt("tour_category_id"));
                q.setNumber_of_days(rs.getInt("number_of_days"));
                q.setStatus(rs.getString("status"));
                q.setCapacity(rs.getInt("capacity"));
                q.setIntroduction(rs.getString("introduction"));
                q.setStart_time(rs.getDate("start_time"));
                q.setTour_image(rs.getString("tour_image"));
                q.setTour_price(rs.getInt("tour_price"));
                q.setStaff_id(rs.getInt("staff_id"));
                q.setVehicle_id(rs.getInt("vehicle_id"));

                tour.add(q);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tour;
    }
//         public static void main(String[] args) {
//        TourDBContext tour = new TourDBContext();
//        ArrayList<Tour> t = tour.getTourByName("chill");
//
//        for (Tour tour1 : t) {
//            System.out.println(tour1.getTour_name());
//        }
//    }

    public ArrayList<Tour> getSortedTour(String xSort) {
        ArrayList<Tour> tour = new ArrayList<>();
        try {
            String sql = "select * from Tour order by " + xSort;
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Tour q = new Tour();
                q.setTour_id(rs.getInt("tour_id"));
                q.setTour_name(rs.getString("tour_name"));
                q.setTour_category_id(rs.getInt("tour_category_id"));
                q.setNumber_of_days(rs.getInt("number_of_days"));
                q.setStatus(rs.getString("status"));
                q.setCapacity(rs.getInt("capacity"));
                q.setIntroduction(rs.getString("introduction"));
                q.setStart_time(rs.getDate("start_time"));
                q.setTour_image(rs.getString("tour_image"));
                q.setTour_price(rs.getInt("tour_price"));
                q.setStaff_id(rs.getInt("staff_id"));
                q.setVehicle_id(rs.getInt("vehicle_id"));

                tour.add(q);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tour;
    }

    public Tour getByTourId(int xTourId) {
        Tour q = new Tour();
        try {
            String sql = "select * from Tour where tour_id=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, xTourId);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                q.setTour_id(rs.getInt("tour_id"));
                q.setTour_name(rs.getString("tour_name"));
                q.setTour_category_id(rs.getInt("tour_category_id"));
                q.setNumber_of_days(rs.getInt("number_of_days"));
                q.setStatus(rs.getString("status"));
                q.setCapacity(rs.getInt("capacity"));
                q.setIntroduction(rs.getString("introduction"));
                q.setStart_time(rs.getDate("start_time"));
                q.setTour_image(rs.getString("tour_image"));
                q.setTour_price(rs.getInt("tour_price"));
                q.setStaff_id(rs.getInt("staff_id"));
                q.setVehicle_id(rs.getInt("vehicle_id"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return q;
    }

    public ArrayList<Tour_category> listCategory() {
        ArrayList<Tour_category> t = new ArrayList<>();
        try {
            String sql = "select * from Tour_category";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Tour_category q = new Tour_category();
                q.setTour_category_id(rs.getInt("tour_category_id"));
                q.setTour_category_name(rs.getString("tour_category_name"));

                t.add(q);
            }
        } catch (NullPointerException ex) {
            Logger.getLogger(TourDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TourDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    public void createTour(Tour model) {
        try {
            String sql = "INSERT INTO [Tour]\n"
                    + "          ([tour_id]\n"
                    + "           ,[tour_name]\n"
                    + "           ,[tour_category_id]\n"
                    + "           ,[number_of_days]\n"
                    + "           ,[status]\n"
                    + "           ,[capacity]\n"
                    + "           ,[introduction]\n"
                    + "           ,[start_time]\n"
                    + "           ,[tour_image]\n"
                    + "           ,[tour_price]\n"
                    + "           ,[staff_id]\n"
                    + "           ,[vehicle_id])\n"
                    + "            VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getTour_id());
            stm.setString(2, model.getTour_name());
            stm.setInt(3, model.getTour_category_id());
            stm.setInt(4, model.getNumber_of_days());
            stm.setString(5, model.getStatus());
            stm.setInt(6, model.getCapacity());
            stm.setString(7, model.getIntroduction());
            stm.setDate(8, (java.sql.Date) model.getStart_time());
            stm.setString(9, model.getTour_image());
            stm.setInt(10, model.getTour_price());
            stm.setInt(11, model.getStaff_id());
            stm.setInt(12, model.getVehicle_id());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TourDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Tour> getAllTour() {
        ArrayList<Tour> tour = new ArrayList<>();
        try {
            String sql = "select * from Tour";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Tour q = new Tour();
                q.setTour_id(rs.getInt("tour_id"));
                q.setTour_name(rs.getString("tour_name"));
                q.setTour_category_id(rs.getInt("tour_category_id"));
                q.setNumber_of_days(rs.getInt("number_of_days"));
                q.setStatus(rs.getString("status"));
                q.setCapacity(rs.getInt("capacity"));
                q.setIntroduction(rs.getString("introduction"));
                q.setStart_time(rs.getDate("start_time"));
                q.setTour_image(rs.getString("tour_image"));
                q.setTour_price(rs.getInt("tour_price"));
                q.setStaff_id(rs.getInt("staff_id"));
                q.setVehicle_id(rs.getInt("vehicle_id"));

                tour.add(q);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tour;
    }

    public void insertPlaceTour(int xTour_id, int[] xPlace_id) {
        try {
            for (int i = 0; i < xPlace_id.length; i++) {
                String sql = "insert into Place_Tour values(?,?)";
                PreparedStatement stm = connection.prepareStatement(sql);

                stm.setInt(1, xPlace_id[i]);
                stm.setInt(2, xTour_id);
                stm.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(TourDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<User> listStaff() {
        ArrayList<User> user = new ArrayList<>();
        try {
            String sql = "select * from [User] where [role_id]=3 ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User q = new User();
                q.setUser_id(rs.getInt("user_id"));
                q.setUsername(rs.getString("username"));
                q.setPassword(rs.getString("password"));
                q.setFirstname(rs.getString("firstname"));
                q.setLastname(rs.getString("lastname"));
                q.setAddress(rs.getString("address"));
                q.setGender(rs.getBoolean("gender"));
                q.setPhone_number(rs.getString("phone_number"));
                q.setDob(rs.getDate("dob"));
                q.setEmail(rs.getString("email"));
                q.setNationality(rs.getString("nationality"));
                q.setNational_id(rs.getString("national_id"));
                q.setPoint(rs.getInt("point"));
                q.setAnswer(rs.getString("answer"));
                q.setRole_id(rs.getInt("role_id"));
                q.setAccount_balance(rs.getInt("account_balance"));

                user.add(q);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
//
//     public static void main(String[] args){
//        TourDBContext tour = new TourDBContext();
//        List<Tour_category> t=tour.listCategory();
//        
//        for(Tour_category a: t){
//              System.out.println(a.getTour_category_name());
//          }
//    }

    @Override
    public ArrayList<Tour> list() {
        ArrayList<Tour> tour = new ArrayList<>();
        try {
            String sql = "select t.tour_id, t.tour_name,t.number_of_days,t.start_time,t.status,count([user_id]) as [Number people]\n"
                    + "from [Tour] t\n"
                    + "left join [Order] o on o.tour_id = t.tour_id\n"
                    + "group by [user_id],t.tour_id,t.tour_name,t.number_of_days,t.start_time,t.status";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Tour t = new Tour();
                t.setTour_id(rs.getInt("tour_id"));
                t.setTour_name(rs.getString("tour_name"));
                t.setNumber_of_days(rs.getInt("number_of_days"));
                t.setStart_time(rs.getDate("start_time"));
                t.setStatus(rs.getString("status"));
                t.setNumber_people(rs.getInt("Number people"));

                tour.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tour;
    }

//    public static void main(String[] args) {
//        TourDBContext tour = new TourDBContext();
//        List<Tour> t = tour.list();
//        for (Tour tour1 : t) {
//            System.out.println(tour1.getTour_id());
//
//        }
//    }

    public void insert(int user_id, int tour_id) {
        try {
            String sql = "INSERT INTO [Tour_Favorite]\n"
                    + "           ([user_id]\n"
                    + "           ,[tour_id])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, user_id);
            stm.setInt(2, tour_id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TourDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Tour> list(int user_id) {
        ArrayList<Tour> tour = new ArrayList<>();
        try {
            String sql = "select t.tour_name, t.tour_id,t.number_of_days,t.start_time,t.tour_price,t.[status],t.tour_image\n"
                    + "from Tour t \n"
                    + "left join Tour_Favorite tf on t.tour_id = tf.tour_id\n"
                    + "left join [User] u on u.[user_id] = tf.[user_id]\n"
                    + "where u.[user_id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, user_id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Tour t = new Tour();
                t.setTour_id(rs.getInt("tour_id"));
                t.setTour_name(rs.getString("tour_name"));
                t.setNumber_of_days(rs.getInt("number_of_days"));
                t.setStart_time(rs.getDate("start_time"));
                t.setTour_price(rs.getInt("tour_price"));
                t.setTour_image(rs.getString("tour_image"));
                t.setStatus(rs.getString("status"));
                tour.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tour;
    }

//    public static void main(String[] args) {
//        TourDBContext tour = new TourDBContext();
//        ArrayList<Tour> t = tour.list(5);
//        for (Tour tour1 : t) {
//            System.out.println(tour1.getTour_id());
//        }
//    }
}
