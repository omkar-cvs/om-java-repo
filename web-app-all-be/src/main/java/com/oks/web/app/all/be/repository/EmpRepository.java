package com.oks.web.app.all.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oks.web.app.all.be.entity.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp,Long>{

}
