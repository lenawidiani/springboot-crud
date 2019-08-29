package com.task.btpn.crudmagdalena.endpoint.impl;

import com.task.btpn.crudmagdalena.data.dto.APIErrorBuilder;
import com.task.btpn.crudmagdalena.data.dto.RequestEmployeeDTO;
import com.task.btpn.crudmagdalena.endpoint.ICUDEmployeeEndpoint;
import com.task.btpn.crudmagdalena.service.ICUDEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * Created on 27/08/19
 *
 * Created by Magdalena WR
 */

@RestController
public class CUDEmployeeEndpointImpl implements ICUDEmployeeEndpoint {
    @Autowired
    private ICUDEmployeeService iCUDEmployeeService;

    @Override
    public ResponseEntity createEmployee(@RequestBody RequestEmployeeDTO requestEmployeeDTO, HttpServletRequest httpServletRequest) {
        try {
            if(!isTglLahirValid(requestEmployeeDTO.getTglLahir())){
                return new ResponseEntity<>(APIErrorBuilder.badRequest(
                        Exception.class,
                        "Tanggal lahir tidak sesuai format dd/MM/yy",
                        httpServletRequest.getRequestURI()
                ), HttpStatus.BAD_REQUEST
                );
            }

            return iCUDEmployeeService.createEmployee(requestEmployeeDTO, httpServletRequest);
        }catch (Exception e){
            return new ResponseEntity<>(APIErrorBuilder.internalServerError(
                    Exception.class,
                    "Failed create Employee, ".concat((e.getMessage())),
                    httpServletRequest.getRequestURI()
            ), HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Override
    public ResponseEntity updateEmployee(@PathVariable Long id, @RequestBody RequestEmployeeDTO requestEmployeeDTO, HttpServletRequest httpServletRequest) {
        try {
            if(!isTglLahirValid(requestEmployeeDTO.getTglLahir())){
                return new ResponseEntity<>(APIErrorBuilder.badRequest(
                        Exception.class,
                        "Tanggal lahir tidak sesuai format dd/MM/yy",
                        httpServletRequest.getRequestURI()
                ), HttpStatus.BAD_REQUEST
                );
            }

            return iCUDEmployeeService.updateEmployee(id, requestEmployeeDTO, httpServletRequest);
        }catch (Exception e){
            return new ResponseEntity<>(APIErrorBuilder.internalServerError(
                    Exception.class,
                    "Failed update Employee, ".concat((e.getMessage())),
                    httpServletRequest.getRequestURI()
            ), HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Override
    public ResponseEntity deleteEmployee(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        try {
            return iCUDEmployeeService.deleteEmployee(id, httpServletRequest);
        }catch (Exception e){
            return new ResponseEntity<>(APIErrorBuilder.internalServerError(
                    Exception.class,
                    "Failed delete Employee, ".concat((e.getMessage())),
                    httpServletRequest.getRequestURI()
            ), HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }


    private Boolean isTglLahirValid(String tglLahir){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy", Locale.getDefault());
            LocalDate ld = LocalDate.parse(tglLahir, formatter);
            String result = ld.format(formatter);

            return result.equals(tglLahir);
        }catch(DateTimeParseException ex){
            return false;
        }
    }
}
