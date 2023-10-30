package com.rhms.hms_backend.Services;

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

    public Optional<Room> getRoomById(Long ID) {
        return roomRepo.findById(ID);
    }

    public Room updateRoom(Long ID, Room updatedRoom) {
        if (roomRepo.existsById(ID)) {
            updatedRoom.setID(ID);
            return roomRepo.save(updatedRoom);
        } else {
            return null;
        }
    }

    public void deleteRoom(Long ID) {
        roomRepo.deleteById(ID);
    }

}
