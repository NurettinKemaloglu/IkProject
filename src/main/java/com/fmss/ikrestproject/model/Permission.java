package com.fmss.ikrestproject.model;


import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


import static com.fmss.ikrestproject.model.EntityConstantsUtil.PREFIX_TB;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = PREFIX_TB+"permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "permission_type")
    private  String permissionType;


    @Column(name = "starting_date")
    private LocalDate startingDate;


    @Column(name = "end_date")
    private LocalDate endDate;


    @Column(name = "date_of_return")
    private LocalDate dateOfReturn;

    @Column(name = "permission_statement")
    private  String permissionStatement;

    @Column(name = "total_days")
    private BigDecimal totalDays;
    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user;
}
