package com.example.apidoctruyen.Controller;

import com.example.apidoctruyen.entity.Chapter;
import com.example.apidoctruyen.entity.Lichsudoctruyen;
import com.example.apidoctruyen.entity.Taikhoan;
import com.example.apidoctruyen.entity.Truyen;
import com.example.apidoctruyen.model.LichSuDocTruyenDto;
import com.example.apidoctruyen.model.LichsudoctruyenModel;
import com.example.apidoctruyen.repository.ChapterRepository;
import com.example.apidoctruyen.repository.TaiKhoanRepository;
import com.example.apidoctruyen.repository.lichsudoctruyenRepository;
import com.example.apidoctruyen.service.LichSuDocTruyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tusach")
public class tusachController {

    @Autowired
    lichsudoctruyenRepository repo;

    @Autowired
    LichSuDocTruyenService lichSuDocTruyenService;


    @GetMapping("/lichsu/{idtaikhoan}")
    public List<LichsudoctruyenModel> getListTruyenDaDoc(@PathVariable int idtaikhoan) {
        return repo.getListTruyenDaDoc(idtaikhoan);
    }

    @PostMapping("/lichsu")
    public void saveLichSuDoc(@RequestBody LichSuDocTruyenDto lichSuDocTruyenDto) {
        Lichsudoctruyen result = lichSuDocTruyenService.saveOrUpdateLichSuDoc(lichSuDocTruyenDto);
    }




}
