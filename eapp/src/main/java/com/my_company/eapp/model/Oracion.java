package com.my_company.eapp.model;

import java.util.Date;

public class Oracion {
    private Integer idOracion;

    private String texto;

    private Date fechaRegistro;

    private Integer idPalabraFrase;

    public Integer getIdOracion() {
        return idOracion;
    }

    public void setIdOracion(Integer idOracion) {
        this.idOracion = idOracion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto == null ? null : texto.trim();
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdPalabraFrase() {
        return idPalabraFrase;
    }

    public void setIdPalabraFrase(Integer idPalabraFrase) {
        this.idPalabraFrase = idPalabraFrase;
    }
}