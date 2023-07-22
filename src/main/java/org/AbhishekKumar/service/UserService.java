package org.AbhishekKumar.service;

import org.AbhishekKumar.model.User;
import org.AbhishekKumar.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public List<User> getAllUsers() {
        return  userRepo.getUserList();
    }

    public User getUser(Integer uId) {
        List<User> myUserList = getAllUsers();
        for(User u : myUserList) {
            if (uId.equals(u.getUserId())) {
                return u;
            }
        }
        throw new IllegalStateException("Id not found");

    }

    public String addUser(User user) {
        List<User> myUserList = getAllUsers();
        myUserList.add(user);
        return "User" + " " + user.getUserId()+" " + "Added Successfully";
    }

    public String addUsers(List<User> usersList) {
        List<User> myUserList = getAllUsers();
        myUserList.addAll(usersList);
        return "Users Added Successfully";
    }

    public String UpdateUserInfo(Integer uId,User user) {
        List<User> myUserList = getAllUsers();
        for(User u : myUserList){
            if(uId.equals(u.getUserId())){
                u.setUserName(user.getUserName());
                u.setUserDOB(user.getUserDOB());
                u.setUserEmail(user.getUserEmail());
                u.setUserPassword(user.getUserPassword());
                u.setUserPhoneNumber(user.getUserPhoneNumber());
                return "User "+" : "+u.getUserId()+" "+"Details updated!!!!";
            }
        }
        return "No such User"+" "+uId+" "+"found!!!";
    }

    public String remove(Integer uId) {
        List<User> myUserList = getAllUsers();
        for(User u : myUserList){
            if(uId.equals(u.getUserId())){
                myUserList.remove(u);
                return "User"+" : "+uId+" "+"Deleted Successfully";
            }
        }
        return "No such User"+" "+uId+" "+"found!!!";

    }
}
