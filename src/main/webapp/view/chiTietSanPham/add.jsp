<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<form action="/chi-tiet-san-pham/add" method="post">
    <div class="container py-5">
        <div class="text-center row">
            <h1>Thêm Chi Tiết Sản Phẩm </h1>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="p-5">
                    <h3 style="color: red">${sessionScope.mess}</h3>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="card-body p-5">
                    <div class="form-outline mb-4">
                        <label class="form-label">Tên Sản Phẩm</label>
                        <select class="form-control form-control-lg" name="tenSp">
                            <c:forEach items="${sanPham}" var="sp">
                                <option value="${sp.id}">${sp.tenSp}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label ">Tên Nhà Sản Xuất</label>
                        <select class="form-control form-control-lg" name="tenNSX">
                            <c:forEach items="${nhaSX}" var="nsx">
                                <option value="${nsx.id}">${nsx.tenNSX}</option>
                            </c:forEach>
                            </section>
                        </select>
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Năm Bảo Hành</label>
                        <input type="text" name="namBH" value="${sessionScope.namBH == null ? 0 : sessionScope.namBH}"
                               class="form-control form-control-lg">
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Số Lượng</label>
                        <input type="text" name="soLuong"
                               value="${sessionScope.soLuong == null ? 0 : sessionScope.soLuong}"
                               class="form-control form-control-lg">
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Mô Tả</label>
                        <input type="text" name="moTa" class="form-control form-control-lg">
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="card-body p-5 ">
                    <div class="form-outline mb-4">
                        <label class="form-label">Màu Sắc</label>
                        <select class="form-control form-control-lg" name="tenMau">
                            <c:forEach items="${mauSac}" var="ms">
                                <option value="${ms.id}">${ms.tenMau}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Dòng Sản Phẩm</label>
                        <select class="form-control form-control-lg" name="tenDSP">
                            <c:forEach items="${dongSP}" var="dsp">
                                <option value="${dsp.id}">${dsp.tenDSP}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Giá Nhập</label>
                        <input type="text" name="giaNhap"
                               value="${sessionScope.giaNhap == null ? 0 : sessionScope.giaNhap}"
                               class="form-control form-control-lg">
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Giá Bán</label>
                        <input type="text" name="giaBan"
                               value="${sessionScope.giaBan == null ? 0 : sessionScope.giaBan}"
                               class="form-control form-control-lg">
                    </div>
                </div>
            </div>
        </div>
        <div class="d-flex justify-content-center">
            <button class="btn btn-primary btn-lg btn-block" type="submit">Add</button>
        </div>
    </div>
</form>
</body>
</html>
