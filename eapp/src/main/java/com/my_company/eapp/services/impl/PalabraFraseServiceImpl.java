package com.my_company.eapp.services.impl;

import com.my_company.eapp.dao.PalabraFraseMapper;
import com.my_company.eapp.dto.PalabraFraseDto;
import com.my_company.eapp.model.PalabraFrase;
import com.my_company.eapp.model.PalabraFraseExample;
import com.my_company.eapp.services.PalabraFraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PalabraFraseServiceImpl implements PalabraFraseService {

    private final PalabraFraseMapper palabraFraseMapper;
    PalabraFraseExample example = new PalabraFraseExample();
    PalabraFraseExample.Criteria criteria = example.createCriteria();

    @Autowired
    public PalabraFraseServiceImpl(PalabraFraseMapper palabraFraseMapper) {
        this.palabraFraseMapper = palabraFraseMapper;
    }

    @Override
    public List<PalabraFraseDto> getAllPalabrasFrases() {
        List<PalabraFrase> palabraFrases = palabraFraseMapper.selectByExample(null,null);
        return palabraFrases.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public PalabraFraseDto getPalabraFraseById(Integer id) {
        PalabraFrase palabraFrase = palabraFraseMapper.selectByPrimaryKey(id);
        return convertToDto(palabraFrase);
    }

    @Override
    public int createPalabraFrase(PalabraFraseDto palabraFraseDto) {
        PalabraFrase palabraFrase = convertToEntity(palabraFraseDto);
        return palabraFraseMapper.insertSelective(palabraFrase);
    }

    @Override
    public int updatePalabraFrase(Integer id, PalabraFraseDto palabraFraseDto) {
        palabraFraseDto.setIdPalabraFrase(id);
        PalabraFrase palabraFrase = convertToEntity(palabraFraseDto);
        return palabraFraseMapper.updateByPrimaryKeySelective(palabraFrase);
    }

    @Override
    public int deletePalabraFrase(Integer id) {
        return palabraFraseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int getPalabraFraseIdByContenido(String contenido) {
        return palabraFraseMapper.getPalabraFraseIdByContenido(contenido);
    }

    @Override
    public List<PalabraFraseDto> buscarPalabrasConFiltros(PalabraFraseExample example, Integer idCategoria) {
        List<PalabraFrase> palabraFrases = palabraFraseMapper.selectByExample(example, idCategoria);
        return palabraFrases.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    
    // Métodos para convertir entre entidad y DTO
    private PalabraFraseDto convertToDto(PalabraFrase palabraFrase) {
        PalabraFraseDto dto = new PalabraFraseDto();
        dto.setIdPalabraFrase(palabraFrase.getIdPalabraFrase());
        dto.setContenido(palabraFrase.getContenido());
        dto.setDificultad(palabraFrase.getDificultad());
        dto.setAprendido(palabraFrase.getAprendido());
        dto.setFechaRegistro(palabraFrase.getFechaRegistro());
        dto.setCodTipo(palabraFrase.getCodTipo());
        return dto;
    }

    private PalabraFrase convertToEntity(PalabraFraseDto dto) {
        PalabraFrase palabraFrase = new PalabraFrase();
        palabraFrase.setIdPalabraFrase(dto.getIdPalabraFrase());
        palabraFrase.setContenido(dto.getContenido());
        palabraFrase.setDificultad(dto.getDificultad());
        palabraFrase.setAprendido(dto.getAprendido());
        palabraFrase.setFechaRegistro(dto.getFechaRegistro());
        palabraFrase.setCodTipo(dto.getCodTipo());
        return palabraFrase;
    }
    
    
}