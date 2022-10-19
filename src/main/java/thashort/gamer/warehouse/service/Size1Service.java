package thashort.gamer.warehouse.service;

import org.springframework.http.ResponseEntity;
import thashort.gamer.warehouse.entity.dto.SizeDto;

import java.util.List;

public interface Size1Service {
    ResponseEntity<List<SizeDto>> getAllSize1();

    ResponseEntity<SizeDto> getSizeById(String id);

    ResponseEntity<List<SizeDto>> getAllSize1ForProduct(String productId);

    ResponseEntity<SizeDto> getSize1ForProduct(String productId, String sizeId);

    ResponseEntity<SizeDto> addSize1ForProduct(String productId,SizeDto sizeDto);

    ResponseEntity<SizeDto> updateSize1ForProduct(String productId, String sizeId, SizeDto sizeDto);

    ResponseEntity<String> deleteSize1ForProduct(String productId, String sizeId);
}
