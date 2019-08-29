package com.task.btpn.crudmagdalena.service.impl;

import com.task.btpn.crudmagdalena.dao.IEmployeeDAO;
import com.task.btpn.crudmagdalena.data.dto.APIErrorBuilder;
import com.task.btpn.crudmagdalena.data.dto.RequestEmployeeDTO;
import com.task.btpn.crudmagdalena.data.model.Employee;
import com.task.btpn.crudmagdalena.service.ICUDEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created on 27/08/19
 *
 * Created by Magdalena WR
 */

@Service
public class CUDEmployeeServiceImpl implements ICUDEmployeeService {
    @Autowired
    private IEmployeeDAO iEmployeeDAO;

    @Transactional
    @Override
    public ResponseEntity createEmployee(RequestEmployeeDTO requestEmployeeDTO,
                                         HttpServletRequest httpServletRequest
    )throws Exception {
        Employee employee = iEmployeeDAO.checkByNIK(requestEmployeeDTO.getNik());

        if(employee == null){
            employee = new Employee();
            employee.setNama(requestEmployeeDTO.getNama());
            employee.setNik(requestEmployeeDTO.getNik());
            employee.setTglLahir(requestEmployeeDTO.getTglLahir());
            employee.setPendapatan(requestEmployeeDTO.getPendapatan());
            employee.setStatus(1);
            employee.setCreatedAt(new Date());
            employee.setUpdatedAt(employee.getCreatedAt());

            employee = iEmployeeDAO.save(employee);

            return ResponseEntity.ok(employee);
        }else{
            return new ResponseEntity<>(APIErrorBuilder.conflict(
                    Exception.class,
                    "Employee dengan NIK ".concat(String.valueOf(requestEmployeeDTO.getNik())).concat(" sudah terdaftar"),
                    httpServletRequest.getRequestURI()
            ), HttpStatus.CONFLICT
            );
        }
    }

    @Transactional
    @Override
    public ResponseEntity updateEmployee(Long id,
                                         RequestEmployeeDTO requestEmployeeDTO,
                                         HttpServletRequest httpServletRequest
    )throws Exception {
        Employee employee = iEmployeeDAO.findById(id).orElse(null);
        if (employee == null){
            return new ResponseEntity<>(APIErrorBuilder.notFound(
                    Exception.class,
                    "Employee dengan ID ".concat(String.valueOf(id)).concat(" tidak ditemukan"),
                    httpServletRequest.getRequestURI()
                ), HttpStatus.NOT_FOUND
            );
        }else{
            Employee checkNIK = iEmployeeDAO.checkByNIK(requestEmployeeDTO.getNik());

            if(checkNIK == null || employee.getNik().toString().equals(requestEmployeeDTO.getNik().toString())){
                employee.setNik(requestEmployeeDTO.getNik());
                employee.setNama(requestEmployeeDTO.getNama());
                employee.setTglLahir(requestEmployeeDTO.getTglLahir());
                employee.setPendapatan(requestEmployeeDTO.getPendapatan());
                employee.setUpdatedAt(new Date());

                employee = iEmployeeDAO.save(employee);

                return ResponseEntity.ok(employee);
            }else{
                return new ResponseEntity<>(APIErrorBuilder.conflict(
                        Exception.class,
                        "Employee dengan NIK ".concat(String.valueOf(requestEmployeeDTO.getNik())).concat(" sudah terdaftar"),
                        httpServletRequest.getRequestURI()
                ), HttpStatus.CONFLICT
                );
            }
        }
    }

    @Transactional
    @Override
    public ResponseEntity deleteEmployee(Long id,
                                         HttpServletRequest httpServletRequest
    )throws Exception {
        Employee employee = iEmployeeDAO.findById(id).orElse(null);
        if (employee == null){
            return new ResponseEntity<>(APIErrorBuilder.notFound(
                    Exception.class,
                    "Employee dengan ID ".concat(String.valueOf(id)).concat(" tidak ditemukan"),
                    httpServletRequest.getRequestURI()
                ), HttpStatus.NOT_FOUND
            );
        }else{
            employee.setStatus(0);
            employee.setDeletedAt(new Date());

            iEmployeeDAO.save(employee);

            return ResponseEntity.ok("Success Delete Employee");
        }
    }

}
