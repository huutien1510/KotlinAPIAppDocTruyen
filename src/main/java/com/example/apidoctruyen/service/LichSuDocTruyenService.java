package com.example.apidoctruyen.service;

import com.example.apidoctruyen.entity.Chapter;
import com.example.apidoctruyen.entity.Lichsudoctruyen;
import com.example.apidoctruyen.entity.Taikhoan;
import com.example.apidoctruyen.entity.Truyen;
import com.example.apidoctruyen.model.LichSuDocTruyenDto;
import com.example.apidoctruyen.repository.ChapterRepository;
import com.example.apidoctruyen.repository.TaiKhoanRepository;
import com.example.apidoctruyen.repository.lichsudoctruyenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LichSuDocTruyenService {

    private final lichsudoctruyenRepository lichSuDocTruyenRepository;
    private final TaiKhoanRepository taiKhoanRepository;
    private final ChapterRepository chapterRepository;


    public Lichsudoctruyen saveOrUpdateLichSuDoc(LichSuDocTruyenDto request) {
        // Lấy thông tin tài khoản
        Taikhoan taiKhoan = taiKhoanRepository.findById(request.getIdtaikhoan()).orElseThrow(() -> new RuntimeException("Tài khoản không tồn tại"));
        // Lấy thông tin chapter
        Chapter chapter = chapterRepository.findById(request.getIdchapter()).orElseThrow(() -> new RuntimeException("Chapter không tồn tại"));
        // Lấy thông tin truyện từ chapter
        Truyen truyen = chapter.getIdtruyen();
        // Kiểm tra xem đã có lịch sử đọc cùng truyện chưa
        Lichsudoctruyen existingHistory = lichSuDocTruyenRepository.findByTaiKhoanIdAndTruyenId(taiKhoan.getId(), truyen.getId());
        if (existingHistory != null) {
            // Cập nhật chapter nếu chapter mới có số thứ tự lớn hơn
            if (existingHistory.getIdchapter().getId() < chapter.getId()) {
                existingHistory.setIdchapter(chapter);
                return lichSuDocTruyenRepository.save(existingHistory);
            } else {
                return existingHistory; // Không cần cập nhật
            }
        }

        // Nếu chưa có lịch sử đọc, thêm mới
        Lichsudoctruyen newHistory = new Lichsudoctruyen();
        newHistory.setIdtaikhoan(taiKhoan);
        newHistory.setIdchapter(chapter);
        return lichSuDocTruyenRepository.save(newHistory);
    }
}