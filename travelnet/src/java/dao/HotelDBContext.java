/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Conscious;
import entity.Hotel;
import entity.Place;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class HotelDBContext extends DBContext<Hotel> {

    @Override
    public void insert(Hotel model) {
        try {
            String sql = "INSERT INTO [Hotel]\n"
                    + "           ([hotel_name]\n"
                    + "           ,[hotel_address]\n"
                    + "           ,[hotel_description]\n"
                    + "           ,[hotel_type]\n"
                    + "           ,[place_id]\n"
                    + "           ,[hotel_img]\n"
                    + "           ,[hotel_phone]\n"
                    + "           ,[hotel_rate])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getHotel_name());
            stm.setString(2, model.getHotel_address());
            stm.setString(3, model.getHotel_description());
            stm.setInt(4, model.getHotel_type());
            stm.setInt(5, model.getPlace().getPlace_id());
            stm.setString(6,"../image/" + model.getHotel_img());
            stm.setString(7, model.getHotel_phone());
            stm.setInt(8, model.getHotel_rate());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HotelDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Hotel model) {
        try {
            String sql = "UPDATE [dbo].[Hotel]\n"
                    + "   SET [hotel_name] = ?\n"
                    + "      ,[hotel_address] = ?\n"
                    + "      ,[hotel_description] = ?\n"
                    + "      ,[hotel_type] = ?\n"
                    + "      ,[place_id] = ?\n"
                    + "      ,[hotel_phone] = ? \n"
                    + " WHERE [hotel_id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getHotel_name());
            stm.setString(2, model.getHotel_address());
            stm.setString(3, model.getHotel_description());
            stm.setInt(4, model.getHotel_type());
            stm.setInt(5, model.getPlace().getPlace_id());
            stm.setString(6, model.getHotel_phone());
            stm.setInt(7, model.getHotel_id());
            
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HotelDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Hotel model) {
        try {
            String sql = "DELETE FROM Hotel\n"
                    + "      WHERE [hotel_id] =  ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getHotel_id());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HotelDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Hotel get(int id) {
        try {
            String sql = "select h.hotel_id, h.hotel_name, h.hotel_address, h.hotel_description, h.hotel_img,\n"
                    + "                          h.hotel_phone, h.hotel_rate, h.hotel_type, \n"
                    + "				 p.place_id, p.place_name,\n"
                    + "                    	   c.c_id, c.c_name\n"
                    + "                            from Hotel h\n"
                    + "                            inner join Place p on h.place_id = p.place_id\n"
                    + "                    		inner join Conscious c on c.c_id = p.c_id\n"
                    + "                    	where h.hotel_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                Hotel h = new Hotel();
                int hotel_id = rs.getInt("hotel_id");
                String hotel_name = rs.getString("hotel_name");
                String hotel_address = rs.getString("hotel_address");
                String hotel_description = rs.getString("hotel_description");
                int hotel_type = rs.getInt("hotel_type");
                String hotel_phone = rs.getString("hotel_phone");
                String hotel_img = rs.getString("hotel_img");
                int hotel_rate = rs.getInt("hotel_rate");
                h.setHotel_id(hotel_id);
                h.setHotel_name(hotel_name);
                h.setHotel_address(hotel_address);
                h.setHotel_description(hotel_description);
                h.setHotel_type(hotel_type);
                h.setHotel_phone(hotel_phone);
                h.setHotel_img(hotel_img);
                h.setHotel_rate(hotel_rate);

                Place p = new Place();
                p.setPlace_id(rs.getInt("place_id"));
                p.setPlace_name(rs.getString("place_name"));
                h.setPlace(p);

                Conscious c = new Conscious();
                c.setC_id(rs.getInt("c_id"));
                c.setC_name(rs.getString("c_name"));
                p.setConscious(c);

                return h;
            }

        } catch (SQLException ex) {
            Logger.getLogger(HotelDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public ArrayList<Hotel> searchHotel(String search) {
        ArrayList<Hotel> hotels = new ArrayList<>();
        try {
            String sql = "select c.c_name, h.hotel_id,h.hotel_img,h.hotel_name,h.hotel_type ,h.hotel_address,h.hotel_phone, h.hotel_rate \n"
                    + "                    from Hotel h\n"
                    + "                            inner join Place p on h.place_id = p.place_id\n"
                    + "                    		inner join Conscious c on c.c_id = p.c_id\n"
                    + "                       where hotel_name like ? or c.c_name like ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + search.trim() + "%");
            stm.setString(2, "%" + search.trim() + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Hotel h = new Hotel();
                Place p = new Place();
                Conscious c = new Conscious();
                h.setHotel_id(rs.getInt("hotel_id"));
                h.setHotel_img(rs.getString("hotel_img"));
                h.setHotel_name(rs.getString("hotel_name"));
                h.setHotel_type(rs.getInt("hotel_type"));
                h.setHotel_address(rs.getString("hotel_address"));
                h.setHotel_phone(rs.getString("hotel_phone"));
                h.setHotel_rate(rs.getInt("hotel_rate"));
                c.setC_name(rs.getString("c_name"));
                h.setPlace(p);
                p.setConscious(c);
                hotels.add(h);

            }
        } catch (SQLException ex) {
            Logger.getLogger(HotelDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hotels;
    }

    @Override
    public ArrayList<Hotel> list() {
        ArrayList<Hotel> hotels = new ArrayList<>();
        String sql = "select c.c_name, h.hotel_id,h.hotel_img,h.hotel_name,h.hotel_type ,h.hotel_address,h.hotel_phone, h.hotel_rate \n"
                + "from Hotel h\n"
                + "        inner join Place p on h.place_id = p.place_id\n"
                + "		inner join Conscious c on c.c_id = p.c_id";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Hotel h = new Hotel();
                Place p = new Place();
                Conscious c = new Conscious();
                h.setHotel_id(rs.getInt("hotel_id"));
                h.setHotel_img(rs.getString("hotel_img"));
                h.setHotel_name(rs.getString("hotel_name"));
                h.setHotel_type(rs.getInt("hotel_type"));
                h.setHotel_address(rs.getString("hotel_address"));
                h.setHotel_phone(rs.getString("hotel_phone"));
                h.setHotel_rate(rs.getInt("hotel_rate"));
                c.setC_name(rs.getString("c_name"));
                h.setPlace(p);
                p.setConscious(c);
                hotels.add(h);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HotelDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hotels;
    }
}
