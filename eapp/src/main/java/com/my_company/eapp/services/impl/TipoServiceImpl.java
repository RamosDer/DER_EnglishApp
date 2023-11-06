package com.my_company.eapp.services.impl;

import com.my_company.eapp.dao.TipoMapper;
import com.my_company.eapp.dto.TipoDto;
import com.my_company.eapp.model.Tipo;
import com.my_company.eapp.model.TipoExample;
import com.my_company.eapp.services.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoServiceImpl implements TipoService {

    @Autowired
    private TipoMapper tipoMapper;

    @Override
    public long countByExample(TipoExample example) {
        return tipoMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(TipoExample example) {
        return tipoMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String codTipo) {
        return tipoMapper.deleteByPrimaryKey(codTipo);
    }

    @Override
    public int insert(TipoDto tipoDto) {
        Tipo tipo = convertToEntity(tipoDto);
        // Genera el valor para codTipo antes de insertar
        tipo.setCodTipo(tipoDto.generateCodTipo());
        return tipoMapper.insert(tipo);
    }

    @Override
    public int insertSelective(TipoDto tipoDto) {
        Tipo tipo = convertToEntity(tipoDto);
        // Genera el valor para codTipo antes de insertar
        tipo.setCodTipo(tipoDto.generateCodTipo());
        return tipoMapper.insertSelective(tipo);
    }

    @Override
    public List<TipoDto> selectByExample() {
        List<Tipo> tipos = tipoMapper.selectByExample(null);
        return tipos.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public TipoDto selectByPrimaryKey(String codTipo) {
        Tipo tipo = tipoMapper.selectByPrimaryKey(codTipo);
        return convertToDto(tipo);
    }

    @Override
    public int updateByExampleSelective(Tipo row, TipoExample example) {
        return tipoMapper.updateByExampleSelective(row, example);
    }

    @Override
    public int updateByExample(Tipo row, TipoExample example) {
        return tipoMapper.updateByExample(row, example);
    }

    @Override
    public int updateByPrimaryKeySelective(TipoDto tipoDto) {
        Tipo tipo = convertToEntity(tipoDto);
        return tipoMapper.updateByPrimaryKeySelective(tipo);
    }

    @Override
    public int updateByPrimaryKey(Tipo row) {
        return tipoMapper.updateByPrimaryKey(row);
    }

    @Override
     public List<TipoDto> selectByCategoriaPrimaryKey(Integer idCategoria) {
        List<Tipo> tipos = tipoMapper.selectByCategoria(idCategoria);
        return tipos.stream().map(this::convertToDto).collect(Collectors.toList());
    }
     
    private TipoDto convertToDto(Tipo tipo) {
        TipoDto tipoDto = new TipoDto();
        tipoDto.setCodTipo(tipo.getCodTipo());
        tipoDto.setDescripcion(tipo.getDescripcion());
        tipoDto.setIdCategoria(tipo.getIdCategoria());
        tipoDto.setFechaRegistro(tipo.getFechaRegistro());
        return tipoDto;
    }

    private Tipo convertToEntity(TipoDto tipoDto) {
        Tipo tipo = new Tipo();
        tipo.setCodTipo(tipoDto.getCodTipo());
        tipo.setDescripcion(tipoDto.getDescripcion());
        tipo.setIdCategoria(tipoDto.getIdCategoria());
        tipo.setFechaRegistro(tipoDto.getFechaRegistro());
        return tipo;
    }
}
