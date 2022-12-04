package com.fmss.ikrestproject.model;


import com.fmss.ikrestproject.utils.enums.Level;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


import static com.fmss.ikrestproject.model.EntityConstantsUtil.PREFIX_TB;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = PREFIX_TB + "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "name",length = 60)
    private  String name;
    @Column(name = "last_name",length = 60)
    private  String lastName;

    @Email
    @Size(max = 100)
    @Column(name = "email",unique = true)
    protected String email;

    @Column(name = "tckn")
    private String tckn;

    @CreatedDate
    @Column(name = "user_dateof_start")
    private LocalDate userDateOfStart;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "title")
    private  String title;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "role")
    private String role;

    @Column(name = "level")
    @Enumerated
    private Level level;

    @ManyToOne
    private Department department;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL ,fetch =FetchType.EAGER)
    private Address address;

    @OneToMany(mappedBy = "user",fetch =FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Expenses> expensesList;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    private List<Permission> permissionList;



}
