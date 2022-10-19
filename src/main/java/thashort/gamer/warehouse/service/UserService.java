package thashort.gamer.warehouse.service;

import org.springframework.http.ResponseEntity;
import thashort.gamer.warehouse.entity.dto.UsersDto;

import java.util.List;

public interface UserService {
    ResponseEntity<List<UsersDto>> getAllUsers();

    ResponseEntity<UsersDto> getUserById(String id);

    ResponseEntity<UsersDto> addUser(UsersDto usersDto);

    ResponseEntity<UsersDto> updateUser(String id, UsersDto usersDto);
}
