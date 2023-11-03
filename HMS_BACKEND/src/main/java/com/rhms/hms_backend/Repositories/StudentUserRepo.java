package com.rhms.hms_backend.Repositories;

import com.rhms.hms_backend.Models.StaffUsers;
import com.rhms.hms_backend.Models.StudentUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentUserRepo extends JpaRepository<StudentUsers,Long> {
    @Transactional
    @Procedure(procedureName="student_users_view")
    List<StudentUsers> student_users_view();


}
