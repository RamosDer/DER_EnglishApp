package com.my_company.eapp.controller;

import com.my_company.eapp.dto.PalabraFraseDto;
import com.my_company.eapp.model.PalabraFraseExample;
import com.my_company.eapp.services.PalabraFraseService;
import java.util.Arrays;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;

@RestController
@RequestMapping("/palabrafrases")
public class PalabraFraseController {

    private final PalabraFraseService palabraFraseService;
    
    private static final Logger logger = LogManager.getLogger(PalabraFraseController.class);

    @Autowired
    public PalabraFraseController(PalabraFraseService palabraFraseService) {
        this.palabraFraseService = palabraFraseService;
    }

    @GetMapping
    public List<PalabraFraseDto> getAllPalabrasFrases() {
        return palabraFraseService.getAllPalabrasFrases();
    }

    @GetMapping("/{id}")
    public PalabraFraseDto getPalabraFraseById(@PathVariable Integer id) {
        return palabraFraseService.getPalabraFraseById(id);
    }

    @PostMapping
    public int createPalabraFrase(@RequestBody PalabraFraseDto palabraFraseDto) {
        return palabraFraseService.createPalabraFrase(palabraFraseDto);
    }

    @PutMapping("/{id}")
    public int updatePalabraFrase(@PathVariable Integer id, @RequestBody PalabraFraseDto palabraFraseDto) {
        return palabraFraseService.updatePalabraFrase(id, palabraFraseDto);
    }

    @DeleteMapping("/{id}")
    public int deletePalabraFrase(@PathVariable Integer id) {
        return palabraFraseService.deletePalabraFrase(id);
    }

    @GetMapping("/buscarPorContenido/{contenido}")
    public Integer getPalabraFraseIdByContenido(@PathVariable String contenido) {
        return palabraFraseService.getPalabraFraseIdByContenido(contenido);
    }

    @GetMapping("/buscar")
    public List<PalabraFraseDto> buscarPalabrasConFiltros(
            @RequestParam(name = "contenido", required = false) String contenido,
            @RequestParam(name = "dificultad", required = false) String dificultad,
            @RequestParam(name = "aprendido", required = false) Boolean aprendido,
            @RequestParam(name = "codTipo", required = false) String codTipo,
            @RequestParam(name = "fechaInicio", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam(name = "fechaFin", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin,
            @RequestParam(name = "idCategoria", required = false) Integer idCategoria
            ) {

        // Construye el objeto PalabraFraseExample
        PalabraFraseExample example = new PalabraFraseExample();
        PalabraFraseExample.Criteria criteria = example.createCriteria();
        logger.info("Ingresa al controlador de PalabraFrase - buscarPalabrasConFiltros");
        // Aplica los filtros según los parámetros proporcionados
        if (contenido != null && !contenido.isEmpty()) {
            logger.info("Palabra: " + contenido);
            criteria.andContenidoLike("%" + contenido + "%");
        }

        if (dificultad != null && Arrays.asList("Easy", "Medium", "Hard").contains(dificultad)) {
            logger.info("dificultad: " + dificultad);
            criteria.andDificultadEqualTo(dificultad);
        }

        if (aprendido != null) {
            logger.info("aprendido: " + aprendido);
            criteria.andAprendidoEqualTo(aprendido);
        }

        if (codTipo != null) {
            logger.info("codTipo: " + codTipo);
            criteria.andCodTipoEqualTo(codTipo);
        } else {
            logger.info("codTipo es null");
        }

        if (fechaInicio != null && fechaFin != null) {
            logger.info("fechaInicio: " + fechaInicio + "FechaFin: " + fechaFin);
            criteria.andFechaRegistroBetween(fechaInicio, fechaFin);
        }

        // Llama al método de búsqueda en el servicio
        return palabraFraseService.buscarPalabrasConFiltros(example, idCategoria);
    }
}
