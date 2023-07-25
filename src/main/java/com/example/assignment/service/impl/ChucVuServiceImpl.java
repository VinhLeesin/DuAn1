package com.example.assignment.service.impl;

import com.example.assignment.entity.ChucVu;
import com.example.assignment.repository.ChucVuRepository;
import com.example.assignment.service.BehaviorService;

import java.util.List;
import java.util.UUID;

public class ChucVuServiceImpl implements BehaviorService<ChucVu> {
    private ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    public List<ChucVu> getList() {
        return chucVuRepository.getListChucVu();
    }

    @Override
    public ChucVu getByID(UUID id) {
        return chucVuRepository.getChucVuByID(id);
    }

    @Override
    public Boolean save(ChucVu e) {
        return chucVuRepository.addChucVu(e);
    }

    @Override
    public Boolean update(ChucVu e) {
        return chucVuRepository.updateChucVu(e);
    }

    @Override
    public Boolean delete(ChucVu e) {
        return chucVuRepository.deleteChucVu(e);
    }

    @Override
    public List<ChucVu> findByName(String name) {
        return chucVuRepository.getChucVuByName(name);
    }

    @Override
    public String CheckForm(ChucVu e) {
        String mess = null;
        if (e.getMaCV().isEmpty()) {
            mess = "Mời nhập mã chức vụ";
        } else if (chucVuRepository.getChucVuByMa(e.getMaCV()) != null) {
            mess = "Mã chức vụ đã tồn tại";
        } else if (e.getTenCV().isEmpty()) {
            mess = "Mời nhập tên chức vụ";
        }
        return mess;
    }

}
