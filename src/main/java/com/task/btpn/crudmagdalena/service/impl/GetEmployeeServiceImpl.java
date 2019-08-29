package com.task.btpn.crudmagdalena.service.impl;

import com.task.btpn.crudmagdalena.dao.IEmployeeDAO;
import com.task.btpn.crudmagdalena.data.dto.APIErrorBuilder;
import com.task.btpn.crudmagdalena.data.model.Employee;
import com.task.btpn.crudmagdalena.service.IGetEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created on 27/08/19
 *
 * Created by Magdalena WR
 */

@Service
public class GetEmployeeServiceImpl implements IGetEmployeeService {
    @Autowired
    private IEmployeeDAO iEmployeeDAO;

    @Override
    public ResponseEntity getAllEmployees(HttpServletRequest httpServletRequest) throws Exception{
        List<Employee> employees = iEmployeeDAO.findAll();

        return ResponseEntity.ok(employees);
    }

    @Override
    public ResponseEntity getEmployeeByNIK(Integer nik, HttpServletRequest httpServletRequest) throws Exception {
        Employee employee = iEmployeeDAO.findByNIK(nik);

        return ResponseEntity.ok(employee);
    }

    @Override
    public ResponseEntity getEmployeeByNama(String nama, HttpServletRequest httpServletRequest) throws Exception{
        List<Employee> employees = iEmployeeDAO.findByNama(nama);

        return ResponseEntity.ok(employees);
    }
}
