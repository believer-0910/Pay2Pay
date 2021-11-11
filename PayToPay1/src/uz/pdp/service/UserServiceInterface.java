package uz.pdp.service;

import uz.pdp.model.User;

public interface UserServiceInterface extends BaseService<User, Integer>{

    boolean checkUser(String phoneNumber);
    boolean checkAdmin(String phoneNumber);

}
