package com.my_company.eapp.services;

import com.my_company.eapp.dto.ResumenDetalleDto;
import com.my_company.eapp.model.ResumenDetalleExample;
import java.util.List;

public interface ResumenDetalleService {
    int insert(ResumenDetalleDto resumenDetalleDto);
    int insertSelective(ResumenDetalleDto resumenDetalleDto);
    List<ResumenDetalleDto> selectByExample(ResumenDetalleExample example);
    ResumenDetalleDto selectByPrimaryKey(Long idResumenDetalle);
    int deleteByPrimaryKey(Long idResumenDetalle);
    List<ResumenDetalleDto> selectByIdResumen(Integer idResumen);
}
