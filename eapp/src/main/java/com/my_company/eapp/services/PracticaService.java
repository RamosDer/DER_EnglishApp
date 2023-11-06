package com.my_company.eapp.services;

import com.my_company.eapp.dto.PracticaDto;
import com.my_company.eapp.model.PracticaExample;
import java.util.List;

public interface PracticaService {
    long countByExample(PracticaExample example);

    int deleteByExample(PracticaExample example);

    int deleteByPrimaryKey(Integer idPractica);

    int insert(PracticaDto practicaDto);

    int insertSelective(PracticaDto practicaDto);

    List<PracticaDto> selectByExample(PracticaExample example);

    PracticaDto selectByPrimaryKey(Integer idPractica);

    int updateByExampleSelective(PracticaDto practicaDto, PracticaExample example);

    int updateByExample(PracticaDto practicaDto, PracticaExample example);

    int updateByPrimaryKeySelective(PracticaDto practicaDto);

    int updateByPrimaryKey(PracticaDto practicaDto);
    
    PracticaDto selectByIdPalabraFrase(Integer idPalabraFrase);
}
