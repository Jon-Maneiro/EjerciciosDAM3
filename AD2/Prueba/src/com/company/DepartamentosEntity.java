package com.company;

import javax.persistence.*;

@Entity
@Table(name = "departamentos", schema = "empleados", catalog = "")
public class DepartamentosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numdep", nullable = false)
    private int numdep;
    @Basic
    @Column(name = "nomdep", nullable = true, length = 45)
    private String nomdep;
    @Basic
    @Column(name = "loc", nullable = true, length = 45)
    private String loc;

    public int getNumdep() {
        return numdep;
    }

    public void setNumdep(int numdep) {
        this.numdep = numdep;
    }

    public String getNomdep() {
        return nomdep;
    }

    public void setNomdep(String nomdep) {
        this.nomdep = nomdep;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
