package com.needbeyond.ums.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.needbeyond.ums.entity.Employee;

public interface UserRepository extends JpaRepository<Employee, Long> {

}