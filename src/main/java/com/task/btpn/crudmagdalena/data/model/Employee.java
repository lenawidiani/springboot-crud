package com.task.btpn.crudmagdalena.data.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created on 27/08/19
 *
 * Created by Magdalena WR
 */

@ToString
@Setter
@Getter
@Entity
@Table(name = "employees")
public class Employee implements Serializable {
    private static final long serialVersionUID = -1836764415578015443L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nik")
    private Integer nik;

    @Column(name = "nama")
    private String nama;

    @Column(name = "tgl_lahir")
    private String tglLahir;

    @Column(name = "pendapatan")
    private Double pendapatan;

    // status 1 = active, 0 = deleted
    @Column(name = "status")
    private Integer status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted_at")
    private Date deletedAt;
}
