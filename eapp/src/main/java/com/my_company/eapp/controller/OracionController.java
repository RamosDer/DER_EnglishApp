package com.my_company.eapp.controller;

import com.my_company.eapp.model.Oracion;
import com.my_company.eapp.services.OracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oraciones")
public class OracionController {

    private final OracionService oracionService;

    @Autowired
    public OracionController(OracionService oracionService) {
        this.oracionService = oracionService;
    }

    @GetMapping
    public List<Oracion> getAllOraciones() {
        return oracionService.getAllOraciones();
    }

    @GetMapping("/{id}")
    public Oracion getOracionById(@PathVariable Integer id) {
        return oracionService.getOracionById(id);
    }

    @PostMapping
    public int createOracion(@RequestBody Oracion oracion) {
        return oracionService.createOracion(oracion);
    }

    @PutMapping("/{id}")
    public int updateOracion(@PathVariable Integer id, @RequestBody Oracion oracion) {
        oracion.setIdOracion(id);
        return oracionService.updateOracion(oracion);
    }

    @DeleteMapping("/{id}")
    public int deleteOracion(@PathVariable Integer id) {
        return oracionService.deleteOracion(id);
    }
    
    @GetMapping("/palabra/{idPalabraFrase}")
    public List<Oracion> getOracionIdByPalabraFraseId(@PathVariable Integer idPalabraFrase) {
        return oracionService.getOracionIdByPalabraFraseId(idPalabraFrase);
    }
}
