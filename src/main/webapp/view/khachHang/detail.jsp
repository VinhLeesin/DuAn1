<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container py-5">
    <div class="text-center row">
        <h3>Thông tin khách hàng</h3>
    </div>
    <div class="row">
        <div class="col-lg-6">
            <div class="card-body p-5">
                <div class="form-outline mb-4">
                    <label class="form-label">Mã Khách Hàng</label>
                    <input type="text" value="${khachHang.maKH}" class="form-control form-control-lg"
                           readonly>
                </div>
                <div class="form-outline mb-4">
                    <label class="form-label">Ngày Sinh</label>
                    <input type="text" value="${khachHang.ngaySinh}"
                           class="form-control form-control-lg"
                           readonly>
                </div>
                <div class="form-outline mb-4">
                    <label class="form-label">Địa Chỉ</label>
                    <input type="text" value="${khachHang.diaChi}" class="form-control form-control-lg"
                           readonly>
                </div>
                <div class="form-outline mb-4">
                    <label class="form-label">Quốc Gia</label>
                    <input type="text" value="${khachHang.quocGia}" class="form-control form-control-lg"
                           readonly>
                </div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="card-body p-5 ">
                <div class="form-outline mb-4">
                    <label class="form-label">Tên Khách Hàng</label>
                    <input type="text" value="${khachHang.tenKH}" class="form-control form-control-lg"
                           readonly>
                </div>
                <div class="form-outline mb-4">
                    <label class="form-label">Số Điện Thoại</label>
                    <input type="text" value="${khachHang.sdt}" class="form-control form-control-lg"
                           readonly>
                </div>
                <div class="form-outline mb-4">
                    <label class="form-label">Thành Phố</label>
                    <input type="text" value="${khachHang.thanhPho}"
                           class="form-control form-control-lg"
                           readonly>
                </div>
            </div>
        </div>
    </div>
    <div class="d-flex justify-content-center">
        <button type="submit" class="btn btn-primary btn-lg btn-block">
            <a href="/khach-hang/hien-thi" style="color: white">Back</a>
        </button>
    </div>
</div>
</body>
</html>
