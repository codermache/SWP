/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Comment;
import entity.Tour;
import entity.User;
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
public class CommentDBContext extends DBContext<Comment> {

    @Override
    public void insert(Comment model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Comment model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Comment model) {
        try {
            String sql = "DELETE FROM [Comment]\n"
                    + "      WHERE cid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1,model.getCid());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Comment get(int id) {
        Comment cmt = new Comment();
        try {
            String sql = "select *\n"
                    + "from [Comment] c\n"
                    + "left join [User] u on c.[user_id] = u.[user_id]\n"
                    + "left join [Tour] t on t.tour_id = c.tour_id\n"
                    + "where cid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                cmt.setCid(rs.getInt("cid"));
                cmt.setCtitle(rs.getString("ctitle"));
                Tour tour = new Tour();
                tour.setTour_id(rs.getInt("tour_id"));
                cmt.setTour(tour);
                User us = new User();
                us.setUser_id(rs.getInt("user_id"));
                cmt.setUser(us);

            }
            return cmt;

        } catch (SQLException ex) {
            Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public ArrayList<Comment> list() {
        ArrayList<Comment> cm = new ArrayList<>();
        try {
            String sql = "select  c.[user_id],c.ctitle,t.tour_id,a.username\n"
                    + "                          from Tour t\n"
                    + "                            join Comment c on t.tour_id= c.tour_id\n"
                    + "                    	  join [User] a on a.[user_id] = c.[user_id]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                Tour tour = new Tour();
                Comment cmt = new Comment();

                cmt.setCtitle(rs.getString("ctitle"));
                cmt.setTour(tour);
                tour.setTour_id(rs.getInt("tour_id"));
                User us = new User();
                us.setUsername(rs.getString("username"));
                us.setUser_id(rs.getInt("user_id"));
                cmt.setUser(us);

                cm.add(cmt);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cm;
    }
    public ArrayList<Comment> listComment(int tour_id) {
        ArrayList<Comment> cm = new ArrayList<>();
        try {
            String sql = "select c.cid,c.[user_id],c.ctitle,t.tour_id,a.username\n"
                    + "from Tour t\n"
                    + "join Comment c on t.tour_id= c.tour_id\n"
                    + "join [User] a on a.[user_id] = c.[user_id]\n"
                    + "where t.tour_id =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, tour_id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                Tour tour = new Tour();
                Comment cmt = new Comment();
                cmt.setCid(rs.getInt("cid"));
                cmt.setCtitle(rs.getString("ctitle"));
                cmt.setTour(tour);
                tour.setTour_id(rs.getInt("tour_id"));
                User us = new User();
                us.setUsername(rs.getString("username"));
                us.setUser_id(rs.getInt("user_id"));
                cmt.setUser(us);

                cm.add(cmt);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cm;
    }

    public void insertComment(int tour_id, String comment, int user_id) {
        try {
            String sql = "INSERT INTO [Comment]\n"
                    + "                    ([ctitle],\n"
                    + "                    [user_id],\n"
                    + "                    [tour_id])\n"
                    + "                    VALUES (?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, comment);
            stm.setInt(2, user_id);
            stm.setInt(3, tour_id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
