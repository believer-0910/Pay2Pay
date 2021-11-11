package uz.pdp.service;

import uz.pdp.model.History;
import uz.pdp.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService implements UserServiceInterface{
    List<User> userList = new ArrayList<>();

    public UserService() {
        User user = new User();
        user.setId();
        user.setName("Saidamin");
        user.setUsername("believer");
        user.setPassword("root");
        user.setPhoneNumber("12345");
        user.setAdmin(true);
        userList.add(user);
    }

    @Override
    public Integer add(User user) {
        if (checkUser(user.getPhoneNumber()))
            return -1;
        userList.add(user);
        return 0;
    }

    @Override
    public void get() {
        for(User user: userList){
            if(user != null)
                System.out.println(user.getName() + " || " + user.getUsername() + " || " + user.getPhoneNumber() + " || ");
        }
    }

    @Override
    public void delete(String cardNumber) {
        userList.removeIf(user -> user.getPhoneNumber().equals(cardNumber));
    }

    @Override
    public boolean checkUser(String phoneNumber) {
        for(User user: userList){
            if(user.getPhoneNumber().equals(phoneNumber))
                return true;
        }
        return false;
    }

    @Override
    public boolean checkAdmin(String phoneNumber) {
        for(User user: userList){
            if(user.getPhoneNumber().equals(phoneNumber) && user.isAdmin())
                return true;
        }
        return false;
    }
}
