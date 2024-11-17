package com.example.apidoctruyen.repository;

import com.example.apidoctruyen.Controller.BinhLuanCuaToiController;
import com.example.apidoctruyen.entity.Binhluan;
import com.example.apidoctruyen.entity.Taikhoan;
import com.example.apidoctruyen.model.BinhLuanCuaToi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface BinhLuanCuaToiRepository extends JpaRepository<Binhluan, Integer> {

    @Query("select NEW com.example.apidoctruyen.model.BinhLuanCuaToi(tk.id,tk.idchapter.id,tk.idtaikhoan.id,tk.noidung,tk.ngaydang,tk.trangthai) from Binhluan tk where tk.idtaikhoan.id = :idtaikhoan")
    public List<BinhLuanCuaToi> findByIdn(@Param("idtaikhoan") Integer idtaikhoan);
}
