package com.example.apidoctruyen.Controller;

import com.example.apidoctruyen.model.NoiDungChapterDto;
import com.example.apidoctruyen.repository.DanhGiaRepository;
import com.example.apidoctruyen.repository.NoiDungChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoiDungChapterController {
    @Autowired
    NoiDungChapterRepository repo;
    @GetMapping("/truyen/getnoidungchapter/{id}")
    public List<NoiDungChapterDto> getNoidungchapterBy(@PathVariable int id) {
        return repo.getNoidungchapterById(id);
    }
}
