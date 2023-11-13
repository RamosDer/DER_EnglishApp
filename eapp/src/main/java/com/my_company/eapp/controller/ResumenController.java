package com.my_company.eapp.controller;

import com.my_company.eapp.dto.ResumenDto;
import com.my_company.eapp.model.ResumenExample;
import com.my_company.eapp.services.ResumenService;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resumen")
public class ResumenController {

    @Autowired
    private ResumenService resumenService;
    
    private static final Logger logger = LogManager.getLogger(ResumenController.class);

    @GetMapping("/count")
    public long countByExample(ResumenExample example) {
        return resumenService.countByExample(example);
    }

    @DeleteMapping("/deleteByExample")
    public int deleteByExample(ResumenExample example) {
        return resumenService.deleteByExample(example);
    }

    @DeleteMapping("/delete/{idResumen}")
    public int deleteByPrimaryKey(@PathVariable Integer idResumen) {
        return resumenService.deleteByPrimaryKey(idResumen);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody ResumenDto resumenDto) {
        return resumenService.insert(resumenDto);
    }

    @PostMapping("/insertSelective")
    public int insertSelective(@RequestBody ResumenDto resumenDto) {
        return resumenService.insertSelective(resumenDto);
    }

    @GetMapping("/selectByExample")
    public List<ResumenDto> selectByExample(ResumenExample example) {
        return resumenService.selectByExample(example);
    }

    @GetMapping("/select/{idResumen}")
    public ResumenDto selectByPrimaryKey(@PathVariable Integer idResumen) {
        return resumenService.selectByPrimaryKey(idResumen);
    }

    @PutMapping("/updateByExampleSelective")
    public int updateByExampleSelective(@RequestBody ResumenDto resumenDto, ResumenExample example) {
        return resumenService.updateByExampleSelective(resumenDto, example);
    }

    @PutMapping("/updateByExample")
    public int updateByExample(@RequestBody ResumenDto resumenDto, ResumenExample example) {
        return resumenService.updateByExample(resumenDto, example); 
    }

    @PutMapping("/updateByPrimaryKeySelective")
    public int updateByPrimaryKeySelective(@RequestBody ResumenDto resumenDto) {
        return resumenService.updateByPrimaryKeySelective(resumenDto);
    }

    @PutMapping("/update/{idResumen}")
    public int updateByPrimaryKey(@PathVariable Integer idResumen, @RequestBody ResumenDto resumenDto) {
        return resumenService.updateByPrimaryKey(resumenDto);
    }
    
    @GetMapping("/selectLast/{idUsuario}")
    public ResumenDto selectLastRecordByUser(@PathVariable Integer idUsuario) {
        return resumenService.selectLastRecordByUser(idUsuario);
    }
    
    @GetMapping("/getByParameters")
    public ResumenDto getByParameters(
            @RequestParam(name = "tiempo", required = false) Integer tiempo,
            @RequestParam(name = "palabrasPracticadas", required = false) Integer palabrasPracticadas,
            @RequestParam(name = "aciertos", required = false) Integer aciertos,
            @RequestParam(name = "idUsuario", required = false) Integer idUsuario,
            @RequestParam(name = "fechaDePractica", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDePractica){
        
        // Construye el objeto PalabraFraseExample
        ResumenExample example = new ResumenExample();
        ResumenExample.Criteria criteria = example.createCriteria();
        logger.info("Ingresa al controlador de PalabraFrase - buscarPalabrasConFiltros");
        
        // Aplica los filtros según los parámetros proporcionados
        if (tiempo != null) {
            logger.info("Tiempo: " + tiempo);
            criteria.andTiempoEqualTo(tiempo);
        }
        
        if (palabrasPracticadas != null) {
            logger.info("Palabras Practicadas: " + palabrasPracticadas);
            criteria.andPalabrasPracticadasEqualTo(palabrasPracticadas);
        }
        
        if (aciertos != null) {
            logger.info("Aciertos: " + aciertos);
            criteria.andAciertosEqualTo(aciertos);
        }
        
        if (idUsuario != null) {
            logger.info("ID USUARIO: " + idUsuario);
            criteria.andIdUsuarioEqualTo(idUsuario);
        }
        
        if (fechaDePractica != null) {
            logger.info("ID USUARIO: " + fechaDePractica);
            criteria.andFechaDePracticaEqualTo(fechaDePractica);
        }
        
        return resumenService.getByParameters(example);
    }
}

