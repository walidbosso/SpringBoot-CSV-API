package com.walid.boussou.repositories;

import com.walid.boussou.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpolyeeRepository extends JpaRepository<Employee,Long> {
}
