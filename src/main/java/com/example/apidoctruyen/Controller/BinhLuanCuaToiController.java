package com.example.apidoctruyen.Controller;

import com.example.apidoctruyen.model.BinhLuanCuaToi;
import com.example.apidoctruyen.repository.BinhLuanCuaToiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BinhLuanCuaToiController {

    @Autowired
    BinhLuanCuaToiRepository binhLuanCuaToiRepository;

    @GetMapping("/binhluancuatoi/{id}")
    public List<BinhLuanCuaToi> findByIdn(@PathVariable Integer id){
        return binhLuanCuaToiRepository.findByIdn(id);
    }
}
