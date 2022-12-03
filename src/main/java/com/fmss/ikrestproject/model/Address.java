package com.fmss.ikrestproject.model;

import lombok.*;

import static com.fmss.ikrestproject.model.EntityConstantsUtil.PREFIX_TB;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = PREFIX_TB + "adress")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "city")
    private  String city;

    @Column(name = "phone_number")
    private  String phoneNumber;

    @Column(name = "country")
    private String country;

    @Column(name = "post_code")
    private  String postCode;

    @Column(name = "address")
    private String address;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user ;
}
