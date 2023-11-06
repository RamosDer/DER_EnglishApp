package com.my_company.eapp.controller;

import com.my_company.eapp.dto.SignificadoDto;
import com.my_company.eapp.model.Significado;
import com.my_company.eapp.services.SignificadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("*")
@RequestMapping("/significados")
public class SignificadoController {

    private final SignificadoService significadoService;

    @Autowired
    public SignificadoController(SignificadoService significadoService) {
        this.significadoService = significadoService;
    }

    @GetMapping
    public List<SignificadoDto> getAllSignificados() {
        return significadoService.getAllSignificados();
    }

    @GetMapping("/{id}")
    public SignificadoDto getSignificadoById(@PathVariable Integer id) {
        return significadoService.getSignificadoById(id);
    }

    @PostMapping
    public int createSignificado(@RequestBody SignificadoDto significadoDto) {
        return significadoService.createSignificado(significadoDto);
    }

    @PutMapping("/{id}")
    public int updateSignificado(@PathVariable Integer id, @RequestBody SignificadoDto significadoDto) {
        significadoDto.setIdSignificado(id);
        return significadoService.updateSignificado(significadoDto);
    }

    @DeleteMapping("/{id}")
    public int deleteSignificado(@PathVariable Integer id) {
        return significadoService.deleteSignificado(id);
    }

    @GetMapping("/palabra/{idPalabraFrase}")
    public List<SignificadoDto> getSignificadosByPalabraFraseId(@PathVariable Integer idPalabraFrase) {
        return significadoService.selectByPalabraFrasePrimaryKey(idPalabraFrase);
    }

}
