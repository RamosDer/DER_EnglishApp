package com.my_company.eapp.model;

public class TipoPractica {
    private Integer idTipoPractica;

    private String tipo;

    public Integer getIdTipoPractica() {
        return idTipoPractica;
    }

    public void setIdTipoPractica(Integer idTipoPractica) {
        this.idTipoPractica = idTipoPractica;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo == null ? null : tipo.trim();
    }
}