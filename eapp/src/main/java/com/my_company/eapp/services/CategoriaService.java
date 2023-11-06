package com.my_company.eapp.services;

import com.my_company.eapp.model.Categoria;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CategoriaService {
    List<Categoria> getAllCategorias();
    Categoria getCategoriaById(Integer id);
    int createCategoria(Categoria categoria);
    int updateCategoria(Integer id, Categoria categoria);
    int deleteCategoria(Integer id);
}
