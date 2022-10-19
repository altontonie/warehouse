package thashort.gamer.warehouse.entity.dto;

import lombok.Data;
import thashort.gamer.warehouse.entity.dao.*;

@Data
public class SalesDto {
    private String SalesID;
    private String BuyingPrice;
    private String price;
    private String Discount;
    private String Selling_Price;
    private String Quantity;
    private String Total_Sale;
    private String Expected_Sale;
    private String Expected_Profit;
    private String Actual_P_L;
    private String Acquired_Loss;
    private CompanyDto CompanyId = new CompanyDto();
    private ProductsDto productID = new ProductsDto();
    private SizeDto size1ID = new SizeDto();
    private Size_2Dto size2ID = new Size_2Dto();
    private UsersDto userID = new UsersDto();
}
