package com.my_company.eapp.model;

import java.util.Date;

public class Resumen {
    private Integer idResumen;

    private Integer tiempo;

    private Date fechaDePractica;

    private Integer aciertos;

    private Integer palabrasPracticadas;

    private Integer idUsuario;

    private Integer idTipoPractica;

    public Integer getIdResumen() {
        return idResumen;
    }

    public void setIdResumen(Integer idResumen) {
        this.idResumen = idResumen;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public Date getFechaDePractica() {
        return fechaDePractica;
    }

    public void setFechaDePractica(Date fechaDePractica) {
        this.fechaDePractica = fechaDePractica;
    }

    public Integer getAciertos() {
        return aciertos;
    }

    public void setAciertos(Integer aciertos) {
        this.aciertos = aciertos;
    }

    public Integer getPalabrasPracticadas() {
        return palabrasPracticadas;
    }

    public void setPalabrasPracticadas(Integer palabrasPracticadas) {
        this.palabrasPracticadas = palabrasPracticadas;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdTipoPractica() {
        return idTipoPractica;
    }

    public void setIdTipoPractica(Integer idTipoPractica) {
        this.idTipoPractica = idTipoPractica;
    }
}