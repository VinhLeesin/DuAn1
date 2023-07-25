package com.example.assignment.controller;

import com.example.assignment.entity.ChucVu;
import com.example.assignment.entity.CuaHang;
import com.example.assignment.entity.NhanVien;
import com.example.assignment.service.BehaviorService;
import com.example.assignment.service.impl.ChucVuServiceImpl;
import com.example.assignment.service.impl.CuaHangServiceImpl;
import com.example.assignment.service.impl.NhanVienServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NhanVienController", value = {
        "/nhan-vien/hien-thi",
        "/nhan-vien/search",
        "/nhan-vien/remote",
        "/nhan-vien/view-update",
        "/nhan-vien/add",
        "/nhan-vien/update",
})
public class NhanVienController extends HttpServlet {
    private BehaviorService<NhanVien> nhanVienService = new NhanVienServiceImpl();

    private BehaviorService<CuaHang> cuaHangService = new CuaHangServiceImpl();

    private BehaviorService<ChucVu> chucVuService = new ChucVuServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            this.hienThiNhanVien(request, response);
        } else if (url.contains("search")) {
            this.searchNhanVien(request, response);
        } else if (url.contains("remote")) {
            this.remoteNhanVien(request, response);
        } else if (url.contains("view-update")) {
            this.viewUpdateNhanVien(request, response);
        } else {
            this.hienThiNhanVien(request, response);
        }
    }

    private void searchNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        List<NhanVien> nv = nhanVienService.findByName(name);
        request.setAttribute("list", nv);
        request.getRequestDispatcher("/view/nhanVien/home.jsp").forward(request, response);
    }

    private void remoteNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        NhanVien nv = nhanVienService.getByID(UUID.fromString(id));
        nhanVienService.delete(nv);
        response.sendRedirect("/nhan-vien/hien-thi");
    }

    private void viewUpdateNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhanVien nv = nhanVienService.getByID(UUID.fromString(id));
        request.setAttribute("nhanVien", nv);
        List<CuaHang> ch = cuaHangService.getList();
        request.setAttribute("cuaHang", ch);

        request.getRequestDispatcher("/view/nhanVien/update.jsp").forward(request, response);
    }

    public void hienThiNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NhanVien> list = nhanVienService.getList();
        request.setAttribute("list", list);
        List<ChucVu> cv = chucVuService.getList();
        request.setAttribute("chucVu", cv);
        request.getRequestDispatcher("/view/nhanVien/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            this.addNhanVien(request, response);
        } else {
            this.updateNhanVien(request, response);
        }
    }

    private void updateNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String idCH = request.getParameter("tenCH");
        String idCV = request.getParameter("tenCV");
        String maNV = request.getParameter("maNV");
        String tenNV = request.getParameter("tenNV");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");

        CuaHang ch = cuaHangService.getByID(UUID.fromString(idCH));
        ChucVu cv = chucVuService.getByID(UUID.fromString(idCV));

    }

    private void addNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String idCH = request.getParameter("tenCH");
        String idCV = request.getParameter("tenCV");
        String maNV = request.getParameter("maNV");
        String tenNV = request.getParameter("tenNV");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");

        CuaHang ch = cuaHangService.getByID(UUID.fromString(idCH));
        ChucVu cv = chucVuService.getByID(UUID.fromString(idCV));
        session.setAttribute("maNV", maNV);
        session.setAttribute("tenNV", tenNV);
        session.setAttribute("ngaySinh", ngaySinh);
        session.setAttribute("sdt", sdt);
        session.setAttribute("diaChi", diaChi);

    }

}
