package thashort.gamer.warehouse.entity.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "company")
public class Company implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "CompanyID")
    private String companyID;

    @Column(name = "COMPANY")
    private String Company;

    @Column(name = "Subscription")
    private String Subscription;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "companyId") @JsonIgnore
    private Set<Users> user=new HashSet<>();

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "companyId") @JsonIgnore
    private Set<Products> products=new HashSet<>();

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "companyId") @JsonIgnore
    private Set<Size> size =new HashSet<>();

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "companyId") @JsonIgnore
    private Set<Size_2> size2=new HashSet<>();

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "companyId") @JsonIgnore
    private Set<Sales> sales=new HashSet<>();

}
