package com.my_company.eapp.services.impl;

import com.my_company.eapp.dao.PracticaMapper;
import com.my_company.eapp.dto.PracticaDto;
import com.my_company.eapp.model.Practica;
import com.my_company.eapp.model.PracticaExample;
import com.my_company.eapp.services.PracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PracticaServiceImpl implements PracticaService {

    @Autowired
    private PracticaMapper practicaMapper;

    @Override
    public long countByExample(PracticaExample example) {
        return practicaMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(PracticaExample example) {
        return practicaMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer idPractica) {
        return practicaMapper.deleteByPrimaryKey(idPractica);
    }

    @Override
    public int insert(PracticaDto practicaDto) {
        Practica practica = convertToEntity(practicaDto);
        return practicaMapper.insert(practica);
    }

    @Override
    public int insertSelective(PracticaDto practicaDto) {
        Practica practica = convertToEntity(practicaDto);
        return practicaMapper.insertSelective(practica);
    }

    @Override
    public List<PracticaDto> selectByExample(PracticaExample example) {
        List<Practica> practicaList = practicaMapper.selectByExample(example);
        return practicaList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PracticaDto selectByPrimaryKey(Integer idPractica) {
        Practica practica = practicaMapper.selectByPrimaryKey(idPractica);
        return convertToDto(practica);
    }

    @Override
    public int updateByExampleSelective(PracticaDto practicaDto, PracticaExample example) {
        Practica practica = convertToEntity(practicaDto);
        return practicaMapper.updateByExampleSelective(practica, example);
    }

    @Override
    public int updateByExample(PracticaDto practicaDto, PracticaExample example) {
        Practica practica = convertToEntity(practicaDto);
        return practicaMapper.updateByExample(practica, example);
    }

    @Override
    public int updateByPrimaryKeySelective(PracticaDto practicaDto) {
        Practica practica = convertToEntity(practicaDto);
        return practicaMapper.updateByPrimaryKeySelective(practica);
    }

    @Override
    public int updateByPrimaryKey(PracticaDto practicaDto) {
        Practica practica = convertToEntity(practicaDto);
        return practicaMapper.updateByPrimaryKey(practica);
    }
    
    @Override
    public PracticaDto selectByIdPalabraFrase(Integer idPalabraFrase) {
        Practica practica = practicaMapper.selectByIdPalabra(idPalabraFrase);
        return convertToDto(practica);
    }

    private Practica convertToEntity(PracticaDto practicaDto) {
        if (practicaDto == null) {
            return null;
        }

        Practica practica = new Practica();
        practica.setIdPractica(practicaDto.getIdPractica());
        practica.setUltimaFecha(practicaDto.getUltimaFecha());
        practica.setConteo(practicaDto.getConteo());
        practica.setIdPalabraFrase(practicaDto.getIdPalabraFrase());
        return practica;
    }

    private PracticaDto convertToDto(Practica practica) {
        if (practica == null) {
            return null;
        }

        PracticaDto practicaDto = new PracticaDto();
        practicaDto.setIdPractica(practica.getIdPractica());
        practicaDto.setUltimaFecha(practica.getUltimaFecha());
        practicaDto.setConteo(practica.getConteo());
        practicaDto.setIdPalabraFrase(practica.getIdPalabraFrase());
        return practicaDto;
    }

    
}
