package com.my_company.eapp.services;

import com.my_company.eapp.dto.SignificadoDto;

import java.util.List;

public interface SignificadoService {
    List<SignificadoDto> getAllSignificados();
    SignificadoDto getSignificadoById(Integer id);
    int createSignificado(SignificadoDto significadoDto);
    int updateSignificado(SignificadoDto significadoDto);
    int deleteSignificado(Integer id);
    List<SignificadoDto> selectByPalabraFrasePrimaryKey(Integer idPalabraFrase);
    List<SignificadoDto> getDefinicionesAleatorias(int count, Integer excludePalabraFraseId);
    int getSignificadoByDescripcion(String descripcion);
}
