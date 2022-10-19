package thashort.gamer.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import thashort.gamer.warehouse.entity.dao.Company;
import thashort.gamer.warehouse.entity.dao.Users;
import thashort.gamer.warehouse.entity.dto.UsersDto;

import java.util.List;

@Repository
public interface UsersRepo extends JpaRepository<Users,Integer> {
    Users findByUserID(String id);
    List<Users> findAllByCompanyId(Company company);
    Users findByCompanyIdAndUserID(Company company, String genID);
    Boolean existsByUsername(String username);
    boolean existsByUsernameAndPassword(String u, String p);

    @Query(value = "SELECT CompanyID FROM users WHERE Username = ? ", nativeQuery = true)
    String findCompanyId(String id);

    @Query(value = "SELECT ID,userid,CompanyID,first_name,last_name,Username,Email,Password,Type FROM users WHERE Username = ? ", nativeQuery = true)
    Users findUser(String u);
}
