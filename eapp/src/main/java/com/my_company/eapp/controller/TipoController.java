package com.my_company.eapp.controller;

import com.my_company.eapp.dto.TipoDto;
import com.my_company.eapp.services.TipoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipos")
public class TipoController {

     @Autowired
    private TipoService tipoService;
     
    @GetMapping
    public List<TipoDto> getAllTipos() {
        return tipoService.selectByExample();
    }

    @GetMapping("/{codTipo}")
    public TipoDto getTipoById(@PathVariable String codTipo) {
        return tipoService.selectByPrimaryKey(codTipo);
    }

    @GetMapping("/categoria/{idCategoria}")
    public List<TipoDto> getTiposByCategoria(@PathVariable Integer idCategoria) {
        return tipoService.selectByCategoriaPrimaryKey(idCategoria);
    }

    @PostMapping
    public int createTipo(@RequestBody TipoDto tipoDto) {
        return tipoService.insertSelective(tipoDto);
    }

    @PutMapping("/{id}")
    public int updateTipo(@PathVariable String codTipo, @RequestBody TipoDto tipoDto) {
        tipoDto.setCodTipo(codTipo);
        return tipoService.updateByPrimaryKeySelective(tipoDto);
    }

    @DeleteMapping("/{id}")
    public int deleteTipo(@PathVariable String codTipo) {
        return tipoService.deleteByPrimaryKey(codTipo);
    }
    
}

