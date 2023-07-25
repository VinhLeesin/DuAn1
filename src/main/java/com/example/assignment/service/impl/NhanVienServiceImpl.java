package com.example.assignment.service.impl;

import com.example.assignment.entity.NhanVien;
import com.example.assignment.repository.NhanVienRepository;
import com.example.assignment.service.BehaviorService;

import java.util.List;
import java.util.UUID;

public class NhanVienServiceImpl implements BehaviorService<NhanVien> {
    private NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    public List<NhanVien> getList() {
        return nhanVienRepository.getListnhanVien();
    }

    @Override
    public NhanVien getByID(UUID id) {
        return nhanVienRepository.getNhanVienById(id);
    }

    @Override
    public Boolean save(NhanVien e) {
        return nhanVienRepository.addNhanVien(e);
    }

    @Override
    public Boolean update(NhanVien e) {
        return nhanVienRepository.updateNhanVien(e);
    }

    @Override
    public Boolean delete(NhanVien e) {
        return nhanVienRepository.deleteNhanVien(e);
    }

    @Override
    public List<NhanVien> findByName(String name) {
        return nhanVienRepository.getNhanVienByName(name);
    }

    @Override
    public String CheckForm(NhanVien e) {

        return null;
    }

}
