/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Vehicle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class VehicleDBContext extends DBContext<Vehicle> {

    @Override
    public void insert(Vehicle model) {
        try {
            String sql = "INSERT INTO [dbo].[Vehicle]\n"
                    + "           ([vehicle_name]\n"
                    + "           ,[vehicle_address]\n"
                    + "           ,[vehicle_supplier]\n"
                    + "           ,[v_email]\n"
                    + "           ,[v_phonenumber]\n"
                    + "           ,[v_description]\n"
                    + "           ,[v_rate])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getVehicle_name());
            stm.setString(2, model.getVehicle_address());
            stm.setString(3, model.getVehicle_supplier());
            stm.setString(4, model.getV_email());
            stm.setString(5, model.getV_phonenumber());
            stm.setString(6, model.getV_description());
            stm.setInt(7, model.getV_rate());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Vehicle model) {
        try {
            String sql = "UPDATE [dbo].[Vehicle]\n"
                    + "   SET [vehicle_name] = ?\n"
                    + "      ,[vehicle_address] = ?\n"
                    + "      ,[vehicle_supplier] = ?\n"
                    + "      ,[v_email] = ?\n"
                    + "      ,[v_phonenumber] = ?\n"
                    + "      ,[v_description] = ?\n"
                    + " WHERE [vehicle_id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getVehicle_name());
            stm.setString(2, model.getVehicle_address());
            stm.setString(3, model.getVehicle_supplier());
            stm.setString(4, model.getV_email());
            stm.setString(5, model.getV_phonenumber());
            stm.setString(6, model.getV_description());
            stm.setInt(7, model.getVehicle_id());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Vehicle model) {
        try {
            String sql = "DELETE FROM [dbo].[Vehicle]\n"
                    + "      WHERE [vehicle_id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getVehicle_id());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Vehicle get(int id) {
        try {
            String sql = "SELECT vehicle_id, vehicle_name, vehicle_address, vehicle_supplier, v_email, v_phonenumber, v_description, v_rate \n"
                    + "FROM Vehicle\n"
                    + "WHERE vehicle_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                Vehicle v = new Vehicle();
                int vehicle_id = rs.getInt("vehicle_id");
                String vehicle_name = rs.getString("vehicle_name");
                String vehicle_address = rs.getString("vehicle_address");
                String vehicle_supplier = rs.getString("vehicle_supplier");
                String v_email = rs.getString("v_email");
                String v_phonenumber = rs.getString("v_phonenumber");
                String v_description = rs.getString("v_description");
                int v_rate = rs.getInt("v_rate");

                v.setVehicle_id(vehicle_id);
                v.setVehicle_name(vehicle_name);
                v.setVehicle_address(vehicle_address);
                v.setVehicle_supplier(vehicle_supplier);
                v.setV_email(v_email);
                v.setV_phonenumber(v_phonenumber);
                v.setV_description(v_description);
                v.setV_rate(v_rate);

                return v;
            }

        } catch (SQLException ex) {
            Logger.getLogger(VehicleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Vehicle> searchVehicles(String search) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        try {
            String sql = "SELECT vehicle_id, vehicle_name, vehicle_address, vehicle_supplier, v_email, v_phonenumber, v_description, v_rate \n"
                    + "FROM Vehicle\n"
                    + "WHERE vehicle_name like ? or vehicle_address like ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + search.trim() + "%");
            stm.setString(2, "%" + search.trim() + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                Vehicle v = new Vehicle();
                v.setVehicle_id(rs.getInt("vehicle_id"));
                v.setVehicle_name(rs.getString("vehicle_name"));
                v.setVehicle_address(rs.getString("vehicle_address"));
                v.setVehicle_supplier(rs.getString("vehicle_supplier"));
                v.setV_email(rs.getString("v_email"));
                v.setV_phonenumber(rs.getString("v_phonenumber"));
                v.setV_description(rs.getString("v_description"));
                v.setV_rate(rs.getInt("v_rate"));
                vehicles.add(v);

            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }

    @Override
    public ArrayList<Vehicle> list() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT vehicle_id, vehicle_name, vehicle_address, vehicle_supplier, v_email, v_phonenumber, v_description, v_rate \n"
                + "FROM Vehicle";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Vehicle v = new Vehicle();

                v.setVehicle_id(rs.getInt("vehicle_id"));
                v.setVehicle_name(rs.getString("vehicle_name"));
                v.setVehicle_address(rs.getString("vehicle_address"));
                v.setVehicle_supplier(rs.getString("vehicle_supplier"));
                v.setV_email(rs.getString("v_email"));
                v.setV_phonenumber(rs.getString("v_phonenumber"));
                v.setV_description(rs.getString("v_description"));
                v.setV_rate(rs.getInt("v_rate"));

                vehicles.add(v);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VehicleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vehicles;
    }

    public int getTotalVehicle(String search) {

        String sql = "SELECT count(*) FROM Vehicle "
                + "WHERE vehicle_name like ? or vehicle_address like ? ";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + search + "%");
            stm.setString(2, "%" + search + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<Vehicle> pagingVehicle(String search, int index) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String sql = "	WITH x as(SELECT ROW_NUMBER() OVER (ORDER BY vehicle_id) r , * FROM Vehicle \n"
                + "WHERE vehicle_name like ? or vehicle_address like ?)\n"
                + "SELECT * FROM x WHERE r between ?*3-2 and ? * 3";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + search + "%");
            stm.setString(2, "%" + search + "%");
            stm.setInt(3, index);
            stm.setInt(4, index);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Vehicle v = new Vehicle();
                
                rs.getInt(1);
                v.setVehicle_id(rs.getInt("vehicle_id"));
                v.setVehicle_name(rs.getString("vehicle_name"));
                v.setVehicle_address(rs.getString("vehicle_address"));
                v.setVehicle_supplier(rs.getString("vehicle_supplier"));
                v.setV_email(rs.getString("v_email"));
                v.setV_phonenumber(rs.getString("v_phonenumber"));
                v.setV_description(rs.getString("v_description"));
                v.setV_rate(rs.getInt("v_rate"));

                vehicles.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }


}
