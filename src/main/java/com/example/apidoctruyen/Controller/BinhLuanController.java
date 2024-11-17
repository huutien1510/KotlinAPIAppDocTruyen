package com.example.apidoctruyen.Controller;
import com.example.apidoctruyen.model.BinhLuanDto;
import com.example.apidoctruyen.model.BinhLuanTruyenDto;

import com.example.apidoctruyen.repository.BinhLuanRepository;


import com.example.apidoctruyen.repository.ChapterRepository;
import com.example.apidoctruyen.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class BinhLuanController {
    @Autowired
    BinhLuanRepository repo;
    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @GetMapping("/truyen/getbinhluan/{id}")
    public List<BinhLuanTruyenDto> getBinhLuan(@PathVariable int id) {
        List<BinhLuanTruyenDto> list = repo.getBinhLuan(id);
        return list;
    }
    @GetMapping("/truyen/gettongbinhluan/{id}")
    public Long gcountBinhLuanByTruyenId(@PathVariable int id) {
        return repo.countBinhLuanByTruyenId(id);
    }
    @GetMapping("/truyen/getbinhluantheoIdChapter/{id}")
    public List<BinhLuanTruyenDto> getBinhLuanTheoIdChapter(@PathVariable int id) {
        List<BinhLuanTruyenDto> list = repo.getBinhLuanTheoIdChapter(id);
        return list;
    }
    @PostMapping("/addBinhLuan")
    public ResponseEntity<BinhLuanDto> addBinhLuan(@RequestBody BinhLuanDto binhLuanDto) {
        // Fetch related entities
        if (!chapterRepository.existsById(binhLuanDto.getIdchapter()) || !taiKhoanRepository.existsById(binhLuanDto.getIdtaikhoan())) {
            return ResponseEntity.badRequest().build();
        }

        // Insert using custom query
        Integer newId = repo.addBinhLuan(
                binhLuanDto.getIdchapter(),
                binhLuanDto.getIdtaikhoan(),
                binhLuanDto.getNoidung(),
                LocalDate.now(),
                1 // Assuming 1 is the default active state for trangthai
        );

        // Prepare response DTO
        BinhLuanDto responseDto = new BinhLuanDto();
        responseDto.setId(newId);
        responseDto.setIdchapter(binhLuanDto.getIdchapter());
        responseDto.setIdtaikhoan(binhLuanDto.getIdtaikhoan());
        responseDto.setNoidung(binhLuanDto.getNoidung());
        responseDto.setNgaydang(String.valueOf(LocalDate.now()));
        responseDto.setTrangthai(1);

        return ResponseEntity.ok(responseDto);
    }

}
