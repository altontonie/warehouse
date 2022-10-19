package thashort.gamer.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thashort.gamer.warehouse.entity.dto.UsersDto;
import thashort.gamer.warehouse.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UsersDto>> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UsersDto> getUser(@PathVariable String id){
        return userService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<UsersDto> addUser(@RequestBody UsersDto usersDto){
        return userService.addUser(usersDto);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UsersDto> updateUser(@PathVariable String id, @RequestBody UsersDto usersDto){
        return userService.updateUser(id,usersDto);
    }
}
