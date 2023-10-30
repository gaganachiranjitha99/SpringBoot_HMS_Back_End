package com.rhms.hms_backend.Repositories;

import com.rhms.hms_backend.Models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {
}
