package com.rhms.hms_backend.Controllers;

import com.rhms.hms_backend.Models.Room;
import com.rhms.hms_backend.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/create")
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room createRoom = roomService.createRoom(room);
        return new ResponseEntity<>(createRoom, HttpStatus.CREATED);
    }

    @GetMapping("/rooms")
    public List<Room> getAllRoom() {
        return roomService.getAllRoom();
    }

    @GetMapping("/rooms/{ID}")
    public Optional<Room> getRoomById(@PathVariable Long ID) {
        return roomService.getRoomById(ID);
    }

    @PutMapping("/rooms/{ID}")
    public Room updateRoom(@PathVariable Long ID, @RequestBody Room updatedRoom) {
        return roomService.updateRoom(ID, updatedRoom);
    }

    @DeleteMapping("rooms/{ID}")
    public void deleteRoom(@PathVariable Long ID) {
        roomService.deleteRoom(ID);
    }

}
