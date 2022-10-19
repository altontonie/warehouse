package thashort.gamer.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thashort.gamer.warehouse.entity.dao.Company;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Integer> {
    Company findByCompanyID(String id);
    Boolean existsByCompanyID(String id);
}
