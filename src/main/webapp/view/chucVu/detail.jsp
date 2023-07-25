<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
    <section class="vh-100">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card shadow-2-strong">
                        <div class="card-body p-5 ">
                            <h1 class="mb-5 text-center">Thông Tin Chức Vụ</h1>
                            <div class="form-outline mb-4">
                                <label class="form-label">Mã Chức Vụ</label>
                                <input type="text" value="${chucVu.maCV}" class="form-control form-control-lg"
                                       readonly>
                            </div>
                            <div class="form-outline mb-4">
                                <label class="form-label">Tên Chức Vụ</label>
                                <input type="text" value="${chucVu.tenCV}" class="form-control form-control-lg"
                                       readonly>
                            </div>
                            <div class="d-flex justify-content-center">
                                <button type="submit" class="btn btn-primary btn-lg btn-block">
                                    <a href="/chuc-vu/hien-thi" style="color: white">Back</a>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>
