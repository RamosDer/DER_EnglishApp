package com.my_company.eapp.controller;

import com.my_company.eapp.dto.PalabraFraseDto;
import com.my_company.eapp.dto.SignificadoDto;
import com.my_company.eapp.model.PalabraFraseExample;
import com.my_company.eapp.services.PalabraFraseService;
import com.my_company.eapp.services.SignificadoService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingresapalabra")
public class IngresaPalabraController {

    @Autowired
    private PalabraFraseService palabraFraseService;

    @Autowired
    private SignificadoService significadoService;
    
    private static final Logger logger = LogManager.getLogger(IngresaPalabraController.class);

    @GetMapping("/iniciarPruebaInput")
    public ResponseEntity<List<SignificadoDto>> iniciarJuego(
            @RequestParam(name = "dificultad", required = false) String dificultad,
            @RequestParam(name = "aprendido", required = false) Boolean aprendido,
            @RequestParam(name = "codTipo", required = false) String codTipo,
            @RequestParam(name = "fechaInicio", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam(name = "fechaFin", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin
    ) {

        // Construye el objeto PalabraFraseExample
        PalabraFraseExample example = new PalabraFraseExample();
        PalabraFraseExample.Criteria criteria = example.createCriteria();
        logger.info("Ingresa al controlador de IngresaPalabra - iniciarJuego");
        // Aplica los filtros según los parámetros proporcionados
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
        //idCategoria siempre sera 1 ya que 1= Palabra: (buscarPalabrasConFiltros(example, idCategoria);
        List<PalabraFraseDto> palabrasConFiltros = palabraFraseService.buscarPalabrasConFiltros(example, 1);

        List<SignificadoDto> todosLosSignificados = new ArrayList<>();
        for (PalabraFraseDto palabra : palabrasConFiltros) {
            List<SignificadoDto> significadosDePalabra = significadoService.selectByPalabraFrasePrimaryKey(palabra.getIdPalabraFrase());
            todosLosSignificados.addAll(significadosDePalabra);
        }

        Collections.shuffle(todosLosSignificados);
        List<SignificadoDto> significadosLimitados = todosLosSignificados.stream().limit(20).collect(Collectors.toList());

        return ResponseEntity.ok(significadosLimitados);
    }

    @PostMapping("/verificarRespuesta")
    public ResponseEntity<Boolean> verificarRespuesta(
            @RequestParam(name = "contenido", required = true) String contenido,
            @RequestParam(name = "idSignificado", required = true) Integer idSignificado) {
        logger.info("Ingresa a verificarRespuesta con contendio: " + contenido + "y idSignificado: " + idSignificado);
        SignificadoDto significado = significadoService.getSignificadoById(idSignificado);
        Integer idPalabra = significado.getIdPalabraFrase();
        logger.info("Id PalabraFrase: " + idPalabra);
        PalabraFraseDto palabra = palabraFraseService.getPalabraFraseById(idPalabra);
        contenido = contenido.toUpperCase();
        logger.info("Respues de palabra.getContenido().equals(contenido): " + palabra.getContenido().toUpperCase().equals(contenido));
        return ResponseEntity.ok(palabra.getContenido().toUpperCase().equals(contenido));
    }
}
