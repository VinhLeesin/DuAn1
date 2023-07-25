package com.example.assignment.service.impl;

import com.example.assignment.entity.KhachHang;
import com.example.assignment.repository.KhachHangRepository;
import com.example.assignment.service.BehaviorService;

import java.util.List;
import java.util.UUID;

public class KhachHangServiceImpl implements BehaviorService<KhachHang> {
    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    public List<KhachHang> getList() {
        return khachHangRepository.getListKhachHang();
    }

    @Override
    public KhachHang getByID(UUID id) {
        return khachHangRepository.getKhachHangByID(id);
    }

    @Override
    public Boolean save(KhachHang e) {
        return khachHangRepository.addKhachHang(e);
    }

    @Override
    public Boolean update(KhachHang e) {
        return khachHangRepository.updateKhachHang(e);
    }

    @Override
    public Boolean delete(KhachHang e) {
        return khachHangRepository.deleteKhachHang(e);
    }

    @Override
    public List<KhachHang> findByName(String name) {
        return khachHangRepository.getKhachHangByName(name);
    }

    @Override
    public String CheckForm(KhachHang e) {
        String mess = null;
        if (e.getMaKH().isEmpty()) {
            mess = "Mời nhập mã khách hàng";
        } else if (khachHangRepository.getKhachHangByMa(e.getMaKH()) != null) {
            mess = "Mã khách hàng đã tồn tại";
        } else if (e.getTenKH().isEmpty()) {
            mess = "Mời nhập tên khách hàng";
        } else if (!e.getTenKH().matches("[a-zA-Z]+")) {
            mess = "Tên khách hàng không đúng định dạng";
        } else if (e.getNgaySinh().isEmpty()) {
            mess = "Mời nhập ngày sinh khách hàng";
        } else if (!e.getNgaySinh().matches("\\d{4}[-|/]\\d{1,2}[-|/]\\d{1,2}")) {
            mess = "Ngày sinh khách hàng không đúng định dạng";
        } else if (e.getSdt().isEmpty()) {
            mess = "Mời nhập số điện thoại khách hàng";
        } else if (!e.getSdt().matches("[0-9]{10}")) {
            mess = "Số điện thoại khách hàng không đúng định dạng";
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
