package com.example.apidoctruyen.repository;
import com.example.apidoctruyen.entity.Noidungchapter;
import com.example.apidoctruyen.entity.Taikhoan;
import com.example.apidoctruyen.model.TaiKhoanDto;
import com.example.apidoctruyen.model.TruyenDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaiKhoanRepository extends JpaRepository<Taikhoan, Integer> {


    /*@Query("select NEW com.example.apidoctruyen.model.TaiKhoanDto(tk.id,tk.email,tk.hoten,tk.dienthoai,tk.diemthuong) from Taikhoan tk where tk.email = :email")
    TaiKhoanDto findByEmail(@Param("email") String email);*/
    @Query("select tk.id from Taikhoan tk where tk.email = :email")
    public int findIDTaiKhoanByEmail( String email);
    @Query("select NEW com.example.apidoctruyen.model.TaiKhoanDto(tk.id,tk.email,tk.matkhau,tk.hoten,tk.dienthoai,tk.diemthuong,tk.loaitk) from Taikhoan tk where tk.email = :email")
    public List<TaiKhoanDto> getByEmail(@Param("email") String email);

    @Query("select NEW com.example.apidoctruyen.model.TaiKhoanDto(tk.id,tk.email,tk.hoten,tk.dienthoai,tk.diemthuong) from Taikhoan tk where tk.email = :email")
    public Optional<TaiKhoanDto> findByEmail(@Param("email") String email);

    // select * from taikhoan where loaitk not in (1)
    @Query("select NEW com.example.apidoctruyen.model.TaiKhoanDto(tk.id,tk.email,tk.matkhau,tk.hoten,tk.dienthoai,tk.diemthuong,tk.loaitk) from Taikhoan tk where tk.loaitk not in (1)")
    public List<TaiKhoanDto> findByLoaiTk();

    //"select * from taikhoan where email=?

    //public Boolean insertNewTaiKhoan(String email,String matkhau,String ten, String dienthoai){
    //        SQLiteDatabase db = this.getWritableDatabase();
    //        ContentValues values = new ContentValues();
    //
    //        values.put("email", email);
    //        values.put("matkhau", matkhau);
    //        values.put("hoten",ten);
    //        values.put("dienthoai",dienthoai);
    //
    //        long result= db.insert("taikhoan",null,values);
    //        if(result==-1) return false;
    //        else
    //            return true;
    //    }
    @Query("insert into Taikhoan (email,matkhau,hoten,dienthoai) values (:email,:matkhau,:hoten,:dienthoai)")
    public Boolean insertNewTaiKhoan(@Param("email") String email,@Param("matkhau") String matkhau,@Param("hoten") String ten,@Param("dienthoai") String dienthoai);


}
