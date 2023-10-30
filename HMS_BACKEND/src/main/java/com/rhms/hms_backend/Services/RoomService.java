package com.rhms.hms_backend.Services;

import com.rhms.hms_backend.Models.Hostals;
import com.rhms.hms_backend.Models.Room;
import com.rhms.hms_backend.Repositories.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepo roomRepo;

    @Autowired
    public RoomService(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    public Room createRoom(Room room) {
        return roomRepo.save(room);
    }

    public List<Room> getAllRoom() {
        return roomRepo.findAll();
    }


}
