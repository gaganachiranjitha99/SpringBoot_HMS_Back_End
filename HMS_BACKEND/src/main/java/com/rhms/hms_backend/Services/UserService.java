package com.rhms.hms_backend.Services;

import com.rhms.hms_backend.Models.StaffUsers;
import com.rhms.hms_backend.Models.StudentUsers;
import com.rhms.hms_backend.Models.Users;
import com.rhms.hms_backend.Repositories.StaffUserRepo;
import com.rhms.hms_backend.Repositories.StudentUserRepo;
import com.rhms.hms_backend.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;

@Service

public class UserService {


    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    StaffUserRepo staffUserRepo;
    @Autowired
    StudentUserRepo studentUserRepo;


    @Transactional
    public List<StaffUsers> getStaffUsersView() {
        return staffUserRepo.staff_users_view();
    }

    @Transactional
    public List<StudentUsers> getStudentUsersView() {
        return studentUserRepo.student_users_view();
    }

    public Users getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }


//Delete user
    public HttpStatus deleteUser(Long id) {
        try {
            Users users = userRepo.findById(id).orElse(null);
            if (users == null) {
                return HttpStatus.NOT_FOUND;
            }


            userRepo.delete(users);
            return HttpStatus.NO_CONTENT;

        } catch (EmptyResultDataAccessException e) {
            return HttpStatus.NOT_FOUND;
        } catch (DataIntegrityViolationException e) {
            return HttpStatus.BAD_REQUEST;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public Integer getUserCount(){
        return Math.toIntExact(userRepo.count());
    }


    public String getMessageByIndexAndRoom(String user_index, String room) {
        return userRepo.getMessageByIndexAndRoom(user_index, room);
    }


    }
