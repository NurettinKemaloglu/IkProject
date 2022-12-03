package com.fmss.ikrestproject.repository;

import com.fmss.ikrestproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
