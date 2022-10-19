package thashort.gamer.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thashort.gamer.warehouse.entity.dto.UsersDto;
import thashort.gamer.warehouse.service.CompanyUserService;

import java.util.List;

@RestController
@RequestMapping(path = "/company/users")
public class CompanyUserController {

    @Autowired
    CompanyUserService userService;

    @GetMapping(path = "/{compId}")
    public ResponseEntity<List<UsersDto>> getAllUsers(@PathVariable String compId){
        return userService.getAllUsers(compId);
    }

    @GetMapping(path = "/{compId}/{id}")
    public ResponseEntity<UsersDto> getUser(@PathVariable String compId,@PathVariable String id){
        return userService.getUserById(compId,id);
    }

    @GetMapping(path = "/login")
    public ResponseEntity<UsersDto> logIn(@RequestParam String u, @RequestParam String p){
        return userService.logIn(u,p);
    }

    @PostMapping(path = "/{compId}")
    public ResponseEntity<UsersDto> addUser(@PathVariable String compId,@RequestBody UsersDto usersDto){
        return userService.addUser(compId,usersDto);
    }

    @PutMapping(path = "/{compId}/{id}")
    public ResponseEntity<UsersDto> updateUser(@PathVariable String compId,@PathVariable String id, @RequestBody UsersDto usersDto){
        return userService.updateUser(compId,id,usersDto);
    }


}
