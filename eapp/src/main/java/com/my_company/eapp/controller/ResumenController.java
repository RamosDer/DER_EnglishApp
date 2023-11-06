package com.my_company.eapp.controller;

import com.my_company.eapp.dto.ResumenDto;
import com.my_company.eapp.model.ResumenExample;
import com.my_company.eapp.services.ResumenService;
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
@RequestMapping("/resumen")
public class ResumenController {

    @Autowired
    private ResumenService resumenService;

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
}

