package thashort.gamer.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thashort.gamer.warehouse.entity.dto.ProductsDto;
import thashort.gamer.warehouse.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public ResponseEntity<List<ProductsDto>> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductsDto> getProductById(@PathVariable String id){
        return productService.getProductById(id);
    }

    @GetMapping(path = "/search")
    public ResponseEntity<List<ProductsDto>> searchProducts(@RequestParam String q){
        return productService.searchProducts(q);
    }

    @PostMapping()
    public ResponseEntity<ProductsDto> addProduct(@RequestBody ProductsDto productsDto){
        return productService.addProduct(productsDto);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductsDto> updateProduct(@PathVariable String id,@RequestBody ProductsDto productsDto){
        return productService.updateProduct(id,productsDto);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id){
        return productService.deleteProduct(id);
    }

}
