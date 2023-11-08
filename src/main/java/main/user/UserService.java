package main.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired private UserRepo repo;

    public User registerUser(User user){
        return repo.save(user);
    }

    public boolean findByPhone(String phone){
        return repo.existsById(phone);
    }

}
