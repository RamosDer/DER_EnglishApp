package com.my_company.eapp.services.impl;

import com.my_company.eapp.dao.CategoriaMapper;
import com.my_company.eapp.model.Categoria;
import com.my_company.eapp.services.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaMapper categoriaMapper;

    @Autowired
    public CategoriaServiceImpl(CategoriaMapper categoriaMapper) {
        this.categoriaMapper = categoriaMapper;
    }

    @Override
    public List<Categoria> getAllCategorias() {
        return categoriaMapper.selectByExample(null);
    }

    @Override
    public Categoria getCategoriaById(Integer id) {
        return categoriaMapper.selectByPrimaryKey(id);
    }

    @Override
    public int createCategoria(Categoria categoria) {
        return categoriaMapper.insertSelective(categoria);
    }

    @Override
    public int updateCategoria(Integer id, Categoria categoria) {
        categoria.setIdCategoria(id);
        return categoriaMapper.updateByPrimaryKeySelective(categoria);
    }

    @Override
    public int deleteCategoria(Integer id) {
        return categoriaMapper.deleteByPrimaryKey(id);
    }
}
