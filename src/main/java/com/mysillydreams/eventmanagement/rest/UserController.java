package com.mysillydreams.eventmanagement.rest;

import com.mysillydreams.eventmanagement.entity.UserEntity;
import com.mysillydreams.eventmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userapi")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserEntity userEntity){

         UserEntity user = new UserEntity(userEntity.getFirstName(), userEntity.getLastName(), userEntity.getEmail());
         userService.createUser(user);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public List<UserEntity> userEntityList(UserEntity user){
        return userService.findAll(user);
    }
    @GetMapping("users/{userId}")
    public UserEntity getUser(@PathVariable int userId){

        UserEntity theUser = userService.findById(userId);

        if(theUser == null){
            throw new RuntimeException("Employee id not found - " + userId);
        }
        return theUser;
    }

    // add mapping for PUT / users - update existing user

    @PutMapping("/users")
    public UserEntity updateUser(@RequestBody UserEntity user){

        UserEntity theUser = userService.update(user);
        return theUser;
    }

    //add mapping for DELETE / users/{userId} - delete user
    @DeleteMapping("users/{userId}")
    public String deleteUser(@PathVariable int userId){
        UserEntity theUser = userService.findById(userId);

        // throw exception if null

        if(theUser == null) {
            throw  new RuntimeException("User id not found - " + userId);
        }
        userService.deleteById(userId);

        return " Deleted user id - " + userId;
    }
}