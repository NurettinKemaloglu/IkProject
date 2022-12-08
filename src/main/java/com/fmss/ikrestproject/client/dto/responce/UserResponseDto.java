package com.fmss.ikrestproject.client.dto.responce;

import com.fmss.ikrestproject.utils.enums.Level;
import com.fmss.ikrestproject.utils.enums.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private  String name;
    private  String lastName;
    private String email;
    private Title title;
    private  String department;
    private  String role;
    private String tckn;
    private LocalDate userDateOfStart;
    private BigDecimal salary;
    private Level level;
    private LocalDate birthDate;
    private Long id;





}
