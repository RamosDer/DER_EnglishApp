package com.my_company.eapp.controller;

import com.my_company.eapp.dto.PalabraFraseDto;
import com.my_company.eapp.dto.SelectPalabraDto;
import com.my_company.eapp.dto.SignificadoDto;
import com.my_company.eapp.model.PalabraFraseExample;
import com.my_company.eapp.services.PalabraFraseService;
import com.my_company.eapp.services.SignificadoService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
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
@RequestMapping("/seleccionapalabra")
public class SeleccionaPalabraController {

    @Autowired
    private PalabraFraseService palabraFraseService;

    @Autowired
    private SignificadoService significadoService;
    
    private static final Logger logger = LogManager.getLogger(SeleccionaPalabraController.class);

    @GetMapping("/iniciarPruebaDefinicion")
    public ResponseEntity<List<SelectPalabraDto>> iniciarJuegoDefinicion(
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

        if (palabrasConFiltros.isEmpty()) {
            return null;
        }

        // Aquí verificamos que las palabras tengan significados
        Iterator<PalabraFraseDto> palabraIterator = palabrasConFiltros.iterator();
        while (palabraIterator.hasNext()) {
            PalabraFraseDto palabra = palabraIterator.next();
            List<SignificadoDto> significadosDePalabra = significadoService.selectByPalabraFrasePrimaryKey(palabra.getIdPalabraFrase());
            if (significadosDePalabra.isEmpty()) {
                palabraIterator.remove(); // Quitamos la palabra sin significados
            }
        }

        if (palabrasConFiltros.isEmpty()) {
            return null;
        }

        // Para simplificar, elegimos una palabra al azar
        Collections.shuffle(palabrasConFiltros);
        

       
            List<SelectPalabraDto> juegos = new ArrayList<>();
    for (int i = 0; i < 10 && !palabrasConFiltros.isEmpty(); i++) {
        PalabraFraseDto palabraSeleccionada = palabrasConFiltros.remove(0);  // Usamos remove() para asegurarnos de no repetir palabras

        SelectPalabraDto juego = new SelectPalabraDto();
        juego.setPalabra(palabraSeleccionada.getContenido());
        juego.setIdPalabraFrase(palabraSeleccionada.getIdPalabraFrase());

        List<SignificadoDto> significadosDePalabra = significadoService.selectByPalabraFrasePrimaryKey(palabraSeleccionada.getIdPalabraFrase());
        SignificadoDto significadoCorrecto = significadosDePalabra.get(0); // Tomamos uno al azar como correcto

        List<SignificadoDto> definicionesIncorrectas = significadoService.getDefinicionesAleatorias(2, palabraSeleccionada.getIdPalabraFrase());

        juego.setRespuestaCorrecta(significadoCorrecto.getDescripcion());
        juego.setOpciones(Arrays.asList(significadoCorrecto.getDescripcion(),
                definicionesIncorrectas.get(0).getDescripcion(),
                definicionesIncorrectas.get(1).getDescripcion()));

        Collections.shuffle(juego.getOpciones()); // Mezclamos las opciones para que no estén en orden

        juegos.add(juego);
    }

    return ResponseEntity.ok(juegos);
    }

    @PostMapping("/verificarRespuesta")
    public ResponseEntity<Boolean> verificarRespuesta(
            @RequestParam(name = "significadoSeleccionado", required = true) String significadoSeleccionado,
            @RequestParam(name = "idPalabraFrase", required = true) Integer idPalabraFrase) {

        // Obtener todos los significados asociados con idPalabraFrase
        List<SignificadoDto> significadosDePalabra = significadoService.selectByPalabraFrasePrimaryKey(idPalabraFrase);
        
        int idSignificadoSeleccionado = significadoService.getSignificadoByDescripcion(significadoSeleccionado);

        // Verificar si el idSignificadoSeleccionado se encuentra en la lista de significados
        boolean esCorrecto = significadosDePalabra.stream()
                .anyMatch(significadoDto -> Objects.equals(significadoDto.getIdSignificado(), idSignificadoSeleccionado));

        return ResponseEntity.ok(esCorrecto);
    }

}
