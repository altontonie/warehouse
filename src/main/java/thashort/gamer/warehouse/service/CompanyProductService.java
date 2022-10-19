package thashort.gamer.warehouse.service;

import org.springframework.http.ResponseEntity;
import thashort.gamer.warehouse.entity.dto.ProductsDto;

import java.util.List;

public interface CompanyProductService {
    ResponseEntity<List<ProductsDto>> getAllProducts(String compId);

    ResponseEntity<ProductsDto> getProductById(String compId, String id);

    ResponseEntity<List<ProductsDto>> searchProducts(String compId, String q);

    ResponseEntity<ProductsDto> addProduct(String compId, ProductsDto productsDto);

    ResponseEntity<ProductsDto> updateProduct(String compId, String id, ProductsDto productsDto);

    ResponseEntity<String> deleteProduct(String compId, String id);
}
