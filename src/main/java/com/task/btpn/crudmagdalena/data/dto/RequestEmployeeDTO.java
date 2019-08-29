package com.task.btpn.crudmagdalena.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created on 27/08/19
 *
 * Created by Magdalena WR
 */

@ToString
@Setter
@Getter
public class RequestEmployeeDTO implements Serializable {
    private static final long serialVersionUID = 1161628158423596396L;

    private Integer nik;
    private String nama;
    private String tglLahir;
    private Double pendapatan;
}
