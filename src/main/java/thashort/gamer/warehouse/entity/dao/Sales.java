package thashort.gamer.warehouse.entity.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "Sales")
public class Sales implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "SalesID")
    private String SalesID;

    /*@Column(name = "Company_ID")
    private int CompanyId;*/

    /*@Column(name = "PRODUCT_ID")
    private String productID;*/

    @Column(name = "Buying_Price")
    private String BuyingPrice;

    @Column(name = "Price")
    private String price;

    @Column(name = "Discount")
    private String Discount;

    @Column(name = "Selling_Price")
    private String Selling_Price;

    @Column(name = "Quantity")
    private String Quantity;

    @Column(name = "Total_Sale")
    private String Total_Sale;

    @Column(name = "Expected_Sale")
    private String Expected_Sale;

    @Column(name = "Expected_Profit")
    private String Expected_Profit;

    @Column(name = "Actual_P_L")
    private String Actual_P_L;

    @Column(name = "Acquired_Loss")
    private String Acquired_Loss;

    /*@Column(name = "INPUTTER")
    private String inputter;*/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CompanyID", nullable=false,referencedColumnName ="CompanyID")
    private Company companyId = new Company();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="PRODUCTID", nullable=false,referencedColumnName ="PRODUCTID")
    private Products productID = new Products();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="SIZE_1_ID", nullable=false,referencedColumnName ="SIZE_1_ID")
    private Size size1ID = new Size();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="SIZE_2_ID", nullable=false,referencedColumnName ="SIZE_2_ID")
    private Size_2 size2ID = new Size_2();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userid", nullable=false,referencedColumnName ="userID")
    private Users userID = new Users();
}
