package com.my_company.eapp.controller;

import com.my_company.eapp.dto.ResumenDetalleDto;
import com.my_company.eapp.model.ResumenDetalleExample;
import com.my_company.eapp.services.ResumenDetalleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resumenDetalle")
public class ResumenDetalleController {
    
    @Autowired
    private ResumenDetalleService resumenDetalleService;

    // Endpoint para insertar un nuevo detalle
    @PostMapping("/insert")
    public ResponseEntity<String> insertResumenDetalle(@RequestBody ResumenDetalleDto resumenDetalleDto) {
        int result = resumenDetalleService.insert(resumenDetalleDto);
        if (result == 1) {
            return new ResponseEntity<>("Detalle insertado exitosamente", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al insertar el detalle", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para obtener detalles por ejemplo
    @GetMapping("/getByExample")
    public ResponseEntity<List<ResumenDetalleDto>> getResumenDetallesByExample(@RequestBody ResumenDetalleExample example) {
        List<ResumenDetalleDto> detalles = resumenDetalleService.selectByExample(example);
        if (!detalles.isEmpty()) {
            return new ResponseEntity<>(detalles, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para obtener un detalle por ID
    @GetMapping("/{id}")
    public ResponseEntity<ResumenDetalleDto> getResumenDetalleById(@PathVariable("id") Long idResumenDetalle) {
        ResumenDetalleDto detalle = resumenDetalleService.selectByPrimaryKey(idResumenDetalle);
        if (detalle != null) {
            return new ResponseEntity<>(detalle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Endpoint para obtener un detalle por IDResumen
    @GetMapping("/getByIdResumen/{id}")
    public ResponseEntity<List<ResumenDetalleDto>> selectByIdResumen(@PathVariable("id") Integer idResumen) {
        List<ResumenDetalleDto> detalle = resumenDetalleService.selectByIdResumen(idResumen);
        if (detalle != null) {
            return new ResponseEntity<>(detalle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar un detalle por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResumenDetalleById(@PathVariable("id") Long idResumenDetalle) {
        int result = resumenDetalleService.deleteByPrimaryKey(idResumenDetalle);
        if (result > 0) {
            return new ResponseEntity<>("Detalle eliminado exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error al eliminar el detalle", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
}
