package com.my_company.eapp.services.impl;

import com.my_company.eapp.dao.ResumenDetalleMapper;
import com.my_company.eapp.dto.ResumenDetalleDto;
import com.my_company.eapp.model.ResumenDetalle;
import com.my_company.eapp.model.ResumenDetalleExample;
import com.my_company.eapp.services.ResumenDetalleService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumenDetalleServiceImpl implements ResumenDetalleService{
    
    @Autowired
    private ResumenDetalleMapper resumenDetalleMapper;

    @Override
    public int insert(ResumenDetalleDto resumenDetalleDto) {
        return resumenDetalleMapper.insert(convertToEntity(resumenDetalleDto));
    }

    @Override
    public int insertSelective(ResumenDetalleDto resumenDetalleDto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ResumenDetalleDto> selectByExample(ResumenDetalleExample example) {
        return resumenDetalleMapper.selectByExample(example).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResumenDetalleDto selectByPrimaryKey(Long idResumenDetalle) {
        return convertToDto(resumenDetalleMapper.selectByPrimaryKey(idResumenDetalle));
    }
    
    @Override
    public List<ResumenDetalleDto> selectByIdResumen(Integer idResumen) {
        return resumenDetalleMapper.selectByIdResumen(idResumen).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public int deleteByPrimaryKey(Long idResumenDetalle) {
        return resumenDetalleMapper.deleteByPrimaryKey(idResumenDetalle);
    }
    
    private ResumenDetalleDto convertToDto(ResumenDetalle resumenDetalle) {
        ResumenDetalleDto resumenDetalleDto = new ResumenDetalleDto();
        resumenDetalleDto.setCorrecto(resumenDetalle.getCorrecto());
        resumenDetalleDto.setIdPalabraFrase(resumenDetalle.getIdPalabraFrase());
        resumenDetalleDto.setIdResumenDetalle(resumenDetalle.getIdResumenDetalle());
        resumenDetalleDto.setIdResumen(resumenDetalle.getIdResumen());
        return resumenDetalleDto;
    }

    private ResumenDetalle convertToEntity(ResumenDetalleDto resumenDetalleDto) {
        ResumenDetalle resumenDetalle = new ResumenDetalle();
        resumenDetalle.setCorrecto(resumenDetalleDto.getCorrecto());
        resumenDetalle.setIdPalabraFrase(resumenDetalleDto.getIdPalabraFrase());
        resumenDetalle.setIdResumenDetalle(resumenDetalleDto.getIdResumenDetalle());
        resumenDetalle.setIdResumen(resumenDetalleDto.getIdResumen());
        return resumenDetalle;
    }
    
}
