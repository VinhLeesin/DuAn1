package com.example.assignment.controller;

import com.example.assignment.entity.SanPham;
import com.example.assignment.service.BehaviorService;
import com.example.assignment.service.impl.SanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "SanPhamController", value = {
        "/san-pham/hien-thi",
        "/san-pham/search",
        "/san-pham/remote",
        "/san-pham/detail",
        "/san-pham/view-update",
        "/san-pham/add",
        "/san-pham/update",
        "/san-pham/view-add"})

public class SanPhamController extends HttpServlet {
    private BehaviorService<SanPham> sanPhamService = new SanPhamServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            this.hienThiSanPham(request, response);
        } else if (url.contains("search")) {
            this.searchSanPham(request, response);
        } else if (url.contains("remote")) {
            this.remoteSanPham(request, response);
        } else if (url.contains("detail")) {
            this.detailSanPham(request, response);
        } else if (url.contains("view-update")) {
            this.viewUpdateSanPham(request, response);
        } else if (url.contains("view-add")) {
            this.viewAddSanPham(request, response);
        } else {
            this.hienThiSanPham(request, response);
        }
    }

    private void viewAddSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/view/sanPham/add.jsp").forward(request, response);
    }

    private void searchSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        List<SanPham> gv = sanPhamService.findByName(name);
        request.setAttribute("list", gv);
        request.getRequestDispatcher("/view/sanPham/home.jsp").forward(request, response);
    }

    private void remoteSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        SanPham sp = sanPhamService.getByID(UUID.fromString(id));
        sanPhamService.delete(sp);
        response.sendRedirect("/san-pham/hien-thi");
    }

    private void detailSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham sp = sanPhamService.getByID(UUID.fromString(id));
        request.setAttribute("sanPham", sp);
        request.getRequestDispatcher("/view/sanPham/detail.jsp").forward(request, response);
    }

    private void viewUpdateSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham sp = sanPhamService.getByID(UUID.fromString(id));
        request.setAttribute("sanPham", sp);
        request.getRequestDispatcher("/view/sanPham/update.jsp").forward(request, response);
    }

    public void hienThiSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SanPham> list = sanPhamService.getList();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/sanPham/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            this.addSanPham(request, response);
        } else {
            this.updateSanPham(request, response);
        }
    }

    private void updateSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String maSp = request.getParameter("maSp");
        String tenSp = request.getParameter("tenSp");

        SanPham sp = new SanPham(UUID.fromString(id), maSp, tenSp);
        sanPhamService.update(sp);
        response.sendRedirect("/san-pham/hien-thi");
    }

    private void addSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String maSp = request.getParameter("maSp");
        String tenSp = request.getParameter("tenSp");

        SanPham sp = SanPham.builder()
                .maSp(maSp)
                .tenSp(tenSp)
                .build();
        String mess = sanPhamService.CheckForm(sp);
        session.setAttribute("maSp", maSp);
        session.setAttribute("tenSp", tenSp);
        if (mess != null) {
            session.setAttribute("mess", mess);
            response.sendRedirect("/san-pham/view-add");
        } else {
            session.invalidate();
            sanPhamService.save(sp);
            response.sendRedirect("/san-pham/hien-thi");
        }
    }

}
