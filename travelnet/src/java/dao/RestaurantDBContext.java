/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Conscious;
import entity.Place;
import entity.Restaurant;
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
public class RestaurantDBContext extends DBContext<Restaurant> {

    @Override
    public void insert(Restaurant model) {
        try {
            String sql = "INSERT INTO [dbo].[Restaurant]\n"
                    + "           ([res_name]\n"
                    + "           ,[place_id]\n"
                    + "           ,[average_price]\n"
                    + "           ,[introduction]\n"
                    + "           ,[res_address]\n"
                    + "           ,[res_phone]\n"
                    + "           ,[res_image]\n"
                    + "           ,[res_rate])\n"
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
            stm.setString(1, model.getRes_name());
            stm.setInt(2, model.getPlace().getPlace_id());
            stm.setInt(3, model.getAverage_price());
            stm.setString(4, model.getIntroduction());
            stm.setString(5, model.getRes_address());
            stm.setString(6, model.getRes_phone());
            stm.setString(7, "../image/" + model.getRes_image());
            stm.setInt(8, model.getRes_rate());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Restaurant model) {
        try {
            String sql = "UPDATE [dbo].[Restaurant]\n"
                    + "   SET [res_name] = ?\n"
                    + "      ,[place_id] = ?\n"
                    + "      ,[average_price] = ?\n"
                    + "      ,[introduction] = ?\n"
                    + "      ,[res_address] = ?\n"
                    + "      ,[res_phone] = ?\n"
                    + " WHERE [res_id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getRes_name());
            stm.setInt(2, model.getPlace().getPlace_id());
            stm.setInt(3, model.getAverage_price());
            stm.setString(4, model.getIntroduction());
            stm.setString(5, model.getRes_address());
            stm.setString(6, model.getRes_phone());
            stm.setInt(7, model.getRes_id());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Restaurant model) {
        try {
            String sql = "DELETE FROM Restaurant\n"
                    + "      WHERE [res_id] =  ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getRes_id());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Restaurant get(int id) {
        try {
            String sql = "SELECT r.res_id, r.res_name, r.res_image, r.introduction, r.res_address, r.res_phone, r.res_rate, r.average_price, \n"
                    + "       p.place_id, p.place_name,\n"
                    + "	   c.c_id, c.c_name\n"
                    + "     FROM Restaurant r\n"
                    + "	   inner join Place p on p.place_id = r.place_id\n"
                    + "	   inner join Conscious c on c.c_id = p.c_id\n"
                    + "	 WHERE res_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                Restaurant r = new Restaurant();
                int res_id = rs.getInt("res_id");
                String res_name = rs.getString("res_name");
                String res_address = rs.getString("res_address");
                String introduction = rs.getString("introduction");
                int average_price = rs.getInt("average_price");
                String res_phone = rs.getString("res_phone");
                String res_image = rs.getString("res_image");
                int res_rate = rs.getInt("res_rate");

                r.setRes_id(res_id);
                r.setRes_name(res_name);
                r.setRes_address(res_address);
                r.setIntroduction(introduction);
                r.setAverage_price(average_price);
                r.setRes_phone(res_phone);
                r.setRes_image(res_image);
                r.setRes_rate(res_rate);

                Place p = new Place();
                p.setPlace_id(rs.getInt("place_id"));
                p.setPlace_name(rs.getString("place_name"));
                r.setPlace(p);

                Conscious c = new Conscious();
                c.setC_id(rs.getInt("c_id"));
                c.setC_name(rs.getString("c_name"));
                p.setConscious(c);

                return r;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Restaurant> searchRestaurants(String search) {
        ArrayList<Restaurant> ress = new ArrayList<>();
        try {
            String sql = "select c.c_name,r.res_id, r.res_image ,r.res_name, r.res_address, r.res_phone, r.res_rate  \n"
                    + "       from Restaurant r\n"
                    + "	     inner join Place p on r.place_id = p.place_id\n"
                    + "		 inner join Conscious c on c.c_id = p.c_id\n"
                    + "	  where res_name like ? or c.c_name like ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + search.trim() + "%");
            stm.setString(2, "%" + search.trim() + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Restaurant r = new Restaurant();
                Place p = new Place();
                Conscious c = new Conscious();
                r.setRes_id(rs.getInt("res_id"));
                r.setRes_image(rs.getString("res_image"));
                r.setRes_name(rs.getString("res_name"));
                r.setRes_address(rs.getString("res_address"));
                r.setRes_phone(rs.getString("res_phone"));
                r.setRes_rate(rs.getInt("res_rate"));
                c.setC_name(rs.getString("c_name"));
                r.setPlace(p);
                p.setConscious(c);
                ress.add(r);

            }
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ress;
    }

    @Override
    public ArrayList<Restaurant> list() {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        String sql = "select c.c_name,r.res_id, r.res_image ,r.res_name, r.res_address, r.res_phone, r.res_rate  \n"
                + "       from Restaurant r\n"
                + "	     inner join Place p on r.place_id = p.place_id\n"
                + "		 inner join Conscious c on c.c_id = p.c_id";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Restaurant r = new Restaurant();
                Place p = new Place();
                Conscious c = new Conscious();
                r.setRes_id(rs.getInt("res_id"));
                r.setRes_image(rs.getString("res_image"));
                r.setRes_name(rs.getString("res_name"));
                r.setRes_address(rs.getString("res_address"));
                r.setRes_phone(rs.getString("res_phone"));
                r.setRes_rate(rs.getInt("res_rate"));
                c.setC_name(rs.getString("c_name"));
                r.setPlace(p);
                p.setConscious(c);
                restaurants.add(r);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return restaurants;
    }

}
