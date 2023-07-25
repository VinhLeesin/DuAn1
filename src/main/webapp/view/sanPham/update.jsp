<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
    <form action="/san-pham/update?id=${sanPham.id}" method="post">
        <section class="vh-100">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-lg-6 card shadow-2-strong ">
                        <div class="card-body p-5 ">
                            <div class="text-center row">
                                <h1>Cập nhập thông tin sản phẩm</h1>
                            </div>
                            <div class="row">
                                <div class="card-body p-5">
                                    <div class="form-outline mb-4">
                                        <label class="form-label">Mã Sản Phẩm</label>
                                        <input type="text" name="maSp" value="${sanPham.maSp}"
                                               class="form-control form-control-lg">
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label">Tên Sản Phẩm</label>
                                        <input type="text" name="tenSp" value="${sanPham.tenSp}"
                                               class="form-control form-control-lg">
                                    </div>
                                </div>
                                <div class="d-flex justify-content-center">
                                    <button class="btn btn-primary btn-lg btn-block" type="submit">Update</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </form>
</div>
</body>
</html>
