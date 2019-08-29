package com.task.btpn.crudmagdalena.endpoint;

import com.task.btpn.crudmagdalena.data.dto.RequestEmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 27/08/19
 *
 * Created by Magdalena WR
 */

@RequestMapping("/api/v1/employees")
public interface ICUDEmployeeEndpoint {

    @PostMapping("/add")
    ResponseEntity createEmployee(@RequestBody RequestEmployeeDTO requestEmployeeDTO, HttpServletRequest httpServletRequest);

    @PutMapping("/edit/{id}")
    ResponseEntity updateEmployee(@PathVariable Long id, @RequestBody RequestEmployeeDTO requestEmployeeDTO, HttpServletRequest httpServletRequest);

    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteEmployee(@PathVariable Long id, HttpServletRequest httpServletRequest);
}
