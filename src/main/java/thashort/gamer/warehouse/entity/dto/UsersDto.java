package thashort.gamer.warehouse.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import thashort.gamer.warehouse.entity.dao.Company;
import thashort.gamer.warehouse.entity.dao.Products;
import thashort.gamer.warehouse.entity.dao.Sales;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UsersDto {
    private String userID;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String type;
    private CompanyDto companyId = new CompanyDto();
    private List<SalesDto> sales=new ArrayList<>();
    private List<ProductsDto> products=new ArrayList<>();


    public UsersDto(String u) {
        this.username = u;
    }


}
