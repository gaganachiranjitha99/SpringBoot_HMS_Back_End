package com.rhms.hms_backend.Controllers;


import com.rhms.hms_backend.Models.Users;
import com.rhms.hms_backend.Repositories.UserRepo;
import com.rhms.hms_backend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {



@Autowired
private UserService userService;

    @GetMapping("/all")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id){
        Users user = userService.getUserById(id);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return  new ResponseEntity<>(user,HttpStatus.OK);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.deleteUser(id));
    }
    @GetMapping("/userCount")
    public Integer getUserCount(){
        return userService.getUserCount();
    }


//    @PutMapping("/update/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
//        User user = userService.getUserById(id);
//        if (user != null) {
//            // Update specific fields based on the values in the updatedUser object
//            if (updatedUser.getFirstname() != null) {
//                user.setFirstname(updatedUser.getFirstname());
//            }
//            if (updatedUser.getLastname() != null) {
//                user.setLastname(updatedUser.getLastname());
//            }
//            if (updatedUser.getEmail() != null) {
//                user.setEmail(updatedUser.getEmail());
//            }
//            if (updatedUser.getRole() != null) {
//                user.setRole(updatedUser.getRole());
//            }
//            User updatedUserEntity = userService.updateUser(user);
//            return ResponseEntity.ok(updatedUserEntity);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

}
