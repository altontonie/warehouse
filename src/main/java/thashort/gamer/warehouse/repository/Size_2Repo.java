package thashort.gamer.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thashort.gamer.warehouse.entity.dao.Size_2;

@Repository
public interface Size_2Repo extends JpaRepository<Size_2,Integer> {
}
