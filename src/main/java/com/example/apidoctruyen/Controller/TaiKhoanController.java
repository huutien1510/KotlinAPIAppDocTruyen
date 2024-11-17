package com.example.apidoctruyen.Controller;

import com.example.apidoctruyen.entity.Taikhoan;
import com.example.apidoctruyen.model.TaiKhoanDto;
import com.example.apidoctruyen.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaiKhoanController {
    @Autowired
    TaiKhoanRepository taiKhoanRepository;



    @GetMapping("/timtaikhoan/{email}")
    public List<TaiKhoanDto> getTaiKhoanByEmail(@PathVariable String email) {
        return taiKhoanRepository.getByEmail(email);
    }
    @GetMapping("/findidtaikhoan/{email}")
    public int findIDTaiKhoanByEmail(@PathVariable String email){
        return taiKhoanRepository.findIDTaiKhoanByEmail(email);
    }

    @GetMapping("/taikhoan/{email}")
    public Optional<TaiKhoanDto> findByEmail(@PathVariable String email){
        return taiKhoanRepository.findByEmail(email);
    }

    @GetMapping("/taikhoan")
    public List<TaiKhoanDto> findByLoaiTk(){
        return taiKhoanRepository.findByLoaiTk();
    }



    // cap nhat loaitk kiểu int theo id
    @PutMapping ("/taikhoan/{id}/{loaitk}")
    public Taikhoan updateLoaiTk(@PathVariable Integer id, @PathVariable Integer loaitk){
        Taikhoan taikhoan = taiKhoanRepository.findById(id).orElse(null);
        if (taikhoan == null) {
            return null;
        }
        taikhoan.setLoaitk(loaitk);
        return taiKhoanRepository.save(taikhoan);
    }

    //@PostMapping("/truyen")
    //    public Truyen addTruyen(@RequestBody Truyen truyen) {
    //        return repo.save(truyen);
    //    }
    @PostMapping("/taikhoan")
    public Taikhoan addTaiKhoan(@RequestBody Taikhoan taikhoan) {
        return taiKhoanRepository.save(taikhoan);
    }

    //@PutMapping("/truyen/{id}")
    //    public Truyen updateTruyen(@RequestBody Truyen truyen, @PathVariable Integer id) {
    //        Truyen truyen1 = repo.findById(id).orElse(null);
    //        truyen1.setTentruyen(truyen.getTentruyen());
    //        truyen1.setTacgia(truyen.getTacgia());
    //        truyen1.setMota(truyen.getMota());
    //        truyen1.setTheloai(truyen.getTheloai());
    //        truyen1.setLinkanh(truyen.getLinkanh());
    //        truyen1.setKey_search(truyen.getKey_search());
    //        return repo.save(truyen1);
    //    }
    @PutMapping("/taikhoan/{id}")
    public Taikhoan updateTaiKhoan(@RequestBody Taikhoan taikhoan, @PathVariable Integer id) {
        Taikhoan taikhoan1 = taiKhoanRepository.findById(id).orElse(null);
        if (taikhoan1 == null) {
            return null;
        }
        taikhoan1.setHoten(taikhoan.getHoten());
        taikhoan1.setDienthoai(taikhoan.getDienthoai());
        //taikhoan1.setEmail(taikhoan.getEmail());
        //taikhoan1.setMatkhau(taikhoan.getMatkhau());
        //taikhoan1.setLoaitk(taikhoan.getLoaitk());
        return taiKhoanRepository.save(taikhoan1);
    }

}
