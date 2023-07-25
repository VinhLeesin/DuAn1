package com.example.assignment.service.impl;

import com.example.assignment.entity.CuaHang;
import com.example.assignment.repository.CuaHangRepository;
import com.example.assignment.service.BehaviorService;

import java.util.List;
import java.util.UUID;

public class CuaHangServiceImpl implements BehaviorService<CuaHang> {
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();

    @Override
    public List<CuaHang> getList() {
        return cuaHangRepository.getListCuaHang();
    }

    @Override
    public CuaHang getByID(UUID id) {
        return cuaHangRepository.getCuaHangByID(id);
    }

    @Override
    public Boolean save(CuaHang e) {
        return cuaHangRepository.addCuaHang(e);
    }

    @Override
    public Boolean update(CuaHang e) {
        return cuaHangRepository.updateCuaHang(e);
    }

    @Override
    public Boolean delete(CuaHang e) {
        return cuaHangRepository.deleteCuaHang(e);
    }

    @Override
    public List<CuaHang> findByName(String name) {
        return cuaHangRepository.getCuaHangByName(name);
    }

    @Override
    public String CheckForm(CuaHang e) {
        String mess = null;
        if (e.getMaCH().isEmpty()) {
            mess = "Mời nhập mã cửa hàng";
        } else if (cuaHangRepository.getCuaHangByMa(e.getMaCH()) != null) {
            mess = "Mã cửa hàng đã tồn tại";
        } else if (e.getTenCH().isEmpty()) {
            mess = "Mời nhập tên cửa hàng";
        } else if (e.getDiaChi().isEmpty()) {
            mess = "Mời nhập địa chỉ";
        } else if (e.getThanhPho().isEmpty()) {
            mess = "Mời nhập thành phố";
        } else if (e.getQuocGia().isEmpty()) {
            mess = "Mời nhập quốc gia";
        }
        return mess;
    }

}
