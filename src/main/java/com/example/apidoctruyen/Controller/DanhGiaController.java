package com.example.apidoctruyen.Controller;


import com.example.apidoctruyen.entity.Chapter;

import com.example.apidoctruyen.entity.Danhgia;
import com.example.apidoctruyen.entity.Taikhoan;
import com.example.apidoctruyen.model.DanhGiaDto;
import com.example.apidoctruyen.model.TruyenDto;
import com.example.apidoctruyen.repository.BinhLuanRepository;
import com.example.apidoctruyen.repository.DanhGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class DanhGiaController {
    @Autowired
    DanhGiaRepository repo;
    @GetMapping("/truyen/gettbdanhgia/{id}")
    public Double getTruyenById(@PathVariable int id) {
        Double danhgia = repo.getAverageRatingByTruyenId(id);
        return danhgia;
    }


    @GetMapping("/getidbychapterandtk/{idchapter}/{idtaikhoan}")
    public List<Integer> getIDByChapterAndTK(@PathVariable int idchapter, @PathVariable int idtaikhoan){
        return repo.getIDByChapterAndTK(idchapter, idtaikhoan);
    }

    @PostMapping("/danhgia")
    public ResponseEntity<DanhGiaDto> addOrUpdateDanhGia(@RequestBody DanhGiaDto danhGiaDto) {
        System.out.println("Received request: idchapter=" + danhGiaDto.getIdchapter() +
                ", idtaikhoan=" + danhGiaDto.getIdtaikhoan() +
                ", sosao=" + danhGiaDto.getSosao());

        // Kiểm tra nếu đánh giá đã tồn tại
        Danhgia danhgia = repo.findByIdchapterAndIdtaikhoan(danhGiaDto.getIdchapter(), danhGiaDto.getIdtaikhoan());
        if (danhgia != null) {
            System.out.println("Updating existing rating...");
            danhgia.setSosao(danhGiaDto.getSosao());
            repo.save(danhgia);
            return ResponseEntity.ok(danhGiaDto);
        } else {
            System.out.println("Creating new rating...");

            Chapter chapter = new Chapter();
            chapter.setId(danhGiaDto.getIdchapter());

            Taikhoan taikhoan = new Taikhoan();
            taikhoan.setId(danhGiaDto.getIdtaikhoan());

            Danhgia newDanhgia = new Danhgia();
            newDanhgia.setIdchapter(chapter);
            newDanhgia.setIdtaikhoan(taikhoan);
            newDanhgia.setSosao(danhGiaDto.getSosao());
            newDanhgia.setNgaydanhgia(LocalDate.now());

            repo.save(newDanhgia);
            return ResponseEntity.ok(danhGiaDto);
        }
    }

    @GetMapping("/danhgia/{idchapter}/{idtaikhoan}")
    public ResponseEntity<DanhGiaDto> getDanhGiaByUserAndChapter(@PathVariable Integer idchapter, @PathVariable Integer idtaikhoan) {
        Danhgia danhgia = repo.findByIdchapterAndIdtaikhoan(idchapter, idtaikhoan);
        if (danhgia != null) {
            DanhGiaDto responseDto = new DanhGiaDto();
            responseDto.setId(danhgia.getId());
            responseDto.setIdchapter(danhgia.getIdchapter().getId());
            responseDto.setIdtaikhoan(danhgia.getIdtaikhoan().getId());
            responseDto.setSosao(danhgia.getSosao());
            responseDto.setNgaydanhgia(String.valueOf(danhgia.getNgaydanhgia()));
            return ResponseEntity.ok(responseDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/truyen/gettbdanhgiatheochapter/{id}")
    public ResponseEntity<Double> getAverageRatingByIdChapter(@PathVariable int id) {
        Double averageRating = repo.getAverageRatingByIdChapter(id);

        // Trả về 0.0 nếu không có dữ liệu
        if (averageRating == null) {
            averageRating = 0.0;
        }

        return ResponseEntity.ok(averageRating);
    }

}
