package com.my_company.eapp.controller;

import com.my_company.eapp.dto.PracticaDto;
import com.my_company.eapp.model.PracticaExample;
import com.my_company.eapp.services.PalabraFraseService;
import com.my_company.eapp.services.PracticaService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RestController
@RequestMapping("/practica")
public class PracticaController {

    private static final Logger logger = LogManager.getLogger(PracticaController.class);
    
    @Autowired
    private PracticaService practicaService;
    
    @Autowired
    private PalabraFraseService palabraService;
    
    @GetMapping("/count")
    public ResponseEntity<Long> countByExample(PracticaExample example) {
        return ResponseEntity.ok(practicaService.countByExample(example));
    }

    @DeleteMapping("/deleteByExample")
    public ResponseEntity<Integer> deleteByExample(PracticaExample example) {
        return ResponseEntity.ok(practicaService.deleteByExample(example));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteByPrimaryKey(@PathVariable Integer id) {
        return ResponseEntity.ok(practicaService.deleteByPrimaryKey(id));
    }

    @PostMapping("/insert")
    public ResponseEntity<Integer> insert(@RequestBody PracticaDto practicaDto) {
        return ResponseEntity.ok(practicaService.insert(practicaDto));
    }

    @PostMapping("/insertSelective")
    public ResponseEntity<Integer> insertSelective(@RequestBody PracticaDto practicaDto) {
        return ResponseEntity.ok(practicaService.insertSelective(practicaDto));
    }

    @GetMapping("/selectByExample")
    public ResponseEntity<List<PracticaDto>> selectByExample(PracticaExample example) {
        return ResponseEntity.ok(practicaService.selectByExample(example));
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<PracticaDto> selectByPrimaryKey(@PathVariable Integer id) {
        return ResponseEntity.ok(practicaService.selectByPrimaryKey(id));
    }

    @PutMapping("/updateByExampleSelective")
    public ResponseEntity<Integer> updateByExampleSelective(@RequestBody PracticaDto practicaDto,
            PracticaExample example) {
        return ResponseEntity.ok(practicaService.updateByExampleSelective(practicaDto, example));
    }

    @PutMapping("/updateByExample")
    public ResponseEntity<Integer> updateByExample(@RequestBody PracticaDto practicaDto,
            PracticaExample example) {
        return ResponseEntity.ok(practicaService.updateByExample(practicaDto, example));
    }

    @PutMapping("/updateByPrimaryKeySelective")
    public ResponseEntity<Integer> updateByPrimaryKeySelective(@RequestBody PracticaDto practicaDto) {
        return ResponseEntity.ok(practicaService.updateByPrimaryKeySelective(practicaDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Integer> updateByPrimaryKey(@PathVariable Integer id,
            @RequestBody PracticaDto practicaDto) {
        return ResponseEntity.ok(practicaService.updateByPrimaryKey(practicaDto));
    }

    @PostMapping("/registrarOActualizarInput")
    public ResponseEntity<Integer> registrarOActualizar(@RequestBody List<Integer> idPalabraFrases) {
        logger.info("INGRESA A registrarOActualizar con " +idPalabraFrases );
        for (Integer idPalabraFrase : idPalabraFrases) {
            logger.info("IdPalabraFrase: " +idPalabraFrase );
            PracticaDto practicaDto = practicaService.selectByIdPalabraFrase(idPalabraFrase);
            
            if (practicaDto == null) {
                // Si no existe, registrar
                logger.info("Ingresa para registrarse");
                practicaDto = new PracticaDto();
                practicaDto.setUltimaFecha(new Date());
                practicaDto.setConteo(1);
                practicaDto.setIdPalabraFrase(idPalabraFrase);
                
                practicaService.insert(practicaDto);
            } else {
                // Si ya existe, actualizar
                logger.info("Ingresa para actualzar");
                practicaDto.setUltimaFecha(new Date());
                practicaDto.setConteo(practicaDto.getConteo() + 1);

                practicaService.updateByPrimaryKeySelective(practicaDto);
            }
        }

        return ResponseEntity.ok(idPalabraFrases.size());
    }
    
    @PostMapping("/registrarOActualizarSelect")
    public ResponseEntity<Integer> registrarOActualizarSelect(@RequestBody List<String> palabrasList) {
        logger.info("INGRESA A registrarOActualizarSelect con " +palabrasList );
        for (String palabra : palabrasList) {
            //logger.info("IdPalabraFrase: " +idPalabraFrase );
            int idPalabra = palabraService.getPalabraFraseIdByContenido(palabra);
            PracticaDto practicaDto = practicaService.selectByIdPalabraFrase(idPalabra);
            
            if (practicaDto == null) {
                // Si no existe, registrar
                logger.info("Ingresa para registrarse");
                practicaDto = new PracticaDto();
                practicaDto.setUltimaFecha(new Date());
                practicaDto.setConteo(1);
                practicaDto.setIdPalabraFrase(idPalabra);
                
                practicaService.insert(practicaDto);
            } else {
                // Si ya existe, actualizar
                logger.info("Ingresa para actualzar");
                practicaDto.setUltimaFecha(new Date());
                practicaDto.setConteo(practicaDto.getConteo() + 1);

                practicaService.updateByPrimaryKeySelective(practicaDto);
            }
        }

        return ResponseEntity.ok(palabrasList.size());
    }

}
