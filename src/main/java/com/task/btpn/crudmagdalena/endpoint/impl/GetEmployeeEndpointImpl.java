package com.task.btpn.crudmagdalena.endpoint.impl;

import com.task.btpn.crudmagdalena.data.dto.APIErrorBuilder;
import com.task.btpn.crudmagdalena.endpoint.IGetEmployeeEndpoint;
import com.task.btpn.crudmagdalena.service.IGetEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 27/08/19
 *
 * Created by Magdalena WR
 */

@RestController
public class GetEmployeeEndpointImpl implements IGetEmployeeEndpoint {
    @Autowired
    private IGetEmployeeService iGetEmployeeService;

    @Override
    public ResponseEntity getAllEmployees(HttpServletRequest httpServletRequest) {
        try {
            return iGetEmployeeService.getAllEmployees(httpServletRequest);
        }catch (Exception e){
            return new ResponseEntity<>(APIErrorBuilder.internalServerError(
                        Exception.class,
                        "Failed Get All Employees, ".concat((e.getMessage())),
                        httpServletRequest.getRequestURI()
                    ),HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Override
    public ResponseEntity getEmployeeByNIK(@PathVariable Integer nik, HttpServletRequest httpServletRequest) {
        try {
            return iGetEmployeeService.getEmployeeByNIK(nik, httpServletRequest);
        }catch (Exception e){
            return new ResponseEntity<>(APIErrorBuilder.internalServerError(
                        Exception.class,
                        "Failed Get Employee by NIK, ".concat((e.getMessage())),
                        httpServletRequest.getRequestURI()
                    ),HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }

    @Override
    public ResponseEntity getEmployeeByNama(@PathVariable String nama, HttpServletRequest httpServletRequest) {
        try {
            return iGetEmployeeService.getEmployeeByNama(nama, httpServletRequest);
        }catch(Exception e) {
            return new ResponseEntity<>(APIErrorBuilder.internalServerError(
                        Exception.class,
                        "Failed Get Employee by Nama ".concat((e.getMessage())),
                        httpServletRequest.getRequestURI()
                    ), HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
