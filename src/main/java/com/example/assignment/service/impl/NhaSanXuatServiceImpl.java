package com.example.assignment.service.impl;

import com.example.assignment.entity.NhaSanXuat;
import com.example.assignment.repository.NhaSanXuatRepository;
import com.example.assignment.service.BehaviorService;

import java.util.List;
import java.util.UUID;

public class NhaSanXuatServiceImpl implements BehaviorService<NhaSanXuat> {
    private NhaSanXuatRepository nhaSxRepository = new NhaSanXuatRepository();

    @Override
    public List<NhaSanXuat> getList() {
        return nhaSxRepository.getList();
    }

    @Override
    public NhaSanXuat getByID(UUID id) {
        return nhaSxRepository.getById(id);
    }

    @Override
    public Boolean save(NhaSanXuat e) {
        return nhaSxRepository.add(e);
    }

    @Override
    public Boolean update(NhaSanXuat e) {
        return nhaSxRepository.update(e);
    }

    @Override
    public Boolean delete(NhaSanXuat e) {
        return nhaSxRepository.delete(e);
    }

    @Override
    public List<NhaSanXuat> findByName(String name) {
        return nhaSxRepository.getByName(name);
    }

    @Override
    public String CheckForm(NhaSanXuat e) {
        String mess = null;
        if (e.getMaNSX().isEmpty()) {
            mess = "Mời nhập mã nhà sản xuất";
        } else if (nhaSxRepository.getNhaSxByMa(e.getMaNSX()) != null) {
            mess = "Mã nhà sản xuất đã tồn tại";
        } else if (e.getTenNSX().isEmpty()) {
            mess = "Mời nhập tên nhà sản xuất";
        }
        return mess;
    }

}
