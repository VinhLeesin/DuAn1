<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container py-5">
    <form action="/nhan-vien/update?id=${nhanVien.id}" method="post">
        <div class="text-center row">
            <h1>Cập Nhập Thông Tin Nhân Viên </h1>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="card-body p-5">
                    <div class="form-outline mb-4">
                        <label class="form-label">Mã Nhân Viên</label>
                        <input type="text" name="maNV" value="${nhanVien.maNV}"
                               class="form-control form-control-lg">
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Tên họ</label>
                        <input type="text" name="tenHo" value="${nhanVien.tenHo}"
                               class="form-control form-control-lg">
                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label">Tên đệm</label>
                        <input type="text" name="tenDem" value="${nhanVien.tenDem}"
                               class="form-control form-control-lg">
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Tên</label>
                        <input type="text" name="ten" value="${nhanVien.tenNV}"
                               class="form-control form-control-lg">
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Giới Tính</label>
                        <div class="form-control form-control-lg">
                            <input type="radio" name="gioiTinh" value="true"
                            ${nhanVien.gioiTinh == true ? "checked" : ""} style="margin-right: 10px">Nam
                            <input type="radio" name="gioiTinh" value="false"
                            ${nhanVien.gioiTinh == false ? "checked" : ""} style="margin-left: 50px;margin-right: 10px">Nữ
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="card-body p-5 ">
                    <div class="form-outline mb-4">
                        <label class="form-label">Tên Chức Vụ</label>
                        <select class="form-control form-control-lg" name="tenCV">
                            <c:forEach items="${chucVu}" var="cv">
                                <option value="${cv.id}" ${cv.tenCV.equals(nhanVien.chucVu.tenCV) ? "selected" : "" }>${cv.tenCV}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Mật Khẩu</label>
                        <input type="password" name="matKhau" value="${nhanVien.matKhau}"
                               class="form-control form-control-lg">
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Trạng Thái</label>
                        <div class="form-control form-control-lg">
                            <input type="checkbox" name="trangThai" value="0"
                            ${nhanVien.trangThai == 0 ? "checked" : ""} style="margin-right: 10px">Đang làm việc<br>
                            <input type="checkbox" name="trangThai" value="1"
                            ${nhanVien.trangThai == 1 ? "checked" : ""} style="margin-right: 10px">Đã nghỉ việc
                        </div>
                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label">Địa Chỉ</label>
                        <div class="form-control form-control-lg">
                            <input type="radio" name="diaChi" value="Mien Bac"
                            ${nhanVien.diaChi.equals("Mien Bac") ? "checked" : ""} style="margin-right: 10px">Miền
                            Bắc<br>
                            <input type="radio" name="diaChi" value="Mien Trung"
                            ${nhanVien.diaChi.equals("Mien Trung") ? "checked" : ""} style="margin-right: 10px">Miền
                            Trung<br>
                            <input type="radio" name="diaChi" value="Mien Nam"
                            ${nhanVien.diaChi.equals("Mien Nam") ? "checked" : ""} style="margin-right: 10px">Miền Nam
                        </div>
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
