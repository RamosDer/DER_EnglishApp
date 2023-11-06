package com.my_company.eapp.services.impl;

import com.my_company.eapp.dao.SignificadoMapper;
import com.my_company.eapp.dto.SignificadoDto;
import com.my_company.eapp.model.Significado;
import com.my_company.eapp.services.SignificadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SignificadoServiceImpl implements SignificadoService {

    private final SignificadoMapper significadoMapper;

    @Autowired
    public SignificadoServiceImpl(SignificadoMapper significadoMapper) {
        this.significadoMapper = significadoMapper;
    }

@Override
    public List<SignificadoDto> getAllSignificados() {
        return significadoMapper.selectByExample(null).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SignificadoDto getSignificadoById(Integer id) {
        return convertToDto(significadoMapper.selectByPrimaryKey(id));
    }

    @Override
    public int createSignificado(SignificadoDto significadoDto) {
        return significadoMapper.insertSelective(convertToEntity(significadoDto));
    }

    @Override
    public int updateSignificado(SignificadoDto significadoDto) {
        return significadoMapper.updateByPrimaryKeySelective(convertToEntity(significadoDto));
    }

    @Override
    public int deleteSignificado(Integer id) {
        return significadoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<SignificadoDto> selectByPalabraFrasePrimaryKey(Integer idPalabraFrase) {
        return significadoMapper.selectByPalabraFrasePrimaryKey(idPalabraFrase).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    
    public List<SignificadoDto> getDefinicionesAleatorias(int count, Integer excludePalabraFraseId) {
        List<Significado> significados = significadoMapper.findRandomDefiniciones(count, excludePalabraFraseId);
        
        return significados.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    
    private SignificadoDto convertToDto(Significado significado) {
        if (significado == null) return null;
        
        SignificadoDto significadoDto = new SignificadoDto();
        significadoDto.setIdSignificado(significado.getIdSignificado());
        significadoDto.setDescripcion(significado.getDescripcion());
        significadoDto.setIdPalabraFrase(significado.getIdPalabraFrase());
        significadoDto.setFechaRegistro(significado.getFechaRegistro());
        return significadoDto;
    }
    
    private Significado convertToEntity(SignificadoDto significadoDto) {
        if (significadoDto == null) return null;
        
        Significado significado = new Significado();
        significado.setIdSignificado(significadoDto.getIdSignificado());
        significado.setDescripcion(significadoDto.getDescripcion());
        significado.setIdPalabraFrase(significadoDto.getIdPalabraFrase());
        significado.setFechaRegistro(significadoDto.getFechaRegistro());
        return significado;
    }

    @Override
    public int getSignificadoByDescripcion(String descripcion) {
        return significadoMapper.getSignificadoIdByDescripcion(descripcion);
    }
    
}