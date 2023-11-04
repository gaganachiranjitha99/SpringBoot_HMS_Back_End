package com.rhms.hms_backend.Repositories;

import com.rhms.hms_backend.Models.Complain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface ComplainRepo extends JpaRepository<Complain, Long> {

//    List<Complain> findByUserIndex(String user_Index);
@Query("SELECT c FROM Complain c WHERE c.user_index = :user_index")
List<Complain> findByUserIndex(@Param("user_index") String user_index);




}
