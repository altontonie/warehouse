package thashort.gamer.warehouse.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import thashort.gamer.warehouse.entity.dao.*;
import thashort.gamer.warehouse.entity.dto.ProductsDto;
import thashort.gamer.warehouse.entity.dto.SizeDto;
import thashort.gamer.warehouse.entity.dto.Size_2Dto;
import thashort.gamer.warehouse.repository.CompanyRepo;
import thashort.gamer.warehouse.repository.ProductsRepo;
import thashort.gamer.warehouse.repository.SizeRepo;
import thashort.gamer.warehouse.service.Size1Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class Size1ServiceImpl implements Size1Service {

    @Autowired
    SizeRepo sizeRepo;

    @Autowired
    ProductsRepo productsRepo;

    @Autowired
    CompanyRepo companyRepo;

    @Override
    public ResponseEntity<List<SizeDto>> getAllSize1() {
        List<SizeDto> result = new ArrayList<>();
        List<Size> data = sizeRepo.findAll();
        for (Size size :
                data) {
            SizeDto sizeDto = new SizeDto();
            BeanUtils.copyProperties(size,sizeDto);
            BeanUtils.copyProperties(size.getProductID(),sizeDto.getProductID());
            BeanUtils.copyProperties(size.getCompanyId(),sizeDto.getCompanyId());
            result.add(sizeDto);
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<SizeDto> getSizeById(String id) {
        SizeDto result = new SizeDto();
        Size data = sizeRepo.findBySize1ID(id);
        if(data != null){
            BeanUtils.copyProperties(data,result);
            BeanUtils.copyProperties(data.getProductID(),result.getProductID());
            BeanUtils.copyProperties(data.getCompanyId(),result.getCompanyId());
            return ResponseEntity.ok(result);
        }else return ResponseEntity.status(404).body(new SizeDto());
    }

    @Override
    public ResponseEntity<List<SizeDto>> getAllSize1ForProduct(String productId) {
        List<SizeDto> result = new ArrayList<>();
        Products products = productsRepo.findByProductID(productId);
        List<Size> data = sizeRepo.findAllByProductID(products);
        for (Size size :
                data) {
            SizeDto sizeDto = new SizeDto();
            BeanUtils.copyProperties(size,sizeDto);
            BeanUtils.copyProperties(size.getProductID(),sizeDto.getProductID());
            BeanUtils.copyProperties(size.getCompanyId(),sizeDto.getCompanyId());
            if(size.getSize2ID() != null){
                for (Size_2 size_2 :
                        size.getSize2ID()) {
                    Size_2Dto size_2Dto = new Size_2Dto();
                    BeanUtils.copyProperties(size_2,size_2Dto);
                    sizeDto.getSize2ID().add(size_2Dto);
                }
            }
            result.add(sizeDto);
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<SizeDto> getSize1ForProduct(String productId, String sizeId) {
        return null;
    }

    @Override
    public ResponseEntity<SizeDto> addSize1ForProduct(String productId, SizeDto sizeDto) {
        if(productsRepo.existsByProductID(productId)){
            SizeDto result = new SizeDto();
            Size size = new Size();
            String uniqueID = UUID.randomUUID().toString();
            sizeDto.setSize1ID(uniqueID);
            BeanUtils.copyProperties(sizeDto,size);
            //BeanUtils.copyProperties(productsDto.getCompanyId(),products.getCompanyId());
            Company company = companyRepo.findByCompanyID(sizeDto.getCompanyId().getCompanyID());
            Products products = productsRepo.findByProductID(productId);
            //Users users = usersRepo.findByUserID(productsDto.getUserID().getUserID());
            size.setCompanyId(company);
            size.setProductID(products);
            Size data = sizeRepo.save(size);
            BeanUtils.copyProperties(data,result);
            return ResponseEntity.ok(result);
        }else return ResponseEntity.status(403).body(sizeDto);
    }

    @Override
    public ResponseEntity<SizeDto> updateSize1ForProduct(String productId, String sizeId, SizeDto sizeDto) {
        Products product = productsRepo.findByProductID(productId);
        Size size = sizeRepo.findBySize1IDAndProductID(sizeId,product);
        size.setSize(sizeDto.getSize());
        size.setSize(sizeDto.getSize());
        size.setColor(sizeDto.getColor());
        size.setPrice(sizeDto.getPrice());
        size.setBought_From(sizeDto.getBought_From());
        size.setBuying_Price(sizeDto.getBuying_Price());
        size.setStock(sizeDto.getStock());
        size.setImages(sizeDto.getImages());

        final Size result = sizeRepo.save(size);
        SizeDto data = new SizeDto();
        BeanUtils.copyProperties(result,data);
        BeanUtils.copyProperties(result.getProductID(),data.getProductID());
        BeanUtils.copyProperties(result.getCompanyId(),data.getCompanyId());
        return ResponseEntity.ok(data);
    }

    @Override
    public ResponseEntity<String> deleteSize1ForProduct(String productId, String sizeId) {
        try{
            Products products = productsRepo.findByProductID(productId);
            Size size = sizeRepo.findBySize1IDAndProductID(sizeId,products);
            sizeRepo.delete(size);
            return ResponseEntity.ok("Successful");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(404).body("Could not delete size");
        }
    }
}
