package com.example.assignment.controller;

import com.example.assignment.entity.CuaHang;
import com.example.assignment.service.BehaviorService;
import com.example.assignment.service.impl.CuaHangServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "CuaHangController", value = {
        "/cua-hang/hien-thi",
        "/cua-hang/search",
        "/cua-hang/remote",
        "/cua-hang/detail",
        "/cua-hang/view-update",
        "/cua-hang/add",
        "/cua-hang/update",
        "/cua-hang/view-add"
})
public class CuaHangController extends HttpServlet {
    private BehaviorService<CuaHang> cuaHangService = new CuaHangServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            this.hienThiCuaHang(request, response);
        } else if (url.contains("search")) {
            this.searchCuaHang(request, response);
        } else if (url.contains("remote")) {
            this.remoteCuaHang(request, response);
        } else if (url.contains("detail")) {
            this.detailCuaHang(request, response);
        } else if (url.contains("view-update")) {
            this.viewUpdateCuaHang(request, response);
        } else if (url.contains("view-add")) {
            this.viewAddCuaHang(request, response);
        } else {
            this.hienThiCuaHang(request, response);
        }
    }

    private void viewAddCuaHang(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/view/cuaHang/add.jsp").forward(request, response);
    }

    private void searchCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        List<CuaHang> cv = cuaHangService.findByName(name);
        request.setAttribute("list", cv);
        request.getRequestDispatcher("/view/cuaHang/home.jsp").forward(request, response);
    }

    private void remoteCuaHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        CuaHang ch = cuaHangService.getByID(UUID.fromString(id));
        cuaHangService.delete(ch);
        response.sendRedirect("/cua-hang/hien-thi");
    }

    private void detailCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CuaHang ch = cuaHangService.getByID(UUID.fromString(id));
        request.setAttribute("cuaHang", ch);
        request.getRequestDispatcher("/view/cuaHang/detail.jsp").forward(request, response);
    }

    private void viewUpdateCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CuaHang ch = cuaHangService.getByID(UUID.fromString(id));
        request.setAttribute("cuaHang", ch);
        request.getRequestDispatcher("/view/cuaHang/update.jsp").forward(request, response);
    }

    public void hienThiCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CuaHang> list = cuaHangService.getList();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/cuaHang/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            this.addCuaHang(request, response);
        } else {
            this.updateCuaHang(request, response);
        }
    }

    private void updateCuaHang(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String maCH = request.getParameter("maCH");
        String tenCH = request.getParameter("tenCH");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");

        CuaHang ch = new CuaHang(UUID.fromString(id), maCH, tenCH, diaChi, thanhPho, quocGia);
        cuaHangService.update(ch);
        response.sendRedirect("/cua-hang/hien-thi");
    }

    private void addCuaHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String maCH = request.getParameter("maCH");
        String tenCH = request.getParameter("tenCH");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");

        session.setAttribute("maCH", maCH);
        session.setAttribute("tenCH", tenCH);
        session.setAttribute("diaChi", diaChi);
        session.setAttribute("thanhPho", thanhPho);
        session.setAttribute("quocGia", quocGia);

        CuaHang ch = CuaHang.builder()
                .maCH(maCH)
                .tenCH(tenCH)
                .diaChi(diaChi)
                .thanhPho(thanhPho)
                .quocGia(quocGia)
                .build();
        String mess = cuaHangService.CheckForm(ch);
        if (mess != null) {
            session.setAttribute("mess", mess);
            response.sendRedirect("/cua-hang/view-add");
        } else {
            session.invalidate();
            cuaHangService.save(ch);
            response.sendRedirect("/cua-hang/hien-thi");
        }
    }

}
