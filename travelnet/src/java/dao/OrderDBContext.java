/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class OrderDBContext extends DBContext<Order> {


    @Override
    public void insert(Order model) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO [dbo].[Order]\n"
                    + "           ([tour_id]\n"
                    + "           ,[user_id]\n"
                    + "           ,[cus_name]\n"
                    + "           ,[cus_phone]\n"
                    + "           ,[cus_email]\n"
                    + "           ,[cus_address]\n"
                    + "           ,[cus_note]\n"
                    + "           ,[voucher_id]\n"
                    + "           ,[price]\n"
                    + "           ,[order_time]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,GETDATE()\n"
                    + "           ,?)";

            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, model.getTour_id());
            stm.setInt(2, model.getUser_id());
            stm.setString(3, model.getCus_name());
            stm.setString(4, model.getCus_phone());
            stm.setString(5, model.getCus_email());
            stm.setString(6, model.getCus_address());
            stm.setString(7, model.getCus_note());
            stm.setInt(8, model.getVoucher_id());
            stm.setDouble(9, model.getPrice());
            stm.setBoolean(10, false);

            stm.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, e);

            }
        }
    }

//    public static void main(String[] args) {
//        OrderDBContext o1 = new OrderDBContext();
//        Order o = new Order();
////         o.setTour_id(1);
////            o.setUser_id(5);
//        o.setCus_name("uuu");
//        o.setCus_phone("00000");
//        o.setCus_email("oossso");
//        o.setCus_address("hhh");
//        o.setCus_note("nnn");
////            o.setVoucher_id(Integer.parseInt("1"));
////            o.setPrice(77777);
//        o1.insert(o);
//    }
    @Override
    public void update(Order model) {
        try {
            String sql = "UPDATE [dbo].[Order]\n"
                    + "   SET [status] = 'True'\n"
                    + " WHERE order_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getOrder_id());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Order model) {
        try {
            String sql = "DELETE FROM [Order]\n"
                    + "      WHERE [order_id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getOrder_id());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Order get(int id) {
        Order order = new Order();
        try {
            String sql = "select *\n"
                    + "from [Order]\n"
                    + "where [order_id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                order.setOrder_id(rs.getInt("order_id"));
                order.setTour_id(rs.getInt("tour_id"));
                order.setUser_id(rs.getInt("user_id"));
                order.setCus_name(rs.getString("cus_name"));
                order.setCus_address(rs.getString("cus_address"));
                order.setCus_email(rs.getString("cus_email"));
                order.setCus_phone(rs.getString("cus_phone"));
                order.setCus_note(rs.getString("cus_note"));
                order.setOrder_time(rs.getDate("order_time"));
            }
            return order;

        } catch (SQLException ex) {
            Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Order> list(int id) {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            String sql = "select * \n"
                    + "from [Order]\n"
                    + "where tour_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Order or = new Order();
                or.setOrder_id(rs.getInt("order_id"));
                or.setTour_id(rs.getInt("tour_id"));
                or.setUser_id(rs.getInt("user_id"));
                or.setCus_name(rs.getString("cus_name"));
                or.setCus_address(rs.getString("cus_address"));
                or.setCus_email(rs.getString("cus_email"));
                or.setCus_phone(rs.getString("cus_phone"));
                or.setCus_note(rs.getString("cus_note"));
                or.setOrder_time(rs.getDate("order_time"));
                or.setStatus(rs.getBoolean("status"));

                orders.add(or);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }
//    public static void main(String[] args) {
//        OrderDBContext r = new OrderDBContext();
//        ArrayList<Order> t = r.list();
//        for (Order order : t) {
//            System.out.println(order.getCus_name());
//        }
//    }

//    public void payment(int user_id, int acc_bl, int price, String cus_name, String cus_phone, String cus_email, String cus_address, String cus_note, String voucher_id, String tour_id) {
//        try {
//            String sql = "UPDATE [User]\n"
//                    + "SET [account_balance] = ?\n"
//                    + " WHERE [user_id] = ?";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setInt(1, (acc_bl - price));
//            stm.setInt(2, user_id);
//            stm.executeUpdate();
//
//            String sql1 = "INSERT INTO [dbo].[Order]\n"
//                    + "           ([tour_id]\n"
//                    + "           ,[user_id]\n"
//                    + "           ,[cus_name]\n"
//                    + "           ,[cus_phone]\n"
//                    + "           ,[cus_email]\n"
//                    + "           ,[cus_address]\n"
//                    + "           ,[cus_note]\n"
//                    + "           ,[voucher_id]\n"
//                    + "           ,[price]\n"
//                    + "           ,[order_time]\n"
//                    + "           ,[status])\n"
//                    + "     VALUES\n"
//                    + "           (?\n"
//                    + "           ,?\n"
//                    + "           ,?\n"
//                    + "           ,?\n"
//                    + "           ,?\n"
//                    + "           ,?\n"
//                    + "           ,?\n"
//                    + "           ,?\n"
//                    + "           ,?\n"
//                    + "           ,GETDATE()\n"
//                    + "           ,?)";
//            PreparedStatement stm1 = connection.prepareStatement(sql1);
//            stm1.setString(1, tour_id);
//            stm1.setInt(2, user_id);
//            stm1.setString(3, cus_name);
//            stm1.setString(4, cus_phone);
//            stm1.setString(5, cus_email);
//            stm1.setString(6, cus_address);
//            stm1.setString(7, voucher_id);
//            stm1.setInt(8, price);
//            stm1.setInt(9, 1);
//            stm.executeUpdate();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(OrderDBContext.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    @Override
    public ArrayList<Order> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Order> listOrder(int user_id) {
        ArrayList<Order> order = new ArrayList<>();
        try {
            String sql = "select *\n"
                    + "from [Order]\n"
                    + "where [user_id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, user_id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Order or = new Order();
                or.setOrder_id(rs.getInt("order_id"));
                or.setTour_id(rs.getInt("tour_id"));
                or.setUser_id(rs.getInt("user_id"));
                or.setCus_name(rs.getString("cus_name"));
                or.setCus_address(rs.getString("cus_address"));
                or.setCus_email(rs.getString("cus_email"));
                or.setCus_phone(rs.getString("cus_phone"));
                or.setCus_note(rs.getString("cus_note"));
                or.setPrice(rs.getInt("price"));
                or.setOrder_time(rs.getDate("order_time"));
                or.setStatus(rs.getBoolean("status"));

                order.add(or);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return order;
    }
//        public static void main(String[] args) {
//        OrderDBContext r = new OrderDBContext();
//        ArrayList<Order> t = r.listOrder(5);
//        for (Order order : t) {
//            System.out.println(order.getCus_name());
//        }
//    }
}
        
