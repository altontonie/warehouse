package thashort.gamer.warehouse.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import thashort.gamer.warehouse.entity.dao.Company;
import thashort.gamer.warehouse.entity.dao.Products;
import thashort.gamer.warehouse.entity.dao.Users;
import thashort.gamer.warehouse.entity.dto.ProductsDto;
import thashort.gamer.warehouse.repository.CompanyRepo;
import thashort.gamer.warehouse.repository.ProductsRepo;
import thashort.gamer.warehouse.repository.UsersRepo;
import thashort.gamer.warehouse.service.CompanyProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CompanyProductServiceImpl implements CompanyProductService {

    @Autowired
    ProductsRepo productsRepo;

    @Autowired
    CompanyRepo companyRepo;

    @Autowired
    UsersRepo usersRepo;

    @Override
    public ResponseEntity<List<ProductsDto>> getAllProducts(String compId) {
        List<ProductsDto> result = new ArrayList<>();
        Company company = companyRepo.findByCompanyID(compId);
        List<Products> data = productsRepo.findAllByCompanyId(company);
        for (Products products :
                data) {
            ProductsDto productsDto = new ProductsDto();
            BeanUtils.copyProperties(products,productsDto);
            //BeanUtils.copyProperties(products.getCompanyId(),productsDto.getCompanyId());
            result.add(productsDto);
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<ProductsDto> getProductById(String compId, String id) {
        ProductsDto result = new ProductsDto();
        Company company = companyRepo.findByCompanyID(compId);
        Products data = productsRepo.findByCompanyIdAndProductID(company,id);
        if(data != null){
            BeanUtils.copyProperties(data,result);
            //BeanUtils.copyProperties(data.getCompanyId(),result.getCompanyId());
            return ResponseEntity.ok(result);
        }else return ResponseEntity.status(404).body(new ProductsDto());
    }

    @Override
    public ResponseEntity<List<ProductsDto>> searchProducts(String compId, String q) {
        Company company = companyRepo.findByCompanyID(compId);
        List<Products> data = productsRepo.findAllByCompanyIdAndNameContainingOrDescriptionContainingOrBrandContainingOrTypeContainingOrTagsContainingOrIndustryContaining(company,q,q,q,q,q,q);
        List<ProductsDto> productsDtos = new ArrayList<>();
        for (Products products :
                data) {
            ProductsDto productsDto = new ProductsDto();
            BeanUtils.copyProperties(products,productsDto);
            //BeanUtils.copyProperties(products.getCompanyId(),productsDto.getCompanyId());
            productsDtos.add(productsDto);
        }
        return ResponseEntity.ok(productsDtos);
    }

    @Override
    public ResponseEntity<ProductsDto> addProduct(String compId, ProductsDto productsDto) {
        if(companyRepo.existsByCompanyID(compId)){
            ProductsDto result = new ProductsDto();
            Products products = new Products();
            String uniqueID = UUID.randomUUID().toString();
            productsDto.setProductID(uniqueID);
            BeanUtils.copyProperties(productsDto,products);
            //BeanUtils.copyProperties(productsDto.getCompanyId(),products.getCompanyId());
            Company company = companyRepo.findByCompanyID(compId);
            Users users = usersRepo.findByUserID(productsDto.getUserID().getUserID());
            products.setCompanyId(company);
            products.setUserID(users);
            Products data = productsRepo.save(products);
            BeanUtils.copyProperties(data,result);
            return ResponseEntity.ok(result);
        }else return ResponseEntity.status(403).body(productsDto);
    }

    @Override
    public ResponseEntity<ProductsDto> updateProduct(String compId, String id, ProductsDto productsDto) {
        Products products = productsRepo.findByProductID(id);
        products.setName(productsDto.getName());
        products.setDescription(productsDto.getDescription());
        products.setBrand(productsDto.getBrand());
        products.setType(productsDto.getType());
        products.setTags(productsDto.getTags());
        products.setStock(productsDto.getStock());
        products.setIndustry(productsDto.getIndustry());
        products.setImages(productsDto.getImages());

        final Products result = productsRepo.save(products);
        ProductsDto data = new ProductsDto();
        BeanUtils.copyProperties(result,data);
        //BeanUtils.copyProperties(result.getCompanyId(),data.getCompanyId());
        return ResponseEntity.ok(data);
    }

    @Override
    public ResponseEntity<String> deleteProduct(String compId, String id) {
        try{
            Company company = companyRepo.findByCompanyID(compId);
            Products products = productsRepo.findByCompanyIdAndProductID(company,id);
            productsRepo.delete(products);
            return ResponseEntity.ok("Successful");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(404).body("Could not delete product");
        }
    }
}
