package com.task.btpn.crudmagdalena.data.dto;

import lombok.*;

import java.util.Date;

/**
 * Created on 27/08/19
 *
 * Created by Magdalena WR
 */

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAPIErrorDTO {

    private Date timestamp;
    private Integer status;
    private String exception;
    private String message;
    private String path;
    private String error;
}
