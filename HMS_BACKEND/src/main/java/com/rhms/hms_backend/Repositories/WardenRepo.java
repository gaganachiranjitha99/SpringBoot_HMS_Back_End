package com.rhms.hms_backend.Repositories;

import com.rhms.hms_backend.Models.Complain;
import com.rhms.hms_backend.Models.WardenComplains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface WardenRepo extends JpaRepository<WardenComplains,Long> {

    @Transactional
    @Procedure(procedureName="warden_null_complain_view")
    List<WardenComplains> warden_null_complain_view();

    @Query("SELECT c FROM WardenComplains c WHERE c.user_index = :user_index")
    List<WardenComplains> findByUserIndex(@Param("user_index") String user_index);


}
