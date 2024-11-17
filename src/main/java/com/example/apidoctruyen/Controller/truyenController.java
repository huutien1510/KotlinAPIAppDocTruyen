package com.example.apidoctruyen.Controller;

import com.example.apidoctruyen.entity.Chapter;
import com.example.apidoctruyen.entity.Taikhoan;
import com.example.apidoctruyen.entity.Truyen;

import com.example.apidoctruyen.model.ChapterDto;

import com.example.apidoctruyen.model.TimkiemModel;

import com.example.apidoctruyen.model.TruyenDto;
import com.example.apidoctruyen.model.TruyenInfo;

import com.example.apidoctruyen.repository.truyenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class truyenController {

    @Autowired
    truyenRepository repo;

    @GetMapping("/truyen")
    public List<TruyenDto> getAllTruyen() {
        List<TruyenDto> listTruyen = repo.getAllTruyen();
        return listTruyen;
    }

    @GetMapping("/truyen/toptruyenmoi")
    public List<TruyenDto> getTopTruyenMoi() {
        Pageable topFive = PageRequest.of(0, 5);
        return repo.getTruyenMoi(topFive);
    }

    @GetMapping("/truyen/toptruyen")
    public List<TruyenDto> getTop5Truyen() {
        Pageable topFive = PageRequest.of(0, 5);
        return repo.getTopTruyen(topFive);
    }

    @GetMapping("/theloai")
    public List<String> getAllTheLoai() {
        return repo.findAllTheLoai();
    }


    @GetMapping("/truyen/truyennewest")
    public List<TruyenInfo> getNewestTruyen() {
        List<TruyenInfo> list = repo.findNewestComics();
        return list;
    }

    @GetMapping("/truyen/truyennewest/{theloai}")
    public List<TruyenInfo> getNewestTruyenByTheLoai(@PathVariable String theloai) {
        List<TruyenInfo> list = repo.findNewestComicsByTheLoai(theloai);
        return list;
    }

    //findVotesComic
    @GetMapping("/truyen/truyenvotes")
    public List<TruyenInfo> getVotesTruyen() {
        List<TruyenInfo> list = repo.findVotesComic();
        return list;
    }

    @GetMapping("/truyen/truyenvotes/{theloai}")
    public List<TruyenInfo> getVotesTruyenByTheLoai(@PathVariable String theloai) {
        List<TruyenInfo> list = repo.findVotesComicByTheLoai(theloai);
        return list;
    }

    @GetMapping("/truyen/truyenview")
    public List<TruyenInfo> getTruyenView() {
        List<TruyenInfo> list = repo.findViewComic();
        return list;
    }

    @GetMapping("/truyen/truyenview/{theloai}")
    public List<TruyenInfo> getTruyenViewByTheLoai(@PathVariable String theloai) {
        List<TruyenInfo> list = repo.findViewComicByTheLoai(theloai);
        return list;
    }
    @GetMapping("/truyen/gettruyen/{id}")
    public List<TruyenDto> getTruyenById(@PathVariable int id) {
        List<TruyenDto> list = repo.getTruyenBy(id);
        return list;
    }

    @GetMapping("/truyen/getone/{idchapter}")
    public TruyenDto getOneTruyen(@PathVariable int idchapter) {
        TruyenDto list = repo.getOneTruyen(idchapter);
        return list;
    }

    @GetMapping("/search")
    public ArrayList<TimkiemModel> findTruyenBySearchText(@RequestParam("textsearch") String textsearch){
        return repo.getListTimKiem(textsearch);
    }


    @GetMapping("/truyen/tentruyen")
    public List<String> getTenTruyen() {
        return repo.getTenTruyen();
    }

    @PostMapping("/truyen")
    public Truyen addTruyen(@RequestBody Truyen truyen) {
        return repo.save(truyen);
    }

    // tìm truyện theo id
    @GetMapping("/truyen/{id}")
    public List<TruyenDto> getAllTruyenById(@PathVariable Integer id) {
        List<TruyenDto> list = repo.getAllTruyenById(id);
        return list;
    }

    // cập nhâật truyện theo id
    @PutMapping("/truyen/{id}")
    public Truyen updateTruyen(@RequestBody Truyen truyen, @PathVariable Integer id) {
        Truyen truyen1 = repo.findById(id).orElse(null);
        truyen1.setTentruyen(truyen.getTentruyen());
        truyen1.setTacgia(truyen.getTacgia());
        truyen1.setMota(truyen.getMota());
        truyen1.setTheloai(truyen.getTheloai());
        truyen1.setLinkanh(truyen.getLinkanh());
        truyen1.setKey_search(truyen.getKey_search());
        return repo.save(truyen1);
    }
}
