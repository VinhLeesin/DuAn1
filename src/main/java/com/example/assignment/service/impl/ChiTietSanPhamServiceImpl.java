package com.example.assignment.service.impl;

import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.repository.ChiTietSanPhamRepository;
import com.example.assignment.service.BehaviorService;

import java.util.List;
import java.util.UUID;

public class ChiTietSanPhamServiceImpl implements BehaviorService<ChiTietSanPham> {
    private ChiTietSanPhamRepository chiTietSpRepository = new ChiTietSanPhamRepository();

    @Override
    public List<ChiTietSanPham> getList() {
        return chiTietSpRepository.getList();
    }

    @Override
    public ChiTietSanPham getByID(UUID id) {
        return chiTietSpRepository.getById(id);
    }

    @Override
    public Boolean save(ChiTietSanPham e) {
        return chiTietSpRepository.add(e);
    }

    @Override
    public Boolean update(ChiTietSanPham e) {
        return chiTietSpRepository.update(e);
    }

    @Override
    public Boolean delete(ChiTietSanPham e) {
        return chiTietSpRepository.delete(e);
    }

    @Override
    public List<ChiTietSanPham> findByName(String name) {
        return chiTietSpRepository.getByName(name);
    }

    @Override
    public String CheckForm(ChiTietSanPham e) {
        String mess = null;
        if (!String.valueOf(e.getNamBH()).matches("\\d{4}")) {
            mess = "Năm bảo hành không đúng định dạng";
        } else if (e.getSoLuongTon() < 0) {
            mess = "Số lượng tồn phải lớn hơn 0";
        } else if (e.getGiaNhap().intValue() <= 0) {
            mess = "Giá nhập phải lớn hơn 0";
        } else if (e.getGiaBan().intValue() <= 0) {
            mess = "Giá bán phải lớn hơn 0";
        } else if (e.getMoTa().isEmpty()) {
            mess = "Mời nhập mô tả";
        }
        return mess;
    }

}
