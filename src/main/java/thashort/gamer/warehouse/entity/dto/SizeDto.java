package thashort.gamer.warehouse.entity.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SizeDto {
    private String size1ID;
    private String size;
    private String color;
    private String price;
    private String Bought_From;
    private String stock;
    private String Buying_Price;
    private String images;
    private CompanyDto CompanyId = new CompanyDto() ;
    private ProductsDto productID = new ProductsDto();
    private List<Size_2Dto> size2ID=new ArrayList<>();
    private List<SalesDto> sales=new ArrayList<>();
}
