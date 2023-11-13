package com.my_company.eapp.dto;

import java.util.Date;

public class PalabraFraseDto {
    private Integer idPalabraFrase;

    private String contenido;

    private String dificultad;

    private Boolean aprendido;

    private Date fechaRegistro;

    private String codTipo; 
    
    private Integer idUsuario;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdPalabraFrase() {
        return idPalabraFrase;
    }

    public void setIdPalabraFrase(Integer idPalabraFrase) {
        this.idPalabraFrase = idPalabraFrase;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public Boolean getAprendido() {
        return aprendido;
    }

    public void setAprendido(Boolean aprendido) {
        this.aprendido = aprendido;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(String codTipo) {
        this.codTipo = codTipo;
    }

    @Override
    public String toString() {
        return "PalabraFraseDto{" + "idPalabraFrase=" + idPalabraFrase + ", contenido=" + contenido + ", dificultad=" + dificultad + ", aprendido=" + aprendido + ", fechaRegistro=" + fechaRegistro + ", codTipo=" + codTipo + ", idUsuario=" + idUsuario + '}';
    }
    
    
}
