/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Voucher;
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
public class VoucherDBContext extends DBContext<Voucher> {

    @Override
    public void insert(Voucher model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Voucher model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Voucher model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Voucher get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Voucher> list() {
        PreparedStatement stm = null;
        ArrayList<Voucher> vouchers = new ArrayList<>();
        try {
            String sql = "Select * From Voucher";
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Voucher voucher = new Voucher();
                voucher.setVoucher_id(rs.getInt("voucher_id"));
                voucher.setVoucher_name(rs.getString("voucher_name"));
                voucher.setQuantity(rs.getInt("quantity"));
                voucher.setDiscount(rs.getInt("discount"));
                voucher.setCreate_date(rs.getDate("create_date"));
                voucher.setEnd_date(rs.getDate("end_date"));
                voucher.setStatus(rs.getBoolean("status"));
                voucher.setDescription(rs.getString("description"));
                voucher.setPoint(rs.getInt("point"));
                vouchers.add(voucher);
            }
            return vouchers;
        } catch (SQLException ex) {
            Logger.getLogger(VoucherDBContext.class.getName()).log(Level.SEVERE, "Error in get list voucher", ex);
        } finally {
            //close connection
            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(VoucherDBContext.class.getName()).log(Level.SEVERE, "Can not close", ex);
            }
        }
        return null;
    
    }

    public ArrayList<Voucher> list(int user_id) {
        PreparedStatement stm = null;
        ArrayList<Voucher> vouchers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Voucher v\n"
                    + "		JOIN Voucher_User vu ON v.voucher_id = vu.voucher_id\n"
                    + "		WHERE [user_id] = ?\n";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, user_id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Voucher voucher = new Voucher();
                voucher.setVoucher_id(rs.getInt("voucher_id"));
                voucher.setVoucher_name(rs.getString("voucher_name"));
                voucher.setQuantity(rs.getInt("quantity"));
                voucher.setDiscount(rs.getInt("discount"));
                voucher.setCreate_date(rs.getDate("create_date"));
                voucher.setEnd_date(rs.getDate("end_date"));
                voucher.setStatus(rs.getBoolean("status"));
                voucher.setDescription(rs.getString("description"));
                voucher.setPoint(rs.getInt("point"));
                vouchers.add(voucher);
            }
            return vouchers;
        } catch (SQLException ex) {
            Logger.getLogger(VoucherDBContext.class.getName()).log(Level.SEVERE, "Error in get list voucher of a user", ex);
        } finally {
            //close connection
            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(VoucherDBContext.class.getName()).log(Level.SEVERE, "Can not close", ex);
            }
        }
        return null;
    }

    public double discount(String voucher_id) {
        PreparedStatement stm = null;
        try {
            String sql = "select *\n"
                    + "from Voucher\n"
                    + "where voucher_id = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, voucher_id);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                return rs.getInt("discount");    
            } 
        } catch (Exception e) {
        }
        return 0;
    }
//    public static void main(String[] args) {
//        VoucherDBContext c = new VoucherDBContext();
//        double i = c.discount("1");
//        System.out.println(i);
//    }

   public void createVoucher(Voucher model) {
        try {
            String sql = "INSERT INTO [Voucher]\n"
                    + "            ([voucher_id]\n"
                    + "           ,[voucher_name]\n"
                    + "           ,[quantity]\n"
                    + "           ,[discount]\n"
                    + "           ,[create_date]\n"
                    + "           ,[end_date]\n"
                    + "           ,[status]\n"
                    + "           ,[description]\n"
                    + "          ,[point])\n"
                    + "            VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getVoucher_id());
            stm.setString(2, model.getVoucher_name());
            stm.setInt(3, model.getQuantity());
            stm.setInt(4, model.getDiscount());
            stm.setDate(5, (java.sql.Date) model.getCreate_date());
            stm.setDate(6, (java.sql.Date) model.getEnd_date());
            stm.setBoolean(7, model.isStatus());
            stm.setString(8, model.getDescription());
            stm.setInt(9, model.getPoint());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VoucherDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdateVoucher(Voucher model) {
        try {
            String sql = "UPDATE [Voucher] "
                    + " SET   [voucher_name] = ?"
                    + "      ,[quantity] = ?"
                    + "      ,[discount] = ?"
                    + "      ,[create_date] =?"
                    + "      ,[end_date] = ?"
                    + "      ,[status] =?"
                    + "      ,[description] = ?"
                    + "      ,[point] = ?"
                    + " WHERE voucher_id = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            
            stm.setString(1, model.getVoucher_name());
            stm.setInt(2, model.getQuantity());
            stm.setInt(3, model.getDiscount());
            stm.setDate(4, (java.sql.Date) model.getCreate_date());
            stm.setDate(5, (java.sql.Date) model.getEnd_date());
            stm.setBoolean(6, model.isStatus());
            stm.setString(7, model.getDescription());
            stm.setInt(8, model.getPoint());
            stm.setInt(9, model.getVoucher_id());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VoucherDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public static void main(String[] args) {
//        VoucherDBContext vo = new VoucherDBContext();
//        ArrayList<Voucher> v = vo.list(5);
//        for (Voucher voucher : v) {
//            System.out.println(voucher.getVoucher_id()  + voucher.getVoucher_name());
//        }
//    }

}
