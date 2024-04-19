package com.example.neofinanceapi.controllers;

import com.example.neofinanceapi.dto.UserDto;
import com.example.neofinanceapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<Integer> save(
            @RequestBody UserDto userDto
    ) {
        return ResponseEntity.ok(userService.save(userDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }
}
