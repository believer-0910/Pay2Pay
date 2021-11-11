package uz.pdp.model;

import uz.pdp.service.UserService;

import java.util.UUID;

public class User extends BaseModel{
    private String username;
    private String password;
    private boolean isAdmin;




    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
