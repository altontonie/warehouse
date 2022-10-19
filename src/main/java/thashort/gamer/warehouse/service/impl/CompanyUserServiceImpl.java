package thashort.gamer.warehouse.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import thashort.gamer.warehouse.entity.dao.Company;
import thashort.gamer.warehouse.entity.dao.Users;
import thashort.gamer.warehouse.entity.dto.CompanyDto;
import thashort.gamer.warehouse.entity.dto.UsersDto;
import thashort.gamer.warehouse.repository.CompanyRepo;
import thashort.gamer.warehouse.repository.UsersRepo;
import thashort.gamer.warehouse.service.CompanyUserService;

import java.util.ArrayList;
import java.util.List;


@Service
public class CompanyUserServiceImpl implements CompanyUserService {

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    CompanyRepo companyRepo;

    @Override
    public ResponseEntity<List<UsersDto>> getAllUsers(String compId) {
        Company company = companyRepo.findByCompanyID(compId);
        List<Users> users = usersRepo.findAllByCompanyId(company);
        List<UsersDto> results = new ArrayList<>();
        for (Users data :
                users) {
            UsersDto usersDto = new UsersDto();
            BeanUtils.copyProperties(data,usersDto);
            results.add(usersDto);
        }
        return ResponseEntity.ok(results);
    }

    @Override
    public ResponseEntity<UsersDto> getUserById(String compId, String id) {
        Company company = companyRepo.findByCompanyID(compId);
        Users users = usersRepo.findByCompanyIdAndUserID(company,id);
        UsersDto usersDto = new UsersDto();
        BeanUtils.copyProperties(users,usersDto);
        return ResponseEntity.ok(usersDto);
    }

    @Override
    public ResponseEntity<UsersDto> addUser(String compId, UsersDto usersDto) {
        Company company = companyRepo.findByCompanyID(compId);
        CompanyDto companyDto = new CompanyDto();
        BeanUtils.copyProperties(company,companyDto);
        usersDto.setCompanyId(companyDto);
        Users data = new Users();
        BeanUtils.copyProperties(usersDto,data);
        Users users = usersRepo.save(data);
        UsersDto result = new UsersDto();
        BeanUtils.copyProperties(users,result);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<UsersDto> updateUser(String compId, String id, UsersDto usersDto) {
        Company company = companyRepo.findByCompanyID(compId);
        Users user = usersRepo.findByCompanyIdAndUserID(company,id);
        user.setEmail(usersDto.getEmail());
        user.setFirstName(usersDto.getFirstName());
        user.setLastName(usersDto.getLastName());
        user.setPassword(usersDto.getPassword());
        user.setUsername(usersDto.getUsername());
        user.setType(usersDto.getType());
        final Users result = usersRepo.save(user);
        UsersDto data = new UsersDto();
        BeanUtils.copyProperties(result,data);
        return ResponseEntity.ok(data);
    }

    @Override
    public ResponseEntity<UsersDto> logIn(String u, String p) {
        if(usersRepo.existsByUsername(u)){
            if(usersRepo.existsByUsernameAndPassword(u,p)){
               // Company company = companyRepo.findByCompanyID(usersRepo.findCompanyId(u));
                Users users = usersRepo.findUser(u);
                //users.setCompanyId(company);
                UsersDto usersDto = new UsersDto();
                BeanUtils.copyProperties(users,usersDto);
                BeanUtils.copyProperties(users.getCompanyId(),usersDto.getCompanyId());
                return ResponseEntity.ok(usersDto);
            }else return ResponseEntity.status(401).body(new UsersDto(u));
        }else return ResponseEntity.status(404).body(new UsersDto(u));
    }
}
