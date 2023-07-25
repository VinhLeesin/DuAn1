package com.example.assignment.controller;

import com.example.assignment.entity.KhachHang;
import com.example.assignment.service.BehaviorService;
import com.example.assignment.service.impl.KhachHangServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "KhachHangController", value = {
        "/khach-hang/hien-thi",
        "/khach-hang/search",
        "/khach-hang/remote",
        "/khach-hang/detail",
        "/khach-hang/view-update",
        "/khach-hang/add",
        "/khach-hang/update",
        "/khach-hang/view-add"
})
public class KhachHangController extends HttpServlet {
    private BehaviorService<KhachHang> khachHangService = new KhachHangServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            this.hienThiKhachHang(request, response);
        } else if (url.contains("search")) {
            this.searchKhachHang(request, response);
        } else if (url.contains("remote")) {
            this.remoteKhachHang(request, response);
        } else if (url.contains("detail")) {
            this.detailKhachHang(request, response);
        } else if (url.contains("view-update")) {
            this.viewUpdateKhachHang(request, response);
        } else if (url.contains("view-add")) {
            this.viewAddKhachHang(request, response);
        } else {
            this.hienThiKhachHang(request, response);
        }
    }

    private void viewAddKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/view/khachHang/add.jsp").forward(request, response);
    }

    private void searchKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        List<KhachHang> kh = khachHangService.findByName(name);
        request.setAttribute("list", kh);
        request.getRequestDispatcher("/view/khachHang/home.jsp").forward(request, response);
    }

    private void remoteKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        KhachHang kh = khachHangService.getByID(UUID.fromString(id));
        khachHangService.delete(kh);
        response.sendRedirect("/khach-hang/hien-thi");
    }

    private void detailKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        KhachHang kh = khachHangService.getByID(UUID.fromString(id));
        request.setAttribute("khachHang", kh);
        request.getRequestDispatcher("/view/khachHang/detail.jsp").forward(request, response);
    }

    private void viewUpdateKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        KhachHang kh = khachHangService.getByID(UUID.fromString(id));
        request.setAttribute("khachHang", kh);
        request.getRequestDispatcher("/view/khachHang/update.jsp").forward(request, response);
    }

    public void hienThiKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<KhachHang> list = khachHangService.getList();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/khachHang/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            this.addKhachHang(request, response);
        } else {
            this.updateKhachHang(request, response);
        }
    }

    private void updateKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String maKH = request.getParameter("maKH");
        String tenKH = request.getParameter("tenKH");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");

        KhachHang kh = new KhachHang(UUID.fromString(id), maKH, tenKH, ngaySinh, sdt, diaChi, thanhPho, quocGia);
        khachHangService.update(kh);
        response.sendRedirect("/khach-hang/hien-thi");
    }

    private void addKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String maKH = request.getParameter("maKH");
        String tenKH = request.getParameter("tenKH");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");

        session.setAttribute("maKH", maKH);
        session.setAttribute("tenKH", tenKH);
        session.setAttribute("ngaySinh", ngaySinh);
        session.setAttribute("sdt", sdt);
        session.setAttribute("diaChi", diaChi);
        session.setAttribute("thanhPho", thanhPho);
        session.setAttribute("quocGia", quocGia);

        KhachHang kh = KhachHang.builder()
                .maKH(maKH)
                .tenKH(tenKH)
                .ngaySinh(ngaySinh)
                .sdt(sdt)
                .diaChi(diaChi)
                .thanhPho(thanhPho)
                .quocGia(quocGia)
                .build();
        String mess = khachHangService.CheckForm(kh);
        if (mess != null) {
            session.setAttribute("mess", mess);
            response.sendRedirect("/khach-hang/view-add");
        } else {
            session.invalidate();
            khachHangService.save(kh);
            response.sendRedirect("/khach-hang/hien-thi");
        }
    }

}
