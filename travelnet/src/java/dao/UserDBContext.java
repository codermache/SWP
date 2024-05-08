/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.SignUpController;
import entity.Role;
import entity.User;
import java.util.Date;
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
public class UserDBContext extends DBContext<User> {

// Method tim ra tai khoan dung voi username password de login
    public User get(String email, String password) {
        try {
            String sql = "SELECT *\n"
                    + "  FROM [User]\n"
                    + "  where email = ? and [password] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email.trim());
            stm.setString(2, password.trim());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setAddress(rs.getString("address"));
                user.setGender(rs.getBoolean("gender"));
                user.setPhone_number(rs.getString("phone_number"));
                user.setDob(rs.getDate("dob"));
                user.setEmail(rs.getString("email"));
                user.setNationality(rs.getString("nationality"));
                user.setNational_id(rs.getString("national_id"));
                user.setPoint(rs.getInt("point"));
                user.setAnswer(rs.getString("answer"));
                user.setRole_id(rs.getInt("role_id"));
                user.setAccount_balance(rs.getInt("account_balance"));
                user.setAvatar(rs.getString("avatar"));
                return user;
            }
//               stm.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

//    
//    public static void main(String[] args) {
//        UserDBContext d = new UserDBContext();
//        User y = d.get("anhng130@gmail.com", "123456");
//        System.out.println(y.getAvatar());
//    }
    public User getIn4UserByEmail(String emailParam) {

        String sql = "select *\n"
                + "  from [User]\n"
                + "  where email = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, emailParam);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User u = new User();
//                int userID = rs.getInt("userID");
                u.setFirstname(rs.getString("firstname"));
                u.setLastname(rs.getString("lastname"));
                u.setEmail(rs.getString("email"));
                u.setUser_id(rs.getInt("user_id"));
                u.setRole_id(rs.getInt("role_id"));
                u.setAccount_balance(rs.getInt("account_balance"));
                return u;
            }
        } catch (SQLException ex) {
        }
        return null;
    }

    //Method insert vào user de luu thong tin nguoi dung
    @Override
    public void insert(User model) {
        try {
            String sql = "INSERT INTO [dbo].[User]\n"
                    + "           ([username]\n"
                    + "           ,[password]\n"
                    + "           ,[firstname]\n"
                    + "           ,[lastname]\n"
                    + "           ,[address]\n"
                    + "           ,[gender]\n"
                    + "           ,[phone_number]\n"
                    + "           ,[dob]\n"
                    + "           ,[email]\n"
                    + "           ,[nationality]\n"
                    + "           ,[national_id]\n"
                    + "           ,[point]\n"
                    + "           ,[answer]\n"
                    + "           ,[role_id]\n"
                    + "           ,[account_balance]\n"
                    + "           ,[avatar])\n"
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
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getUsername().trim());
            stm.setString(2, model.getPassword().trim());
            stm.setString(3, model.getFirstname().trim());
            stm.setString(4, model.getLastname().trim());
            stm.setString(5, model.getAddress().trim());
            stm.setBoolean(6, model.isGender());
            stm.setString(7, model.getPhone_number().trim());
            stm.setDate(8, (java.sql.Date) model.getDob());
            stm.setString(9, model.getEmail().trim());
            stm.setString(10, model.getNationality().trim());
            stm.setString(11, model.getNational_id().trim());
            stm.setInt(12, 0);
            stm.setString(13, model.getAnswer().trim());
            stm.setInt(14, 1);
            stm.setInt(15, 0);
            stm.setString(16, model.getAvatar().trim());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//       public static void main(String[] args) {
//        UserDBContext us = new UserDBContext();
//        us.insert();
//           System.out.println(us);
//    }

    @Override
    public void update(User model) {
        PreparedStatement stm = null;
        try {
            String sql = "UPDATE [User]\n"
                    + "	SET  [firstname] = ? \n"
                    + "      ,[lastname] = ? \n"
                    + "      ,[address] = ? \n"
                    + "      ,[gender] = ? \n"
                    + "      ,[phone_number] = ? \n"
                    + "      ,[dob] = ? \n"
                    + "      ,[email] = ? \n"
                    + "      ,[nationality] = ? \n"
                    + "      ,[national_id] = ? \n"
                    + " WHERE [user_id] =  ? ";
            stm = connection.prepareStatement(sql);
            stm.setString(1, model.getFirstname());
            stm.setString(2, model.getLastname());
            stm.setString(3, model.getAddress());
            stm.setBoolean(4, model.isGender());
            stm.setString(5, model.getPhone_number());
            stm.setDate(6, (java.sql.Date) model.getDob());
            stm.setString(7, model.getEmail());
            stm.setString(8, model.getNationality());
            stm.setString(9, model.getNational_id());
            stm.setInt(10, model.getUser_id());
            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, "update User false", ex);
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void updatePassword(User model) {
        String query = "UPDATE [dbo].[User]\n"
                + "   SET [password] = ?\n"
                + " WHERE user_id = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setString(1, model.getPassword());
            pre.setInt(2, model.getUser_id());
            pre.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    @Override
    public void delete(User model) {
        try {
            String sql = "DELETE FROM [User]"
                    + "WHERE [user_id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getUser_id());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HotelDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public User get(int id) {
        try {

            String sql = "select *\n"
                    + "from [User]\n"
                    + "where user_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setRole_id(rs.getInt("role_id"));
                user.setAccount_balance(rs.getInt("account_balance"));
                return user;
            }
//               stm.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateStaff(User staff) {
        PreparedStatement stm = null;
        try {
            String sql = "UPDATE [User]"
                    + "	SET  [firstname] = ?"
                    + "      ,[lastname] = ?"
                    + "      ,[address] = ? "
                    + "      ,[gender] = ? "
                    + "      ,[phone_number] = ? "
                    + "      ,[dob] = ? "
                    + "      ,[email] = ? "
                    + "      ,[nationality] = ? "
                    + "      ,[national_id] = ? "
                    + "      ,[username] = ? "
                    + "      ,[password] = ? "
                    + "      ,[avatar] = ? "
                    + " WHERE [user_id] =  ? ";
            stm = connection.prepareStatement(sql);
            stm.setString(1, staff.getFirstname());
            stm.setString(2, staff.getLastname());
            stm.setString(3, staff.getAddress());
            stm.setBoolean(4, staff.isGender());
            stm.setString(5, staff.getPhone_number());
            stm.setDate(6, (java.sql.Date) staff.getDob());
            stm.setString(7, staff.getEmail());
            stm.setString(8, staff.getNationality());
            stm.setString(9, staff.getNational_id());
            stm.setString(10, staff.getUsername());
            stm.setString(11, staff.getPassword());
            stm.setString(12, staff.getAvatar());
            stm.setInt(13, staff.getUser_id());
            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, "update staff false", ex);
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void insertStaff(User user) {
        PreparedStatement stm = null;
        try {
            String sql = "INSERT INTO [User]"
                    + "           ([username]"
                    + "           ,[password]"
                    + "           ,[firstname]"
                    + "           ,[lastname]"
                    + "           ,[address]"
                    + "           ,[gender]"
                    + "           ,[phone_number]"
                    + "           ,[dob]"
                    + "           ,[email]"
                    + "           ,[nationality]"
                    + "           ,[national_id]"
                    + "           ,[point]"
                    + "           ,[answer]"
                    + "           ,[role_id]"
                    + "           ,[account_balance]"
                    + "           ,[avatar])"
                    + "     VALUES"
                    + "           (?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?"
                    + "           ,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, user.getUsername());
            stm.setString(2, user.getPassword());
            stm.setString(3, user.getFirstname());
            stm.setString(4, user.getLastname());
            stm.setString(5, user.getAddress());
            stm.setBoolean(6, user.isGender());
            stm.setString(7, user.getPhone_number());
            stm.setDate(8, (java.sql.Date) user.getDob());
            stm.setString(9, user.getEmail());
            stm.setString(10, user.getNationality());
            stm.setString(11, user.getNational_id());
            stm.setInt(12, 0);
            stm.setString(13, "Travelnet");
            stm.setInt(14, 2);
            stm.setInt(15, 0);
            stm.setString(16, user.getAvatar());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, "INSERT STAFF FAIL", ex);
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<User> getStaffList() {
        PreparedStatement stm = null;
        ArrayList<User> staffs = new ArrayList<>();
        try {
            String sql = "select *"
                    + "from [User]"
                    + "where role_id = 2";
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User staff = new User();
                staff.setUser_id(rs.getInt("user_id"));
                staff.setUsername(rs.getString("username"));
                staff.setPassword(rs.getString("password"));
                staff.setFirstname(rs.getString("firstname"));
                staff.setLastname(rs.getString("lastname"));
                staff.setAddress(rs.getString("address"));
                staff.setGender(rs.getBoolean("gender"));
                staff.setPhone_number(rs.getString("phone_number"));
                staff.setDob(rs.getDate("dob"));
                staff.setEmail(rs.getString("email"));
                staff.setNationality(rs.getString("nationality"));
                staff.setNational_id(rs.getString("national_id"));
                staff.setAvatar(rs.getString("avatar"));
                staffs.add(staff);
            }
            return staffs;
        } catch (SQLException ex) {
            Logger.getLogger(VoucherDBContext.class.getName()).log(Level.SEVERE, "Error in get list staff", ex);
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

    public ArrayList<User> getStaffListByName(String name) {
        PreparedStatement stm = null;
        ArrayList<User> staffs = new ArrayList<>();
        try {
            String sql = "select *"
                    + "from [User]"
                    + "where role_id = 2 and firstname like '%" + name + "%' or lastname like '%" + name + "%'";

            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User staff = new User();
                staff.setUser_id(rs.getInt("user_id"));
                staff.setUsername(rs.getString("username"));
                staff.setPassword(rs.getString("password"));
                staff.setFirstname(rs.getString("firstname"));
                staff.setLastname(rs.getString("lastname"));
                staff.setAddress(rs.getString("address"));
                staff.setGender(rs.getBoolean("gender"));
                staff.setPhone_number(rs.getString("phone_number"));
                staff.setDob(rs.getDate("dob"));
                staff.setEmail(rs.getString("email"));
                staff.setNationality(rs.getString("nationality"));
                staff.setNational_id(rs.getString("national_id"));
                staff.setAvatar(rs.getString("avatar"));
                staffs.add(staff);
            }
            return staffs;
        } catch (SQLException ex) {
            Logger.getLogger(VoucherDBContext.class.getName()).log(Level.SEVERE, "Error in get list staff", ex);
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

    @Override
    public ArrayList<User> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public void changePassword(int user_id, String newpass) {
        String query = "UPDATE [User]\n"
                + "   SET [password] = ?\n"
                + " WHERE user_id = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setString(1, newpass);
            pre.setInt(2, user_id);
            pre.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    
//        public static void main(String[] args) {
//        UserDBContext us = new UserDBContext();
//        us.changePassword(1010,"12345");
//        System.out.println("name" + uu.getFirstname());
//    }

}
