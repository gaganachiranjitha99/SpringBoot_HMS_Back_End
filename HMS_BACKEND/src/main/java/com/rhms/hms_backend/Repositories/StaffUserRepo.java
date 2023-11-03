package com.rhms.hms_backend.Repositories;

import com.rhms.hms_backend.Models.StaffUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StaffUserRepo extends JpaRepository<StaffUsers,Long> {

    @Transactional
    @Procedure(procedureName="staff_users_view")
    List<StaffUsers> staff_users_view();

}
