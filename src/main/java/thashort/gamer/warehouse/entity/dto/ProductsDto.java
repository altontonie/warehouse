package thashort.gamer.warehouse.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ProductsDto {
    private String productID;
    private String name;
    private String description;
    private String brand;
    private String type;
    private String tags;
    private String stock;
    private String industry;
    private String images;
    private CompanyDto companyId = new CompanyDto();
    private UsersDto userID = new UsersDto();
    private List<SizeDto> size=new ArrayList<>();
    private List<SalesDto> sales=new ArrayList<>();
}
