package com.my_company.eapp.model;

import java.util.Date;

public class Significado {
    private Integer idSignificado;

    private String descripcion;

    private Integer idPalabraFrase;

    private Date fechaRegistro;

    public Integer getIdSignificado() {
        return idSignificado;
    }

    public void setIdSignificado(Integer idSignificado) {
        this.idSignificado = idSignificado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion == null ? null : descripcion.trim();
    }

    public Integer getIdPalabraFrase() {
        return idPalabraFrase;
    }

    public void setIdPalabraFrase(Integer idPalabraFrase) {
        this.idPalabraFrase = idPalabraFrase;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}