package com.task.btpn.crudmagdalena.dao;

import com.task.btpn.crudmagdalena.data.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created on 27/08/19
 *
 * Created by Magdalena WR
 */

public interface IEmployeeDAO extends JpaRepository<Employee, Long> {
    @Query("SELECT c FROM Employee c WHERE c.status = 1")
    List<Employee> findAll();

    @Query("SELECT c FROM Employee c WHERE c.nik = :nik AND c.status = 1")
    Employee findByNIK(@Param("nik") Integer nik);

    @Query("SELECT c FROM Employee c WHERE c.nik = :nik")
    Employee checkByNIK(@Param("nik") Integer nik);

    @Query("SELECT c FROM Employee c WHERE c.nama = :nama AND c.status = 1")
    List<Employee> findByNama(@Param("nama") String nama);
}
