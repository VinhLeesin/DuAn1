package com.example.assignment.repository;

import com.example.assignment.entity.NhanVien;
import com.example.assignment.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NhanVienRepository {
    public List<NhanVien> getListnhanVien() {
        List<NhanVien> list = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NhanVien order by ma ASC", NhanVien.class);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public NhanVien getNhanVienById(UUID id) {
        NhanVien nhanVien = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From NhanVien where id=:id", NhanVien.class);
            query.setParameter("id", id);
            nhanVien = (NhanVien) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nhanVien;
    }

    public NhanVien getNhanVienByMa(String ma) {
        NhanVien nhanVien = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From NhanVien where ma=:ma", NhanVien.class);
            query.setParameter("ma", ma);
            nhanVien = (NhanVien) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nhanVien;
    }

    public Boolean addNhanVien(NhanVien nv) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(nv);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Boolean updateNhanVien(NhanVien nv) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nv);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Boolean deleteNhanVien(NhanVien nv) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nv);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<NhanVien> getNhanVienByName(String ten) {
        List<NhanVien> nhanVien = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From NhanVien where ten=:ten", NhanVien.class);
            query.setParameter("ten", ten);
            nhanVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVien;
    }

}
