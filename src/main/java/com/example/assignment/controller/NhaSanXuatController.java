package com.example.assignment.controller;

import com.example.assignment.entity.NhaSanXuat;
import com.example.assignment.service.BehaviorService;
import com.example.assignment.service.impl.NhaSanXuatServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NhaSanXuatController", value = {
        "/nha-san-xuat/hien-thi",
        "/nha-san-xuat/search",
        "/nha-san-xuat/remote",
        "/nha-san-xuat/detail",
        "/nha-san-xuat/view-update",
        "/nha-san-xuat/add",
        "/nha-san-xuat/update",
        "/nha-san-xuat/view-add"
})
public class NhaSanXuatController extends HttpServlet {
    private BehaviorService<NhaSanXuat> nhaSxService = new NhaSanXuatServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            this.hienThiNhaSx(request, response);
        } else if (url.contains("search")) {
            this.searchNhaSx(request, response);
        } else if (url.contains("remote")) {
            this.remoteNhaSx(request, response);
        } else if (url.contains("detail")) {
            this.detailNhaSx(request, response);
        } else if (url.contains("view-update")) {
            this.viewUpdateNhaSx(request, response);
        } else if (url.contains("view-add")) {
            this.viewAddNhaSx(request, response);
        } else {
            this.hienThiNhaSx(request, response);
        }
    }

    private void viewAddNhaSx(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/view/nhaSanXuat/add.jsp").forward(request, response);
    }

    private void searchNhaSx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        List<NhaSanXuat> nhaSX = nhaSxService.findByName(name);
        request.setAttribute("list", nhaSX);
        request.getRequestDispatcher("/view/nhaSanXuat/home.jsp").forward(request, response);
    }

    private void remoteNhaSx(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        NhaSanXuat nhaSX = nhaSxService.getByID(UUID.fromString(id));
        nhaSxService.delete(nhaSX);
        response.sendRedirect("/nha-san-xuat/hien-thi");
    }

    private void detailNhaSx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhaSanXuat nhaSX = nhaSxService.getByID(UUID.fromString(id));
        request.setAttribute("nhaSX", nhaSX);
        request.getRequestDispatcher("/view/nhaSanXuat/detail.jsp").forward(request, response);
    }

    private void viewUpdateNhaSx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhaSanXuat nhaSX = nhaSxService.getByID(UUID.fromString(id));
        request.setAttribute("nhaSX", nhaSX);
        request.getRequestDispatcher("/view/nhaSanXuat/update.jsp").forward(request, response);
    }

    public void hienThiNhaSx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NhaSanXuat> list = nhaSxService.getList();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/nhaSanXuat/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            this.addNhaSx(request, response);
        } else {
            this.updateNhaSx(request, response);
        }
    }

    private void updateNhaSx(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String maNSX = request.getParameter("maNSX");
        String tenNSX = request.getParameter("tenNSX");

        NhaSanXuat nhaSX = new NhaSanXuat(UUID.fromString(id), maNSX, tenNSX);
        nhaSxService.update(nhaSX);
        response.sendRedirect("/nha-san-xuat/hien-thi");
    }

    private void addNhaSx(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String maNSX = request.getParameter("maNSX");
        String tenNSX = request.getParameter("tenNSX");

        session.setAttribute("maNSX", maNSX);
        session.setAttribute("tenNSX", tenNSX);

        NhaSanXuat nhaSX = NhaSanXuat.builder()
                .maNSX(maNSX)
                .tenNSX(tenNSX)
                .build();
        String mess = nhaSxService.CheckForm(nhaSX);
        if (mess != null) {
            session.setAttribute("mess", mess);
            response.sendRedirect("/nha-san-xuat/view-add");
        } else {
            session.invalidate();
            nhaSxService.save(nhaSX);
            response.sendRedirect("/nha-san-xuat/hien-thi");
        }
    }

}
