package com.fmss.ikrestproject.client.dto.request;
import com.fmss.ikrestproject.utils.enums.Level;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@RequiredArgsConstructor
public class UserRequestDto {
    private  String name;
    private  String lastName;
    protected String email;
    private String tckn;
    private LocalDate userDateOfStart;
    private BigDecimal salary;
    private  String title;
    private Long department;
    private LocalDate birthDate;
    private String role;
    private Level level;
    //Adress Bilgileri
    private  String city;
    private  String phoneNumber;
    private String country;
    private  String postCode;
    private  String address;


}
