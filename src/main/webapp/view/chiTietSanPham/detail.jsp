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
        <h1>Thông Tin Chi Tiết Sản Phẩm </h1>
    </div>
    <div class="row">
        <div class="col-lg-6">
            <div class="card-body p-5">
                <div class="form-outline mb-4">
                    <label class="form-label">Tên Sản Phẩm</label>
                    <input type="text" value="${chiTietSP.sanPham.tenSp}" class="form-control form-control-lg"
                           readonly>
                </div>
                <div class="form-outline mb-4">
                    <label class="form-label">Tên Nhà Sản Xuất</label>
                    <input type="text" value="${chiTietSP.nhaSX.tenNSX}" class="form-control form-control-lg"
                           readonly>
                </div>
                <div class="form-outline mb-4">
                    <label class="form-label">Năm Bảo Hành</label>
                    <input type="text" value="${chiTietSP.namBH}" class="form-control form-control-lg"
                           readonly>
                </div>
                <div class="form-outline mb-4">
                    <label class="form-label">Số Lượng</label>
                    <input type="text" value="${chiTietSP.soLuongTon}" class="form-control form-control-lg"
                           readonly>
                </div>
                <div class="form-outline mb-4">
                    <label class="form-label">Mô Tả</label>
                    <input type="text" value="${chiTietSP.moTa}" class="form-control form-control-lg"
                           readonly>
                </div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="card-body p-5 ">
                <div class="form-outline mb-4">
                    <label class="form-label">Màu Sắc</label>
                    <input type="text" name="id" value="${chiTietSP.mauSac.tenMau}" class="form-control form-control-lg"
                           readonly>
                </div>
                <div class="form-outline mb-4">
                    <label class="form-label">Dòng Sản Phẩm</label>
                    <input type="text" value="${chiTietSP.dongSP.tenDSP}" class="form-control form-control-lg"
                           readonly>
                </div>
                <div class="form-outline mb-4">
                    <label class="form-label">Giá Nhập</label>
                    <input type="text" value="${chiTietSP.giaNhap}" class="form-control form-control-lg"
                           readonly>
                </div>
                <div class="form-outline mb-4">
                    <label class="form-label">Giá Bán</label>
                    <input type="text" value="${chiTietSP.giaBan}" class="form-control form-control-lg"
                           readonly>
                </div>

            </div>
        </div>
    </div>
    <div class="d-flex justify-content-center">
        <button type="submit" class="btn btn-primary btn-lg btn-block">
            <a href="/chi-tiet-san-pham/hien-thi" style="color: white">Back</a>
        </button>
    </div>
</div>
</body>

</html>