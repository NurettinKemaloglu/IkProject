package com.fmss.ikrestproject.repository;

import com.fmss.ikrestproject.model.User;
import com.fmss.ikrestproject.utils.enums.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Modifying
    @Transactional

    @Query(value = "update User  u " +
            "set u.email=:email ," +
            "u.title=:title, " +
            "u.role=:role , " +
            "u.salary=:salary " +
            "where u.userId=:userid"
    )
    void updateUser(String email, Title title, String role , BigDecimal salary, Long userid);

}
