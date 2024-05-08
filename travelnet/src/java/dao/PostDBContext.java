/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Post;
import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhth
 */
public class PostDBContext extends DBContext<Post> {

    @Override
    public void insert(Post model) {
        try {
            String sql = "INSERT INTO [Post]\n"
                    + "           ([title]\n"
                    + "           ,[content]\n"
                    + "           ,[post_image]\n"
                    + "           ,[status_post]\n"
                    + "           ,[user_id]\n"
                    + "           ,[type]\n"
                    + "           ,[description])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getTitle());
            stm.setString(2, model.getContent());
            stm.setString(3, "../image/" + model.getPost_image());
            stm.setBoolean(4, model.isStatus_post());
            stm.setInt(5, model.getUser().getUser_id());
            stm.setString(6, model.getType());
            stm.setString(7, model.getDescription());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PostDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Post model) {
        String sql = "UPDATE [Post]\n"
                + "   SET [title] = ?\n"
                + "      ,[content] = ?\n"
                + "      ,[post_image] = ?\n"
                + "      ,[status_post] = ?\n"
                + "      ,[user_id] = ?\n"
                + "      ,[type] = ?\n"
                + "      ,[description] = ?\n"
                + " WHERE [post_id] =";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getTitle());
            stm.setString(2, model.getContent());
            stm.setString(3, "../image/"+model.getPost_image());
            stm.setBoolean(4, model.isStatus_post());
            stm.setInt(5, model.getUser().getUser_id());
            stm.setString(6, model.getType());
            stm.setString(7, model.getDescription());
            stm.setInt(8, model.getPost_id());
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(PostDBContext.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ArrayList<Post> list(int user_id) {
        ArrayList<Post> post = new ArrayList<>();
        try {
            String sql = "select p.post_id, p.title, p. content, p.post_image, p.[type], p.[description], u.user_id, u.username\n"
                    + "from Post p inner join [User] u on p.user_id = u.user_id\n"
                    + "where u.user_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, user_id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUser_id(rs.getInt("user_id"));
                Post p = new Post(rs.getInt("post_id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("post_image"),
                        rs.getString("type"),
                        rs.getString("description"), u);
                post.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return post;
    }

    @Override
    public ArrayList<Post> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Post model) {
        String sql = "delete from Post \n"
                + "where post_id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getPost_id());
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(PostDBContext.class.getName()).log(Level.SEVERE, null, e);
        }
    }

//    public Post getPost(int post_id, int user_id) {
//        
//    }
    @Override
    public Post get(int post_id) {
        try {
            String sql = "select p.post_id, p.title, p. content, p.post_image, p.[type], p.[description]\n"
                    + "from Post p where p.post_id=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, post_id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Post p = new Post(rs.getInt("post_id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("post_image"),
                        rs.getString("type"),
                        rs.getString("description"));
                return p;
            }
        } catch (SQLException e) {
            Logger.getLogger(PostDBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

}
