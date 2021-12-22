/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;


/**
 *
 * @author nyanpasu
 */
public class User {
                  private int id;
	private String username;
	private String password;
                    private String secret;

    public User(int id, String username, String password, String secret) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.secret = secret;
    }

    public User(String username, String password, String secret) {
        this.username = username;
        this.password = password;
        this.secret = secret;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + '}';
    }
    
}
