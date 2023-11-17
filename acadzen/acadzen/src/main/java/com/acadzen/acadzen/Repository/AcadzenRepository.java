package com.acadzen.acadzen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acadzen.acadzen.Entity.AcadzenEntity;

@Repository
public interface AcadzenRepository extends JpaRepository<AcadzenEntity, Integer>{
    AcadzenEntity findByUsernameAndPassword(String username, String password);
}
