package thashort.gamer.warehouse.entity.dto;

import lombok.Data;
import thashort.gamer.warehouse.entity.dao.Company;
import thashort.gamer.warehouse.entity.dao.Sales;
import thashort.gamer.warehouse.entity.dao.Size;

import java.util.ArrayList;
import java.util.List;

@Data
public class Size_2Dto {
    private String size2ID;
    private String size2;
    private String addPrice;
    private String stock;
    private CompanyDto CompanyId = new CompanyDto();
    private SizeDto size1ID = new SizeDto();
    private List<SalesDto> sales=new ArrayList<>();
}
