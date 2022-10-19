package thashort.gamer.warehouse.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import thashort.gamer.warehouse.entity.dao.Users;
import thashort.gamer.warehouse.entity.dto.UsersDto;
import thashort.gamer.warehouse.repository.CompanyRepo;
import thashort.gamer.warehouse.repository.UsersRepo;
import thashort.gamer.warehouse.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    CompanyRepo companyRepo;

    @Override
    public ResponseEntity<List<UsersDto>> getAllUsers() {
        List<UsersDto> result = new ArrayList<>();
        List<Users> data = usersRepo.findAll();
        for (Users users :
                data) {
            UsersDto usersDto = new UsersDto();
            BeanUtils.copyProperties(users,usersDto);
            BeanUtils.copyProperties(users.getCompanyId(),usersDto.getCompanyId());
            result.add(usersDto);
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<UsersDto> getUserById(String id) {
        UsersDto result = new UsersDto();
        Users data = usersRepo.findByUserID(id);
        BeanUtils.copyProperties(data,result);
        BeanUtils.copyProperties(data.getCompanyId(),result.getCompanyId());
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<UsersDto> addUser(UsersDto usersDto) {
        if(companyRepo.existsByCompanyID(usersDto.getCompanyId().getCompanyID())){
            UsersDto result = new UsersDto();
            Users users = new Users();
            String uniqueID = UUID.randomUUID().toString();
            usersDto.setUserID(uniqueID);
            BeanUtils.copyProperties(usersDto,users);
            BeanUtils.copyProperties(usersDto.getCompanyId(),users.getCompanyId());
            Users data = usersRepo.save(users);
            BeanUtils.copyProperties(data,result);
            return ResponseEntity.ok(result);
        }else return ResponseEntity.status(403).body(usersDto);
    }

    @Override
    public ResponseEntity<UsersDto> updateUser(String id, UsersDto usersDto) {
         Users user = usersRepo.findByUserID(id);
         user.setEmail(usersDto.getEmail());
         user.setFirstName(usersDto.getFirstName());
         user.setLastName(usersDto.getLastName());
         user.setPassword(usersDto.getPassword());
         user.setUsername(usersDto.getUsername());
         user.setType(usersDto.getType());

         final Users result = usersRepo.save(user);
         UsersDto data = new UsersDto();
         BeanUtils.copyProperties(result,data);
         BeanUtils.copyProperties(result.getCompanyId(),data.getCompanyId());
         return ResponseEntity.ok(data);
    }
}
