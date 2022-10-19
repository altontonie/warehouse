package thashort.gamer.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thashort.gamer.warehouse.entity.dao.Products;
import thashort.gamer.warehouse.entity.dao.Size;

import java.util.List;

@Repository
public interface SizeRepo extends JpaRepository<Size, Integer> {
    Size findBySize1ID(String id);
    List<Size> findAllByProductID(Products product);
    Size findBySize1IDAndProductID(String id, Products product);
}
