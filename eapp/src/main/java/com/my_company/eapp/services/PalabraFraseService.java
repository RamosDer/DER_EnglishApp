package com.my_company.eapp.services;

import com.my_company.eapp.dto.PalabraFraseDto;
import com.my_company.eapp.model.PalabraFraseExample;
import java.util.List;

public interface PalabraFraseService {
    List<PalabraFraseDto> getAllPalabrasFrases();
    PalabraFraseDto getPalabraFraseById(Integer id);
    int createPalabraFrase(PalabraFraseDto palabraFraseDto);
    int updatePalabraFrase(Integer id, PalabraFraseDto palabraFraseDto);
    int deletePalabraFrase(Integer id);
    int getPalabraFraseIdByContenido(String contenido);
    List<PalabraFraseDto> buscarPalabrasConFiltros(PalabraFraseExample example, Integer idCategoria);
}