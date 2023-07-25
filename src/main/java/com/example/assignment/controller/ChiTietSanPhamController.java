package com.example.assignment.controller;

import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.entity.DongSanPham;
import com.example.assignment.entity.MauSac;
import com.example.assignment.entity.NhaSanXuat;
import com.example.assignment.entity.SanPham;
import com.example.assignment.service.BehaviorService;
import com.example.assignment.service.impl.ChiTietSanPhamServiceImpl;
import com.example.assignment.service.impl.DongSanPhamServiceImpl;
import com.example.assignment.service.impl.MauSacServiceImpl;
import com.example.assignment.service.impl.NhaSanXuatServiceImpl;
import com.example.assignment.service.impl.SanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChiTietSanPhamController", value = {
        "/chi-tiet-san-pham/hien-thi",
        "/chi-tiet-san-pham/remote",
        "/chi-tiet-san-pham/detail",
        "/chi-tiet-san-pham/view-update",
        "/chi-tiet-san-pham/add",
        "/chi-tiet-san-pham/update",
        "/chi-tiet-san-pham/view-add"
})
public class ChiTietSanPhamController extends HttpServlet {
    private BehaviorService<ChiTietSanPham> chiTietSPService = new ChiTietSanPhamServiceImpl();

    private BehaviorService<DongSanPham> dongSpService = new DongSanPhamServiceImpl();

    private BehaviorService<MauSac> mauSacService = new MauSacServiceImpl();

    private BehaviorService<NhaSanXuat> nhaSxService = new NhaSanXuatServiceImpl();

    private BehaviorService<SanPham> sanPhamService = new SanPhamServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            this.hienThiChiTietSanPham(request, response);
        } else if (url.contains("remote")) {
            this.remoteChiTietSanPham(request, response);
        } else if (url.contains("detail")) {
            this.detailChiTietSanPham(request, response);
        } else if (url.contains("view-update")) {
            this.viewUpdateChiTietSanPham(request, response);
        } else if (url.contains("view-add")) {
            this.viewAddChiTietSanPham(request, response);
        } else {
            this.hienThiChiTietSanPham(request, response);
        }
    }

    private void viewAddChiTietSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<SanPham> sp = sanPhamService.getList();
        request.setAttribute("sanPham", sp);
        List<MauSac> ms = mauSacService.getList();
        request.setAttribute("mauSac", ms);
        List<DongSanPham> dsp = dongSpService.getList();
        request.setAttribute("dongSP", dsp);
        List<NhaSanXuat> nsx = nhaSxService.getList();
        request.setAttribute("nhaSX", nsx);
        request.getRequestDispatcher("/view/chiTietSanPham/add.jsp").forward(request, response);
    }

    private void remoteChiTietSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        ChiTietSanPham ctsp = chiTietSPService.getByID(UUID.fromString(id));
        chiTietSPService.delete(ctsp);
        response.sendRedirect("/chi-tiet-san-pham/hien-thi");
    }

    private void detailChiTietSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChiTietSanPham ctsp = chiTietSPService.getByID(UUID.fromString(id));
        request.setAttribute("chiTietSP", ctsp);
        request.getRequestDispatcher("/view/chiTietSanPham/detail.jsp").forward(request, response);
    }

    private void viewUpdateChiTietSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChiTietSanPham ctsp = chiTietSPService.getByID(UUID.fromString(id));
        request.setAttribute("chiTietSP", ctsp);
        List<SanPham> sp = sanPhamService.getList();
        request.setAttribute("sanPham", sp);
        List<MauSac> ms = mauSacService.getList();
        request.setAttribute("mauSac", ms);
        List<DongSanPham> dsp = dongSpService.getList();
        request.setAttribute("dongSP", dsp);
        List<NhaSanXuat> nsx = nhaSxService.getList();
        request.setAttribute("nhaSX", nsx);
        request.getRequestDispatcher("/view/chiTietSanPham/update.jsp").forward(request, response);
    }

    public void hienThiChiTietSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChiTietSanPham> list = chiTietSPService.getList();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/chiTietSanPham/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            this.addChiTietSanPham(request, response);
        } else {
            this.updateChiTietSanPham(request, response);
        }
    }

    private void updateChiTietSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String idSP = request.getParameter("tenSp");
        String idMau = request.getParameter("tenMau");
        String idNSX = request.getParameter("tenNSX");
        String idDSP = request.getParameter("tenDSP");
        String namBH = request.getParameter("namBH");
        String soLuong = request.getParameter("soLuong");
        String giaNhap = request.getParameter("giaNhap");
        String giaBan = request.getParameter("giaBan");
        String moTa = request.getParameter("moTa");

        SanPham sp = sanPhamService.getByID(UUID.fromString(idSP));
        MauSac ms = mauSacService.getByID(UUID.fromString(idMau));
        NhaSanXuat nsx = nhaSxService.getByID(UUID.fromString(idNSX));
        DongSanPham dsp = dongSpService.getByID(UUID.fromString(idDSP));

        ChiTietSanPham ctsp = new ChiTietSanPham(UUID.fromString(id), sp, nsx, ms, dsp, Integer.valueOf(namBH), Integer.valueOf(soLuong), BigDecimal.valueOf(Long.parseLong(giaNhap)), BigDecimal.valueOf(Long.parseLong(giaBan)), moTa);
        chiTietSPService.update(ctsp);
        response.sendRedirect("/chi-tiet-san-pham/hien-thi");
    }

    private void addChiTietSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String idSP = request.getParameter("tenSp");
        String idMau = request.getParameter("tenMau");
        String idNSX = request.getParameter("tenNSX");
        String idDSP = request.getParameter("tenDSP");
        String namBH = request.getParameter("namBH");
        String soLuong = request.getParameter("soLuong");
        String giaNhap = request.getParameter("giaNhap");
        String giaBan = request.getParameter("giaBan");
        String moTa = request.getParameter("moTa");

        SanPham sp = sanPhamService.getByID(UUID.fromString(idSP));
        MauSac ms = mauSacService.getByID(UUID.fromString(idMau));
        NhaSanXuat nsx = nhaSxService.getByID(UUID.fromString(idNSX));
        DongSanPham dsp = dongSpService.getByID(UUID.fromString(idDSP));

        session.setAttribute("namBH", namBH);
        session.setAttribute("soLuong", soLuong);
        session.setAttribute("giaNhap", giaNhap);
        session.setAttribute("giaBan", giaBan);
        session.setAttribute("moTa", moTa);

        ChiTietSanPham ctsp = ChiTietSanPham.builder()
                .sanPham(sp)
                .mauSac(ms)
                .nhaSX(nsx)
                .dongSP(dsp)
                .namBH(Integer.valueOf(namBH))
                .soLuongTon(Integer.valueOf(soLuong))
                .giaNhap(BigDecimal.valueOf(Long.parseLong(giaNhap)))
                .giaBan(BigDecimal.valueOf(Long.parseLong(giaBan)))
                .moTa(moTa)
                .build();
        String mess = chiTietSPService.CheckForm(ctsp);
        if (mess != null) {
            session.setAttribute("mess", mess);
            response.sendRedirect("/chi-tiet-san-pham/view-add");
        } else {
            session.invalidate();
            chiTietSPService.save(ctsp);
            response.sendRedirect("/chi-tiet-san-pham/hien-thi");
        }
    }

}
