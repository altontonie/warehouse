package thashort.gamer.warehouse.entity.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity(name = "size")
public class Size implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "SIZE_1_ID")
    private String size1ID;

    /*@Column(name = "Company_ID")
    private int CompanyId;*/

    @Column(name = "SIZE")
    private String size;

   /* @Column(name = "PRODUCT_ID")
    private int productID;*/

    @Column(name = "COLOR")
    private String color;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "Bought_From")
    private String Bought_From;

    @Column(name = "STOCK")
    private String stock;

    @Column(name = "Buying_Price")
    private String Buying_Price;

    @Column(name = "IMAGES")
    private String images;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CompanyID", nullable=false,referencedColumnName = "CompanyID")
    private Company companyId = new Company();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="PRODUCTID", nullable=false,referencedColumnName = "PRODUCTID")
    private Products productID = new Products();

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "size1ID") @JsonIgnore
    private Set<Size_2> size2ID =new HashSet<>();

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "size1ID") @JsonIgnore
    private Set<Sales> sales=new HashSet<>();
}
