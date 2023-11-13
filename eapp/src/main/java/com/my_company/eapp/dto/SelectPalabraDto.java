package com.my_company.eapp.dto;

import java.util.List;

public class SelectPalabraDto {

    private String palabra;
    private List<String> opciones;
    private String respuestaCorrecta;
    private Integer idPalabraFrase;

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Integer getIdPalabraFrase() {
        return idPalabraFrase;
    }

    public void setIdPalabraFrase(Integer idPalabraFrase) {
        this.idPalabraFrase = idPalabraFrase;
    }
    
    
}
