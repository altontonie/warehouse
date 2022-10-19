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
@Entity(name = "size_2")
public class Size_2 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "SIZE_2_ID")
    private String size2ID;

    /*@Column(name = "Company_ID")
    private int CompanyId;*/

    /*@Column(name = "SIZE_1")
    private int size1;*/

    @Column(name = "SIZE_2")
    private String size2;

    @Column(name = "ADD_PRICE")
    private String addPrice;

    @Column(name = "STOCK")
    private String stock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CompanyID", nullable=false,referencedColumnName = "CompanyID")
    private Company companyId = new Company();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="SIZE_1_ID", nullable=false,referencedColumnName = "SIZE_1_ID")
    private Size size1ID = new Size();

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "size2ID") @JsonIgnore
    private Set<Sales> sales=new HashSet<>();
}
