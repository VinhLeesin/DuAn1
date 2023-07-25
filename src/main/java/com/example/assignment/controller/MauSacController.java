package com.example.assignment.controller;

import com.example.assignment.entity.MauSac;
import com.example.assignment.service.BehaviorService;
import com.example.assignment.service.impl.MauSacServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "MauSac", value = {
        "/mau-sac/hien-thi",
        "/mau-sac/search",
        "/mau-sac/remote",
        "/mau-sac/detail",
        "/mau-sac/view-update",
        "/mau-sac/add",
        "/mau-sac/update",
        "/mau-sac/view-add"
})
public class MauSacController extends HttpServlet {
    private BehaviorService<MauSac> mauSacService = new MauSacServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            this.hienThiMauSac(request, response);
        } else if (url.contains("search")) {
            this.searchMauSac(request, response);
        } else if (url.contains("remote")) {
            this.remoteMauSac(request, response);
        } else if (url.contains("detail")) {
            this.detailMauSac(request, response);
        } else if (url.contains("view-update")) {
            this.viewUpdateMauSac(request, response);
        } else if (url.contains("view-add")) {
            this.viewAddMauSac(request, response);
        } else {
            this.hienThiMauSac(request, response);
        }
    }

    private void viewAddMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/view/mauSac/add.jsp").forward(request, response);
    }

    private void searchMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        List<MauSac> ms = mauSacService.findByName(name);
        request.setAttribute("list", ms);
        request.getRequestDispatcher("/view/mauSac/home.jsp").forward(request, response);
    }

    private void remoteMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        MauSac ms = mauSacService.getByID(UUID.fromString(id));
        mauSacService.delete(ms);
        response.sendRedirect("/mau-sac/hien-thi");
    }

    private void detailMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        MauSac ms = mauSacService.getByID(UUID.fromString(id));
        request.setAttribute("mauSac", ms);
        request.getRequestDispatcher("/view/mauSac/detail.jsp").forward(request, response);
    }

    private void viewUpdateMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        MauSac ms = mauSacService.getByID(UUID.fromString(id));
        request.setAttribute("mauSac", ms);
        request.getRequestDispatcher("/view/mauSac/update.jsp").forward(request, response);
    }

    public void hienThiMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MauSac> list = mauSacService.getList();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/mauSac/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            this.addMauSac(request, response);
        } else {
            this.updateMauSac(request, response);
        }
    }

    private void updateMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String maMau = request.getParameter("maMau");
        String tenMau = request.getParameter("tenMau");

        MauSac ms = new MauSac(UUID.fromString(id), maMau, tenMau);
        mauSacService.update(ms);
        response.sendRedirect("/mau-sac/hien-thi");
    }

    private void addMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String maMau = request.getParameter("maMau");
        String tenMau = request.getParameter("tenMau");

        session.setAttribute("maMau",maMau);
        session.setAttribute("tenMau",tenMau);
        MauSac ms = MauSac.builder()
                .maMau(maMau)
                .tenMau(tenMau)
                .build();
        String mess = mauSacService.CheckForm(ms);
        if(mess != null){
            session.setAttribute("mess",mess);
            response.sendRedirect("/mau-sac/view-add");
        }else{
            session.invalidate();
            mauSacService.save(ms);
            response.sendRedirect("/mau-sac/hien-thi");
        }
    }

}
