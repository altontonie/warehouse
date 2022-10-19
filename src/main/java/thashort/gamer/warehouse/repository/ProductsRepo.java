package thashort.gamer.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thashort.gamer.warehouse.entity.dao.Company;
import thashort.gamer.warehouse.entity.dao.Products;

import java.util.List;

@Repository
public interface ProductsRepo extends JpaRepository<Products,Integer> {
    Products findByProductID(String id);
    List<Products> findAllByNameContainingOrDescriptionContainingOrBrandContainingOrTypeContainingOrTagsContainingOrIndustryContaining(String name,String desc,String brand,String type,String tags,String industry);
    List<Products> findAllByCompanyId(Company companyId);
    Products findByCompanyIdAndProductID(Company company,String id);
    List<Products> findAllByCompanyIdAndNameContainingOrDescriptionContainingOrBrandContainingOrTypeContainingOrTagsContainingOrIndustryContaining(Company company, String name,String desc,String brand,String type,String tags,String industry);
    Boolean existsByProductID(String id);
}
