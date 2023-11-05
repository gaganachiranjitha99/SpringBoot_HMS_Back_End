package com.rhms.hms_backend.Repositories;

import com.rhms.hms_backend.Models.ResolvedComplain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ComplainResolvedRepo extends JpaRepository<ResolvedComplain,Long> {

    @Transactional
    @Procedure(procedureName="all_resolved_complain_view")
    List<ResolvedComplain> all_resolved_complain_view();

    @Query("SELECT c FROM ResolvedComplain c WHERE c.user_index = :user_index")
    List<ResolvedComplain> findByUserIndex(@Param("user_index") String user_index);



}
