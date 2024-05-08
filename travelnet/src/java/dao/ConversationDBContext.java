/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Conversation;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author win
 */
public class ConversationDBContext extends DBContext<Conversation> {

    @Override
    public void insert(Conversation model) {
        PreparedStatement stm = null;
        try {
            String sql = "INSERT INTO [Conversation]\n"
                    + "           ([user_id]\n"
                    + "           ,[email]\n"
                    + "           ,[phone_number]\n"
                    + "           ,[title]\n"
                    + "           ,[Content]\n"
                    + "           ,[status]\n"
                    + "           ,[record_date])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,GETDATE())";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getUser_id());
            stm.setString(2, model.getEmail());
            stm.setString(3, model.getPhone_number());
            stm.setString(4, model.getTitle());
            stm.setString(5,model.getContent());
            stm.setBoolean(6, model.isStatus());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConversationDBContext.class.getName()).log(Level.SEVERE, "update false", ex);
        } finally {
            try {
                if(stm != null){
                    stm.close(); 
                }      
            } catch (SQLException ex) {
                Logger.getLogger(ConversationDBContext.class.getName()).log(Level.SEVERE, "False close connection", ex);
            }
        }
    }

    @Override
    public void update(Conversation model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Conversation model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Conversation get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Conversation> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
