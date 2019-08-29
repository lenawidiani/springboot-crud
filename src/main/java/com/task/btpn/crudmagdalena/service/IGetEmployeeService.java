package com.task.btpn.crudmagdalena.service;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 27/08/19
 *
 * Created by Magdalena WR
 */

public interface IGetEmployeeService {

    ResponseEntity getAllEmployees(HttpServletRequest httpServletRequest) throws Exception;

    ResponseEntity getEmployeeByNIK(Integer nik, HttpServletRequest httpServletRequest) throws Exception;

    ResponseEntity getEmployeeByNama(String nama, HttpServletRequest httpServletRequest) throws Exception;
}
