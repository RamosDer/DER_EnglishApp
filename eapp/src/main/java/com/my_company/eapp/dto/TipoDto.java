package com.my_company.eapp.dto;

import java.util.Date;

public class TipoDto {
    private String codTipo;
    private String descripcion;
    private Integer idCategoria;
    private Date fechaRegistro;

    public String getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(String codTipo) {
        this.codTipo = codTipo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public String generateCodTipo() {
        if (descripcion != null && descripcion.length() >= 3) {
            return "TIP" + descripcion.substring(0, 3).toUpperCase();
        } else {
            return null;
        }
    }
}
