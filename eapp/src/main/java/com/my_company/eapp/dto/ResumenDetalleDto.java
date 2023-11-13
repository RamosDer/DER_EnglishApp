package com.my_company.eapp.dto;

public class ResumenDetalleDto {

    private Long idResumenDetalle;

    private Integer idPalabraFrase;

    private Boolean correcto;

    private Integer idResumen;

    public Long getIdResumenDetalle() {
        return idResumenDetalle;
    }

    public void setIdResumenDetalle(Long idResumenDetalle) {
        this.idResumenDetalle = idResumenDetalle;
    }

    public Integer getIdPalabraFrase() {
        return idPalabraFrase;
    }

    public void setIdPalabraFrase(Integer idPalabraFrase) {
        this.idPalabraFrase = idPalabraFrase;
    }

    public Boolean getCorrecto() {
        return correcto;
    }

    public void setCorrecto(Boolean correcto) {
        this.correcto = correcto;
    }

    public Integer getIdResumen() {
        return idResumen;
    }

    public void setIdResumen(Integer idResumen) {
        this.idResumen = idResumen;
    }

    @Override
    public String toString() {
        return "ResumenDetalleDto{" + "idResumenDetalle=" + idResumenDetalle + ", idPalabraFrase=" + idPalabraFrase + ", correcto=" + correcto + ", idResumen=" + idResumen + '}';
    }
    

    
    
    

}
