package thashort.gamer.warehouse.entity.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "users")
public class Users implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "userid")
    private String userID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "Username", unique = true)
    private String username;

    @Column(name = "Email",unique = true)
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Type")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CompanyID", nullable=false,referencedColumnName = "CompanyID")
    private Company companyId = new Company();

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "userID") @JsonIgnore
    private Set<Sales> sales=new HashSet<>();

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "userID") @JsonIgnore
    private Set<Products> products=new HashSet<>();

}
