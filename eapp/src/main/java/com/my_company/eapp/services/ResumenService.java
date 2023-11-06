package com.my_company.eapp.services;

import com.my_company.eapp.dto.ResumenDto;
import com.my_company.eapp.model.ResumenExample;
import java.util.List;

public interface  ResumenService {
    long countByExample(ResumenExample example);

    int deleteByExample(ResumenExample example);

    int deleteByPrimaryKey(Integer idResumen);

    int insert(ResumenDto resumenDto);

    int insertSelective(ResumenDto resumenDto);

    List<ResumenDto> selectByExample(ResumenExample example);

    ResumenDto selectByPrimaryKey(Integer idResumen);

    int updateByExampleSelective(ResumenDto resumenDto, ResumenExample example);

    int updateByExample(ResumenDto resumenDto, ResumenExample example);

    int updateByPrimaryKeySelective(ResumenDto resumenDto);

    int updateByPrimaryKey(ResumenDto resumenDto);
}
