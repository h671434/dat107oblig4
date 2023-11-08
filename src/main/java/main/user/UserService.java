package main.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired private UserRepo repo;

    public User registerUser(User user){
        return repo.save(user);
    }

    public boolean findByPhone(String phone){
        return repo.existsById(phone);
    }

    public Optional<User> findById(String phone){
        return repo.findById(phone);
    }


    public List<User> getAllUsers(){
        return repo.findAll();
    }

}
