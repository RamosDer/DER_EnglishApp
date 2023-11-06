package com.my_company.eapp.controller;

import com.my_company.eapp.dao.CategoriaMapper;
import com.my_company.eapp.model.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaMapper categoriaMapper;

    @Autowired
    public CategoriaController(CategoriaMapper categoriaMapper) {
        this.categoriaMapper = categoriaMapper;
    }
    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }

    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaMapper.selectByExample(null);
    }

    @GetMapping("/{id}")
    public Categoria getCategoriaById(@PathVariable Integer id) {
        return categoriaMapper.selectByPrimaryKey(id);
    }

    @PostMapping
    public int createCategoria(@RequestBody Categoria categoria) {
        return categoriaMapper.insertSelective(categoria);
    }

    @PutMapping("/{id}")
    public int updateCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {
        categoria.setIdCategoria(id);
        return categoriaMapper.updateByPrimaryKeySelective(categoria);
    }

    @DeleteMapping("/{id}")
    public int deleteCategoria(@PathVariable Integer id) {
        return categoriaMapper.deleteByPrimaryKey(id);
    }
}