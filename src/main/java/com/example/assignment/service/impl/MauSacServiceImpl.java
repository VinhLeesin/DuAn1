package com.example.assignment.service.impl;

import com.example.assignment.entity.MauSac;
import com.example.assignment.repository.MauSacRepository;
import com.example.assignment.service.BehaviorService;

import java.util.List;
import java.util.UUID;

public class MauSacServiceImpl implements BehaviorService<MauSac> {
    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    public List<MauSac> getList() {
        return mauSacRepository.getListMauSac();
    }

    @Override
    public MauSac getByID(UUID id) {
        return mauSacRepository.getMauSacById(id);
    }

    @Override
    public Boolean save(MauSac e) {
        return mauSacRepository.addMauSac(e);
    }

    @Override
    public Boolean update(MauSac e) {
        return mauSacRepository.updateMauSac(e);
    }

    @Override
    public Boolean delete(MauSac e) {
        return mauSacRepository.deleteMauSac(e);
    }

    @Override
    public List<MauSac> findByName(String name) {
        return mauSacRepository.getMauSacByName(name);
    }

    @Override
    public String CheckForm(MauSac e) {
        String mess = null;
        if (e.getMaMau().isEmpty()) {
            mess = "Mời nhập mã màu sắc";
        } else if (mauSacRepository.getMauSacByMa(e.getMaMau()) != null) {
            mess = "Mã màu sắc đã tồn tại";
        } else if (e.getTenMau().isEmpty()) {
            mess = "Mời nhập tên màu sắc";
        }
        return mess;
    }

}
