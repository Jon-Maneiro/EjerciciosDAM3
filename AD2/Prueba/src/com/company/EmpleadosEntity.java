package com.company;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "empleados", schema = "empleados", catalog = "")
public class EmpleadosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numemp", nullable = false)
    private int numemp;
    @Basic
    @Column(name = "apellido", nullable = true, length = 45)
    private String apellido;
    @Basic
    @Column(name = "empleo", nullable = true, length = 45)
    private String empleo;
    @Basic
    @Column(name = "numdep", nullable = true)
    private Integer numdep;
    @Basic
    @Column(name = "sueldo", nullable = true, precision = 0)
    private Double sueldo;
    @Basic
    @Column(name = "dir", nullable = true)
    private Integer dir;
    @Basic
    @Column(name = "comision", nullable = true, precision = 0)
    private Double comision;
    @Basic
    @Column(name = "fechaalta", nullable = true)
    private Timestamp fechaalta;
    @ManyToOne
    @JoinColumn(name = "numdep", referencedColumnName = "numdep")
    private DepartamentosEntity departamentosByNumdep;

    public int getNumemp() {
        return numemp;
    }

    public void setNumemp(int numemp) {
        this.numemp = numemp;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmpleo() {
        return empleo;
    }

    public void setEmpleo(String empleo) {
        this.empleo = empleo;
    }

    public Integer getNumdep() {
        return numdep;
    }

    public void setNumdep(Integer numdep) {
        this.numdep = numdep;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public Integer getDir() {
        return dir;
    }

    public void setDir(Integer dir) {
        this.dir = dir;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public Timestamp getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Timestamp fechaalta) {
        this.fechaalta = fechaalta;
    }

    public DepartamentosEntity getDepartamentosByNumdep() {
        return departamentosByNumdep;
    }

    public void setDepartamentosByNumdep(DepartamentosEntity departamentosByNumdep) {
        this.departamentosByNumdep = departamentosByNumdep;
    }
}
