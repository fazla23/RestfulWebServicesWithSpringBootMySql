package com.fazla.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;
    @GetMapping("/users/old")
    public List<User> getUsers(){
        return userDaoService.getUsers();
    }

    @GetMapping("/users/old/{id}")
    public User getUser(@PathVariable int id){
        User userById = userDaoService.getUserById(id);
        if(userById==null)
            throw new UserNotFoundException("id:"+id);
        return userById;
    }

    @DeleteMapping("/users/old/{id}")
    public void deleteUser(@PathVariable int id){
        userDaoService.deleteUserById(id);
    }

    @PostMapping("/users/old")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
        User savedUser = userDaoService.save(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }


}
