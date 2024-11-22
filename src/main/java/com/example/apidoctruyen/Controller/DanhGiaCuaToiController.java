package com.example.apidoctruyen.Controller;

import com.example.apidoctruyen.model.BinhLuanCuaToi;
import com.example.apidoctruyen.model.DanhGiaCuaToiDto;
import com.example.apidoctruyen.repository.BinhLuanCuaToiRepository;
import com.example.apidoctruyen.repository.DanhGiaCuaToiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DanhGiaCuaToiController {

    @Autowired
    private DanhGiaCuaToiRepository danhGiaCuaToiRepository;

    @GetMapping("/danhgiacuatoi/{id}")
    public List<DanhGiaCuaToiDto> findByIdn(@PathVariable Integer id) {
        return danhGiaCuaToiRepository.findByIdn(id);
    }
}

