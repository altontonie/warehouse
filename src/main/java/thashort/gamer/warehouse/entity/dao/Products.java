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

@Entity(name = "products")
@Getter
@Setter
public class Products implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "productID")
    private String productID;

    /*@Column(name = "Company_ID")
    private int CompanyId;*/

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "TAGS")
    private String tags;

    @Column(name = "STOCK")
    private String stock;

    @Column(name = "INDUSTRY")
    private String industry;

    @Column(name = "IMAGES")
    private String images;

    /*@Column(name = "INPUTTER")
    private String inputter;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CompanyID", nullable=false,referencedColumnName = "CompanyID")
    private Company companyId = new Company();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userid", nullable=false,referencedColumnName = "userid")
    private Users userID = new Users();

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "productID") @JsonIgnore
    private Set<Size> size=new HashSet<>();

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "productID") @JsonIgnore
    private Set<Sales> sales=new HashSet<>();

}
