package com.task.btpn.crudmagdalena.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 27/08/19
 *
 * Created by Magdalena WR
 */

@RequestMapping("/api/v1/employees")
public interface IGetEmployeeEndpoint {

    @GetMapping("")
    ResponseEntity getAllEmployees(HttpServletRequest httpServletRequest);

    @GetMapping("/get-by-nik/{nik}")
    ResponseEntity getEmployeeByNIK(@PathVariable Integer nik, HttpServletRequest httpServletRequest);

    @GetMapping("/get-by-name/{nama}")
    ResponseEntity getEmployeeByNama(@PathVariable String nama, HttpServletRequest httpServletRequest);

}
