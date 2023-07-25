package com.example.assignment.service.impl;

import com.example.assignment.entity.SanPham;
import com.example.assignment.repository.SanPhamRepository;
import com.example.assignment.service.BehaviorService;

import java.util.List;
import java.util.UUID;

public class SanPhamServiceImpl implements BehaviorService<SanPham> {
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public List<SanPham> getList() {
        return sanPhamRepository.getList();
    }

    @Override
    public SanPham getByID(UUID id) {
        return sanPhamRepository.getById(id);
    }

    @Override
    public Boolean save(SanPham e) {
        return sanPhamRepository.add(e);
    }

    @Override
    public Boolean update(SanPham e) {
        return sanPhamRepository.update(e);
    }

    @Override
    public Boolean delete(SanPham e) {
        return sanPhamRepository.delete(e);
    }

    @Override
    public List<SanPham> findByName(String name) {
        return sanPhamRepository.getByName(name);
    }

    @Override
    public String CheckForm(SanPham e) {
        String mess = null;
        if (e.getMaSp().isEmpty()) {
            mess = "Mời nhập mã sản phẩm";
        } else if (sanPhamRepository.getSanPhamByMa(e.getMaSp()) != null) {
            mess = "Mã sản phẩm đã tồn tại";
        } else if (e.getTenSp().isEmpty()) {
            mess = "Mời nhập tên sản Phẩm";
        }
        return mess;
    }
}
