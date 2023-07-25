<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<form action="/khach-hang/add" method="post">
    <div class="container py-5">
        <div class="text-center row">
            <h1>Thêm Khách Hàng</h1>
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
                        <label class="form-label">Mã Khách Hàng</label>
                        <input type="text" name="maKH" value="${sessionScope.maKH}"
                               class="form-control form-control-lg">
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Ngày Sinh</label>
                        <input type="text" name="ngaySinh" value="${sessionScope.ngaySinh}"
                               class="form-control form-control-lg">
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Địa Chỉ</label>
                        <input type="text" name="diaChi" value="${sessionScope.diaChi}"
                               class="form-control form-control-lg">
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Quốc Gia</label>
                        <input type="text" name="quocGia" value="${sessionScope.quocGia}"
                               class="form-control form-control-lg">
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="card-body p-5 ">
                    <div class="form-outline mb-4">
                        <label class="form-label">Tên Khách Hàng</label>
                        <input type="text" name="tenKH" value="${sessionScope.tenKH}"
                               class="form-control form-control-lg">
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Số Điện Thoại</label>
                        <input type="text" name="sdt" value="${sessionScope.sdt}" class="form-control form-control-lg">
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Thành Phố</label>
                        <input type="text" name="thanhPho" value="${sessionScope.thanhPho}"
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
