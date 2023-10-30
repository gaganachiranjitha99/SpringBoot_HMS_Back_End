package com.rhms.hms_backend.Controllers;


import com.rhms.hms_backend.Models.Room;
import com.rhms.hms_backend.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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



}
