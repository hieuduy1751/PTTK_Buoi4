package com.kttk.lab5.hangkhong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kttk.lab5.hangkhong.entities.NhanVien;
import com.kttk.lab5.hangkhong.services.NhanVienService;

@RestController
@RequestMapping("/api/v1/nhan-vien")
public class NhanVienController {
  @Autowired
  NhanVienService nhanVienService;

  @GetMapping("/tong-luong")
  public Long getTongLuong() {
    return nhanVienService.calculateTongLuong();
  }

  @GetMapping("/luong/{operator}/{luong}")
  public List<NhanVien> getNhanVienByLuong(@PathVariable(name = "operator") String operator, @PathVariable(name = "luong") Long luong) {
    return nhanVienService.findByLuong((luong), operator);
  }

  @GetMapping("/loai-may-bay/{loai}")
  public List<NhanVien> getNhanVienByLoaiMayBay(@PathVariable(name = "loai") String loai) {
    return nhanVienService.findByLoaiMayBay(loai);
  }
  
  @GetMapping("/ma-may-bay/{ma}")
  public List<NhanVien> getNhanVienByMaMayBay(@PathVariable(name = "ma") int ma) {
    return nhanVienService.findByMaMayBay(ma);
  }
}
