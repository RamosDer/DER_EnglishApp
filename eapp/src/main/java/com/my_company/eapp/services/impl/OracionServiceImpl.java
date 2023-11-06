package com.my_company.eapp.services.impl;

import com.my_company.eapp.dao.OracionMapper;
import com.my_company.eapp.model.Oracion;
import com.my_company.eapp.services.OracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OracionServiceImpl implements OracionService {

    private final OracionMapper oracionMapper;

    @Autowired
    public OracionServiceImpl(OracionMapper oracionMapper) {
        this.oracionMapper = oracionMapper;
    }

    @Override
    public List<Oracion> getAllOraciones() {
        return oracionMapper.selectByExample(null);
    }

    @Override
    public Oracion getOracionById(Integer id) {
        return oracionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int createOracion(Oracion oracion) {
        return oracionMapper.insertSelective(oracion);
    }

    @Override
    public int updateOracion(Oracion oracion) {
        return oracionMapper.updateByPrimaryKeySelective(oracion);
    }

    @Override
    public int deleteOracion(Integer id) {
        return oracionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Oracion> getOracionIdByPalabraFraseId(Integer idPalabraFrase) {
        return oracionMapper.getOracionIdByPalabraFraseId(idPalabraFrase);
    }
}
