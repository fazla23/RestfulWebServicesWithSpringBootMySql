package com.fazla.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserDaoService {
    static List<User> users= new ArrayList<>();
    static int idCount=0;
    static {
        users.add(new User(++idCount,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++idCount,"Eve", LocalDate.now().minusYears(30)));
        users.add(new User(++idCount,"Jim", LocalDate.now().minusYears(30)));
    }

    public List<User> getUsers(){
        return users;
    }

    public User getUserById(int id){
        Predicate<? super User> predicate = user -> user.getId()==id;
        User user = users.stream().filter(predicate).findFirst().orElse(null);
        return user;
    }

    public User save(User user){
        user.setId(++idCount);
        users.add(user);
        return user;
    }

    public void deleteUserById(int id) {
        Predicate<? super User> predicate = user -> user.getId()==id;
        users.removeIf(predicate);
    }
}
