package thashort.gamer.warehouse.service;

import org.springframework.http.ResponseEntity;
import thashort.gamer.warehouse.entity.dto.ProductsDto;

import java.util.List;

public interface ProductService {
    ResponseEntity<List<ProductsDto>> getAllProducts();

    ResponseEntity<ProductsDto> getProductById(String id);

    ResponseEntity<List<ProductsDto>> searchProducts(String q);

    ResponseEntity<ProductsDto> addProduct(ProductsDto productsDto);

    ResponseEntity<ProductsDto> updateProduct(String id, ProductsDto productsDto);

    ResponseEntity<String> deleteProduct(String id);
}
