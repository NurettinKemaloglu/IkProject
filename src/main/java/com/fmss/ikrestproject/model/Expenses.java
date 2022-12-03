package com.fmss.ikrestproject.model;


import jdk.jfr.Timestamp;
import lombok.*;


import static com.fmss.ikrestproject.model.EntityConstantsUtil.PREFIX_TB;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = PREFIX_TB+"expenses")
public class Expenses {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "type_of_expenditure")
  private String typeOfExpenditure;

  @Column(name = "spending_amount")
  private BigDecimal spendingAmounut;

  @Column(name = "receipt_date")
  private LocalDate receiptDate;

  @Column(name = "vat_percent")
  private int vatPercent;




  @Column(name = "spending_statement")
  private String spendingStatement;
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "userId" ,referencedColumnName = "userId")
  private User user;
}
