package com.example.apidoctruyen.Controller;

import com.example.apidoctruyen.model.LichsudoctruyenModel;
import com.example.apidoctruyen.repository.lichsudoctruyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/tusach")
public class tusachController {

    @Autowired
    lichsudoctruyenRepository repo;


    @GetMapping("/lichsu/{idtaikhoan}")
    public List<LichsudoctruyenModel> getListTruyenDaDoc(@PathVariable int idtaikhoan) {
        return repo.getListTruyenDaDoc(idtaikhoan);
    }

}
