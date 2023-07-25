<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container py-5">
    <form action="/khach-hang/update?id=${khachHang.id}" method="post">
        <div class="text-center row">
            <h3>Cập nhập thông tin khách hàng</h3>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="card-body p-5">
                    <div class="form-outline mb-4">
                        <label class="form-label">Mã Khách Hàng</label>
                        <input type="text" name="maKH" value="${khachHang.maKH}"
                               class="form-control form-control-lg">
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Ngày Sinh</label>
                        <input type="text" name="ngaySinh" value="${khachHang.ngaySinh}"
                               class="form-control form-control-lg">
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Địa Chỉ</label>
                        <input type="text" name="diaChi" value="${khachHang.diaChi}"
                               class="form-control form-control-lg">
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Quốc Gia</label>
                        <input type="text" name="quocGia" value="${khachHang.quocGia}"
                               class="form-control form-control-lg">
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="card-body p-5 ">
                    <div class="form-outline mb-4">
                        <label class="form-label">Tên Khách Hàng</label>
                        <input type="text" name="tenKH" value="${khachHang.tenKH}"
                               class="form-control form-control-lg">
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Số Điện Thoại</label>
                        <input type="text" name="sdt" value="${khachHang.sdt}"
                               class="form-control form-control-lg">
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Thành Phố</label>
                        <input type="text" name="thanhPho" value="${khachHang.thanhPho}"
                               class="form-control form-control-lg">
                    </div>
                </div>
            </div>
            <div class="d-flex justify-content-center">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Update</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
