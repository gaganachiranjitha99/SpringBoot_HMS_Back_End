package com.rhms.hms_backend.Repositories;

import com.rhms.hms_backend.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {
    @Query("SELECT u FROM Users u WHERE u.user_index = :user_index")
    Optional<Users> findByIndex(String user_index);


    List<Users> findAll();

    @Query(value = "SELECT assign_student_to_room(:input_user_index, :input_room_no)", nativeQuery = true)
    String getMessageByIndexAndRoom(@Param("input_user_index") String user_index, @Param("input_room_no") String room);

}
