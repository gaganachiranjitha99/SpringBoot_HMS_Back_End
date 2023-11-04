package com.rhms.hms_backend.Repositories;

import com.rhms.hms_backend.Models.ResolvedComplain;
import com.rhms.hms_backend.Models.ResolvedComplainCopy;
import com.rhms.hms_backend.Models.SubwardenComplains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ComplainResolvedRepo extends JpaRepository<ResolvedComplain,Long> {

    @Transactional
    @Procedure(procedureName="all_resolved_complain_view")
    List<ResolvedComplain> all_resolved_complain_view();


}
