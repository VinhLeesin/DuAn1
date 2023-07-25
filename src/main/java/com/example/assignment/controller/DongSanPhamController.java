package com.example.assignment.controller;

import com.example.assignment.entity.DongSanPham;
import com.example.assignment.service.BehaviorService;
import com.example.assignment.service.impl.DongSanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "DongSanPhamController", value = {"/dong-san-pham/hien-thi", "/dong-san-pham/search", "/dong-san-pham/remote", "/dong-san-pham/detail", "/dong-san-pham/view-update", "/dong-san-pham/add", "/dong-san-pham/update", "/dong-san-pham/view-add"})
public class DongSanPhamController extends HttpServlet {
    private BehaviorService<DongSanPham> dongSpService = new DongSanPhamServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            this.hienThiDongSP(request, response);
        } else if (url.contains("search")) {
            this.searchDongSP(request, response);
        } else if (url.contains("remote")) {
            this.remoteDongSP(request, response);
        } else if (url.contains("detail")) {
            this.detailDongSP(request, response);
        } else if (url.contains("view-update")) {
            this.viewUpdateDongSP(request, response);
        } else if (url.contains("view-add")) {
            this.viewAddDongSP(request, response);
        } else {
            this.hienThiDongSP(request, response);
        }
    }

    private void viewAddDongSP(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/view/dongSanPham/add.jsp").forward(request, response);
    }

    private void searchDongSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        List<DongSanPham> dsp = dongSpService.findByName(name);
        request.setAttribute("list", dsp);
        request.getRequestDispatcher("/view/dongSanPham/home.jsp").forward(request, response);
    }

    private void remoteDongSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        DongSanPham dsp = dongSpService.getByID(UUID.fromString(id));
        dongSpService.delete(dsp);
        response.sendRedirect("/dong-san-pham/hien-thi");
    }

    private void detailDongSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        DongSanPham dsp = dongSpService.getByID(UUID.fromString(id));
        request.setAttribute("dongSP", dsp);
        request.getRequestDispatcher("/view/dongSanPham/detail.jsp").forward(request, response);
    }

    private void viewUpdateDongSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        DongSanPham dsp = dongSpService.getByID(UUID.fromString(id));
        request.setAttribute("dongSP", dsp);
        request.getRequestDispatcher("/view/dongSanPham/update.jsp").forward(request, response);
    }

    public void hienThiDongSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DongSanPham> dsp = dongSpService.getList();
        request.setAttribute("list", dsp);
        request.getRequestDispatcher("/view/dongSanPham/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            this.addDongSP(request, response);
        } else {
            this.updateDongSP(request, response);
        }
    }

    private void updateDongSP(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String maDSP = request.getParameter("maDSP");
        String tenDSP = request.getParameter("tenDSP");

        DongSanPham dsp = new DongSanPham(UUID.fromString(id), maDSP, tenDSP);
        dongSpService.update(dsp);
        response.sendRedirect("/dong-san-pham/hien-thi");
    }

    private void addDongSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String maDSP = request.getParameter("maDSP");
        String tenDSP = request.getParameter("tenDSP");

        session.setAttribute("maDSP", maDSP);
        session.setAttribute("tenDSP", tenDSP);
        DongSanPham dsp = DongSanPham.builder().maDSP(maDSP).tenDSP(tenDSP).build();
        String mess = dongSpService.CheckForm(dsp);
        if (mess != null) {
            session.setAttribute("mess", mess);
            response.sendRedirect("/dong-san-pham/view-add");
        } else {
            session.invalidate();
            dongSpService.save(dsp);
            response.sendRedirect("/dong-san-pham/hien-thi");
        }
    }

}
