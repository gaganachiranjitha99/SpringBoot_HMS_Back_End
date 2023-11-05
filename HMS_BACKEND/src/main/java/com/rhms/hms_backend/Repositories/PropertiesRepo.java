package com.rhms.hms_backend.Repositories;

import com.rhms.hms_backend.Models.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PropertiesRepo extends JpaRepository<Properties, Long> {

    @Transactional
    @Procedure(procedureName = "property_view")
    List<Properties> property_view();

    @Transactional
    @Procedure(procedureName = "insert_property")
    void insertProperty(@Param("c_itemcode_param") String c_itemcode, @Param("name_param") String name, @Param("status_param") String status);
}
