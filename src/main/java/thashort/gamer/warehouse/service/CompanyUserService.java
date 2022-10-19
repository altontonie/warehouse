package thashort.gamer.warehouse.service;

import org.springframework.http.ResponseEntity;
import thashort.gamer.warehouse.entity.dto.UsersDto;

import java.util.List;

public interface CompanyUserService {
    ResponseEntity<List<UsersDto>> getAllUsers(String compId);

    ResponseEntity<UsersDto> getUserById(String compId, String id);

    ResponseEntity<UsersDto> addUser(String compId, UsersDto usersDto);

    ResponseEntity<UsersDto> updateUser(String compId, String id, UsersDto usersDto);

    ResponseEntity<UsersDto> logIn(String u, String p);
}
