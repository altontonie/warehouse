package thashort.gamer.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thashort.gamer.warehouse.entity.dao.Sales;

@Repository
public interface SalesRepo extends JpaRepository<Sales, Integer> {
}
