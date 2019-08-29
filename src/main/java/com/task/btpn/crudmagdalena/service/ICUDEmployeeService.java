package com.task.btpn.crudmagdalena.service;

import com.task.btpn.crudmagdalena.data.dto.RequestEmployeeDTO;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

/**
 * Created on 27/08/19
 *
 * Created by Magdalena WR
 */

public interface ICUDEmployeeService {
    @Transactional
    ResponseEntity createEmployee(RequestEmployeeDTO requestEmployeeDTO,
                                  HttpServletRequest httpServletRequest
    )throws Exception;

    @Transactional
    ResponseEntity updateEmployee(Long id,
                                  RequestEmployeeDTO requestEmployeeDTO,
                                  HttpServletRequest httpServletRequest
    )throws Exception;

    @Transactional
    ResponseEntity deleteEmployee(Long id,
                                  HttpServletRequest httpServletRequest
    )throws Exception;
}
