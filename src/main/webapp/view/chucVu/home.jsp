<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="container">
<nav class="navbar navbar-expand-sm bg-light navbar-light">
    <div class="hide-for-medium ">
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link text-dark" href="/nhan-vien/hien-thi">Nhân viên</a></li>
            <li class="nav-item"><a class="nav-link text-dark" href="/khach-hang/hien-thi">Khách hàng</a></li>
            <li class="nav-item"><a class="nav-link text-dark" href="/chuc-vu/hien-thi">Chức vụ</a></li>
            <li class="nav-item"><a class="nav-link text-dark" href="/cua-hang/hien-thi">Cửa hàng</a></li>
            <li class="nav-item"><a class="nav-link text-dark" href="/chi-tiet-san-pham/hien-thi">Chi tiết sản
                phẩm</a></li>
            <li class="nav-item"><a class="nav-link text-dark" href="/san-pham/hien-thi">Sản phẩm</a></li>
            <li class="nav-item"><a class="nav-link text-dark" href="/nha-san-xuat/hien-thi">Nhà sản xuất</a></li>
            <li class="nav-item"><a class="nav-link text-dark" href="/dong-san-pham/hien-thi">Dòng sản phẩm</a></li>
            <li class="nav-item"><a class="nav-link text-dark" href="/mau-sac/hien-thi">Màu sắc</a></li>

        </ul>
    </div>
    <div class="form-inline" style="margin-top: 20px; margin-left: 100px;">
        <form action="/chuc-vu/search" method="get">
            <input type="text" class="searchTerm" name="search" placeholder="Tìm kiếm...">
            <button type="submit">Search</button>
        </form>
    </div>
</nav>
<div class="gap-element clearfix" style="display:block; height:auto; padding-top:30px"></div>
<div class="d-flex justify-content-center">
    <h1>Danh Sách Chức Vụ</h1>
</div>
<div class="gap-element clearfix" style="display:block; height:auto; padding-top:30px"></div>
<button type="submit"><a href="/chuc-vu/view-add">Thêm chức vụ</a></button>
<div class="gap-element clearfix" style="display:block; height:auto; padding-top:50px"></div>
<table class="table table-striped">
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="cv" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${cv.maCV}</td>
            <td>${cv.tenCV}</td>
            <td>
                <button><a href="/chuc-vu/detail?id=${cv.id}">Detail</a></button>
                <button><a href="/chuc-vu/view-update?id=${cv.id}">Edit</a></button>
                <button onclick="return confirm('Bạn chắc chắn muốn xóa')"><a
                        href="/chuc-vu/remote?id=${cv.id}">Remove</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<footer class="container" style="position: fixed; bottom: 0;">
    <div class="text-center text-white">
        <section class="mb-4">
            <a class="btn text-white btn-floating m-1" style="background-color: #3b5998;" href="#!"
               role="button"><i class="bi bi-facebook"></i></a>
            <a class="btn text-white btn-floating m-1" style="background-color: #55acee;" href="#!"
               role="button"><i class="bi bi-twitter"></i></a>
            <a class="btn text-white btn-floating m-1" style="background-color: #dd4b39;" href="#!"
               role="button"><i class="bi bi-google"></i></a>
            <a class="btn text-white btn-floating m-1" style="background-color: #ac2bac;" href="#!"
               role="button"><i class="bi bi-instagram"></i></a>
            <a class="btn text-white btn-floating m-1" style="background-color: #0082ca;" href="#!"
               role="button"><i class="bi bi-linkedin"></i></a>
            <a class="btn text-white btn-floating m-1" style="background-color: #333333;" href="#!"
               role="button"><i class="bi bi-github"></i></a>
        </section>
    </div>
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
        Vinhnt-PH19977
    </div>
</footer>
</body>
</html>
