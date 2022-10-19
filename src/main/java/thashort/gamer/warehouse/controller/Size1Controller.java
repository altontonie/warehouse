package thashort.gamer.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thashort.gamer.warehouse.entity.dto.SizeDto;
import thashort.gamer.warehouse.service.Size1Service;

import java.util.List;

@RestController
@RequestMapping(path = "/size1")
public class Size1Controller {

    @Autowired
    Size1Service size1Service;

    @GetMapping()
    public ResponseEntity<List<SizeDto>> getAllSize1(){
        return size1Service.getAllSize1();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SizeDto> getSizeById(@PathVariable String id){
        return size1Service.getSizeById(id);
    }

    @GetMapping(path = "/product/{productId}")
    public ResponseEntity<List<SizeDto>> getAllSize1ForProduct(@PathVariable String productId){
        return size1Service.getAllSize1ForProduct(productId);
    }

    @GetMapping(path = "/{productId}/{sizeId}")
    public ResponseEntity<SizeDto> getSize1ForProduct(@PathVariable String productId, @PathVariable String sizeId){
        return size1Service.getSize1ForProduct(productId,sizeId);
    }

    @PostMapping(path = "/{productId}")
    public ResponseEntity<SizeDto> addSize1ForProduct(@PathVariable String productId, @RequestBody SizeDto sizeDto){
        return size1Service.addSize1ForProduct(productId,sizeDto);
    }

    @PutMapping(path = "/{productId}/{sizeId}")
    public ResponseEntity<SizeDto> updateSize1ForProduct(@PathVariable String productId,@PathVariable String sizeId,@RequestBody SizeDto sizeDto){
        return size1Service.updateSize1ForProduct(productId,sizeId,sizeDto);
    }

    @DeleteMapping(path = "/{productId}/{sizeId}")
    public ResponseEntity<String> deleteSize1ForProduct(@PathVariable String productId, @PathVariable String sizeId){
        return size1Service.deleteSize1ForProduct(productId,sizeId);
    }
}
