package com.rhms.hms_backend.Services;

import com.rhms.hms_backend.Configurations.AccessRequest;
import com.rhms.hms_backend.Configurations.AccessResponse;
import com.rhms.hms_backend.Configurations.RegisterRequests;
import com.rhms.hms_backend.Models.Role;
import com.rhms.hms_backend.Models.Users;
import com.rhms.hms_backend.Repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AccessResponse register (RegisterRequests request) {
        if ("ADMIN".equals(request.getRole())) {
            var users = Users.builder()
                    .fname(request.getFname())
                    .lname(request.getLname())
                    .user_index(request.getUser_index())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.ADMIN)
                    .build();
            userRepo.save(users);
            var jwtToken = jwtService.generateToken(users);
            return AccessResponse.builder()
                    .Token(jwtToken)
                    .build();
        } else if ("STUDENT".equals(request.getRole())) {
            var users = Users.builder()
                    .fname(request.getFname())
                    .lname(request.getLname())
                    .user_index(request.getUser_index())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.STUDENT)
                    .build();
            userRepo.save(users);
            var jwtToken = jwtService.generateToken(users);
            return AccessResponse.builder()
                    .Token(jwtToken)
                    .build();
        }
            return null;
        }


        public AccessResponse authenticate(AccessRequest request){
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUser_index(),
                            request.getPassword()
                    )
            );

            var users = userRepo.findByIndex(request.getUser_index())
                    .orElseThrow();
            var jwtToken = jwtService.generateToken(users);
            return AccessResponse.builder()
                    .Token(jwtToken)
                    .build();

        }


        public Users getUserByIndex(String user_index){
            return userRepo.findByIndex(user_index)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with Index: " + user_index));
        }

//    public Users updateUserProfile(Users users) {
//        Integer id = users.getId();
//
//        Users user1 = userRepo.findById(id).get();
//        user1.setFname(users.getFname());
//        user1.setLname(users.getLname());
//        user1.setPassword(passwordEncoder.encode(users.getPassword()));
//        user1.setRole(users.getRole());
//        return userRepo.save(user1);
//    }
        public Users getUserById (Long id){
            return userRepo.findById(id).orElse(null);
        }

//    public Users updateUser(User users) {
//        return updateRepo.save(users);
//    }
    }
