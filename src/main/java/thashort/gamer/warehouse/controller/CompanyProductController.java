package thashort.gamer.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thashort.gamer.warehouse.entity.dto.ProductsDto;
import thashort.gamer.warehouse.service.CompanyProductService;

import java.util.List;

@RestController
@RequestMapping(path = "/company/products")
public class CompanyProductController {

    @Autowired
    CompanyProductService companyProductService;

    @GetMapping(path = "/{compId}")
    public ResponseEntity<List<ProductsDto>> getAllProducts(@PathVariable String compId){
        return companyProductService.getAllProducts(compId);
    }

    @GetMapping(path = "/{compId}/{id}")
    public ResponseEntity<ProductsDto> getProductById(@PathVariable String compId,@PathVariable String id){
        return companyProductService.getProductById(compId,id);
    }

    @GetMapping(path = "/{compId}/search")
    public ResponseEntity<List<ProductsDto>> searchProducts(@PathVariable String compId,@RequestParam String q){
        return companyProductService.searchProducts(compId,q);
    }

    @PostMapping(path = "/{compId}")
    public ResponseEntity<ProductsDto> addProduct(@PathVariable String compId,@RequestBody ProductsDto productsDto){
        return companyProductService.addProduct(compId,productsDto);
    }

    @PutMapping(path = "/{compId}/{id}")
    public ResponseEntity<ProductsDto> updateProduct(@PathVariable String compId,@PathVariable String id,@RequestBody ProductsDto productsDto){
        return companyProductService.updateProduct(compId,id,productsDto);
    }

    @DeleteMapping(path = "/{compId}/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String compId,@PathVariable String id){
        return companyProductService.deleteProduct(compId,id);
    }

}
