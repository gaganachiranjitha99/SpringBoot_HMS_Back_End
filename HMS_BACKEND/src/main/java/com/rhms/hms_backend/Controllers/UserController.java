package com.rhms.hms_backend.Controllers;

import com.rhms.hms_backend.Models.Users;
import com.rhms.hms_backend.Repositories.UserRepo;
import com.rhms.hms_backend.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserRepo userRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> adminWelcome(){
        return ResponseEntity.ok("Admin Board");
    }

    @GetMapping("/allUsers")
    public List<Users> getAllUsers(){
        return userRepo.findAll();
    }

    @PostMapping ("/assign/{input_user_index}/{input_room_no}")
    public String getMessageByIndexAndRoom(@PathVariable ("input_user_index") String user_index, @PathVariable ("input_room_no") String room) {
        return userService.getMessageByIndexAndRoom(user_index, room);
    }

}
