<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
    <form action="/nha-san-xuat/update?id=${nhaSX.id}" method="post">
        <section class="vh-100">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-lg-6 card shadow-2-strong ">
                        <div class="card-body p-5 ">
                            <div class="text-center row">
                                <h1>Cập Nhập Thông Tin Nhà Sản Xuất</h1>
                            </div>
                            <div class="row">
                                <div class="card-body p-5">
                                    <div class="form-outline mb-4">
                                        <label class="form-label">Mã Nhà Sản Xuất</label>
                                        <input type="text" name="maNSX" value="${nhaSX.maNSX}"
                                               class="form-control form-control-lg">
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label">Tên Nhà Sản Xuất</label>
                                        <input type="text" name="tenNSX" value="${nhaSX.tenNSX}"
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
