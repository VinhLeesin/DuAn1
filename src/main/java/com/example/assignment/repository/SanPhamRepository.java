package com.example.assignment.repository;

import com.example.assignment.entity.SanPham;
import com.example.assignment.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SanPhamRepository {
    public List<SanPham> getList() {
        List<SanPham> list = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From SanPham order by ma ASC", SanPham.class);
            list = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public SanPham getById(UUID id) {
        SanPham sp = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From SanPham where id=:id", SanPham.class);
            query.setParameter("id", id);
            sp = (SanPham) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sp;
    }

    public SanPham getSanPhamByMa(String ma) {
        SanPham sp = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From SanPham where ma=:ma", SanPham.class);
            query.setParameter("ma", ma);
            sp = (SanPham) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sp;
    }

    public Boolean add(SanPham sp) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(sp);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Boolean update(SanPham sp) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(sp);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Boolean delete(SanPham sp) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sp);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<SanPham> getByName(String ten) {
        List<SanPham> sp = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From SanPham where ten=:ten", SanPham.class);
            query.setParameter("ten", ten);
            sp = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }

}
