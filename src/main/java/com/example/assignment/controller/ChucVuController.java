package com.example.assignment.controller;

import com.example.assignment.entity.ChucVu;
import com.example.assignment.service.BehaviorService;
import com.example.assignment.service.impl.ChucVuServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChucVuController", value = {
        "/chuc-vu/hien-thi",
        "/chuc-vu/search",
        "/chuc-vu/remote",
        "/chuc-vu/detail",
        "/chuc-vu/view-update",
        "/chuc-vu/add",
        "/chuc-vu/update",
        "/chuc-vu/view-add"
})

public class ChucVuController extends HttpServlet {
    private BehaviorService<ChucVu> chucVuService = new ChucVuServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            this.hienThiChucVu(request, response);
        } else if (url.contains("search")) {
            this.searchChucVu(request, response);
        } else if (url.contains("remote")) {
            this.remoteChucVu(request, response);
        } else if (url.contains("detail")) {
            this.detailChucVu(request, response);
        } else if (url.contains("view-update")) {
            this.viewUpdateChucVu(request, response);
        } else if (url.contains("view-add")) {
            this.viewAddChucVu(request, response);
        } else {
            this.hienThiChucVu(request, response);
        }
    }

    private void viewAddChucVu(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/view/chucVu/add.jsp").forward(request, response);
    }

    private void searchChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        List<ChucVu> cv = chucVuService.findByName(name);
        request.setAttribute("list", cv);
        request.getRequestDispatcher("/view/chucVu/home.jsp").forward(request, response);
    }

    private void remoteChucVu(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        ChucVu cv = chucVuService.getByID(UUID.fromString(id));
        chucVuService.delete(cv);
        response.sendRedirect("/chuc-vu/hien-thi");
    }

    private void detailChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChucVu cv = chucVuService.getByID(UUID.fromString(id));
        request.setAttribute("chucVu", cv);
        request.getRequestDispatcher("/view/chucVu/detail.jsp").forward(request, response);
    }

    private void viewUpdateChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChucVu cv = chucVuService.getByID(UUID.fromString(id));
        request.setAttribute("chucVu", cv);
        request.getRequestDispatcher("/view/chucVu/update.jsp").forward(request, response);
    }

    public void hienThiChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChucVu> list = chucVuService.getList();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/chucVu/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            this.addChucVu(request, response);
        } else {
            this.updateChucVu(request, response);
        }
    }

    private void updateChucVu(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String maCV = request.getParameter("maCV");
        String tenCV = request.getParameter("tenCV");

        ChucVu cv = new ChucVu(UUID.fromString(id), maCV, tenCV);
        chucVuService.update(cv);
        response.sendRedirect("/chuc-vu/hien-thi");
    }

    private void addChucVu(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String maCV = request.getParameter("maCV");
        String tenCV = request.getParameter("tenCV");

        ChucVu cv = ChucVu.builder()
                .maCV(maCV)
                .tenCV(tenCV)
                .build();

        session.setAttribute("maCV", maCV);
        session.setAttribute("tenCV", tenCV);
        String mess = chucVuService.CheckForm(cv);
        if (mess != null) {
            session.setAttribute("mess", mess);
            response.sendRedirect("/chuc-vu/view-add");
        } else {
            session.invalidate();
            chucVuService.save(cv);
            response.sendRedirect("/chuc-vu/hien-thi");
        }
    }

}
