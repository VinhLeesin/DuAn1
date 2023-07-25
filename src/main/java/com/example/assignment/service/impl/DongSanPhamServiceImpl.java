package com.example.assignment.service.impl;

import com.example.assignment.entity.DongSanPham;
import com.example.assignment.repository.DongSanPhamRepository;
import com.example.assignment.service.BehaviorService;

import java.util.List;
import java.util.UUID;

public class DongSanPhamServiceImpl implements BehaviorService<DongSanPham> {
    private DongSanPhamRepository dongSpRepository = new DongSanPhamRepository();

    @Override
    public List<DongSanPham> getList() {
        return dongSpRepository.getListDongSP();
    }

    @Override
    public DongSanPham getByID(UUID id) {
        return dongSpRepository.getDongSpById(id);
    }

    @Override
    public Boolean save(DongSanPham e) {
        return dongSpRepository.addDongSP(e);
    }

    @Override
    public Boolean update(DongSanPham e) {
        return dongSpRepository.updateDongSP(e);
    }

    @Override
    public Boolean delete(DongSanPham e) {
        return dongSpRepository.deleteDongSP(e);
    }

    @Override
    public List<DongSanPham> findByName(String name) {
        return dongSpRepository.getDongSpByName(name);
    }

    @Override
    public String CheckForm(DongSanPham e) {
        String mess = null;
        if (e.getMaDSP().isEmpty()) {
            mess = "Mời nhập mã dòng sản phẩm";
        } else if (dongSpRepository.getDongSpByMa(e.getMaDSP()) != null) {
            mess = "Mã dòng sản phẩm đã tồn tại";
        } else if (e.getTenDSP().isEmpty()) {
            mess = "Mời nhập tên dòng sản phẩm";
        }
        return mess;
    }

}
