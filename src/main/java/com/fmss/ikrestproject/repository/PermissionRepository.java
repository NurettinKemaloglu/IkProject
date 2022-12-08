package com.fmss.ikrestproject.repository;

import com.fmss.ikrestproject.model.Expenses;
import com.fmss.ikrestproject.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
@Repository

public interface PermissionRepository extends JpaRepository<Permission,Long> {
    List<Permission> findAllByUser_UserId(Long userid);

    @Modifying
    @Transactional
    @Query(value = "update  Permission p " +
            "set p.permissionType=:permissionType, " +
            "p.dateOfReturn=:dateOfReturn, " +
            "p.permissionStatement=:permissionStatement, " +
            "p.startingDate=:startingDate, " +
            "p.endDate=:endDate " +
            "where p.id=:id"
    )
    void updatePermission(String permissionType, LocalDate startingDate, LocalDate endDate, LocalDate dateOfReturn, String permissionStatement, Long id);


}
