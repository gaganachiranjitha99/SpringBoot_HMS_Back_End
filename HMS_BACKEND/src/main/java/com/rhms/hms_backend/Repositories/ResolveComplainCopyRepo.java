package com.rhms.hms_backend.Repositories;

import com.rhms.hms_backend.Models.ResolvedComplainCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResolveComplainCopyRepo extends JpaRepository<ResolvedComplainCopy,Long>{
}
