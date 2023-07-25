package com.example.assignment.util;

import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.entity.ChucVu;
import com.example.assignment.entity.CuaHang;
import com.example.assignment.entity.DongSanPham;
import com.example.assignment.entity.KhachHang;
import com.example.assignment.entity.MauSac;
import com.example.assignment.entity.NhaSanXuat;
import com.example.assignment.entity.NhanVien;
import com.example.assignment.entity.SanPham;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(NhaSanXuat.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(DongSanPham.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(ChiTietSanPham.class);
        conf.addAnnotatedClass(CuaHang.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(NhanVien.class);
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041");
        properties.put(Environment.USER, "vinhntph");
        properties.put(Environment.PASS, "vinh2908");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

}
