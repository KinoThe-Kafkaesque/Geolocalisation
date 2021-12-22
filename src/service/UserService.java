/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.google.common.hash.Hashing;
import com.toedter.components.UTF8ResourceBundle;
import connexion.Connexion;
import dao.IDao;
import entities.User;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nyanpasu
 */
public class UserService implements IDao<User> {

    @Override
    public boolean create(User o) {
        try {

            String req = "insert into User values (null, ?,?,?)";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setString(1, o.getUsername());
            pr.setString(2, Hashing.sha256().hashString(o.getPassword(), StandardCharsets.UTF_8).toString());
            pr.setString(3, Hashing.sha256().hashString(o.getPassword(), StandardCharsets.UTF_8).toString());

            if (pr.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(User o) {
        try {
            String req = "update User set password = ? where username = ?  and secret = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setString(1, Hashing.sha256().hashString(o.getPassword(), StandardCharsets.UTF_8).toString());
            pr.setString(2, o.getUsername());
            pr.setString(3, Hashing.sha256().hashString(o.getSecret(), StandardCharsets.UTF_8).toString());

            if (pr.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("User : update");
        }

        return false;
    }

    @Override
    public boolean delete(User o) {
        try {
            String req = "delete from  User where id  = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, o.getId());
            if (pr.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println("User : delete");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User findById(int id) {
        try {
            String req = "select * from User where id  = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),rs.getString("secret"));
            }

        } catch (SQLException e) {
            System.out.println("User : FindById");
        }

        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<User>();
        try {
            String req = "select * from User";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);

            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),rs.getString("secret")));

            }

        } catch (SQLException e) {
            System.out.println("User : findAll");
        }

        return users;
    }

    public User login(String username, String password) {
        try {
            String req = "select * from User where username  = ? and password = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setString(1, username);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),rs.getString("secret"));
            }

        } catch (SQLException e) {
            System.out.println("User : FindById");
        }

        return null;
    }

}
