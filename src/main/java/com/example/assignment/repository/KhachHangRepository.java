package com.example.assignment.repository;

import com.example.assignment.entity.KhachHang;
import com.example.assignment.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class KhachHangRepository {
    public List<KhachHang> getListKhachHang() {
        List<KhachHang> list = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From KhachHang order by ma ASC", KhachHang.class);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public KhachHang getKhachHangByID(UUID id) {
        KhachHang khachHang = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From KhachHang where id=:id", KhachHang.class);
            query.setParameter("id", id);
            khachHang = (KhachHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return khachHang;
    }

    public KhachHang getKhachHangByMa(String ma) {
        KhachHang khachHang = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From KhachHang where ma=:ma", KhachHang.class);
            query.setParameter("ma", ma);
            khachHang = (KhachHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return khachHang;
    }

    public Boolean addKhachHang(KhachHang kh) {
        Transaction transaction;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(kh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean updateKhachHang(KhachHang kh) {
        Transaction transaction;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(kh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean deleteKhachHang(KhachHang kh) {
        Transaction transaction;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(kh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<KhachHang> getKhachHangByName(String name) {
        List<KhachHang> list = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From KhachHang where ten=:name", KhachHang.class);
            query.setParameter("name", name);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
