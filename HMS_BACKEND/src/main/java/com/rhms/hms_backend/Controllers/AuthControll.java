package com.rhms.hms_backend.Controllers;

import com.rhms.hms_backend.Configurations.AccessRequest;
import com.rhms.hms_backend.Configurations.AccessResponse;
import com.rhms.hms_backend.Configurations.RegisterRequests;
import com.rhms.hms_backend.Models.Users;
import com.rhms.hms_backend.Services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthControll {

    private final AuthService authService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<AccessResponse> register(@RequestBody RegisterRequests request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")

    public ResponseEntity<AccessResponse>login(@RequestBody AccessRequest request){
        return ResponseEntity.ok(authService.authenticate(request));
    }

//    @GetMapping("/CurrentUser")
//    public navBarLogin getCurrentUser(){  //Getting the CurrentUser username Using Authentication Interface that comes with Spring Security
//        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
//        String firstname=authentication.getName();
//        return new navBarLogin(firstname);
//    }
    @GetMapping("/UserProfile")
    public Users getCurrentUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String index = authentication.getName();
        return authService.getUserByIdex(index);
    }

//    @PutMapping("/UpdateProfile")
//    public ResponseEntity<Users> updateUserProfile (@RequestBody Users updatedUser){
//        int id = updatedUser.getId();
//        Users users = authService.getUserById(id);
//
//        if (users != null) {
//            // Update specific fields based on the values in the updatedUser object
//            if (updatedUser.getFirstname() != null) {
//                users.setFirstname(updatedUser.getFirstname());
//            }
//            if (updatedUser.getLastname() != null) {
//                users.setLastname(updatedUser.getLastname());
//            }
//            if (updatedUser.getIndex() != null) {
//                users.setEmail(updatedUser.getEmail());
//            }
//            if (updatedUser.getPassword() != null){
//                users.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
//            }
//            if (updatedUser.getRole() != null) {
//                users.setRole(updatedUser.getRole());
//            }
//            Users updatedUserEntity = authenticationService.updateUser(users);
//            return ResponseEntity.ok(updatedUserEntity);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

}
