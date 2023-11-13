package com.my_company.eapp.services.impl;

import com.my_company.eapp.dao.ResumenMapper;
import com.my_company.eapp.dto.ResumenDto;
import com.my_company.eapp.model.Resumen;
import com.my_company.eapp.model.ResumenExample;
import com.my_company.eapp.services.ResumenService;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ResumenServiceImpl implements ResumenService {

    @Autowired
    private ResumenMapper resumenMapper;
    
    private static final Logger logger = LogManager.getLogger(ResumenServiceImpl.class);

    @Override
    public long countByExample(ResumenExample example) {
        return resumenMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ResumenExample example) {
        return resumenMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer idResumen) {
        return resumenMapper.deleteByPrimaryKey(idResumen);
    }
    
    @Override
    public ResumenDto selectLastRecordByUser(Integer idUsuario) {
        return convertToDto(resumenMapper.selectLastRecordByUser(idUsuario));
    }

    @Override
    public int insert(ResumenDto resumenDto) {
        Resumen resumen = convertToEntity(resumenDto);
        return resumenMapper.insert(resumen);
    }

    @Override
    public int insertSelective(ResumenDto resumenDto) {
        Resumen resumen = convertToEntity(resumenDto);
        logger.info("Ingresa a insertSelective: " + resumen.toString());
        return resumenMapper.insertSelective(resumen);
    }

    @Override
    public List<ResumenDto> selectByExample(ResumenExample example) {
        List<Resumen> resumenList = resumenMapper.selectByExample(example);
        return resumenList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public ResumenDto selectByPrimaryKey(Integer idResumen) {
        Resumen resumen = resumenMapper.selectByPrimaryKey(idResumen);
        return convertToDto(resumen);
    }

    @Override
    public int updateByExampleSelective(ResumenDto resumenDto, ResumenExample example) {
        Resumen resumen = convertToEntity(resumenDto);
        return resumenMapper.updateByExampleSelective(resumen, example);
    }

    @Override
    public int updateByExample(ResumenDto resumenDto, ResumenExample example) {
        Resumen resumen = convertToEntity(resumenDto);
        return resumenMapper.updateByExample(resumen, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ResumenDto resumenDto) {
        Resumen resumen = convertToEntity(resumenDto);
        return resumenMapper.updateByPrimaryKeySelective(resumen);
    }
    
    @Override
    public ResumenDto getByParameters(ResumenExample example) {
        return convertToDto(resumenMapper.getByParameters(example));
    }

    @Override
    public int updateByPrimaryKey(ResumenDto resumenDto) {
        Resumen resumen = convertToEntity(resumenDto);
        return resumenMapper.updateByPrimaryKey(resumen);
    }

    private ResumenDto convertToDto(Resumen resumen) {
        if (resumen == null) {
            return null;
        }

        ResumenDto resumenDto = new ResumenDto();
        resumenDto.setIdResumen(resumen.getIdResumen());
        resumenDto.setTiempo(resumen.getTiempo());
        resumenDto.setFechaDePractica(resumen.getFechaDePractica());
        resumenDto.setAciertos(resumen.getAciertos());
        resumenDto.setPalabrasPracticadas(resumen.getPalabrasPracticadas());
        resumenDto.setIdUsuario(resumen.getIdUsuario());
        return resumenDto;
    }

    private Resumen convertToEntity(ResumenDto resumenDto) {
        if (resumenDto == null) {
            return null;
        }

        Resumen resumen = new Resumen();
        resumen.setIdResumen(resumenDto.getIdResumen());
        resumen.setTiempo(resumenDto.getTiempo());
        resumen.setFechaDePractica(resumenDto.getFechaDePractica());
        resumen.setAciertos(resumenDto.getAciertos());
        resumen.setPalabrasPracticadas(resumenDto.getPalabrasPracticadas());
        resumen.setIdUsuario(resumenDto.getIdUsuario());
        return resumen;
    }

    
}
