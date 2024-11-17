package com.example.apidoctruyen.Controller;

import com.example.apidoctruyen.entity.Chapter;

import com.example.apidoctruyen.entity.Noidungchapter;
import com.example.apidoctruyen.entity.Truyen;
import com.example.apidoctruyen.model.ChapterDto;
import com.example.apidoctruyen.model.ChapterModel;
import com.example.apidoctruyen.model.NoiDungChapterDto;
import com.example.apidoctruyen.repository.ChapterRepository;
import com.example.apidoctruyen.repository.NoiDungChapterRepository;
import com.example.apidoctruyen.repository.truyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ChapterController {
    @Autowired
    ChapterRepository chapterRepository;
    @Autowired
    truyenRepository repo;
    @Autowired
    NoiDungChapterRepository noiDungChapterRepository;

    @GetMapping("/truyen/chapter/{id}")
    public List<ChapterDto> getChapterById(@PathVariable Integer id) {
        //Truyen truyen = repo.findById(id);
        List<ChapterDto> list = chapterRepository.getChapterByIdTruyen(id);
        return list;
    }

    @PostMapping("/truyen/{id}/chapterupdate")
    public Chapter addChapter(@PathVariable Integer id, @RequestBody Map<String, Object> payload) {
        Truyen truyen = repo.findById(id).orElse(null);
        if (truyen == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Truyen not found");
        }
        Chapter chapter = new Chapter();
        chapter.setIdtruyen(truyen);
        chapter.setTenchapter((String) payload.get("tenchapter"));
        chapter.setNgaydang(LocalDate.now()); // giả sử ngày đăng là ngày hiện tại
        chapter.setSoluotxem(0); // giả sử số lượt xem ban đầu là 0
        chapter.setDanhgia(0.0); // giả sử đánh giá ban đầu là 0.0
        return chapterRepository.save(chapter);
    }

    @GetMapping("/truyen/chapter/noidung/{id}")
    public List<ChapterDto> getChapterContentById(@PathVariable Integer id) {
        //Truyen truyen = repo.findById(id);
        List<ChapterDto> list = chapterRepository.getChapterContentById(id);
        return list;
    }
    // @Query("SELECT NEW com.example.apidoctruyen.model.NoiDungChapter (c.id,c.idchapter,c.linkanh)\n" +
    //            "FROM Noidungchapter c\n" +
    //            "WHERE c.idchapter = :id")
    //    List<NoiDungChapter> getLinkChapterById(int id);
    @GetMapping("/truyen/chapter/noidung/linkanh/{id}")
    public List<NoiDungChapterDto> getLinkChapterById(@PathVariable Integer id) {
        //Truyen truyen = repo.findById(id);
        List<NoiDungChapterDto> list = chapterRepository.getLinkChapterById(id);
        return list;
    }

    @PostMapping("/truyen/chapter/{id}/noidung")
    public Noidungchapter addNoiDungChapter(@PathVariable Integer id, @RequestBody Map<String, Object> payload) {
        Chapter chapter = chapterRepository.findById(id).orElse(null);
        if (chapter == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Chapter not found");
        }
        Noidungchapter noidungchapter = new Noidungchapter();
        noidungchapter.setIdchapter(chapter);
        noidungchapter.setLinkanh((String) payload.get("linkanh"));
        return noiDungChapterRepository.save(noidungchapter);
    }


    @GetMapping("/truyen/chapter/getone/{idchapter}")
    public ChapterDto getOneChapter(@PathVariable int idchapter) {
        ChapterDto listChapter = chapterRepository.getOneChapter(idchapter);
        return listChapter;
    }
    @GetMapping("/truyen/chapter/tenchapter/{idtruyen}")
    public String getTenChapterNew(@PathVariable int idtruyen) {
        String tenChapter = chapterRepository.getTenChapterNew(idtruyen);
        return tenChapter;
    }
    @GetMapping("/truyen/chapter1/{id}")
    public List<ChapterModel> getChapterById1(@PathVariable Integer id) {
        //Truyen truyen = repo.findById(id);
        List<ChapterModel> list = chapterRepository.getChapterById(id);
        return list;
    }

    @GetMapping("/truyen/chapter/getidtruyen/{id}")
    public int getIdTruyenByIdChapter(@PathVariable Integer id) {
        int idtruyen = chapterRepository.getIdTruyenByIdChapter(id);
        return idtruyen;
    }
    @Autowired
    ChapterRepository repo1;
    @GetMapping("/truyen/gettongluotxem/{id}")
    public Long getBinhLuan(@PathVariable int id) {
        return repo1.sumSoluotxemByTruyenId(id);
    }
    @GetMapping("/truyen/getchapterbyidtruyen/{id}")
    public List<ChapterDto> getChapterByIdTruyen(@PathVariable int id){
        return repo1.getChapterByIdTruyen(id);
    }
    @GetMapping("/truyen/gettenchapter/{id}")
    public List<ChapterDto> findTenById(@PathVariable int id) {
        return repo1.findTenById(id);
    }
    @PutMapping("/updateLuotXem/{id}")
    public Chapter updateLuotXemChapter(@PathVariable int id) {
        Optional<Chapter> optionalChapter = repo1.findById(id);
        Chapter chapter = optionalChapter.get();
        chapter.setSoluotxem(chapter.getSoluotxem() + 1);
        return repo1.save(chapter);
    }
    @GetMapping("/truyen/getminidchapter/{id}")
    public int getMinIdChapter(@PathVariable int id) {
        return repo1.getMinIdChapter(id);
    }
    @GetMapping("/truyen/getmaxidchapter/{id}")
    public int getMaxIdChapter(@PathVariable int id) {
        return repo1.getMaxIdChapter(id);
    }

}
